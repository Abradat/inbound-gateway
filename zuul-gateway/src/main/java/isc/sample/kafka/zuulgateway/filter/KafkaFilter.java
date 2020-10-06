package isc.sample.kafka.zuulgateway.filter;

import com.netflix.discovery.converters.Auto;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import isc.sample.kafka.zuulgateway.service.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class KafkaFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaFilter.class);
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setSendZuulResponse(false);
        ctx.setResponseBody("Pushed to Kafka");
        ctx.setResponseStatusCode(HttpStatus.OK.value());
        kafkaProducerService.sendMessageToIn("hello");
        LOGGER.info("REQUEST BLOCKED !!");
        return null;
    }
}
