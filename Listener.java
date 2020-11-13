import java.io.*;
import java.net.*;

public class Listener extends Thread{
	
	private BufferedReader	input;
	private PrintWriter 	output;
	
	public boolean			running = true;	

	public Listener(BufferedReader in, PrintWriter out)
	{
		input 	= in;
		output 	= out;
	}
	
	public void run()
	{
		char[] buffer = new char[1024];
		int gelesen;
		
		while (running)
		{
			try
			{
				while( (gelesen = input.read(buffer)) != -1)
				{
				output.write(buffer, 0, gelesen);
				output.flush();
				Thread.yield();
				}
			}
			catch (Exception ex)
			{
			}
			
			output.println("Verbindung zu Server beendet");
			output.flush();
			return;
			
		}
		
		
		
	}
	
	
}
