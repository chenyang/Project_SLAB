package gui;

import javax.swing.JPanel;

import logic.Facade;

import org.dyno.visual.swing.layouts.GroupLayout;

//VS4E -- DO NOT REMOVE THIS LINE!
public class JPanel_Deconnection extends JPanel {

	private static final long serialVersionUID = 1L;
	private Facade f;
	
	public JPanel_Deconnection(Facade f) {
		this.f=f;
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
	}

}
