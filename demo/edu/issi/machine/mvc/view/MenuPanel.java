package edu.issi.machine.mvc.view;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import edu.issi.machine.mvc.controller.EventArguments;

class MenuPanel extends JPanel {
    private DefaultListModel<String> productsListModel = new DefaultListModel<String>();
    private JList<String> productsList;

    public MenuPanel() {
	this.setLayout(new GridLayout(2, 2));

	productsList = new JList<String>();
	productsList.setModel(productsListModel);
	productsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	productsList.addMouseListener(new IngredientListener(productsList));
	this.add(productsList);

	JButton makeOrderButton = new JButton("Zamów!");
	makeOrderButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		String selectedProduct = productsList.getSelectedValue();

		if (selectedProduct == null) {
		    showError("Nie wybrano produktu!");
		}
		else {
		    EventArguments arguments = new EventArguments(GraphicalView.this, selectedProduct);
		    orderListener.actionPerformed(arguments);
		}
	    }
	});
	this.add(makeOrderButton);
    }
}
