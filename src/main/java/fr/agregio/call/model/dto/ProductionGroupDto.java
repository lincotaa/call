package fr.agregio.call.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import fr.agregio.call.model.enums.ProductionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductionGroupDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private ProductionType productionType;
    private Double productionCost;
    private PowerAgreementDto powerAgreement;
}
