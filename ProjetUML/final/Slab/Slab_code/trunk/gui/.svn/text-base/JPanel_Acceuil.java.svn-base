package gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import logic.Facade;
import logic.Notification;
import logic.Reservation;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
public class JPanel_Acceuil extends JPanel {
	private static final long serialVersionUID = 1L;
	Facade f;
	JLabel jLabel0;
	JScrollPane jScrollPane8;
	JLabel jLabel10;
	JButton jButton3, jButton4;
	ArrayList<Notification> list_notification=new ArrayList<Notification>();
	
	public JPanel_Acceuil(Facade f) {
	//public JPanel_Acceuil(){	
		this.f=f;
		initComponents();
	}

	private void initComponents() {
				setLayout(new GroupLayout());
				add(getJLabel0(), new Constraints(new Leading(55, 294, 10, 10), new Leading(42, 56, 10, 10)));
				add(getJLabel10(), new Constraints(new Leading(187, 110, 10, 10), new Leading(104, 12, 12)));
				add(getJScrollPane8(), new Constraints(new Leading(187, 641, 10, 10), new Leading(139, 243, 10, 10)));
				add(getJButton3(), new Constraints(new Leading(187, 12, 12), new Leading(408, 10, 10)));
				setSize(1068, 567);
		}

private JLabel getJLabel0() {
	if (jLabel0 == null) {
		jLabel0 = new JLabel();
		jLabel0.setFont(new Font("Dialog", Font.BOLD, 22));
		jLabel0.setText("Bienvenu sur EDT UM2");
	}
	return jLabel0;
}

private JScrollPane getJScrollPane8() {
	if (jScrollPane8 == null) {
		jScrollPane8 = new JScrollPane();
		jScrollPane8.setViewportView(getJList1());
	}
	return jScrollPane8;
}

private JLabel getJLabel10() {
	if (jLabel10 == null) {
		jLabel10 = new JLabel();
		jLabel10.setFont(new Font("Dialog", Font.BOLD, 16));
		jLabel10.setText("Notification");
	}
	return jLabel10;
}

private JButton getJButton3() {
	if (jButton3 == null) {
		jButton3 = new JButton();
		jButton3.setText("Supprimer Notification");
		jButton3.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent event) {
				jButton3MouseMouseClicked(event);
			}
		});
	}
	return jButton3;
}

private JList getJList1() {
	JList jList1 = new JList();
		DefaultListModel listModel = new DefaultListModel();
		/**************************************************************************************************************/
		list_notification=f.getNotifications();
			for(int i=0; i<list_notification.size();i++)
			{
				listModel.addElement(list_notification.get(i));
			}
		/************************************************************************************************************/	
		jList1.setModel(listModel);
	return jList1;
}


private void jButton3MouseMouseClicked(MouseEvent event) {
	f.supprimerNotifications();
	jScrollPane8.setViewportView(getJList1());
	jScrollPane8.repaint();	
}


}
