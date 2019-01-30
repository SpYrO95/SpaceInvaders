package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JPanel;

import Command.EndGame;
import Command.NewGame;
import Utility.Commons;
import Utility.Invoker;
import Utility.MyButton;

public class ScoreBoard extends JPanel implements Commons 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image background;
	Image score;
	MyFrame frame;
	MyButton replay;
	MyButton exit;
	Invoker invoker;
	NewGame command;
	EndGame command1;
	
	public ScoreBoard(MyFrame frame)
	{
		this.frame = frame;
		setBackground(Color.BLACK);
	
		background = loadAssets("space.gif");
		score = loader.getScore();
		
		replay = new MyButton(50, 475, 150, 150, loader.getReplay());
		exit = new MyButton(800, 475, 150, 150, loader.getExit());
		
		invoker = new Invoker();
		command = new NewGame(frame);
		command1 = new EndGame(frame);
		
		eventHandler();
	}
	
	public void Score()
	{
		Scanner scanner;

		try 
		{
			int[] lista = new int[5];
			int i=0;
			
			int score = 66;
			int temp;

			scanner = new Scanner(new File("./src/finestra/finestra.txt"));

			while(scanner.hasNext()) 
			{
				//String parola = scanner.next();
				int numero = scanner.nextInt();
				lista[i++] = numero;
			}
			
			for(i=0; i<5; i++) 
			{
				if(score > lista[i]) 
				{
					temp = lista[i];
					lista[i] = score;
					score = temp;
				}
			}

			Formatter y = new Formatter("./src/finestra/finestra.txt");
			y.format("");
			y.close();

			BufferedWriter out;
			out = new BufferedWriter(new FileWriter("./src/finestra/finestra.txt", true));

			for(int j=0; j<5; j++) 
			{
				out.write(" utente  "+lista[j]+"  \n");	
			}
		
			while(scanner.hasNext()) 
			{
				String parola = scanner.next();
				int numero = scanner.nextInt();
				lista[i++] = numero;

				System.out.println(parola+"   "+numero);
			}
			
			out.close();

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
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
					invoker.execute(command); //newgame
				}
				
				if (exit.isOver(mouseX, mouseY)) 
				{
					if(Board.pause == false)
						invoker.undo(command1);//newgame
					else
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
        g.drawImage(score, 0, 0, 974, 720, this);
        
        g.drawImage(replay.getImage(), replay.getX(), replay.getY(), replay.getHeight(), replay.getWidth(), this);
        g.drawImage(exit.getImage(), exit.getX(), exit.getY(), exit.getHeight(), exit.getWidth(), this);
        //draw scoreboard
	}
	
	public Image loadAssets(String path)
	{
		URL url = this.getClass().getResource(path);
		Image gameOver = Toolkit.getDefaultToolkit().getImage(url);
		return gameOver;
	}
	
}
