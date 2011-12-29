package com.jamesshore.finances.ui;

import com.jamesshore.finances.domain.*;

public class ApplicationModelQuery {

	public static final Year DEFAULT_STARTING_YEAR = new Year(2010);
	public static final Year DEFAULT_ENDING_YEAR = new Year(2050);
	public static final Dollars DEFAULT_STARTING_BALANCE = ValidDollars.create(10000);
	public static final Dollars DEFAULT_STARTING_COST_BASIS = ValidDollars.create(7000);
	public static final GrowthRate DEFAULT_GROWTH_RATE = new GrowthRate(10);
	public static final TaxRate DEFAULT_CAPITAL_GAINS_TAX_RATE = new TaxRate(25);
	public static final Dollars DEFAULT_YEARLY_SPENDING = ValidDollars.create(695);

	private Year startingYear = DEFAULT_STARTING_YEAR;
	private Year endingYear = DEFAULT_ENDING_YEAR;
	private Dollars startingBalance = DEFAULT_STARTING_BALANCE;
	private Dollars startingCostBasis = DEFAULT_STARTING_COST_BASIS;
	private GrowthRate growthRate = DEFAULT_GROWTH_RATE;
	private TaxRate capitalGainsTaxRate = DEFAULT_CAPITAL_GAINS_TAX_RATE;
	private Dollars yearlySpending = DEFAULT_YEARLY_SPENDING;

	public Dollars startingBalance() {
		return startingBalance;
	}

	public Dollars startingCostBasis() {
		return startingCostBasis;
	}

	public Dollars yearlySpending() {
		return yearlySpending;
	}

	public void setStartingBalance(Dollars startingBalance) {
		this.startingBalance = startingBalance;
	}

	public void setStartingCostBasis(Dollars startingCostBasis) {
		this.startingCostBasis = startingCostBasis;
	}

	public void setYearlySpending(Dollars yearlySpending) {
		this.yearlySpending = yearlySpending;
	}

	public StockMarketProjection stockMarketProjection() {
		StockMarketYear firstYear = new StockMarketYear(startingYear, startingBalance, startingCostBasis, growthRate, capitalGainsTaxRate);
		return new StockMarketProjection(firstYear, endingYear, yearlySpending);
	}

}
