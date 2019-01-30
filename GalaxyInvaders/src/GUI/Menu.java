package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JPanel;

import Command.NewGame;
import Command.ShowScore;
import Utility.Commons;
import Utility.Invoker;
import Utility.MyButton;

public class Menu extends JPanel implements Commons
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image background;
	Image galaxyInvades;
	MyFrame frame;
	MyButton play;	
	MyButton scoreBoard;
	Invoker invoker;
	NewGame command;
	ShowScore command2;
	
	public Menu(MyFrame frame)
	{
		this.frame = frame;
		
		background = loadAssets("space.gif");
		galaxyInvades = loader.getGalaxyInvades();
		
		play = new MyButton(325, 325, 150, 150, loader.getPlay());
		scoreBoard = new MyButton(500, 325, 150, 150, loader.getScoreBoard()); 
		
		invoker = new Invoker();
		command = new NewGame(frame);
		command2 = new ShowScore(frame);
		
		eventHandler();
	}
	
	private void eventHandler() 
	{
		this.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int mouseX = e.getX();
				int mouseY = e.getY();
				
				if (play.isOver(mouseX, mouseY))
				{
					invoker.execute(command);
				}
				
				if (scoreBoard.isOver(mouseX, mouseY))
				{
					invoker.execute(command2);
				}
			}
		});
	}
	
	@Override
    protected void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
        
        g.drawImage(background, 0, 0, 1024, 720, this);
        g.drawImage(galaxyInvades, 45, 10, 920, 300, this);
        
        g.drawImage(play.getImage(), play.getX(), play.getY(), play.getHeight(), play.getWidth(), this);
        
        g.drawImage(scoreBoard.getImage(), scoreBoard.getX(), scoreBoard.getY(), scoreBoard.getHeight(), scoreBoard.getWidth(), this);
	}
	
	public Image loadAssets(String path)
	{
		URL url = this.getClass().getResource(path);
		Image background = Toolkit.getDefaultToolkit().getImage(url);
		return background;
	}
}
