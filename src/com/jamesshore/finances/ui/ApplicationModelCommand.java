package com.jamesshore.finances.ui;

import com.jamesshore.finances.domain.*;

import java.io.File;

public class ApplicationModelCommand {

	private final ApplicationModelQuery applicationModelQuery;
	private final StockMarketTableModel stockMarketTableModel;

	public ApplicationModelCommand(ApplicationModelQuery applicationModelQuery) {
		this.applicationModelQuery = applicationModelQuery;
		stockMarketTableModel = new StockMarketTableModel(applicationModelQuery.stockMarketProjection());
	}

	public StockMarketTableModel stockMarketTableModel() {
		return stockMarketTableModel;
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
