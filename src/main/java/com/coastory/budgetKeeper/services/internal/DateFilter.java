package com.coastory.budgetKeeper.services.internal;

import com.coastory.budgetKeeper.utils.DateRange;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class DateFilter {
  private LocalDate start;

  private LocalDate end;

  public DateFilter() {
    new DateFilter(DateRange.ONE_MONTH);
  }

  public DateFilter(DateRange dateRange) {
    LocalDate now = LocalDate.now();
    this.end = now;
    switch (dateRange) {
      case ONE_WEEK:
        this.start = now.with(WeekFields.of(Locale.CHINESE).dayOfWeek(), 1);
        break;
      case ONE_MONTH:
        this.start = now.withDayOfMonth(1);
        break;
      case THREE_MONTH:
        this.start = now.minusMonths(2).withDayOfMonth(1);
        break;
      case SIX_MONTH:
        this.start = now.minusMonths(5).withDayOfMonth(1);
        break;
      case ONE_YEAR:
        this.start = now.withDayOfYear(1);
        break;
      case THREE_YEAR:
        this.start = now.minusYears(2).withDayOfMonth(1);
        break;
    }
  }

  public DateFilter(LocalDate start, LocalDate end) {
    this.start = start;
    this.end = end;
  }

  public LocalDate getStart() {
    return start;
  }

  public void setStart(LocalDate start) {
    this.start = start;
  }

  public LocalDate getEnd() {
    return end;
  }

  public void setEnd(LocalDate end) {
    this.end = end;
  }

}
