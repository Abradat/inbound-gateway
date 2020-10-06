package isc.sample.kafka.testservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestRequest {

    private String name;

    @JsonCreator
    public TestRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TestRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
