package fr.agregio.call.service.dto.rte;

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
public class SignalsDto {
    private List<SignalRecordDto> records = new ArrayList<>();
}
