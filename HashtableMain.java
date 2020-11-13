import java.util.*;

public class HashtableMain {

	public static void main(String[] args) {
		
		Hashtable test = new Hashtable();
		
		test.put("Svenja", "3216-54987");
		test.put("Patrick", "987-65431");
		test.put("Ina", "9873-51");
		test.put("Julia", "853-17");
		test.put("Marius", "79-210");
		
		Enumeration enumer = test.elements();
		enumer = test.keys();
		
		
//		String s = (String) test.get("Svenja");
//		
//		System.out.println(s);
		
		while(enumer.hasMoreElements())
		{
			String name = (String) enumer.nextElement();
			String nummer = (String) test.get(name);
			
			System.out.println("Name der Person: " + name + " , Nummer der Person: " + nummer);
			
			
		}
		
		Vector v = new Vector();
		
		v.add("Patrick");
		v.add("Marius");
		
		
		
		String s = (String) v.get(1);
		
		System.out.println(s);

	}

}
