package edu.issi.machine.mvc.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

@SuppressWarnings({ "javadoc", "serial" })
public class MenuPanel extends JPanel {
    private DefaultListModel<String> productsListModel = new DefaultListModel<String>();

    /**
     * Create the panel.
     */
    public MenuPanel() {
	setLayout(new GridLayout(2, 2));

	final JList<String> list = new JList<String>();
	list.setModel(productsListModel);
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	list.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
//		EventArguments arguments = new EventArguments(GraphicalView.this, list.getSelectedValue());
//		ingredientsListener.actionPerformed(arguments);
	    }
	});
	add(list);

	JButton makeOrderButton = new JButton("Zamów!");
	makeOrderButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		String selectedProduct = list.getSelectedValue();

//		if (selectedProduct == null) {
//		    showError("Nie wybrano produktu!");
//		}
//		else {
//		    EventArguments arguments = new EventArguments(GraphicalView.this, selectedProduct);
//		    orderListener.actionPerformed(arguments);
//		}
	    }
	});
	add(makeOrderButton);

	add(new JLabel(""));

	JButton customProductButton = new JButton("W³asny napój");
	customProductButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	add(customProductButton);

    }

}
