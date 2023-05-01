package fr.agregio.call.service.dto.rte;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignalRecordDto {
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private boolean pp1;
    private boolean pp2;
}
