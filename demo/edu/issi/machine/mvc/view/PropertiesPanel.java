package edu.issi.machine.mvc.view;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.issi.machine.product.ingredient.Unit;

@SuppressWarnings({ "serial", "javadoc" })
public class PropertiesPanel extends JPanel {

    /**
     * Create the panel.
     */
    public PropertiesPanel() {
	setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public void add(String name, Double value, Unit unit) {
	add(new JLabel(name));
	add(new JLabel(value.toString()));
	add(new JLabel(unit.name()));
    }
}
