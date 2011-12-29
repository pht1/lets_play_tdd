package com.jamesshore.finances.ui;

import com.jamesshore.finances.domain.*;

import java.io.File;

public class ApplicationModelCommand {

	private ApplicationModelQuery applicationModelQuery = new ApplicationModelQuery();

	private StockMarketTableModel stockMarketTableModel = new StockMarketTableModel(applicationModelQuery.stockMarketProjection());

	public StockMarketTableModel stockMarketTableModel() {
		return stockMarketTableModel;
	}

	public Dollars startingBalance() {
		return applicationModelQuery.startingBalance();
	}

	public Dollars startingCostBasis() {
		return applicationModelQuery.startingCostBasis();
	}

	public Dollars yearlySpending() {
		return applicationModelQuery.yearlySpending();
	}

	public void setStartingBalance(Dollars startingBalance) {
		applicationModelQuery.setStartingBalance(startingBalance);
		stockMarketTableModel.setProjection(applicationModelQuery.stockMarketProjection());
	}

	public void setStartingCostBasis(Dollars startingCostBasis) {
		applicationModelQuery.setStartingCostBasis(startingCostBasis);
		stockMarketTableModel.setProjection(applicationModelQuery.stockMarketProjection());
	}

	public void setYearlySpending(Dollars yearlySpending) {
		applicationModelQuery.setYearlySpending(yearlySpending);
		stockMarketTableModel.setProjection(applicationModelQuery.stockMarketProjection());
	}

	public void save(File saveFile) {
		System.out.println("save called: " + saveFile);
		// TODO: finish me
	}

}
