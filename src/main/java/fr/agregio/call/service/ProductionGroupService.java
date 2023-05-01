package fr.agregio.call.service;

import fr.agregio.call.model.ProductionGroup;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductionGroupService {

    ProductionGroup save(ProductionGroup productionGroupDto);

    Optional<ProductionGroup> findById(Long id);

    void delete(Long id);
}
