package GUI;

import java.awt.Color;
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

public class GameOver extends JPanel implements Commons
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image background;
	MyFrame frame;
	MyButton replay;
	MyButton scoreboard;
	MyButton exit;
	Invoker invoker;
	NewGame command;
	ShowScore command2;
	
	public GameOver(MyFrame frame)
	{
		this.frame = frame;
		setBackground(Color.BLACK);
	
		background = loadAssets("gameOver.gif");
		
		replay = new MyButton(250, 525, 100, 100, loader.getPlay());
		scoreboard = new MyButton(450, 525, 100, 100, loader.getScoreBoard());
		exit = new MyButton(650, 525, 100, 100, loader.getExit());
		
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
				
				if (replay.isOver(mouseX, mouseY))
				{
					invoker.execute(command);
				}
				
				if (scoreboard.isOver(mouseX, mouseY)) {
					invoker.execute(command2);
				}
				
				if (exit.isOver(mouseX, mouseY)) {
					invoker.undo(command);
				}
			}
		});
	}
	
	@Override
    protected void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 1024, 720, this);
        g.drawImage(replay.getImage(), replay.getX(), replay.getY(), replay.getHeight(), replay.getWidth(), this);
        g.drawImage(scoreboard.getImage(), scoreboard.getX(), scoreboard.getY(), scoreboard.getHeight(), scoreboard.getWidth(), this);
        g.drawImage(exit.getImage(), exit.getX(), exit.getY(), exit.getHeight(), exit.getWidth(), this);
	}
	
	public Image loadAssets(String path)
	{
		URL url = this.getClass().getResource(path);
		Image gameOver = Toolkit.getDefaultToolkit().getImage(url);
		return gameOver;
	}
}
