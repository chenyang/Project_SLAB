package gui;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logic.Facade;
import logic.Reservation;
import logic.Salle;
import logic.Seance;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import exceptionsEDT.SalleIntrouvableException;

//VS4E -- DO NOT REMOVE THIS LINE!
public class Panel_Responsable extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JTabbedPane jTabbedPane0;
	private JButton jButton0;
	private JButton jButton1;
	private JFrame jFrame0;
	private JButton jButton2;
	private JList jList2;
	private JScrollPane jScrollPane2;
	private JButton jButton3;
	private JButton jButton4;
	private JLabel jLabel2;
	private JList jList3;
	private JScrollPane jScrollPane3;
	ArrayList<Reservation> list_reservation=new ArrayList <Reservation>();
	ArrayList<Salle> salles_dispos=new ArrayList<Salle>();
	Salle salle_selectionnee;
	Facade f;
	Reservation reservation_selectionnee;
	private JButton jButton5;
	
		public Panel_Responsable(Facade f){
		//public Panel_Responsable(){
			this.f=f;
			initComponents();
		}

	private void initComponents() {
			setLayout(new BorderLayout());
			add(getJTabbedPane0(), BorderLayout.CENTER);
			setSize(1068, 567);
		}

	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setText("Actualiser");
			jButton5.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton5MouseMouseClicked(event);
				}
			});
		}
		return jButton5;
	}

	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setViewportView(getJList3());
		}
		return jScrollPane3;
	}

	private JList getJList3() {
			jList3 = new JList();
			DefaultListModel listModel = new DefaultListModel();
			/***************************************************************************************************/
			list_reservation=f.getAllDemandes();
			System.out.println("!!!!!!!!!!!!!!"+list_reservation.size());
				for(int i=0; i<list_reservation.size(); i++){
					//JOptionPane.showMessageDialog(this, list_reservation.get(i).toString());
					listModel.addElement(list_reservation.get(i));
				}
			/**************************************************************************************************/
			jList3.setModel(listModel);
			jList3.addListSelectionListener(new ListSelectionListener() {
	
				public void valueChanged(ListSelectionEvent event) {
					jList3ListSelectionValueChanged(event);
				}
			});
		return jList3;
	}

	private JLabel getJLabel2() {
			jLabel2 = new JLabel();
			if(reservation_selectionnee!=null)
			jLabel2.setText(reservation_selectionnee.toString());
		return jLabel2;
	}

	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("Annuler");
			jButton4.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton4MouseMouseClicked(event);
				}
			});
		}
		return jButton4;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Accepter");
			jButton3.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton3MouseMouseClicked(event);
				}
			});
		}
		return jButton3;
	}

	private JScrollPane getJScrollPane2() {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getJList2());
			jScrollPane2.repaint();
		return jScrollPane2;
	}

	private JList getJList2() {
			jList2 = new JList();
			DefaultListModel listModel = new DefaultListModel();
			/***************************************************************************************************/
			if(reservation_selectionnee!=null){
				System.out.println("reservation_selectionneee!!!!!!!!!"+reservation_selectionnee.toString());
				salles_dispos=f.getSallesDisponibles((Seance)reservation_selectionnee);
				for(int i=0; i<salles_dispos.size(); i++){
					listModel.addElement(salles_dispos.get(i));
				}
			}
			/**************************************************************************************************/
			jList2.setModel(listModel);
			jList2.addListSelectionListener(new ListSelectionListener() {
				
				public void valueChanged(ListSelectionEvent event) {
					jList2ListSelectionValueChanged(event);
				}
			});
			
		return jList2;
	}

	private JFrame getjFrame0() {
			jFrame0 = new JFrame("Selection de salle");
			jFrame0.setVisible(true);
			jFrame0.setSize(650, 400);
			jFrame0.setLocation(new Point(300, 200));
			jFrame0.setLayout(new GroupLayout());
			jFrame0.add(getJScrollPane2(), new Constraints(new Leading(34, 609, 10, 10), new Leading(56, 201, 10, 10)));
			jFrame0.add(getJButton3(), new Constraints(new Leading(36, 10, 10), new Leading(275, 12, 12)));
			jFrame0.add(getJButton4(), new Constraints(new Leading(148, 10, 10), new Leading(275, 12, 12)));
			jFrame0.add(getJLabel2(), new Constraints(new Leading(34, 12, 12), new Leading(17, 10, 10)));
			return jFrame0;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Refuser");
			jButton1.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton1MouseMouseClicked(event);
				}
			});
		}
		return jButton1;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Accepter");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JTabbedPane getJTabbedPane0() {
		if (jTabbedPane0 == null) {
			jTabbedPane0 = new JTabbedPane();
			jTabbedPane0.addTab("Traiter les demandes", getJPanel1());
		}
		return jTabbedPane0;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJButton0(), new Constraints(new Leading(21, 12, 12), new Leading(454, 10, 10)));
			jPanel1.add(getJButton1(), new Constraints(new Leading(138, 10, 10), new Leading(454, 12, 12)));
			jPanel1.add(getJScrollPane3(), new Constraints(new Leading(33, 971, 10, 10), new Leading(25, 411, 10, 10)));
			jPanel1.add(getJButton5(), new Constraints(new Leading(247, 10, 10), new Leading(454, 12, 12)));
		}
		return jPanel1;
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {
		JOptionPane.showMessageDialog(this, reservation_selectionnee.toString());
		jPanel1.validate();
		jFrame0=getjFrame0();
		jFrame0.validate();
		jFrame0.setVisible(true);
		jList3.setEnabled(false);
	}

	private void jButton3MouseMouseClicked(MouseEvent event) {
		try {
			f.attribuerSalle(reservation_selectionnee, salle_selectionnee);
		} catch (SalleIntrouvableException e) {
			JOptionPane.showMessageDialog(this, "Vous ne pouvez pas effectuer cette reservation");
			e.printStackTrace();
		}
		
		jFrame0.setVisible(false);
		jList3.setEnabled(true);
		jScrollPane3.setViewportView(getJList3());
		jScrollPane3.repaint();
	}

	private void jButton4MouseMouseClicked(MouseEvent event) {
		jFrame0.setVisible(false);
		jList3.setEnabled(true);
	}

	private void jList3ListSelectionValueChanged(ListSelectionEvent event) {
		reservation_selectionnee=(Reservation)jList3.getSelectedValue();
		System.out.println("The reservation selected "+reservation_selectionnee.toString());
	}
	
	private void jList2ListSelectionValueChanged(ListSelectionEvent event) {
		salle_selectionnee=(Salle)jList2.getSelectedValue();
		System.out.println("The salle selected "+salle_selectionnee.toString());
	}

	private void jButton1MouseMouseClicked(MouseEvent event) {
		try {
			f.attribuerSalle(reservation_selectionnee, new Salle("REFUS"));
		} catch (SalleIntrouvableException e) {
			JOptionPane.showMessageDialog(this, "Vous ne pouvez pas effacer cette reservation");
			e.printStackTrace();
		}
		jScrollPane3.setViewportView(getJList3());
		jScrollPane3.repaint();
	}

	private void jButton5MouseMouseClicked(MouseEvent event) {
		jScrollPane3.setViewportView(getJList3());
		jScrollPane3.repaint();
	}

}
