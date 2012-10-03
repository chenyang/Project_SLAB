package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.Caracteristique;
import logic.Creneau;
import logic.Enseignement;
import logic.Facade;
import logic.Groupe;
import logic.Notification;
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
public class JPanel_Planning extends JPanel {
	private JPanel jPanel_MonPlanning;
	private JPanel jPanel_Planning_Groupe;
	private JPanel jPanel99;
	private JComboBox jComboBox_Groupe_Etudiant;
	private JScrollPane jScrollPane9;
	private JScrollPane jScrollPane10;
	private JLabel jLabel11;
	private JLabel jLabel12;
	private JLabel jLabel9;
	private JTable jTable1;
	private JTable jTable4;
	
	private JButton jButton99;//Semaine suivante
	private JButton jButton98;//Semain precetente
	private JButton jButton_PlanningGroupe;
	private JButton jButton_Monplanning;
	private JTabbedPane jTabbedPane2;//switch between Mon Planning/planning groupe
	private JXDatePicker jXDatePicker3;
	private JXDatePicker jXDatePicker4;
	
	
	//Common variables
	private Facade f;
	private ArrayList<Reservation> list_planning=new ArrayList<Reservation>();
	private ArrayList<Reservation> list_planning_groupe=new ArrayList<Reservation>();
	private SimpleDateFormat sdf;
	
	private static final long serialVersionUID = 1L;
	Date mydate;
	
	//Constructor
	public JPanel_Planning(Facade f) {
	//public Panel_Enseignant(){
		this.f=f;
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		mydate=new Date();
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		add(getJTabbedPane2(), BorderLayout.CENTER);
		add(getJPanel99(), BorderLayout.SOUTH);
		setSize(982, 530);
	}

	private JButton getjButton_Monplanning() {
		if (jButton_Monplanning == null) {
			jButton_Monplanning = new JButton();
			jButton_Monplanning.setText("Valider");
			jButton_Monplanning.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					jButton_MonplanningMouseMouseClicked(event);
				}
			});
		}
		return jButton_Monplanning;
	}

	private JXDatePicker getJXDatePicker3(){
	if(jXDatePicker3==null){
	jXDatePicker3 = new JXDatePicker();
	}
	return jXDatePicker3;
	}
	
	private JXDatePicker getJXDatePicker4(){
		if(jXDatePicker4==null){
		jXDatePicker4 = new JXDatePicker();
		}
		return jXDatePicker4;
		}

	private JButton getjButton_PlanningGroupe() {
		if (jButton_PlanningGroupe == null) {
			jButton_PlanningGroupe = new JButton();
			jButton_PlanningGroupe.setText("Valider");
			jButton_PlanningGroupe.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					jButton_PlanningGroupeMouseMouseClicked(event);
				}
			});
		}
		return jButton_PlanningGroupe;
	}


	private JLabel getJLabel12() {
		if (jLabel12 == null) {
			jLabel12 = new JLabel();
			jLabel12.setText("Choisir un jour");
		}
		return jLabel12;
	}

	private JLabel getJLabel11() {
		if (jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setText("Group d'etudiant");
		}
		return jLabel11;
	}

	private JComboBox getjComboBox_Groupe_Etudiant() {
		if (jComboBox_Groupe_Etudiant == null) {
			jComboBox_Groupe_Etudiant = new JComboBox();
		}
		/******************************************************************************************************/
		ArrayList<Groupe>groupes=new ArrayList<Groupe>();
		groupes=f.getGroupes();
		for(int i=0; i<groupes.size(); i++){
			jComboBox_Groupe_Etudiant.addItem(groupes.get(i));
		}
		/******************************************************************************************************/
		
		return jComboBox_Groupe_Etudiant;
	}

	private JScrollPane getJScrollPane10() {
		if (jScrollPane10 == null) {
			jScrollPane10 = new JScrollPane();
			jScrollPane10.setViewportView(getJTable4());
		}
		return jScrollPane10;
	}

	private JTable getJTable4() {
			jTable4 = new JTable();
			/************************************************************************************************************/
			int i=0, j=0;
			EDT edt=new EDT();
			ArrayList<Date> dates=new ArrayList<Date>();
			dates=edt.getDaysOfWeek(mydate);
			jTable4.setEnabled(false);
			Vector<String> title=new Vector<String>();
			title.addElement("      ");
			title.addElement("Lundi\n"+sdf.format(dates.get(0)));
			title.addElement("Mardi\n"+sdf.format(dates.get(1)));
			title.addElement("Mercredi\n"+sdf.format(dates.get(2)));
			title.addElement("Jeudi\n"+sdf.format(dates.get(3)));
			title.addElement("Vendredi\n"+sdf.format(dates.get(4)));
			
			ArrayList<Reservation> pls=new ArrayList<Reservation>();
			pls=f.getPlanning();
			for(i=0; i<pls.size(); i++){
				System.out.println(pls.get(i)+"!!!!!!!!");
				System.out.println(pls.get(i).getCreneau().toString());
			}
			ArrayList<Creneau> cn=new ArrayList<Creneau>();
			cn=f.getCreneaux();
			System.out.println("mydate="+mydate.getDate());
			DefaultTableModel model=new DefaultTableModel(title, 0);
			jTable4.setShowVerticalLines(true);
			for(i=0; i<cn.size(); i++){
				Reservation r=null;
					Vector<String> row=new Vector<String>();
					row.add(cn.get(i).toString());
					for(j=0; j<dates.size(); j++){
						try{
							if(list_planning_groupe!=null){
								r=(Reservation)edt.getSpecifiedReservation(list_planning_groupe, cn.get(i), dates.get(j));
							}else{
								r=(Reservation)edt.getSpecifiedReservation(list_planning, cn.get(i), dates.get(j));
							}
							//System.out.println("Le creneau="+cn.get(i).toString()+" and date="+dates.get(j).getDate());
							if(r==null)
								row.add(null);
							else
								{row.add(r.stringPlanning());
								 //System.out.println("HOLALA"+r.stringPlanning());
								}
						}catch(Exception e){System.out.println("Creneau introuvable");}
						}
					model.addRow(row);
			}
			jTable4.setModel(model);
			MultiLineCellRenderer renderer=new MultiLineCellRenderer();
			TableColumnModel colmodel=jTable4.getColumnModel();
			for(i=0; i<colmodel.getColumnCount(); i++){
			colmodel.getColumn(i).setCellRenderer(renderer);
			}
			/*****************************************************************************************************************/
		return jTable4;
	}

	private JLabel getJLabel9() {
		if (jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("Choisir un jour");
		}
		return jLabel9;
	}

	private JScrollPane getJScrollPane9() {
		if (jScrollPane9 == null) {
			jScrollPane9 = new JScrollPane();
			jScrollPane9.setViewportView(getJTable1());
		}
		return jScrollPane9;
	}

	private JTable getJTable1() {
			jTable1 = new JTable();	
			/************************************************************************************************************/
			int i=0, j=0;
			EDT edt=new EDT();
			ArrayList<Date> dates=new ArrayList<Date>();
			dates=edt.getDaysOfWeek(mydate);
			jTable1.setEnabled(false);
			Vector<String> title=new Vector<String>();
			title.addElement("      ");
			title.addElement("Lundi\n"+sdf.format(dates.get(0)));
			title.addElement("Mardi\n"+sdf.format(dates.get(1)));
			title.addElement("Mercredi\n"+sdf.format(dates.get(2)));
			title.addElement("Jeudi\n"+sdf.format(dates.get(3)));
			title.addElement("Vendredi\n"+sdf.format(dates.get(4)));
			
			ArrayList<Reservation> pls=new ArrayList<Reservation>();
			pls=f.getPlanning();
			for(i=0; i<pls.size(); i++){
				System.out.println(pls.get(i)+"!!!!!!!!");
				System.out.println(pls.get(i).getCreneau().toString());
			}
			ArrayList<Creneau> cn=new ArrayList<Creneau>();
			cn=f.getCreneaux();
			System.out.println("mydate="+mydate.getDate());
			DefaultTableModel model=new DefaultTableModel(title, 0);
			jTable1.setShowVerticalLines(true);
			for(i=0; i<cn.size(); i++){
					Vector<String> row=new Vector<String>();
					row.add(cn.get(i).toString());
					for(j=0; j<dates.size(); j++){
						try{
							Reservation r=(Reservation)edt.getSpecifiedReservation(list_planning, cn.get(i), dates.get(j));
							//System.out.println("Le creneau="+cn.get(i).toString()+" and date="+dates.get(j).getDate());
							if(r==null)
								row.add(null);
							else
								{row.add(r.stringPlanning());
								}
						}catch(Exception e){System.out.println("Creneau introuvable");}
						}
					model.addRow(row);
			}
			
			jTable1.setModel(model);
			MultiLineCellRenderer renderer=new MultiLineCellRenderer();
			TableColumnModel colmodel=jTable1.getColumnModel();
			for(i=0; i<colmodel.getColumnCount();  i++){
				colmodel.getColumn(i).setCellRenderer(renderer);
			}
			/********************************************************************************************/
			
		return jTable1;
	}

	private JTabbedPane getJTabbedPane2() {
		if (jTabbedPane2 == null) {
			jTabbedPane2 = new JTabbedPane();
			jTabbedPane2.addTab("Mon Planning", getjPanel_MonPlanning());
			jTabbedPane2.addTab("Planning d'un groupe", getjPanel_Planning_Groupe());
			jTabbedPane2.addChangeListener(new ChangeListener() {
	
				public void stateChanged(ChangeEvent event) {
					jTabbedPane2ChangeStateChanged(event);
				}
			});
		}
		mydate=new Date();
		GregorianCalendar gcl=new GregorianCalendar();
		gcl.setTime(mydate);
		list_planning=f.getPlanning();
		jScrollPane9.setViewportView(getJTable1());
		jScrollPane9.repaint();
		return jTabbedPane2;
	}

	private JPanel getjPanel_Planning_Groupe() {
		if (jPanel_Planning_Groupe == null) {
			jPanel_Planning_Groupe = new JPanel();
			jPanel_Planning_Groupe.setLayout(new GroupLayout());
			jPanel_Planning_Groupe.add(getJScrollPane10(), new Constraints(new Leading(149, 818, 10, 10), new Leading(11, 399, 10, 10)));
			jPanel_Planning_Groupe.add(getjComboBox_Groupe_Etudiant(), new Constraints(new Leading(12, 99, 12, 12), new Leading(57, 26, 10, 10)));
			jPanel_Planning_Groupe.add(getJLabel11(), new Constraints(new Leading(12, 12, 12), new Leading(27, 12, 12)));
			jPanel_Planning_Groupe.add(getJLabel12(), new Constraints(new Leading(15, 10, 10), new Leading(101, 12, 12)));
			jPanel_Planning_Groupe.add(getjButton_PlanningGroupe(), new Constraints(new Leading(12, 12, 12), new Leading(197, 10, 10)));
			jPanel_Planning_Groupe.add(getJXDatePicker4(), new Constraints(new Leading(12, 12, 12), new Leading(130, 10, 30)));
		}
		return jPanel_Planning_Groupe;
	}

	private JPanel getjPanel_MonPlanning() {
		if (jPanel_MonPlanning == null) {
			jPanel_MonPlanning = new JPanel();
			jPanel_MonPlanning.setLayout(new GroupLayout());
			jPanel_MonPlanning.add(getJLabel9(), new Constraints(new Leading(12, 12, 12), new Leading(46, 12, 12)));
			jPanel_MonPlanning.add(getJXDatePicker3(), new Constraints(new Leading(8, 104, 10, 10), new Leading(70, 24, 10, 10)));
			jPanel_MonPlanning.add(getjButton_Monplanning(), new Constraints(new Leading(8, 12, 12), new Leading(121, 10, 10)));
			jPanel_MonPlanning.add(getJScrollPane9(), new Constraints(new Leading(149, 818, 10, 10), new Leading(6, 418, 10, 10)));
		}
		return jPanel_MonPlanning;
	}


	private JPanel getJPanel99() {
		if (jPanel99 == null) {
			jPanel99 = new JPanel();
			jPanel99.add(getJButton98());
			jPanel99.add(getJButton99());
		}
		return jPanel99;
	}

	private JButton getJButton99() {
		if (jButton99 == null) {
			jButton99 = new JButton();
			jButton99.setText("semaine suivante>>");
			jButton99.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton99MouseMouseClicked(event);
				}
			});
		}
		return jButton99;
	}

	private JButton getJButton98() {
		if (jButton98 == null) {
			jButton98 = new JButton();
			jButton98.setText("<<semaine precedente");
			jButton98.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton98MouseMouseClicked(event);
				}
			});
		}
		return jButton98;
	}

	
	private void jButton99MouseMouseClicked(MouseEvent event) {
		System.out.println("semaine suivante");
		GregorianCalendar gcl=new GregorianCalendar();
		gcl.setTime(mydate);
		gcl.add(gcl.DAY_OF_MONTH, +7);
		mydate=gcl.getTime();
		//parce que on ne sait pas sur quel pane est le user
		jScrollPane9.setViewportView(getJTable1());
		jScrollPane9.repaint();
		jScrollPane10.setViewportView(getJTable4());
		jScrollPane10.repaint();
	}

	private void jButton98MouseMouseClicked(MouseEvent event) {
		System.out.println("semaine precedente");
		GregorianCalendar gcl=new GregorianCalendar();
		gcl.setTime(mydate);
		gcl.add(gcl.DAY_OF_MONTH, -7);
		mydate=gcl.getTime();
		jScrollPane9.setViewportView(getJTable1());
		jScrollPane9.repaint();
		jScrollPane10.setViewportView(getJTable4());
		jScrollPane10.repaint();
	}

	

	private void jTabbedPane2ChangeStateChanged(ChangeEvent event) {
		
		int selectedIndex=jTabbedPane2.getSelectedIndex();
		if(selectedIndex==0)//Mon Planning
		{
			mydate=new Date();
			GregorianCalendar gcl=new GregorianCalendar();
			gcl.setTime(mydate);
			list_planning=f.getPlanning();
			jScrollPane9.setViewportView(getJTable1());
			jScrollPane9.repaint();
		}
		
		if(selectedIndex==1)//jpanel_planning_groupe
		{
			mydate=new Date();
			GregorianCalendar gcl=new GregorianCalendar();
			gcl.setTime(mydate);
			//list_planning=f.getPlanning();
			jScrollPane10.setViewportView(getJTable4());
			jScrollPane10.repaint();
		}
	}

	private void jButton_MonplanningMouseMouseClicked(MouseEvent event) {
		mydate=jXDatePicker3.getDate();
		GregorianCalendar gcl=new GregorianCalendar();
		gcl.setTime(mydate);
		list_planning=f.getPlanning();
		jScrollPane9.setViewportView(getJTable1());
		jScrollPane9.repaint();
	}
	
	private void jButton_PlanningGroupeMouseMouseClicked(MouseEvent event) {
		System.out.println("planing groupe button clicked");
		mydate=jXDatePicker4.getDate();
		Groupe groupe=(Groupe)jComboBox_Groupe_Etudiant.getSelectedItem();
		GregorianCalendar gcl=new GregorianCalendar();
		gcl.setTime(mydate);
		list_planning_groupe=f.getPlanning(groupe);
		jScrollPane10.setViewportView(getJTable4());
		jScrollPane10.repaint();
	}

}
