import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class jumpingBallFrame extends JFrame implements MouseListener{

	JPanel panel = new JPanel();
	Color c = Color.blue;
	
	int x = 100;
	int y = 100;
	
	jumpThread ball = new jumpThread(x, y);
	
	
	
	public jumpingBallFrame()
	{
		init();
	}
	
	
	public void init()
	{
		this.setTitle("Jumping Ball");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addMouseListener(this);
		
		this.add(panel);
		
		ball.start();
	}
	
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, 2000, 2000);
		g.setColor(c);
		
		int x_ = ball.getX();
		int y_ = ball.getY();
		
		
		g.fillOval(x_-15, y_-15, 30, 30);
		
		repaint();
	}
	
	public void mouseClicked(MouseEvent e) 
	{
		if (c == Color.blue)
		{
			c = Color.red;
		}
		else
		{
			c = Color.blue;
		}
		
		repaint();
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
}
