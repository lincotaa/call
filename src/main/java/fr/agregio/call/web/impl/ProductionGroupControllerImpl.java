package fr.agregio.call.web.impl;

import fr.agregio.call.model.dto.ProductionGroupDto;
import fr.agregio.call.service.ProductionGroupService;
import fr.agregio.call.web.ProductionGroupController;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductionGroupControllerImpl implements ProductionGroupController {

    Logger logger = LoggerFactory.getLogger(ProductionGroupControllerImpl.class);

    private static final ProductionGroupService productionGroupService;

    public ProductionGroupControllerImpl(ProductionGroupService productionGroupService) {
        this.productionGroupService = productionGroupService;
    }

    @Override
    public ResponseEntity<ProductionGroupDto> create(@Valid @RequestBody ProductionGroupDto productionGroupDto) {
        logger.info("Create a new group of production");
        return productionGroupService.save(productionGroupDto);
    }
    @Override
    public ResponseEntity<ProductionGroupDto> update(@Valid @RequestBody ProductionGroupDto productionGroupDto) {
        logger.info("Update a new group of production");
        return productionGroupService.save(productionGroupDto);
    }

    @Override
    public ResponseEntity<String> delete(@Valid @RequestBody ProductionGroupDto productionGroupDto) {
        logger.info("Create a new group of production");
        return productionGroupService.delete(productionGroupDto);
    }
}
