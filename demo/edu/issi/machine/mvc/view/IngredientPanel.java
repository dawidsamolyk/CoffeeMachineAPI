package edu.issi.machine.mvc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

@SuppressWarnings({ "serial", "javadoc" })
public class IngredientPanel extends JScrollPane {

    /**
     * Create the panel.
     */
    public IngredientPanel() {
    	GridBagLayout gridBagLayout = new GridBagLayout();
    	gridBagLayout.columnWidths = new int[]{112, 112, 112, 112, 0};
    	gridBagLayout.rowHeights = new int[]{300, 0};
    	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    	gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
    	setLayout(gridBagLayout);
    	
    	JLabel nameLabel = new JLabel("Sk³adnik");
    	GridBagConstraints gbc_nameLabel = new GridBagConstraints();
    	gbc_nameLabel.fill = GridBagConstraints.BOTH;
    	gbc_nameLabel.insets = new Insets(0, 0, 0, 5);
    	gbc_nameLabel.gridx = 0;
    	gbc_nameLabel.gridy = 0;
    	add(nameLabel, gbc_nameLabel);

    }

}
