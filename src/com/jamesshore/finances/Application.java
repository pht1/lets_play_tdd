package com.jamesshore.finances;

import com.jamesshore.finances.ui.ApplicationFrame;

import javax.swing.*;

public class Application {

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (args.length > 0) {
				ApplicationFrame.newWindow(args[0]);
				} else {
				ApplicationFrame.newWindow();
				}
			}
		});
	}

}
