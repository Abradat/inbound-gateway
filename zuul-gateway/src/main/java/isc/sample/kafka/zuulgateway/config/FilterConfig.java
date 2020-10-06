package isc.sample.kafka.zuulgateway.config;

import isc.sample.kafka.zuulgateway.filter.KafkaFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public KafkaFilter kafkaFilter(){
        return new KafkaFilter();
    }
}
