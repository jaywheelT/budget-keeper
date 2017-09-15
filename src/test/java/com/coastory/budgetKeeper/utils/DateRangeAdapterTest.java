package com.coastory.budgetKeeper.utils;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.coastory.budgetKeeper.utils.models.DateFilter;
import com.coastory.budgetKeeper.utils.models.DateRange;

@RunWith(JUnit4.class)
public class DateRangeAdapterTest {

  @Test
  public void shouldReturnCorretDate() {
    LocalDate now = LocalDate.of(2017, 9, 8);
    LocalDate monthStart = LocalDate.of(2017, 9, 1);
    LocalDate weekStart = LocalDate.of(2017, 9, 3);
    LocalDate yearStart = LocalDate.of(2017, 1, 1);
    LocalDate threeMonthStart = LocalDate.of(2017, 7, 1);

    DateFilter dateFilter = DateRangeAdapter.adaptRange(now, DateRange.ONE_MONTH);
    assertEquals(monthStart, dateFilter.getStart());

    dateFilter = DateRangeAdapter.adaptRange(now, DateRange.ONE_WEEK);
    assertEquals(weekStart, dateFilter.getStart());

    dateFilter = DateRangeAdapter.adaptRange(now, DateRange.ONE_YEAR);
    assertEquals(yearStart, dateFilter.getStart());

    dateFilter = DateRangeAdapter.adaptRange(now, DateRange.THREE_MONTH);
    assertEquals(threeMonthStart, dateFilter.getStart());
  }
}
