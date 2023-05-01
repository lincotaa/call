package fr.agregio.call.service.dto;

import fr.agregio.call.model.enums.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlockReserveDto {
    private Step step;
    private ProductionGroupDto productionGroup;
    private CallDto call;
    private Double allocatedPower;
    private Double bottomPrice;
}
