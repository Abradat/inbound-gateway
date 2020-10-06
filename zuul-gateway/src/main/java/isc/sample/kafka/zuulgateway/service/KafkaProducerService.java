package isc.sample.kafka.zuulgateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import isc.sample.kafka.zuulgateway.domain.TestRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);
    @Value("${kafka.topic.in.json}")
    private String inJsonTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToIn(String message) {
        TestRequest testRequest = new TestRequest(message);
        ObjectMapper mapper = new ObjectMapper();
        String testRequestAsSrting;
        try {
            testRequestAsSrting = mapper.writeValueAsString(testRequest);
        } catch (JsonProcessingException e) {
            LOGGER.error("ERROR IN JSON PROCESSING");
            testRequestAsSrting = "ERROR";
        }
        LOGGER.info("Sending Test Request ='{}'", testRequest.toString());
        kafkaTemplate.send(inJsonTopic, testRequestAsSrting);
    }


}
