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

public class Pause extends JPanel implements Commons
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image background;
	Image pause;
	MyFrame frame;
	MyButton play;
	MyButton replay;	
	MyButton scoreBoard;
	Invoker invoker;
	NewGame command;
	ShowScore command1;
	
	public Pause(MyFrame frame)
	{
		this.frame = frame;
		
		background = loadAssets("pause.gif");
		pause = loader.getMenuPause();
		
		play = new MyButton(200, 500, 150, 150, loader.getPlay());
		replay = new MyButton(450, 500, 150, 150, loader.getReplay());
		scoreBoard = new MyButton(700, 500, 150, 150, loader.getScoreBoard());
		
		invoker = new Invoker();
		command = new NewGame(frame);
		command1 = new ShowScore(frame);
		
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
					invoker.undo(command);
				}
				
				if (replay.isOver(mouseX, mouseY))
				{
					invoker.execute(command);
				}
				
				if (scoreBoard.isOver(mouseX, mouseY))
				{
					invoker.execute(command1);
				}
			}
		});
	}
	
	@Override
    protected void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
        
        g.drawImage(background, 0, 0, 1024, 720, this);
        g.drawImage(pause, 0, 0, 1024, 365, this);
        
        g.drawImage(replay.getImage(), replay.getX(), replay.getY(), replay.getHeight(), replay.getWidth(), this);
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
