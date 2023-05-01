package fr.agregio.call.web.impl;

import fr.agregio.call.model.ProductionGroup;
import fr.agregio.call.service.ProductionGroupService;
import fr.agregio.call.service.dto.ProductionGroupDto;
import fr.agregio.call.service.mapper.ProductionGroupMapper;
import fr.agregio.call.web.ProductionGroupController;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


@RestController
public class ProductionGroupControllerImpl implements ProductionGroupController {

    Logger logger = LoggerFactory.getLogger(ProductionGroupControllerImpl.class);

    private final ProductionGroupService productionGroupService;
    private final ProductionGroupMapper productionGroupMapper;

    public ProductionGroupControllerImpl(ProductionGroupService productionGroupService,
                                         ProductionGroupMapper productionGroupMapper) {
        this.productionGroupService = productionGroupService;
        this.productionGroupMapper = productionGroupMapper;
    }

    @Override
    public ResponseEntity<ProductionGroupDto> create(@Valid @RequestBody ProductionGroupDto productionGroupDto)
            throws URISyntaxException {
        logger.info("Create a new group of production");
        if (productionGroupDto.hasId()) {
            throw new RequestRejectedException("'id' field must be left empty.");
        } else {
            ProductionGroup productionGroupCreated = productionGroupService.save(productionGroupMapper.toEntity(productionGroupDto));
            return ResponseEntity.created(new URI("/api/v1/producers/" + productionGroupCreated.getId()))
                    .body(productionGroupMapper.toDto(productionGroupCreated));
        }
    }

    @Override
    public ResponseEntity<ProductionGroupDto> get(@Valid final Long id) {
        logger.info("Get a new group of production");
        Optional<ProductionGroup> productionGroup = productionGroupService.findById(id);
        if (productionGroup.isPresent()) {
            // Production group of 'id' found
            return ResponseEntity.ok(productionGroupMapper.toDto(productionGroup.get()));
        } else {
            String msg = getEntityNotExistErrorMsg(id);
            logger.error(msg);
            throw new EntityNotFoundException(msg);
        }
    }

    @Override
    public ResponseEntity<ProductionGroupDto> update(@Valid @RequestBody ProductionGroupDto productionGroupDto) {
        logger.info("Update a group of production");
        if (productionGroupExists((productionGroupDto.getId()))) {
            // Production group of 'id' found
            ProductionGroup productionGroupUpdated = productionGroupService.save(productionGroupMapper.toEntity(productionGroupDto));
            return ResponseEntity.ok(productionGroupMapper.toDto(productionGroupUpdated));
        } else {
            String msg = getEntityNotExistErrorMsg(productionGroupDto.getId());
            logger.error(msg);
            throw new EntityNotFoundException(msg);
        }
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") final Long id)
            throws EntityNotFoundException {
        logger.info("Deleting an existing group of production");
        if (!productionGroupExists(id)) {
            String msg = getEntityNotExistErrorMsg(id);
            logger.error(msg);
            throw new EntityNotFoundException(msg);
        }
        productionGroupService.delete(id);
        return ResponseEntity.ok().build();
    }

    private boolean productionGroupExists(Long id) {
        Optional<ProductionGroup> productionGroup = productionGroupService.findById(id);
        return productionGroup.isPresent();
    }

    private String getEntityNotExistErrorMsg(Long id) {
        return String.format("ProductionGroup of id '%d' does not exist", id);
    }
}
