package com.jamesshore.finances.ui;

import com.jamesshore.finances.domain.StockMarketProjection;
import com.jamesshore.finances.domain.StockMarketYear;
import com.jamesshore.finances.domain.ValidDollars;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class _ApplicationModelTest {

	private ApplicationModelCommand modelCommand;

	@Before
	public void setup() {
		modelCommand = new ApplicationModelCommand(new ApplicationModelQuery());
	}

	@Test
	public void shouldStartWithDefaultStockMarket() {
		StockMarketProjection projection = modelCommand.stockMarketTableModel().stockMarketProjection();

		StockMarketYear startingYear = projection.getYearOffset(0);
		assertEquals(ApplicationModelQuery.DEFAULT_STARTING_YEAR, startingYear.year());
		assertEquals(ApplicationModelQuery.DEFAULT_STARTING_BALANCE, startingYear.startingBalance());
		assertEquals(ApplicationModelQuery.DEFAULT_STARTING_COST_BASIS, startingYear.startingCostBasis());
		assertEquals(ApplicationModelQuery.DEFAULT_GROWTH_RATE, startingYear.growthRate());
		assertEquals(ApplicationModelQuery.DEFAULT_CAPITAL_GAINS_TAX_RATE, startingYear.capitalGainsTaxRate());
		assertEquals(ApplicationModelQuery.DEFAULT_YEARLY_SPENDING, startingYear.totalSellOrders());

		assertEquals(41, projection.numberOfYears());
	}

	@Test
	public void shouldOnlyHaveOneInstanceOfStockMarketTableModel() {
		assertTrue("should be same instance", modelCommand.stockMarketTableModel() == modelCommand.stockMarketTableModel());
	}

	@Test
	public void changingStartingBalanceShouldChangeStockMarketTableModel() {
		modelCommand.setStartingBalance(ValidDollars.create(123));
		assertEquals(ValidDollars.create(123), modelCommand.stockMarketTableModel().startingBalance());
	}

	@Test
	public void changingStartingCostBasisShouldChangeStockMarketTableModel() {
		modelCommand.setStartingCostBasis(ValidDollars.create(39));
		assertEquals(ValidDollars.create(39), modelCommand.stockMarketTableModel().startingCostBasis());
	}

	@Test
	public void changingYearlySpendingShouldChangeStockMarketTableModel() {
		modelCommand.setYearlySpending(ValidDollars.create(423));
		assertEquals(ValidDollars.create(423), modelCommand.stockMarketTableModel().yearlySpending());
	}

}
