package com.h8.howlong.services;

import com.h8.howlong.domain.WorkDay;

import java.time.LocalDateTime;

public class TimesheetService {

    private TimesheetContextService service;

    public TimesheetService(TimesheetContextService service) {
        this.service = service;
    }

    public WorkDay updateWorkDay() {
        WorkDay wd = getWorkDayOfToday();
        wd.setEnd(LocalDateTime.now());
        return service.updateWorkDay(wd);
    }

    private WorkDay getWorkDayOfToday() {
        return service.getWorkDayOfToday();
    }

}
