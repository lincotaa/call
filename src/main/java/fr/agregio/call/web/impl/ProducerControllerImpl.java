package fr.agregio.call.web.impl;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerControllerImpl {

    @Override
    public ResponseEntity<ProducerDTO> create(@Valid @RequestBody ProducerDTO producer) {

    }
}
