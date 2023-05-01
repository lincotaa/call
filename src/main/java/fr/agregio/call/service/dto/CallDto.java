package fr.agregio.call.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.agregio.call.model.BlockReserve;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CallDto {
    private Long id;
    private ReserveDto reserve;
    private Date day;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BlockReserve> blockReserves;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BlockReserve> aggregatedBlockReserves;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BlockReserve> detailedBlockReserves;
}
