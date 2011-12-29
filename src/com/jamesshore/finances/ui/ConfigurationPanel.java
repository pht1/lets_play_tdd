package com.jamesshore.finances.ui;

import com.jamesshore.finances.ui.DollarsTextField.ChangeListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ConfigurationPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final ApplicationModelCommand applicationModelCommand;
	private final ApplicationModelQuery applicationModelQuery;

	public ConfigurationPanel(
			ApplicationModelCommand applicationModelCommand, ApplicationModelQuery applicationModelQuery) {
		this.applicationModelCommand = applicationModelCommand;
		this.applicationModelQuery = applicationModelQuery;
		addComponents();
	}

	private void addComponents() {
		this.setLayout(new MigLayout("fillx, wrap 2", "[right]rel[grow]"));
		addField("Starting Balance:", startingBalanceField());
		addField("Cost Basis:", costBasisField());
		addField("Yearly Spending:", yearlySpendingField());
	}

	private void addField(String name, DollarsTextField field) {
		this.add(new JLabel(name));
		this.add(field, "growx");
	}

	public DollarsTextField startingBalanceField() {
		final DollarsTextField field = new DollarsTextField(applicationModelQuery.startingBalance());
		field.addTextChangeListener(new ChangeListener() {
			public void textChanged() {
				applicationModelCommand.setStartingBalance(field.getDollars());
			}
		});
		return field;
	}

	private DollarsTextField costBasisField() {
		final DollarsTextField field = new DollarsTextField(applicationModelQuery.startingCostBasis());
		field.addTextChangeListener(new ChangeListener() {
			public void textChanged() {
				applicationModelCommand.setStartingCostBasis(field.getDollars());
			}
		});
		return field;
	}

	private DollarsTextField yearlySpendingField() {
		final DollarsTextField field = new DollarsTextField(applicationModelQuery.yearlySpending());
		field.addTextChangeListener(new ChangeListener() {
			public void textChanged() {
				applicationModelCommand.setYearlySpending(field.getDollars());
			}
		});
		return field;
	}
}
