package fr.agregio.call.repository;

import fr.agregio.call.model.ProductionGroup;
import fr.agregio.call.model.enums.ProductionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionGroupRepository extends JpaRepository<ProductionGroup, Long> {
    ProductionGroup findByProductionType(ProductionType type);
}