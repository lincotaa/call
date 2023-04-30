package fr.agregio.call.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Step {
    STEP_01 ("00:00"),
    STEP_02 ("00:30"),
    STEP_03 ("01:00"),
    STEP_04 ("01:30"),
    STEP_05 ("02:00"),
    STEP_06 ("02:30"),
    STEP_07 ("02:30"),
    STEP_08 ("03:00"),
    STEP_09 ("03:30"),
    STEP_10 ("00:30"),
    STEP_11 ("00:30"),
    STEP_12 ("00:30"),
    STEP_13 ("00:30"),
    STEP_14 ("00:30"),
    STEP_15 ("00:30"),
    STEP_16 ("00:30"),
    STEP_17 ("00:30");
    
    private final String startHour;

}
