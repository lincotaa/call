package fr.agregio.call.model.dto.rte;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarketTomorrowDto {
    private SignalsDto signals;
    private FrancePowerExchangesDto exchanges;
}
