package gui;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import logic.Caracteristique;
import logic.Creneau;
import logic.Enseignement;
import logic.Facade;
import logic.Reservation;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.jdesktop.swingx.JXDatePicker;

import exceptionsEDT.CaracteristiqueIntrouvableException;
import exceptionsEDT.CreneauIntrouvableException;
import exceptionsEDT.DateIncorrecteException;
import exceptionsEDT.EnseignementIntrouvableException;

//VS4E -- DO NOT REMOVE THIS LINE!
public class JPanel_Demande extends JPanel {
private static final long serialVersionUID = 1L;
private Facade f;
private JScrollPane jScrollPane0, jScrollPane1, jScrollPane3, jScrollPane5;
private JTabbedPane jTabbedPane1;
private JTable jTable0;
private JPanel jPanel_Mes_Demandes, jPanel_Nouvelle_Demande;
private JLabel jLabel1, jLabel2, jLabel3, jLabel4;
private JTextArea jTextArea_Enseignement, jTextArea_Creneau1, jTextArea_Caracteristique1;
private JButton jButton0;
private JXDatePicker jXDatePicker0;
private JComboBox jComboBox_Creneau1, jComboBox_Caracteristique1, jComboBox_Enseignement;

private ArrayList<String> css=new ArrayList<String>();//arraylist d'carateristiques pour le premiere panel demande
private ArrayList<Caracteristique> cs=new ArrayList<Caracteristique>();
Date mydate;

	public JPanel_Demande(Facade f) {
		this.f=f;
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		add(getJTabbedPane1(), BorderLayout.CENTER);
		css.add("Caracteristique");
		mydate=new Date();
	}

	
	private void jTabbedPane1StateChanged(ChangeEvent event){
		int selectedIndex=jTabbedPane1.getSelectedIndex();
		if(selectedIndex==0){
			jScrollPane0.setViewportView(getJTable0());
			jScrollPane0.validate();
			jScrollPane0.repaint();
		}
		
		if(selectedIndex==1){//si c'est faire une nouvelle demande
			jTextArea_Enseignement.setText("");
			jTextArea_Creneau1.setText("");
			jTextArea_Caracteristique1.setText("");
			css=new ArrayList<String>();
			css.add("Caracteristique");
			//cs=null;
			/*
			getjComboBox_carac1();
			getjComboBox_creneau1();
			getjComboBox_Enseignement();
			jComboBox_Caracteristique1.repaint();
			jComboBox_Creneau1.repaint();
			jComboBox_Enseignement.repaint();
			cs=new ArrayList<Caracteristique>();
			*/
		}	
	}
	
	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJTable0());
		}
		return jScrollPane0;
	}
	
	private JTable getJTable0() {
		if (jTable0 == null) {
			jTable0 = new JTable();
		}
		jTable0.setEnabled(false);
		jTable0.setRowHeight(35);
		Vector<String> title=new Vector<String>();
		title.addElement("Mes Demande");
		/********************************************************************************************************************/
		ArrayList<Reservation> rs=new ArrayList<Reservation>();
		rs=f.getDemandes();
		DefaultTableModel model=new DefaultTableModel(title, 0);
		for(int i=0; i<rs.size(); i++){
			Vector<Reservation> row=new Vector<Reservation>();
			row.addElement(rs.get(i));
			model.addRow(row);
		}
		jTable0.setModel(model);
		/**********************************************************************************************************************/
		return jTable0;
	}
	
	private JTabbedPane getJTabbedPane1() {
		if (jTabbedPane1 == null) {
			jTabbedPane1 = new JTabbedPane();
			jTabbedPane1.addTab("Mes Demandes", getjPanel_Mes_Demandes());
			jTabbedPane1.addTab("Faire Une nouvelle Demande", getjPanel_Nouvelle_Demande());
			jTabbedPane1.addChangeListener(new ChangeListener() {
	
				public void stateChanged(ChangeEvent event) {
					jTabbedPane1StateChanged(event);
				}
			});
		}
		return jTabbedPane1;
	}
	
	
	private JPanel getjPanel_Mes_Demandes() {
		if (jPanel_Mes_Demandes == null) {
			jPanel_Mes_Demandes = new JPanel();
			jPanel_Mes_Demandes.setLayout(new BorderLayout());
			jPanel_Mes_Demandes.add(getJScrollPane0(), BorderLayout.CENTER);
		}
		return jPanel_Mes_Demandes;
	}

	
	
	private JPanel getjPanel_Nouvelle_Demande() {
		if (jPanel_Nouvelle_Demande == null) {
			jPanel_Nouvelle_Demande = new JPanel();
			jPanel_Nouvelle_Demande.setLayout(new GroupLayout());
			jPanel_Nouvelle_Demande.add(getJButton0(), new Constraints(new Leading(823, 12, 12), new Leading(413, 10, 10)));
			jPanel_Nouvelle_Demande.add(getJLabel3(), new Constraints(new Leading(593, 94, 12, 12), new Leading(164, 23, 12, 12)));
			jPanel_Nouvelle_Demande.add(getJXDatePicker0(), new Constraints(new Leading(769, 127, 10, 10), new Leading(44, 23, 12, 12)));
			jPanel_Nouvelle_Demande.add(getJLabel4(), new Constraints(new Leading(693, 56, 10, 10), new Leading(45, 22, 12, 12)));
			jPanel_Nouvelle_Demande.add(getjComboBox_creneau1(), new Constraints(new Leading(440, 133, 10, 10), new Leading(44, 26, 12, 12)));
			jPanel_Nouvelle_Demande.add(getjComboBox_carac1(), new Constraints(new Leading(103, 163, 12, 12), new Leading(45, 28, 12, 12)));
			jPanel_Nouvelle_Demande.add(getjComboBox_Enseignement(), new Constraints(new Leading(103, 258, 12, 12), new Leading(105, 24, 10, 10)));
			jPanel_Nouvelle_Demande.add(getJLabel1(), new Constraints(new Leading(103, 94, 12, 12), new Leading(166, 23, 10, 10)));
			jPanel_Nouvelle_Demande.add(getJScrollPane3(), new Constraints(new Leading(103, 194, 10, 10), new Leading(224, 148, 10, 10)));
			jPanel_Nouvelle_Demande.add(getJScrollPane5(), new Constraints(new Leading(356, 203, 10, 10), new Leading(221, 151, 10, 10)));
			jPanel_Nouvelle_Demande.add(getJScrollPane1(), new Constraints(new Leading(600, 309, 10, 10), new Leading(221, 153, 10, 10)));
			jPanel_Nouvelle_Demande.add(getJLabel2(), new Constraints(new Leading(356, 94, 12, 12), new Leading(163, 25, 12, 12)));
		}
		return jPanel_Nouvelle_Demande;
	}
	
	
	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Creneaux");
		}
		return jLabel2;
	}
	
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getjTextArea_Enseignement());
		}
		return jScrollPane1;
	}
	
	private JTextArea getjTextArea_Enseignement() {
		if (jTextArea_Enseignement == null) {
			jTextArea_Enseignement = new JTextArea();
			jTextArea_Enseignement.setEditable(false);
		}
		return jTextArea_Enseignement;
	}
	
	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Envoyer");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Enseignement");
		}
		return jLabel3;
	}
	
	
	private JXDatePicker getJXDatePicker0(){
	if(jXDatePicker0==null){
	jXDatePicker0 = new JXDatePicker();
	}
	return jXDatePicker0;
	}
	
	
	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Date");
		}
		return jLabel4;
	}
	
	
	private JComboBox getjComboBox_creneau1() {
			jComboBox_Creneau1 = new JComboBox();
			jComboBox_Creneau1.setModel(new DefaultComboBoxModel(new Object[] { "Creneau" }));
			/************************************************************************************************/
			ArrayList<Creneau> cn=new ArrayList<Creneau>();
			cn=f.getCreneaux();
			for(int i=0; i<cn.size(); i++){
				//System.out.println(cn.toString()+"creneau");
				jComboBox_Creneau1.addItem((Creneau)cn.get(i));
			}
		   /**************************************************************************************************/
			jComboBox_Creneau1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent event) {
					jComboBox_creneau1ItemItemStateChanged(event);
				}
			});
		return jComboBox_Creneau1;
	}
	
	
	private JComboBox getjComboBox_carac1() {
			jComboBox_Caracteristique1 = new JComboBox();
			jComboBox_Caracteristique1.setModel(new DefaultComboBoxModel(new Object[] { "Caracteristique" }));
			/****************************************************************************************************/
			ArrayList<Caracteristique> cs=new ArrayList<Caracteristique>();
			cs=f.getCaracteristiques();
			for(int i=0; i<cs.size(); i++){
				System.out.println(cs.toString());
				jComboBox_Caracteristique1.addItem(cs.get(i));
			}
			/****************************************************************************************************/
			jComboBox_Caracteristique1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent event) {
					jComboBox_carac1ItemItemStateChanged(event);
				}
			});
		return jComboBox_Caracteristique1;
	}
	
	private JComboBox getjComboBox_Enseignement() {
			jComboBox_Enseignement = new JComboBox();
			jComboBox_Enseignement.setModel(new DefaultComboBoxModel(new Object[] { "Enseignement" }));
			/**************************************************************************************************/
			ArrayList<Enseignement> ens=new ArrayList<Enseignement>();
			ens=f.getEnseignements();
			for(int i=0; i<ens.size(); i++){
				System.out.println(ens.toString());
				jComboBox_Enseignement.addItem(ens.get(i));
			}
		   /***************************************************************************************************/
			
			
			jComboBox_Enseignement.setBorder(null);
			jComboBox_Enseignement.addItemListener(new ItemListener() {
	
				public void itemStateChanged(ItemEvent event) {
					jComboBox_EnseignementItemItemStateChanged(event);
				}
			});
		return jComboBox_Enseignement;
	}
	
	
	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Caracteristique");
		}
		return jLabel1;
	}
	
	
	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setViewportView(getjTextArea_Caracteristique1());
		}
		return jScrollPane3;
	}

	private JScrollPane getJScrollPane5() {
		if (jScrollPane5 == null) {
			jScrollPane5 = new JScrollPane();
			jScrollPane5.setViewportView(getjTextArea_Creneau1());
		}
		return jScrollPane5;
	}
	
	
	
	
	
	
	
	
	
	private void jButton0MouseMouseClicked(MouseEvent event){
		mydate=jXDatePicker0.getDate();
		Creneau creneau = null;
		Enseignement enseignement=null;
		
		if(!jComboBox_Creneau1.getSelectedItem().toString().equals("Creneau")){
			creneau=(Creneau)jComboBox_Creneau1.getSelectedItem();
		}
		if(!jComboBox_Enseignement.getSelectedItem().toString().equals("Enseignement")){
			enseignement=(Enseignement)jComboBox_Enseignement.getSelectedItem();
		}
			try{
			if(cs.size()<1){JOptionPane.showMessageDialog(this,"Caracteristique Vide");}//si dans ArrayLIst n'a pas de caracteristique chois
			if(creneau==null){JOptionPane.showMessageDialog(this,"Creneau Vide");}
			if(enseignement==null){JOptionPane.showMessageDialog(this,"Enseignement Vide");}
			if(mydate==null){JOptionPane.showMessageDialog(this,"Date Vide");}
				int result=f.demanderSeance(creneau, mydate, enseignement, cs);
				if(result==0){JOptionPane.showMessageDialog(this, "Base de donne erreur");}
				else if(result==2){JOptionPane.showMessageDialog(this, "Groupe n'est pas disponible");}
				else if(result==3){JOptionPane.showMessageDialog(this, "L'Enseignant n'est pas disponible");}
				else{JOptionPane.showMessageDialog(this, "Votre demande est enregistree");}
				}catch(CreneauIntrouvableException e){
					JOptionPane.showMessageDialog(this,"CreneauIntrouvableException");
				}catch(EnseignementIntrouvableException e){
					JOptionPane.showMessageDialog(this,"EnseignementIntrouvableException");
				}catch(CaracteristiqueIntrouvableException e){
					JOptionPane.showMessageDialog(this,"CaracteristiqueIntrouvableException");
				}catch(DateIncorrecteException e){
					JOptionPane.showMessageDialog(this,"DateIncorrecteException");
				}catch(Exception e){
					JOptionPane.showMessageDialog(this, "Erreur en inserant dans la BD!");
				}
	}
	
	
	private void jComboBox_creneau1ItemItemStateChanged(ItemEvent event) {
		if(event.getStateChange()==ItemEvent.SELECTED){
			String name=jComboBox_Creneau1.getSelectedItem().toString();
			if(!name.equals("Creneau"))
			jTextArea_Creneau1.setText(name);
			}
	}

	
	private void jComboBox_carac1ItemItemStateChanged(ItemEvent event) {
		Caracteristique ct;
		String name="";
		if(event.getStateChange()==ItemEvent.SELECTED){
			name=jComboBox_Caracteristique1.getSelectedItem().toString();
			ct=(Caracteristique)jComboBox_Caracteristique1.getSelectedItem();		
		int vu=0;
			for(int i=0; i<css.size(); i++){
				if(name.equals(css.get(i).toString()))
					vu=1;
			}
			//System.out.println("Here ct is !!"+ct.toString());
			if(vu==0){css.add(name);cs.add(ct);}
			String result="";
			if(css.size()>1){
			for(int i=1; i<css.size(); i++){
				result+=css.get(i).toString()+"\n";}
			}
			jTextArea_Caracteristique1.setText(result);
		}
	}	
	
	
	
	private void jComboBox_EnseignementItemItemStateChanged(ItemEvent event) {
		if(event.getStateChange()==ItemEvent.SELECTED){
			String name=jComboBox_Enseignement.getSelectedItem().toString();
			if(!name.equals("Enseignement"))
			jTextArea_Enseignement.setText(name);
			}
	}
	
	

	private JTextArea getjTextArea_Caracteristique1() {
		if (jTextArea_Caracteristique1 == null) {
			jTextArea_Caracteristique1 = new JTextArea();
			jTextArea_Caracteristique1.setEditable(false);
		}
		return jTextArea_Caracteristique1;
	}
	


	private JTextArea getjTextArea_Creneau1() {
		if (jTextArea_Creneau1 == null) {
			jTextArea_Creneau1 = new JTextArea();
			jTextArea_Creneau1.setEditable(false);
		}
		return jTextArea_Creneau1;
	}
}
