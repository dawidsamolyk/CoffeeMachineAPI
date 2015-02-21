package edu.issi.machine.mvc.view;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

@SuppressWarnings({ "serial", "javadoc" })
public class ErrorPanel extends JScrollPane {
    private JLabel messageLabel;

    /**
     * Create the panel.
     */
    public ErrorPanel() {
    	setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    	messageLabel = new JLabel("");
    	add(messageLabel);
    }

    public void show(String message) {
	messageLabel.setText(message);
    }
}
