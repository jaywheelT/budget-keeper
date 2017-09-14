package com.coastory.budgetKeeper.utils;

import com.coastory.budgetKeeper.services.internal.DateFilter;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class DateRangeAdapter {

  public DateFilter defaultDateFilter() {
    return adaptRange(LocalDate.now(), DateRange.ONE_MONTH);
  }

  public DateFilter adaptRange(LocalDate end, DateRange dateRange) {
    LocalDate start = null;
    switch (dateRange) {
      case ONE_WEEK:
        start = end.with(WeekFields.of(Locale.CHINESE).dayOfWeek(), 1);
        break;
      case ONE_MONTH:
        start = end.withDayOfMonth(1);
        break;
      case THREE_MONTH:
        start = end.minusMonths(2).withDayOfMonth(1);
        break;
      case SIX_MONTH:
        start = end.minusMonths(5).withDayOfMonth(1);
        break;
      case ONE_YEAR:
        start = end.withDayOfYear(1);
        break;
      case THREE_YEAR:
        start = end.minusYears(2).withDayOfMonth(1);
        break;
    }

    return new DateFilter(start, end);
  }

}
