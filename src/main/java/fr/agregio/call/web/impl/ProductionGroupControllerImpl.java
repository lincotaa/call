package fr.agregio.call.web.impl;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductionGroupControllerImpl {

    Logger logger = LoggerFactory.getLogger(ProductionGroupControllerImpl.class);

    @Override
    public ResponseEntity<ProductionGroupDTO> create(@Valid @RequestBody ProductionGroupDTO producer) {

        logger.info("Create new group of production");

        return null;
    }
}
