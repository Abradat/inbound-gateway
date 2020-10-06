package isc.sample.kafka.zuulgateway.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestResponse {

    private String name;
    private String lastName;

    @JsonCreator
    public TestResponse(@JsonProperty("name") String name, @JsonProperty("lastName") String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "TestResponse{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
