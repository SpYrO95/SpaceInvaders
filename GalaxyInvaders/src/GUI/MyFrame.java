package GUI;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Utility.Commons;

public class MyFrame extends JFrame implements Commons
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JPanel menu;
	
	public MyFrame()
	{
		menu = new Menu(this);
	}

	public void init()
	{				
		getContentPane().add(menu);
		repaint();
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1024, 720));
		setResizable(false);
		setVisible(true);
		setTitle("Galaxy Invaders");
		pack();
	}
	
	public void switchPanel(JPanel panel)
	{		
		setContentPane(panel);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		revalidate();
		pack();
	}
}
