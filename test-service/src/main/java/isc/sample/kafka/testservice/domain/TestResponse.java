package isc.sample.kafka.testservice.domain;

public class TestResponse {
    private String name;
    private String lastName;

    public TestResponse(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "TestResponse{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
