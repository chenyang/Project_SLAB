package gui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logic.Creneau;
import logic.Enseignement;
import logic.Facade;
import logic.Reservation;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.jdesktop.swingx.JXDatePicker;

//VS4E -- DO NOT REMOVE THIS LINE!
public class JPanel_Supprimer_Seance extends JPanel {

	private static final long serialVersionUID = 1L;
	private Facade f;
	private JComboBox jComboBox_Supprimer_Creneau, jComboBox_Supprimer_Seance;
	private JLabel jLabel8;
	private JXDatePicker jXDatePicker2;
	private JButton jButton_Supprimer_delete, jButton2;
	private JPanel jPanel_Supprimer_Internal;
	private JList jList0;
	private JScrollPane jScrollPane7;
	
	private ArrayList<Reservation> reservation_recherchee=new ArrayList<Reservation>();
	
	public JPanel_Supprimer_Seance(Facade f) {
		this.f=f;
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getjPanel_Supprimer_Internal(), new Constraints(new Leading(66, 805, 10, 10), new Leading(164, 286, 10, 10)));
		add(getJButton2(), new Constraints(new Leading(767, 10, 10), new Leading(113, 12, 12)));
		add(getjButton_Supprimer_delete(), new Constraints(new Leading(624, 10, 10), new Leading(113, 12, 12)));
		add(getJXDatePicker2(), new Constraints(new Leading(745, 123, 12, 12), new Leading(60, 27, 10, 10)));
		add(getJLabel8(), new Constraints(new Leading(665, 53, 12, 12), new Leading(60, 27, 12, 12)));
		add(getjComboBox_Supprimer_Seance(), new Constraints(new Leading(66, 174, 12, 12), new Leading(64, 12, 12)));
		add(getjComboBox_Supprimer_Creneau(), new Constraints(new Leading(337, 193, 10, 10), new Leading(64, 12, 12)));
	}
	
	
	private JComboBox getjComboBox_Supprimer_Creneau() {
		if (jComboBox_Supprimer_Creneau == null) {
			jComboBox_Supprimer_Creneau = new JComboBox();
			jComboBox_Supprimer_Creneau.setModel(new DefaultComboBoxModel(new Object[] { "Creneau" }));
			
			/***********************************************************************************************************/
			ArrayList<Creneau> cns=new ArrayList<Creneau>();
			cns=f.getCreneaux();
			for(int i=0; i<cns.size(); i++){
				System.out.println(cns.toString());
				jComboBox_Supprimer_Creneau.addItem(cns.get(i));
			}	
			/***********************************************************************************************************/
		}
		return jComboBox_Supprimer_Creneau;
	}
	
	private JComboBox getjComboBox_Supprimer_Seance() {
		if (jComboBox_Supprimer_Seance == null) {
			jComboBox_Supprimer_Seance = new JComboBox();
			jComboBox_Supprimer_Seance.setModel(new DefaultComboBoxModel(new Object[] { "Enseignement" }));
			
			/***********************************************************************************************************/
			ArrayList<Enseignement> ens=new ArrayList<Enseignement>();
			ens=f.getEnseignements();
			for(int i=0; i<ens.size(); i++){
				System.out.println(ens.toString());
				jComboBox_Supprimer_Seance.addItem(ens.get(i));
			}	
			/***********************************************************************************************************/
		}
		return jComboBox_Supprimer_Seance;
	}
	
	private JLabel getJLabel8() {
		if (jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("Date");
		}
		return jLabel8;
	}

	
	private JXDatePicker getJXDatePicker2(){
	if(jXDatePicker2==null){
	jXDatePicker2 = new JXDatePicker();
	}
	return jXDatePicker2;
	}
	
	private JButton getjButton_Supprimer_delete() {
		if (jButton_Supprimer_delete == null) {
			jButton_Supprimer_delete = new JButton();
			jButton_Supprimer_delete.setText("Supprimer");
			jButton_Supprimer_delete.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton_Supprimer_deleteMouseMouseClicked(event);
				}
			});
		}
		return jButton_Supprimer_delete;
	}
	
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Rechercher");
			jButton2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					jButton2MouseMouseClicked(event);
				}
			});
		}
		return jButton2;
	}
	
	private JPanel getjPanel_Supprimer_Internal() {
		if (jPanel_Supprimer_Internal == null) {
			jPanel_Supprimer_Internal = new JPanel();
			jPanel_Supprimer_Internal.setLayout(new BorderLayout());
			jPanel_Supprimer_Internal.add(getJScrollPane7(), BorderLayout.CENTER);
		}
		return jPanel_Supprimer_Internal;
	}
	
	private JScrollPane getJScrollPane7() {
		if (jScrollPane7 == null) {
			jScrollPane7 = new JScrollPane();
			jScrollPane7.setViewportView(getJList0());
		}
		return jScrollPane7;
	}
	
private JList getJList0() {
		
		jList0 = new JList();
		/**************************************************************************************************************/
			DefaultListModel listModel = new DefaultListModel();
			if(reservation_recherchee!=null){
				for(int i=0; i<reservation_recherchee.size();i++)
				{
					listModel.addElement(reservation_recherchee.get(i));
				}
				jList0.setModel(listModel);
				jList0.addListSelectionListener(new ListSelectionListener() {
		
					public void valueChanged(ListSelectionEvent event) {
						jList0ListSelectionValueChanged(event);
					}
				});
			}
		/************************************************************************************************************/	
		return jList0;
	}
	
	private void jButton_Supprimer_deleteMouseMouseClicked(MouseEvent event) {
		Reservation r=(Reservation)jList0.getSelectedValue();
		f.supprimerReservation(r);
		Enseignement ens=(Enseignement)jComboBox_Supprimer_Seance.getSelectedItem();
		Creneau cn=(Creneau)jComboBox_Supprimer_Creneau.getSelectedItem();
		Date date=jXDatePicker2.getDate();
		reservation_recherchee=f.chargerReservations(ens, cn, date);
		jScrollPane7.setViewportView(getJList0());
		jList0.repaint();
	}
	
	
	private void jButton2MouseMouseClicked(MouseEvent event) {
		if(jComboBox_Supprimer_Seance.getSelectedItem().toString().equals("Enseignement")){JOptionPane.showMessageDialog(this, "Enseignement ne soit pas vide");}
		else if(jComboBox_Supprimer_Creneau.getSelectedItem().toString().equals("Creneau")){JOptionPane.showMessageDialog(this, "Creneau ne soit pas vide");}
		else{
			Enseignement ens=(Enseignement)jComboBox_Supprimer_Seance.getSelectedItem();
			Creneau cn=(Creneau)jComboBox_Supprimer_Creneau.getSelectedItem();
			Date date=jXDatePicker2.getDate();
			reservation_recherchee=f.chargerReservations(ens, cn, date);
		}
		if(reservation_recherchee==null){
			JOptionPane.showMessageDialog(this, "Vous n'avez pas chosi cette demande");
		}
		jScrollPane7.setViewportView(getJList0());
		jList0.repaint();
	}
	

	private void jList0ListSelectionValueChanged(ListSelectionEvent event) {
		Reservation r=(Reservation)jList0.getSelectedValue();
		System.out.println(r.getCreneau());
		
	}
	
}
