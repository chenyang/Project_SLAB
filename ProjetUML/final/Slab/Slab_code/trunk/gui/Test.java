package gui;
import logic.AbstractFactory;
import logic.Facade;
import logic.Reservation;
import gestionnairesBD.FactoryBD;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gcl;
		// TODO Auto-generated method stub
		EDT edt=new EDT();
		int day=edt.getmyDay();
		int week=edt.getWeek();
		System.out.println("day is "+day);
		System.out.println("week is"+week);
		gcl=new GregorianCalendar();
		//gcl.clear();
		//gcl.set(2012, 7, 25);
		Date now=gcl.getTime();
		String time=sdf.format(now);
		System.out.println("the time setted is "+time);
		
		
		ArrayList mm=new ArrayList();
		mm=edt.getDaysOfWeek(now);
		System.out.println("The days in this week is ");
		for (int i=0; i<mm.size(); i++){
			Date d=(Date)mm.get(i);
			String temp=sdf.format(d);
			System.out.println(temp);
		}
	
		
		AbstractFactory.setInstance(new FactoryBD());
		Facade ff=new Facade();
		ff.connexion("Stratulat", "tiberiu");
		ArrayList<Reservation> temp=new ArrayList<Reservation>();
		temp=ff.getAllDemandes();
		System.out.println("heihei"+temp.size());
	}

}
