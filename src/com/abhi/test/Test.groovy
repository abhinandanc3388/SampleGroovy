package com.abhi.test

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.temporal.TemporalAdjuster
import java.time.temporal.TemporalAdjusters


def flag=false

def currDate = LocalDate.now()
def thirdDay = currDate.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.SUNDAY));

if (currDate.equals(thirdDay)){
    flag = true
}
