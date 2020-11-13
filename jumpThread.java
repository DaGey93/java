import java.util.Random;

public class jumpThread extends Thread{

	public boolean running = true;
	
	int x;
	int y;
	
	Random random = new Random();
	
	public jumpThread(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void run()
	{
		while (running)
		{
			x = random.nextInt(770);
			y = random.nextInt(570);
			try {
				this.sleep(1000);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	
	
}
