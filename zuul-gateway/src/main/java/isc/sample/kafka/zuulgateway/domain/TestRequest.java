package isc.sample.kafka.zuulgateway.domain;

public class TestRequest {
    private String name;

    public TestRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
