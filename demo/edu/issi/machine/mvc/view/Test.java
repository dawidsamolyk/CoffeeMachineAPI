package edu.issi.machine.mvc.view;

import javax.swing.JFrame;

import edu.issi.machine.product.ingredient.Unit;

@SuppressWarnings("javadoc")
public class Test {

    public static void main(String[] args) {
	JFrame frame = new JFrame();
	frame.setBounds(100, 100, 550, 300);
	
	PropertiesPanel panel = new PropertiesPanel();
	frame.add(panel);
	
	panel.add("Ciœnienie", 100.0, Unit.BAR);
	
	frame.setVisible(true);
    }

}
