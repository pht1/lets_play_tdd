package com.jamesshore.finances.ui;

import com.jamesshore.finances.domain.Dollars;

import java.io.File;

public class __ApplicationModelSpy extends ApplicationModelCommand {
	public Dollars setStartingBalanceCalledWith;
	public Dollars setStartingCostBasisCalledWith;
	public Dollars setYearlySpendingCalledWith;
	public File saveCalledWith;

	public __ApplicationModelSpy(ApplicationModelQuery applicationModelQuery) {
		super(applicationModelQuery);
	}

	@Override
	public void setStartingBalance(Dollars startingBalance) {
		setStartingBalanceCalledWith = startingBalance;
	}

	@Override
	public void setStartingCostBasis(Dollars startingCostBasis) {
		setStartingCostBasisCalledWith = startingCostBasis;
	}

	@Override
	public void setYearlySpending(Dollars yearlySpending) {
		setYearlySpendingCalledWith = yearlySpending;
	}

	@Override
	public void save(File saveFile) {
		saveCalledWith = saveFile;
	}
}