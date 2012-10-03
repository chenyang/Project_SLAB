import java.util.ArrayList;


public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GestionnaireBD bd=new GestionnaireBD();
		
		ArrayList<String> tuples=new ArrayList<String>();
		
		tuples=bd.RequeteSelect("select * from emprunt");
		
		for(int i=0;i<tuples.size();i++)
		{
			System.out.println(tuples.get(i));		
		}
	}

}
