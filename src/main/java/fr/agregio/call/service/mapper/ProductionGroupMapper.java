package fr.agregio.call.service.mapper;

import fr.agregio.call.model.ProductionGroup;
import fr.agregio.call.service.dto.ProductionGroupDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductionGroupMapper {
    Logger logger = LoggerFactory.getLogger(ProductionGroupMapper.class);
    private final ModelMapper modelMapper;

    public ProductionGroupMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductionGroup toEntity(ProductionGroupDto dto) {
        return modelMapper.map(dto, ProductionGroup.class);
    }
    public ProductionGroupDto toDto(ProductionGroup entity) {
        return modelMapper.map(entity, ProductionGroupDto.class);
    }
}
