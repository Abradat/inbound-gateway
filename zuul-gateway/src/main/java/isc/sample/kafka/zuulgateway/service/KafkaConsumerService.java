package isc.sample.kafka.zuulgateway.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import isc.sample.kafka.zuulgateway.domain.TestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "${kafka.topic.out.json}")
    public void receiveMessageFromOut(String responseAsString) {
        ObjectMapper mapper = new ObjectMapper();
        TestResponse testResponse;
        try {
            testResponse = mapper.readValue(responseAsString, TestResponse.class);
        } catch (IOException e) {
            LOGGER.error("COULD NOT READ RESPONSE FROM JSON");
            testResponse = new TestResponse("ERROR", "ERROR");
        }
        LOGGER.info("Received Response= '{}'", testResponse.toString());
    }
}
