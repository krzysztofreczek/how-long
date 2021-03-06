package com.h8.howlong.domain;

import com.google.inject.Singleton;
import lombok.Data;
import lombok.Singular;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
@Singleton
public class TimesheetContext implements Serializable {

    @Singular
    private final Map<LocalDate, WorkDay> timesheets;

    public TimesheetContext() {
        this.timesheets = new HashMap<>();
    }

}
