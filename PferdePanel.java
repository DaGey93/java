import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PferdePanel extends JPanel{
	
	// Neuer Vector wird erstellt - hier werden alle
	// Pferdeobjekte gespeichert
	Vector allePferde = new Vector();
	
	
	public PferdePanel()
	{
	}
	
	// Wenn in der Frame-Klasse über den ActionListener
	// auf "Starten" gedrückt wird, wird diese Methode 
	// gestartet
	// in der For-Schleife werden 5 Objekte erstellt
	public void go()
	{
		for(int i=1; i<6; i++)
		{
			pferdThread o = new pferdThread(i);	// ein neuer Thread wird erstellt
			allePferde.add(o);					// der Thread o wird dem vector allePferde hinzugefügt
			o.start();							// hier wird der Thread gestartet
		}
	}
	
	public void stop()
	{
		// Wenn in der Frame-Klasse über den ActionListener
		// auf "Stoppen" gedrückt wird, wird diese Methode 
		// gestartet
		// Für jedes einzelne Objekt des Vektors, wird die 
		// Methode stopPferd aufgerufen
		for(int i=0; i<allePferde.size(); i++)
		{
			// allePferde.get(i) holt das i-te Objekt aus dem Vector
			// (pferdThread) castet das Objekt zurück als Thread
			// Das ganze wird dann einem neuen Objekt zugewiesen,
			// mit dem wir arbeiten können
			
			pferdThread pf = (pferdThread) allePferde.get(i);
			pf.stopPferd();			
		}
	}
	
	// GrafikMethode (ist auch immer gleich)
	public void paint (Graphics gra)
	{
		// dunkelgüner Hintergrund wird als neue Farbe gesetzt
		gra.setColor(new Color(67,109,69));
		// Es wird ein neues "ausgefülltes" Rechteck erzeugt
		gra.fillRect(0, 0, 1300, 800);
		
		// Farbe wird auf Weiss gesetzt und ein neues Rechteck - 
		// hier unsere Ziellinie - erstellt
		gra.setColor(Color.white);
		gra.fillRect(1100, 0, 50, 800);
		
		// Schriftzug für die Finish-Linie
		gra.setColor(Color.BLACK);
		gra.drawString("FINISH", 1100, 10);
		
		
		// In dieser Schleife werden alle Objekte (also die Pferde abgearbeitet)
		// also gezeichnet (allePferde.size ist gleich die Größe des Vektors)
		for(int i=0; i<allePferde.size(); i++)
		{
			// allePferde.get(i) holt das i-te Objekt aus dem Vector
			// (pferdThread) castet das Objekt zurück als Thread
			// Das ganze wird dann einem neuen Objekt zugewiesen,
			// mit dem wir arbeiten können
			
			pferdThread pf = (pferdThread) allePferde.get(i);
			
			// Mit get_pferdX, Y, C holen wir den X-, Y-, und Farbwert
			// aus dem Thread-Objekt, die Werte sind ja für jedes Objekt
			// extra bzw unterschiedlich gespeichert, ähnlich unseren
			// Nahrungsmitteln
			int pferdX = pf.get_pferdX(); 
			int pferdY = pf.get_pferdY();
			Color pferdC = pf.get_pferdC();
			
			// Farbe wird auf die Farbe des Pferdes gesetzt 
			// und anschließend als neues Rechteck gezeichnet
			gra.setColor(pferdC);
			gra.fillRect(pferdX, pferdY, 70, 20);
			
			// weisser Rahmen um das Rechteck damit man
			// es auf dem Hintergrund besser erkennen kann
			gra.setColor(Color.white);
			gra.drawRect(pferdX, pferdY, 70, 20);
			
			repaint();
		}
	}
}
