package com.coastory.budgetKeeper.services.internal;

import com.coastory.budgetKeeper.utils.DateRange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDate;

@PrepareForTest({LocalDate.class})
@RunWith(PowerMockRunner.class)
public class DateFilterTest {
  @Test
  public void shouldReturnCorretDate() {
    DateFilter dateFilter = new DateFilter(DateRange.ONE_MONTH);
    Assert.assertEquals(LocalDate.of(2017, 9, 1), dateFilter.getStart());
    dateFilter = new DateFilter(DateRange.ONE_WEEK);
    Assert.assertEquals(LocalDate.of(2017, 9, 10), dateFilter.getStart());
    dateFilter = new DateFilter(DateRange.ONE_YEAR);
    Assert.assertEquals(LocalDate.of(2017, 1, 1), dateFilter.getStart());
    dateFilter = new DateFilter(DateRange.THREE_MONTH);
    Assert.assertEquals(LocalDate.of(2017, 7, 1), dateFilter.getStart());
  }
}
