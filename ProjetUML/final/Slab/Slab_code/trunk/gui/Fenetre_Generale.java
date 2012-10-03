package gui;
import gestionnairesBD.FactoryBD;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import logic.Facade;
import logic.AbstractFactory;
import com.seaglasslookandfeel.SeaGlassLookAndFeel;
//VS4E -- DO NOT REMOVE THIS LINE!
public class Fenetre_Generale extends JFrame {
	private Facade facade;
	private JPanel panel_Login;
	private static final long serialVersionUID = 1L;
	//private static final String PREFERRED_LOOK_AND_FEEL = "com.seaglasslookandfeel.SeaGlassLookAndFeel";
	private static final String PREFERRED_LOOK_AND_FEEL = "Nimbus";
	public Fenetre_Generale() {
		initComponents();
	}

	private void initComponents() {
		setBackground(Color.white);
		setResizable(false);
		setSize(1000, 550);
	}
	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
			public void init() {
				//installLnF();
				AbstractFactory.setInstance(new FactoryBD());
				facade=new Facade();
				panel_Login=new Panel_Login(this, facade);
				this.setDefaultCloseOperation(Fenetre_Generale.EXIT_ON_CLOSE);
				this.setTitle("Gestion EDT");
				this.add(panel_Login, BorderLayout.CENTER);
				this.getContentPane().setPreferredSize(this.getSize());
				this.pack();
				this.setLocationRelativeTo(null);
				this.setVisible(true);
			}
			
			
			public static void main(String args[]){
				Fenetre_Generale fg=new Fenetre_Generale();
				fg.init();
			}
}
