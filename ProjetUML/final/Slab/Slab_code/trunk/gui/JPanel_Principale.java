package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logic.Facade;

import org.dyno.visual.swing.layouts.GroupLayout;

//VS4E -- DO NOT REMOVE THIS LINE!
public class JPanel_Principale extends JPanel {

	private static final long serialVersionUID = 1L;
	private Facade f;
	private int identity;
	private GregorianCalendar gcl;
	private JTabbedPane jTabbedPane0;
	private JPanel jPanel_Acceuil;
	private JPanel jPanel_Demande;
	private JPanel jPanel_Supprimer_Seance;
	private JPanel jPanel_Planning;
	private JPanel jPanel_Etat;
	private JPanel jPanel_Deconnection;
	private JPanel panel_Responsable;
	private Date mydate;
	private SimpleDateFormat sdf;
	
	
	public JPanel_Principale(Facade f, int identity) {
		this.f=f;
		this.identity=identity;
		initComponents();
	}

	private void initComponents() {
		mydate=new Date();
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		setLayout(new BorderLayout());
		add(getJTabbedPane0(), BorderLayout.CENTER);
		setSize(982, 530);
	}

	private JTabbedPane getJTabbedPane0() {
		if (jTabbedPane0 == null) {
			jTabbedPane0 = new JTabbedPane();
			jTabbedPane0.addTab("Acceuil", getJPanel_Acceuil(f));
			if(identity==1){
			jTabbedPane0.addTab("Traiter les Demandes", getpanel_responsable(f));
			}
			jTabbedPane0.addTab("Demande", getjPanel_Demande(f));
			jTabbedPane0.addTab("Supprimer une seance", getjPanel_Supprimer_Seance());
			jTabbedPane0.addTab("Plannings", getjPanel_Planning(f));
			
			jTabbedPane0.addTab("Etat de mon Service", getjPanel_Etat(f));
			jTabbedPane0.addTab("Deconnection", getjPanel_Deconnection(f));
			validate();
			repaint();
			
			jTabbedPane0.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent event) {
					jTabbedPane0StateChanged(event);
				}
			});
			
		}
		return jTabbedPane0;
	}
	
	
	private JPanel getjPanel_Deconnection(Facade f) {
		if (jPanel_Deconnection == null) {
			jPanel_Deconnection = new JPanel_Deconnection(f);
		}
		return jPanel_Deconnection;
	}

	private JPanel getjPanel_Etat(Facade f) {
		if (jPanel_Etat == null) {
			jPanel_Etat = new JPanel_Etat(f);
		}
		return jPanel_Etat;
	}

	private JPanel getjPanel_Planning(Facade f) {
		if (jPanel_Planning == null) {
			jPanel_Planning = new JPanel_Planning(f);
		}
		return jPanel_Planning;
	}
	
	private JPanel getjPanel_Supprimer_Seance() {
		if (jPanel_Supprimer_Seance == null) {
			jPanel_Supprimer_Seance = new JPanel_Supprimer_Seance(f);	
		}
		return jPanel_Supprimer_Seance;
	}

	private JPanel getjPanel_Demande(Facade f) {
		if (jPanel_Demande == null) {
			jPanel_Demande = new JPanel_Demande(f);
		}
		return jPanel_Demande;
	}

	private JPanel getpanel_responsable(Facade f) {
		if (panel_Responsable == null) {
			panel_Responsable = new Panel_Responsable(f);
		}
		return panel_Responsable;
	}

	private Component getJPanel_Acceuil(Facade f) {
		if (jPanel_Acceuil == null) {
			jPanel_Acceuil = new JPanel_Acceuil(f);
		}
		return jPanel_Acceuil;
	}


	private void jTabbedPane0StateChanged(ChangeEvent event){
		//intialisation de mon etat
		int selectedIndex=jTabbedPane0.getSelectedIndex();
		if(selectedIndex==4&&identity==1){//si responsable
			//JOptionPane.showMessageDialog(this, "hey");
			getjPanel_Planning(f);
		}
		else if(selectedIndex==3&&identity==2){//si enseignant
			//JOptionPane.showMessageDialog(this, "hey");
			getjPanel_Planning(f);
		}
	}
	
	
	
	
}
