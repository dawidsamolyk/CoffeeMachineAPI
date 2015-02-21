package edu.issi.machine.mvc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

@SuppressWarnings({ "serial", "javadoc" })
public class OrderPanel extends JScrollPane {

    /**
     * Create the panel.
     */
    public OrderPanel() {
    	GridBagLayout gridBagLayout = new GridBagLayout();
    	gridBagLayout.columnWidths = new int[]{0, 0};
    	gridBagLayout.rowHeights = new int[]{0, 0};
    	gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    	gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
    	setLayout(gridBagLayout);
    	
    	JScrollPane scrollPane = new JScrollPane();
    	GridBagConstraints gbc_scrollPane = new GridBagConstraints();
    	gbc_scrollPane.fill = GridBagConstraints.BOTH;
    	gbc_scrollPane.gridx = 0;
    	gbc_scrollPane.gridy = 0;
    	add(scrollPane, gbc_scrollPane);
    }

}
