package isc.sample.kafka.testservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<String> returnResponse() {
        System.out.printf("\n\n\n\n\nsalaaamm\n\n\n\n\n");
        String response = "Hello from ";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
