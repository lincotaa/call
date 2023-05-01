package fr.agregio.call.service.impl;

import fr.agregio.call.model.ProductionGroup;
import fr.agregio.call.model.ProductionGroupRepository;
import fr.agregio.call.service.ProductionGroupService;
import fr.agregio.call.service.mapper.ProductionGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("producerService")
public class ProductionGroupServiceImpl implements ProductionGroupService {

    Logger logger = LoggerFactory.getLogger(ProductionGroupServiceImpl.class);
    private final ProductionGroupRepository repository;

    public ProductionGroupServiceImpl(ProductionGroupRepository repository,
                                      ProductionGroupMapper mapper) {
        this.repository = repository;
    }

    public ProductionGroup save(ProductionGroup productionGroup) {
        return repository.save(productionGroup);
    }

    public Optional<ProductionGroup> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
