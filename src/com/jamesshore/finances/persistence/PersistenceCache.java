package com.jamesshore.finances.persistence;

import java.io.*;

public class PersistenceCache {

	private String startingBalance;

	public PersistenceCache(String startingBalance) {
		this.startingBalance = startingBalance;
	}

	public void setStartingBalance(String startingBalance) {
		this.startingBalance = startingBalance;
	}

	public String getStartingBalance() {
		return startingBalance;
	}

	public void save(File saveFile) throws IOException {
		DataFormatV1 dataToWrite = new DataFormatV1(startingBalance);
		FileOutputStream fos = new FileOutputStream(saveFile);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			try {
				oos.writeObject(dataToWrite);
			}
			finally {
				oos.close();
			}
		}
		finally {
			fos.close();
		}
	}

	public static PersistenceCache load(File loadFile) throws Exception {
		FileInputStream fis = new FileInputStream(loadFile);
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				DataFormatV1 dataRead = (DataFormatV1) ois.readObject();
				return new PersistenceCache(dataRead.getStartingBalance());
			}
			finally {
				ois.close();
			}
		}
		finally {
			fis.close();
		}
	}

}
