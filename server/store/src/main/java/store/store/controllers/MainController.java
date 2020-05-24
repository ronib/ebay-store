package store.store.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> rootResponse() {
        String welcomeMessage = "Store application";
        return new ResponseEntity<String>(welcomeMessage, HttpStatus.OK);
    }

    @RequestMapping("/healthcheck")
    String healthcheck() {
        return "OK";
    }
}