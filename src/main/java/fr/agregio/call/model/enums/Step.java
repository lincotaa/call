package fr.agregio.call.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Step {
    S_1 ("00:00"),
    S_2 ("03:00"),
    S_3 ("06:00"),
    S_4 ("09:00"),
    S_5 ("12:00"),
    S_6 ("15:00"),
    S_7 ("18:00"),
    S_8 ("21:00");
    
    private final String startHour;

}
