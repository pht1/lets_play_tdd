package com.jamesshore.finances.persistence;

import java.io.Serializable;

public class DataFormatV1 implements Serializable {

	// no serial uuid here, to fail fast if changed

	private final String startingBalance;

	public DataFormatV1(String startingBalance) {
		this.startingBalance = startingBalance;
	}

	public String getStartingBalance() {
		return startingBalance;
	}

}
