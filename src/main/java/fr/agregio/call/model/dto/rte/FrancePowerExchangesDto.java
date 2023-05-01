package fr.agregio.call.model.dto.rte;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FrancePowerExchangesDto {
    private List<FrancePowerExchangeRecordDto> records = new ArrayList<>();
}
