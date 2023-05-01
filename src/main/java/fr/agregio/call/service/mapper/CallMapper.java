package fr.agregio.call.service.mapper;

import fr.agregio.call.model.Call;
import fr.agregio.call.service.dto.CallDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CallMapper {
    Logger logger = LoggerFactory.getLogger(CallMapper.class);
    private final ModelMapper modelMapper;

    public CallMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CallDto toDtoAggregated(Call entity) {
        CallDto dto = modelMapper.map(entity, CallDto.class);
        dto.setBlockReserves(dto.getAggregatedBlockReserves());
        dto.getAggregatedBlockReserves().clear();
        dto.getDetailedBlockReserves().clear();
        return dto;
    }
    public CallDto toDtoDetailed(Call entity) {
        CallDto dto = modelMapper.map(entity, CallDto.class);
        dto.setBlockReserves(dto.getDetailedBlockReserves());
        dto.getAggregatedBlockReserves().clear();
        dto.getDetailedBlockReserves().clear();
        return dto;
    }
}
