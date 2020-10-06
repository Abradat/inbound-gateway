package isc.sample.kafka.testservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import isc.sample.kafka.testservice.domain.TestRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @KafkaListener(topics = "${kafka.topic.in.json}")
    public void receiveMessageFromOut(String requestAsString) {
        ObjectMapper mapper = new ObjectMapper();
        TestRequest testRequest;
        try {
            testRequest = mapper.readValue(requestAsString, TestRequest.class);
        } catch (IOException e) {
            LOGGER.error("COULD NOT READ RESPONSE FROM JSON");
            testRequest = new TestRequest("ERROR");
        }
        LOGGER.info("Received Request= '{}'", testRequest.toString());
        kafkaProducerService.sendMessageToOut(testRequest.getName());
    }
}
