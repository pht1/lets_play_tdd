package com.jamesshore.finances.ui;

import static org.junit.Assert.*;
import org.junit.*;
import com.jamesshore.finances.domain.*;

public class _ApplicationModelTest {

	private ApplicationModelCommand modelCommand;

	@Before
	public void setup() {
		modelCommand = new ApplicationModelCommand();
	}

	@Test
	public void shouldStartWithDefaultStockMarket() {
		StockMarketProjection projection = modelCommand.stockMarketTableModel().stockMarketProjection();

		StockMarketYear startingYear = projection.getYearOffset(0);
		assertEquals(ApplicationModelCommand.DEFAULT_STARTING_YEAR, startingYear.year());
		assertEquals(ApplicationModelCommand.DEFAULT_STARTING_BALANCE, startingYear.startingBalance());
		assertEquals(ApplicationModelCommand.DEFAULT_STARTING_COST_BASIS, startingYear.startingCostBasis());
		assertEquals(ApplicationModelCommand.DEFAULT_GROWTH_RATE, startingYear.growthRate());
		assertEquals(ApplicationModelCommand.DEFAULT_CAPITAL_GAINS_TAX_RATE, startingYear.capitalGainsTaxRate());
		assertEquals(ApplicationModelCommand.DEFAULT_YEARLY_SPENDING, startingYear.totalSellOrders());

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
