package fr.agregio.call.model.dto.rte;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FrancePowerExchangeRecordDto {
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Double value;
}
