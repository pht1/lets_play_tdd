package com.jamesshore.finances.persistence;

import com.jamesshore.finances.domain.Dollars;

import java.io.*;

public class SaveFile {

	private File path;

	public SaveFile(File path) {
		this.path = path;
	}

	@SuppressWarnings ("UnusedParameters")
	public void save(Dollars startingBalance) throws IOException {
		Writer writer = new BufferedWriter(new FileWriter(path));
		try {
			writer.write("com.jamesshore.finances,1\n");
//			writer.write(startingBalance.toCoreDataType() + "\n");
		}
		finally {
			writer.close();
		}

	}

}
