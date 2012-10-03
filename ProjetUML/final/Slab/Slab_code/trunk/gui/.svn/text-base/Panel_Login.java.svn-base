package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import logic.Facade;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
//VS4E -- DO NOT REMOVE THIS LINE!
public class Panel_Login extends JPanel {
	Fenetre_Generale fg;
	Facade f;
	private static final long serialVersionUID = 1L;
	private JTextField jTextField0;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JButton jButton0;
	private Image image, image2;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JPasswordField jPasswordField0;
	public Panel_Login(Fenetre_Generale fg, Facade f) {
	//public Panel_Login(){
		this.fg=fg;
		this.f=f;
		image=Toolkit.getDefaultToolkit().getImage("slab_small.jpg");
		image2=Toolkit.getDefaultToolkit().getImage("UM.jpg");
		initComponents();
	}
	
	
	private void initComponents() {
		setBackground(new Color(249, 251, 251));
		setLayout(new GroupLayout());
		add(getJButton0(), new Constraints(new Leading(715, 10, 10), new Leading(460, 10, 10)));
		add(getJTextField0(), new Constraints(new Leading(439, 268, 10, 10), new Leading(370, 27, 12, 12)));
		add(getJPasswordField0(), new Constraints(new Leading(439, 268, 12, 12), new Leading(418, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(230, 142, 10, 10), new Leading(415, 12, 12)));
		add(getJLabel0(), new Constraints(new Leading(230, 59, 12, 12), new Leading(363, 34, 12, 12)));
		add(getJLabel2(), new Constraints(new Leading(293, 496, 12, 12), new Leading(233, 121, 10, 10)));
		add(getJLabel3(), new Constraints(new Leading(218, 665, 10, 10), new Leading(14, 232, 10, 10)));
		add(getJLabel4(), new Constraints(new Leading(744, 105, 10, 10), new Leading(366, 63, 12, 12)));
		setSize(1015, 538);
	}


	private JPasswordField getJPasswordField0() {
		if (jPasswordField0 == null) {
			jPasswordField0 = new JPasswordField();
			jPasswordField0.setEchoChar('*');
		}
		return jPasswordField0;
	}


	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setIcon(new ImageIcon(image2));
		}
		return jLabel4;
	}


	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setFont(new Font("Broadway", Font.BOLD, 26));
			jLabel2.setText("Gestion Emploi du Temp UMII");
		}
		return jLabel2;
	}


	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setIcon(new ImageIcon(image));
			
		}
		return jLabel3;
	}


	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Valider");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setFont(new Font("Dialog", Font.PLAIN, 18));
			jLabel1.setText("Mot de passe");
		}
		return jLabel1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setFont(new Font("Dialog", Font.PLAIN, 18));
			jLabel0.setText("Nom");
		}
		return jLabel0;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
		}
		return jTextField0;
	}
	
	
	private void jButton0MouseMouseClicked(MouseEvent event) {
		String nom=jTextField0.getText();
		String mdp=jPasswordField0.getText();
		int result=f.connexion(nom, mdp);
		if(result==2){//c'est enseignant
			JPanel_Principale pe=new JPanel_Principale(f, 2);
			//fg.setSize(740, 430);
			//fg.setResizable(false);
			fg.getContentPane().removeAll();
			fg.getContentPane().add(pe, BorderLayout.CENTER);
			fg.getContentPane().validate();
			fg.getContentPane().repaint();
		}else if(result==1){//si c'est responsable
			JPanel_Principale px=new JPanel_Principale(f, 1);
			fg.getContentPane().removeAll();
			fg.getContentPane().add(px, BorderLayout.NORTH);
			fg.getContentPane().validate();
			fg.getContentPane().repaint();
		}else{
			JOptionPane.showMessageDialog(this, "mot de passe ou identifiant incorrect");
			//System.out.println("Wrong Password or Name");
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */

}
