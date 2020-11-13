import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class PferdeFrame extends JFrame implements ActionListener{

	
	//Objekte für die JMenuBar werden erstellt
	private JMenuBar menubar = new JMenuBar();
	private JMenu menu1 = new JMenu("Spiel");
	private JMenuItem menuitem1 = new JMenuItem("Starten");
	private JMenuItem menuitem2 = new JMenuItem("Stoppen");
	private JMenuItem menuitem3 = new JMenuItem("Beenden");
	
	//Panel auf dem das Grüne Spielfeld ist und alle Pferde gezeichnet werden
	private PferdePanel panel = new PferdePanel();
	
	
	public PferdeFrame()
	{
		init();
	}
	
	public void init()
	{
		//Standard bei allen Frames
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pferderennen");
		this.setLayout(new FlowLayout());
		this.setSize(new Dimension(1200, 600));
		
		//Auf die Menuitems wird der ActionListener (this) hinzugefügt
		menuitem1.addActionListener(this);
		menuitem2.addActionListener(this);
		menuitem3.addActionListener(this);
		
		//MenuItems werden dem Menu und Menu der Menubar hinzugefügt
		menu1.add(menuitem1);
		menu1.add(menuitem2);
		menu1.add(menuitem3);
		menubar.add(menu1);
		
		//MenuBar wird dem Frame (this -also DIESER Frame) hinzugefügt
		this.setJMenuBar(menubar);
		this.setContentPane(panel);
		
		
	}
	// Methode für den ActionListener (muss immervorhanden sein 
	// wenn oben implements ActionListener steht)
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == menuitem1)
		{
			panel.go();
		}
		if(src == menuitem2)
		{
			panel.stop();
		}
		if(src == menuitem3)
		{
			System.exit(0);
		}
		
		
	}
	
	
	
}

