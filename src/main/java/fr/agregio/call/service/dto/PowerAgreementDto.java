package fr.agregio.call.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PowerAgreementDto {
    private Double minPower;
    private Double maxPower;
}
