package org.loadtest4j.examples.java.driver;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.loadtest4j.driver.Driver;
import org.loadtest4j.driver.DriverRequest;
import org.loadtest4j.driver.DriverResult;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Dummy implements Driver {

    private static final Client client = new JerseyClientBuilder().build();

    private final String url;
    
    Dummy(String url) {
        this.url = url;
    }
    
    public DriverResult run(List<DriverRequest> requests) {
        final List<Invocation> invocations = build(requests);

        final List<Boolean> results = invocations.stream()
                .map(this::run)
                .collect(Collectors.toList());

        final int total = results.size();
        final long ko = results.stream().filter(result -> !result).count();
        final long ok = total - ko;

        return new DummyResult(ok, ko);
    }

    private List<Invocation> build(List<DriverRequest> requests) {
        return requests.stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    private Invocation build(DriverRequest request) {
        // TODO include the body parameter
        final MultivaluedMap<String, Object> headers = toMultivaluedMap(request.getHeaders());
        final String method = request.getMethod();
        final String uri = url + request.getPath();

        return client.target(uri)
                .request()
                .headers(headers)
                .build(method);
    }

    private boolean run(Invocation invocation) {
        final Response response = invocation.invoke();
        return isSuccess(response);
    }

    private static boolean isSuccess(Response response) {
        final int status = response.getStatus();
        return status >= 200 && status <= 399;
    }

    private static MultivaluedMap<String, Object> toMultivaluedMap(Map<String, String> map) {
        final MultivaluedHashMap<String, Object> foo = new MultivaluedHashMap<>();
        map.forEach(foo::putSingle);
        return foo;
    }
}