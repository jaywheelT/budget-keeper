package com.coastory.budgetKeeper.services.internal;

import com.coastory.budgetKeeper.utils.DateRange;
import com.coastory.budgetKeeper.utils.DateRangeAdapter;

import java.time.LocalDate;

public class DateFilter {

  private LocalDate start;

  private LocalDate end;

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
