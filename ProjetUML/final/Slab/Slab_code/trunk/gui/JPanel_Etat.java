package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logic.Enseignement;
import logic.Facade;

import org.dyno.visual.swing.layouts.GroupLayout;

//VS4E -- DO NOT REMOVE THIS LINE!
public class JPanel_Etat extends JPanel {

	private static final long serialVersionUID = 1L;
	private Facade f;
	private JScrollPane jScrollPane6;
	private JTable jTable2;
	
	public JPanel_Etat(Facade f) {
		this.f=f;
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		add(getJScrollPane6(), BorderLayout.CENTER);
	}

	private JScrollPane getJScrollPane6() {
		if (jScrollPane6 == null) {
			jScrollPane6 = new JScrollPane();
			jScrollPane6.setViewportView(getJTable2());
		}
		return jScrollPane6;
	}
	
	private JTable getJTable2() {
		if (jTable2 == null) {
			jTable2 = new JTable();
		}
		jTable2.setRowHeight(35);
		/***********************************************************************************************************/
		Vector<String> title=new Vector<String>();
		title.addElement("Enseignement");
		title.addElement("Heures a faire");
		title.addElement("Heures programmees");
		title.addElement("Heures faites");
		DefaultTableModel model=new DefaultTableModel(title, 0);
		ArrayList<Enseignement> ens=new ArrayList<Enseignement>();
		ens=f.getEnseignements();
		for(int i=0; i<ens.size(); i++){
			Vector row=new Vector();
			row.addElement(ens.get(i));
			row.addElement(ens.get(i).getNbHeure()+"h00");
			try{
			row.addElement(f.getNbHeureProgramme(ens.get(i)));
			}catch(Exception e){JOptionPane.showMessageDialog(this, "Enseignant introuvable");}
			try{
			row.addElement(f.getNbHeureFait(ens.get(i)));
			}catch(Exception e){JOptionPane.showMessageDialog(this, "Enseignant introuvable");}
			model.addRow(row);
		}
		jTable2.setModel(model);
		/*************************************************************************************************************/
		
		
		return jTable2;
	}
	
	
}
