import java.util.Vector;

public class laufVerwaltung {

	public static void main(String[] args) {

		Vector v = new Vector();
		
		int i = 0;
		
		
		laeufer person1 = new laeufer(i, "Person1", 22, 80);
		v.add(person1);
		i++;
		
		laeufer person2 = new laeufer(i, "Person2", 30, 67);
		v.add(person2);
		i++;
		
		laeufer person3 = new laeufer(i, "Person3", 19, 55);
		v.add(person3);
		i++;
		
		
		for(int k=0; k<v.size(); k++)
		{
			laeufer temp = (laeufer) v.elementAt(k);
			String s = temp.getName();
			System.out.println("Vector an der "+ k + "-ten Position, Name: " + s);
			
		}
		

	}

}
