package com.h8.howlong.app.services.impl;

import com.h8.howlong.app.services.PrintingService;
import com.h8.howlong.services.TimesheetContextService;
import com.h8.howlong.services.WorkDayComputationService;
import com.h8.howlong.utils.DurationUtils;
import com.h8.howlong.utils.print.PrintBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class QuietPrintingService implements PrintingService {

    private final TimesheetContextService contextService;

    private final WorkDayComputationService computationService;

    public QuietPrintingService(
            TimesheetContextService contextService,
            WorkDayComputationService computationService) {
        this.contextService = contextService;
        this.computationService = computationService;
    }

    @Override
    public String print(int month) {
        contextService.getWorkDayOfToday();
        return PrintBuilder.builder()
                .ln(String.format("<c%s> | <y%s> | <y%s>",
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")),
                        DurationUtils.format(computationService.getElapsedTime()),
                        DurationUtils.format(computationService.getRemainingTime())))
                .build();
    }

}
