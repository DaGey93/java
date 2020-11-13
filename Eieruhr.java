
public class Eieruhr {

	int zeit;
	
	
	public Eieruhr(int x)
	{
		zeit = x;
	}
	
	
	public void start()
	{
		for(int i=zeit; i >= 0; i--)
		{
			System.out.println("tick - " + i);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception Ex)
			{
				
			}
		}
		System.out.println("klingel!");
	}
	
	
	
	public static void main(String[] args) {
		Eieruhr eu = new Eieruhr(10);
		eu.start();
		

	}

}
