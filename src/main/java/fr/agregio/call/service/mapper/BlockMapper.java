package fr.agregio.call.service.mapper;

import fr.agregio.call.model.BlockProducer;
import fr.agregio.call.model.BlockReserve;
import fr.agregio.call.service.dto.BlockProducerDto;
import fr.agregio.call.service.dto.BlockReserveDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BlockMapper {
    Logger logger = LoggerFactory.getLogger(BlockMapper.class);
    private final ModelMapper modelMapper;

    public BlockMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BlockProducerDto toDto(BlockProducer entity) {
        return modelMapper.map(entity, BlockProducerDto.class);
    }
    public BlockReserveDto toDto(BlockReserve entity) {
        return modelMapper.map(entity, BlockReserveDto.class);
    }
}
