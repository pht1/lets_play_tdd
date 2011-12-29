package com.jamesshore.finances.ui;

import com.jamesshore.finances.domain.ValidDollars;
import net.miginfocom.swing.MigLayout;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertEquals;

public class _ConfigurationPanelTest {

	private ConfigurationPanel panel;
	private ApplicationModelQuery modelQuery;

	private DollarsTextField startingBalanceField() {
		return (DollarsTextField)panel.getComponent(1);
	}

	private DollarsTextField costBasisField() {
		return (DollarsTextField)panel.getComponent(3);
	}

	private DollarsTextField yearlySpendingField() {
		return (DollarsTextField)panel.getComponent(5);
	}

	@Before
	public void setUp() {
		modelQuery = new ApplicationModelQuery();
		ApplicationModelCommand modelCommand = new ApplicationModelCommand(modelQuery);
		panel = new ConfigurationPanel(modelCommand, modelQuery);
	}

	@Test
	public void layout() {
		MigLayout manager = (MigLayout)panel.getLayout();
		assertEquals("layout", MigLayout.class, manager.getClass());
		assertEquals("layout constraints", "fillx, wrap 2", manager.getLayoutConstraints());
		assertEquals("column constraints", "[right]rel[grow]", manager.getColumnConstraints());

		Component[] components = panel.getComponents();
		assertEquals("# of components", 6, components.length);
		assertFormField("starting balance", components[0], components[1]);
		assertFormField("cost basis", components[2], components[3]);
		assertFormField("yearly spending", components[4], components[5]);
	}

	private void assertFormField(String message, Component label, Component field) {
		MigLayout manager = (MigLayout)panel.getLayout();
		assertEquals(message + " label", JLabel.class, label.getClass());
		assertEquals(message + " field", DollarsTextField.class, field.getClass());
		assertEquals(message + " field constraint", "growx", manager.getComponentConstraints(field));
	}

	@Test
	public void fieldsInitializeToModelValue() {
		assertEquals("starting balance field text", modelQuery.startingBalance(), startingBalanceField().getDollars());
		assertEquals("cost basis field text", modelQuery.startingCostBasis(), costBasisField().getDollars());
		assertEquals("yearly spending field text", modelQuery.yearlySpending(), yearlySpendingField().getDollars());
	}

	@Test
	public void startingBalanceFieldUpdatesApplicationModel() {
		ApplicationModelCommand mockModelCommand = Mockito.mock(ApplicationModelCommand.class);
		panel = new ConfigurationPanel(mockModelCommand, modelQuery);

		startingBalanceField().setText("668");
		Mockito.verify(mockModelCommand).setStartingBalance(ValidDollars.create(668));
	}

	@Test
	public void costBasisFieldUpdatesApplicationModel() {
		ApplicationModelCommand mockModelCommand = Mockito.mock(ApplicationModelCommand.class);
		panel = new ConfigurationPanel(mockModelCommand, modelQuery);

		costBasisField().setText("670");
		Mockito.verify(mockModelCommand).setStartingCostBasis(ValidDollars.create(670));
	}

	@Test
	public void yearlySpendingFieldUpdatesApplicationModel() {
		ApplicationModelCommand mockModelCommand = Mockito.mock(ApplicationModelCommand.class);
		panel = new ConfigurationPanel(mockModelCommand, modelQuery);

		yearlySpendingField().setText("672");
		Mockito.verify(mockModelCommand).setYearlySpending(ValidDollars.create(672));

	}

}
