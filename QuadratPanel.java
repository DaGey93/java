import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class QuadratPanel extends JFrame implements MouseListener{

	JPanel panel = new JPanel();
	Color blau = Color.blue;
	Color rot = Color.red;
	Color c = Color.blue;
	
	
	public QuadratPanel()
	{
		init();
	}
	
	
	public void init()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("QuadratPanel");
		this.setSize(400, 400);
		this.setContentPane(panel);
		this.addMouseListener(this);
	}
	
	
	public void paint(Graphics gra)
	{
		
		gra.setColor(Color.white);
		gra.fillRect(0, 0, 3000, 3000);
		
		
		gra.setColor(c);
		// this.getWidth holt die aktuelle Breite des Frames, zu Beginn 400 (siehe this.setSize(400, 400);)
		// später dann je nachdem wie groß oder klein man das Fenster macht
		// this.getHeight genau das selbe
		// danach wird das ganze / 2 geteilt und die Mitte herauszufinden, und 100 addiert
		// 100 ist dabei die Hälfte der Kantenlänge des Rechtecks
		gra.fillRect((this.getWidth() / 2)-100, (this.getHeight() / 2)-100, 200, 200);
	}
	
	
	


	public void mouseClicked(MouseEvent e) {
		System.out.println("Maus gedrückt!");
		if(c == Color.blue)
		{
			c = rot;
		}
		else {
			c = blau;
		}
		repaint();	
		
		
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	
	public static void main(String[]args)
	{
		QuadratPanel neu = new QuadratPanel();
		neu.validate();
		neu.setVisible(true);
	}

	
	
	
}
