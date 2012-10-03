package gui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import logic.Creneau;
import logic.Reservation;
import logic.Salle;

public class EDT {
	private Date mydate, lundiD, mardiD, mercrediD, jeudiD, vendrediD, samediD, dimancheD;
	private GregorianCalendar gcl, lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche;
	private SimpleDateFormat sdf;
	public ArrayList<Date> getDaysOfWeek(Date mydate){
		ArrayList<Date> dow=new ArrayList<Date>();
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		gcl=new GregorianCalendar();
		lundi=new GregorianCalendar();
		mardi=new GregorianCalendar();
		mercredi=new GregorianCalendar();
		jeudi=new GregorianCalendar();
		vendredi=new GregorianCalendar();
		samedi=new GregorianCalendar();
		dimanche=new GregorianCalendar();
		gcl.setTime(mydate);
		lundi.setTime(mydate);
		mardi.setTime(mydate);
		mercredi.setTime(mydate);
		jeudi.setTime(mydate);
		vendredi.setTime(mydate);
		samedi.setTime(mydate);
		dimanche.setTime(mydate);
		gcl.setFirstDayOfWeek(gcl.SUNDAY);
		int sourceDay=gcl.get(gcl.DAY_OF_WEEK);
		//System.out.println(sourceDay+"!!!!!!!!!!");
		
		//lundi
		if(sourceDay==2)
		{
			lundi.add(gcl.DAY_OF_MONTH, 0);
			lundiD=lundi.getTime();
			sdf=new SimpleDateFormat("yyyy-MM-dd");
			String time=sdf.format(lundiD);
			System.out.println("This week's monday is "+time+" and source day is monday");
			
			mardi.add(gcl.DAY_OF_MONTH, +1);
			mardiD=mardi.getTime();
			
			mercredi.add(gcl.DAY_OF_MONTH, +2);
			mercrediD=mercredi.getTime();
	
			jeudi.add(gcl.DAY_OF_MONTH, +3);
			jeudiD=jeudi.getTime();
			
			vendredi.add(gcl.DAY_OF_MONTH, +4);
			vendrediD=vendredi.getTime();
			
			samedi.add(gcl.DAY_OF_MONTH, +5);
			samediD=samedi.getTime();
			
			dimanche.add(gcl.DAY_OF_MONTH, +6);
			dimancheD=dimanche.getTime();
			
			//add days in dow
			dow.add(lundiD);dow.add(mardiD);dow.add(mercrediD);
			dow.add(jeudiD);dow.add(vendrediD);
		}
		
		//Mardi
		else if(sourceDay==3)
		{
			lundi.add(gcl.DAY_OF_MONTH, -1);
			lundiD=lundi.getTime();
			sdf=new SimpleDateFormat("yyyy-MM-dd");
			String time=sdf.format(lundiD);
			System.out.println("This week's monday is "+time+"and source day is tuesday");
			
			mardi.add(gcl.DAY_OF_MONTH, +0);
			mardiD=mardi.getTime();
			
			mercredi.add(gcl.DAY_OF_MONTH, +1);
			mercrediD=mercredi.getTime();
	
			jeudi.add(gcl.DAY_OF_MONTH, +2);
			jeudiD=jeudi.getTime();
			
			vendredi.add(gcl.DAY_OF_MONTH, +3);
			vendrediD=vendredi.getTime();
			
			samedi.add(gcl.DAY_OF_MONTH, +4);
			samediD=samedi.getTime();
			
			dimanche.add(gcl.DAY_OF_MONTH, +5);
			dimancheD=dimanche.getTime();
			
			//add days in dow
			dow.add(lundiD);dow.add(mardiD);dow.add(mercrediD);
			dow.add(jeudiD);dow.add(vendrediD);
		}
		
		
		//Mercredi
		else if(sourceDay==4)
		{
			lundi.add(gcl.DAY_OF_MONTH, -2);
			lundiD=lundi.getTime();
			sdf=new SimpleDateFormat("yyyy-MM-dd");
			String time=sdf.format(lundiD);
			System.out.println("This week's monday is "+time+"and source day is wendsady");
			
			mardi.add(gcl.DAY_OF_MONTH, -1);
			mardiD=mardi.getTime();
			
			mercredi.add(gcl.DAY_OF_MONTH, +0);
			mercrediD=mercredi.getTime();
	
			jeudi.add(gcl.DAY_OF_MONTH, +1);
			jeudiD=jeudi.getTime();
			
			vendredi.add(gcl.DAY_OF_MONTH, +2);
			vendrediD=vendredi.getTime();
			
			samedi.add(gcl.DAY_OF_MONTH, +3);
			samediD=samedi.getTime();
			
			dimanche.add(gcl.DAY_OF_MONTH, +4);
			dimancheD=dimanche.getTime();
			
			//add days in dow
			dow.add(lundiD);dow.add(mardiD);dow.add(mercrediD);
			dow.add(jeudiD);dow.add(vendrediD);
		}
		
		//Jeudi
		else if(sourceDay==5)
		{
			lundi.add(gcl.DAY_OF_MONTH, -3);
			lundiD=lundi.getTime();
			sdf=new SimpleDateFormat("yyyy-MM-dd");
			String time=sdf.format(lundiD);
			System.out.println("This week's monday is "+time+"and source day is thrusday");
			
			mardi.add(gcl.DAY_OF_MONTH, -2);
			mardiD=mardi.getTime();
			
			mercredi.add(gcl.DAY_OF_MONTH, -1);
			mercrediD=mercredi.getTime();
	
			jeudi.add(gcl.DAY_OF_MONTH, +0);
			jeudiD=jeudi.getTime();
			
			vendredi.add(gcl.DAY_OF_MONTH, +1);
			vendrediD=vendredi.getTime();
			
			samedi.add(gcl.DAY_OF_MONTH, +2);
			samediD=samedi.getTime();
			
			dimanche.add(gcl.DAY_OF_MONTH, +3);
			dimancheD=dimanche.getTime();
			
			//add days in dow
			dow.add(lundiD);dow.add(mardiD);dow.add(mercrediD);
			dow.add(jeudiD);dow.add(vendrediD);
		}
		
		
		//Vendredi
		else if(sourceDay==6)
		{
			lundi.add(gcl.DAY_OF_MONTH, -4);
			lundiD=lundi.getTime();
			sdf=new SimpleDateFormat("yyyy-MM-dd");
			String time=sdf.format(lundiD);
			System.out.println("This week's monday is "+time+"and source day is friday");
			
			mardi.add(gcl.DAY_OF_MONTH, -3);
			mardiD=mardi.getTime();
			
			mercredi.add(gcl.DAY_OF_MONTH, -2);
			mercrediD=mercredi.getTime();
	
			jeudi.add(gcl.DAY_OF_MONTH, -1);
			jeudiD=jeudi.getTime();
			
			vendredi.add(gcl.DAY_OF_MONTH, +0);
			vendrediD=vendredi.getTime();
			
			samedi.add(gcl.DAY_OF_MONTH, +1);
			samediD=samedi.getTime();
			
			dimanche.add(gcl.DAY_OF_MONTH, +2);
			dimancheD=dimanche.getTime();
			
			//add days in dow
			dow.add(lundiD);dow.add(mardiD);dow.add(mercrediD);
			dow.add(jeudiD);dow.add(vendrediD);
		}
		
		
		
		//samedi
		else if(sourceDay==7)
		{
			lundi.add(gcl.DAY_OF_MONTH, -5);
			lundiD=lundi.getTime();
			sdf=new SimpleDateFormat("yyyy-MM-dd");
			String time=sdf.format(lundiD);
			System.out.println("This week's monday is "+time+" and source day is saturday");
			
			mardi.add(gcl.DAY_OF_MONTH, -4);
			mardiD=mardi.getTime();
			
			mercredi.add(gcl.DAY_OF_MONTH, -3);
			mercrediD=mercredi.getTime();
	
			jeudi.add(gcl.DAY_OF_MONTH, -2);
			jeudiD=jeudi.getTime();
			
			vendredi.add(gcl.DAY_OF_MONTH, -1);
			vendrediD=vendredi.getTime();
			
			samedi.add(gcl.DAY_OF_MONTH, +0);
			samediD=samedi.getTime();
			
			dimanche.add(gcl.DAY_OF_MONTH, +1);
			dimancheD=dimanche.getTime();
			
			//add days in dow
			dow.add(lundiD);dow.add(mardiD);dow.add(mercrediD);
			dow.add(jeudiD);dow.add(vendrediD);
		}
		
		//dimanche
		else if(sourceDay==1)
		{
			lundi.add(gcl.DAY_OF_MONTH, -6);
			lundiD=lundi.getTime();
			sdf=new SimpleDateFormat("yyyy-MM-dd");
			String time=sdf.format(lundiD);
			System.out.println("This week's monday is "+time+" and source day is sunday");
			
			mardi.add(gcl.DAY_OF_MONTH, -5);
			mardiD=mardi.getTime();
			
			mercredi.add(gcl.DAY_OF_MONTH, -4);
			mercrediD=mercredi.getTime();
	
			jeudi.add(gcl.DAY_OF_MONTH, -3);
			jeudiD=jeudi.getTime();
			
			vendredi.add(gcl.DAY_OF_MONTH, -2);
			vendrediD=vendredi.getTime();
			
			samedi.add(gcl.DAY_OF_MONTH, -1);
			samediD=samedi.getTime();
			
			dimanche.add(gcl.DAY_OF_MONTH, +0);
			dimancheD=dimanche.getTime();
			
			//add days in dow
			dow.add(lundiD);dow.add(mardiD);dow.add(mercrediD);
			dow.add(jeudiD);dow.add(vendrediD);
		}
		
		return dow;
	}
	
	
	public int getmyDay(){
		mydate=new Date();
		gcl=new GregorianCalendar();
		gcl.setTime(mydate);
		return gcl.get(gcl.DAY_OF_WEEK)-1;
	}
	
	public int getWeek(){
		mydate=new Date();
		//System.out.println("Today is "+mydate.getDay());
		gcl=new GregorianCalendar();
		gcl.setTime(mydate);
		int result=gcl.get(gcl.WEEK_OF_YEAR);
		return result;
	}
	
	
	
	public Reservation getSpecifiedReservation(ArrayList<Reservation> list, Creneau cn, Date date)
	{	
		Reservation r = null;
		for(int i=0; i<list.size(); i++){
			if((list.get(i).getCreneau().toString()).equals(cn.toString()) && (list.get(i).getDate().toString()).equals(sdf.format(date)))
			{
				r=list.get(i);
				break;
			}
		}
		if(r!=null)
			{return r;
			}
		else
			return null;
	}	
	
}






