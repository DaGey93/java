import java.awt.*;
import java.util.Random;

public class pferdThread extends Thread {

	// Running ist nötig für den Thread, 
	// damit wir später eine Variable haben um ihn wieder
	// stoppen zu können
	public boolean running = true;
	
	
	// Variablen für das Pferd, mit dem es nachher gezeichnet 
	// werden kann
	int pferdX, pferdY;
	Color pferdC;
	int pferdID;
	
	
	// Ziellinie - Wenn quasi das Rechteck diese Linie überschritten
	// hat, soll der Thread stoppen - das Pferd is ja jetzt im Ziel
	int zielline = 1100;
	
	// Random Generator für unsere zufälligen Farben für die
	// einzelnen Pferde
	Random random = new Random();
	
	
	// Konstruktur - i ist dabei das i-te Pferd
	// haben wir nicht benutzt, aber denkbar wäre es
	// als Zahl über dem Rechteck zu benutzen, bspw. als Startnummer
	public pferdThread (int i)
	{
		pferdID = i;
		pferdX = 50;
		pferdY = i*100;
		
		// Random Zahl für die RGB-Farben
		float r = random.nextFloat();
		float g = random.nextFloat();
		float b = random.nextFloat();
		// neue Zufällige Farbe wird erstellt und dem Objekt zugewiesen
		pferdC = new Color(r,g,b);
		
	}
	
	// Methode, die die ID des Pferds zurück gibt - haben wir nicht benutzt
	public int get_pferdID ()
	{
		return pferdID;
	}
	
	// Methode, die den X-Wert des Objekts zurückgibt - haben wir in der 
	// graphics Methode verwendet
	public int get_pferdX ()
	{
		return pferdX;
	}
	
	// Methode, die den Y-Wert des Objekts zurückgibt - haben wir in der 
	// graphics Methode verwendet
	public int get_pferdY ()
	{
		return pferdY;
	}
	
	// Methode, die den Farb-Wert des Objekts zurückgibt - haben wir in der 
	// graphics Methode verwendet
	public Color get_pferdC ()
	{
		return pferdC;
	}
	
	
	
	// Alles was der Thread machen soll, steht in der run()-Methode
	// aufgerufen wird sie jedoch über start(), bei uns also im Panel
	// in der go-Methode: o.start()
	
	public void run()
	{
		while (running) // Solange die Variable running auf true ist soll das ausgeführt werden:
		{
			try
			{
				// Es wird eine Zufallsvariable erstellt und in sleepTime gespeichert
				int sleepTime = 1+ (int)(1000*Math.random());
				// der Thread wartet jetzt solange, wie hoch eben die Zufallsvariable
				// ist - damit laufen alle Pferde-Objekte unterschiedlich schnell
				
				// Wer will kann man mit der 1000 rumspielen,
				// je kleiner der Wert, deste kleiner die Wartezeit, desto schneller laufen die
				// Pferde, z.b. mit 100* usw
				Thread.sleep(sleepTime);
			}
			catch(Exception Ex)
			{
				
			}
			
			// Das Pferd "hüpft" nachdem es "gewartet" hat, 15 Pixel nach rechts
			// Hier kann man auch mit dem Wert rumspielen, bspw. kleinere Hüpfer
			// machen (mit pferdX + 5 z.b.). Dauert dann halt länger, bis die 
			// Pferde am Ziel sind
			pferdX = pferdX + 15;
			
			// Wenn das Pferd die Ziellinie überschritten hat, soll der Thread gestoppt werden
			if(pferdX >= zielline)
			{
				running = false;
			}
			
		}
	}
	
	// Methode um den Thread per Hand zu stoppen
	// Wir haben das über den ActionListener implementiert
	
	// Wird in der Frame-Klasse das menuitem2 angeklickt,
	// wird im Panel die Methode public void stop() aufgerufen,
	// dort ist dann beschrieben, wie wieder alle Objekte aus dem
	// Vector "rausgezogen" (also gecastet) werden und für jedes 
	// Objekt die Methode stopPferd() aufgerufen
	public void stopPferd()
	{
		running = false;
	}
	
	
	
}
