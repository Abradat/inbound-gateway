package isc.sample.kafka.testservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import isc.sample.kafka.testservice.domain.TestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    @Value("${kafka.topic.out.json}")
    private String outJsonTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToOut(String message) {
        TestResponse testResponse = new TestResponse(message, message);
        ObjectMapper mapper = new ObjectMapper();
        String testResponseAsString;
        try{
            testResponseAsString = mapper.writeValueAsString(testResponse);
        } catch (JsonProcessingException e ) {
            LOGGER.error("ERROR IN JSON PROCESSING");
            testResponseAsString = "ERROR";
        }
        LOGGER.info("Sending Test Response= '{}", testResponse.toString());
        kafkaTemplate.send(outJsonTopic, testResponseAsString);
    }

}
