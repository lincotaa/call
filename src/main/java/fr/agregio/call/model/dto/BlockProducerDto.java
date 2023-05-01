package fr.agregio.call.model.dto;

import fr.agregio.call.model.enums.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlockProducerDto {
    private Step step;
    private ProductionGroupDto productionGroup;
    private Double allocatedPower;
    private Double totalPower;
    private Double availablePower;
}
