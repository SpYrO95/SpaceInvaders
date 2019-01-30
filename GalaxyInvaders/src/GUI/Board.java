package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import Command.EndGame;
import Command.Stop;
import Event.Animation;
import Event.KeyImput;
import Logic.Alien;
import Logic.Bomb;
import Logic.Player;
import Logic.Shot;
import Logic.World;
import Utility.Commons;
import Utility.Drawer;
import Utility.Invoker;
import Utility.MyButton;

public class Board extends JPanel implements Commons 
{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dimension d;

	private Player player;
	private Shot shot;
	private Alien alien;
	private Bomb bomb;
	private int deaths = 0;
	
	public ArrayList<Alien> listaAlieni;
	public ArrayList<Shot> listaShot;
	
	public boolean ingame = true;
	public static boolean pause;
	
	public KeyListener key;
	public Drawer drawer;
	public Animation animate;
	private World animator;
	private Image background;
	
	public MyFrame frame;
	public MyButton stop;
	public Invoker invoker;
	public EndGame command;
	public Stop command1;
	
	/*
	 * Viene settato il pannello ed i relativi componenti.
	 */
	public Board(MyFrame frame) 
	{
		this.frame = frame;
		
		background = loader.getBackgroundGame();
		
		invoker = new Invoker();
		command = new EndGame(frame);
		command1 = new Stop(frame);
		
		stop = new MyButton(500, 620, 50, 50, loader.getPause());
		
		key = new KeyImput(this);
		this.addKeyListener(key);
		
		drawer = new Drawer(this);
		animate = new Animation(this);
		
		d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		gameInit();
	}

	@Override
	public void addNotify() 
	{
		super.addNotify();
	}

	/*
	 * Gli oggetti del gioco vengono inizializzati prima di essere usati.
	 */
	public void gameInit() 
	{
		eventHandler();
		
		alien = new Alien();
		bomb = new Bomb();
		
		listaAlieni = new ArrayList<Alien>();
		listaShot = new ArrayList<Shot>();
		
		pause = false;
		
		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 8; j++)
			{
				listaAlieni.add(new Alien(alien.getX()+55*j, alien.getY()+55*i));
			}
		}

    	listaShot.add(new Shot());	
    	listaShot.add(new Shot());
    	listaShot.add(new Shot());
    	listaShot.add(new Shot());
    	listaShot.add(new Shot());
    
		player = new Player();
		
		shot = new Shot();
		shot.setVisible(false);
		bomb.setVisible(false);

		if (animator == null || !ingame) 
		{
			animator = new World(this);
			animator.start();
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
				
				if (stop.isOver(mouseX, mouseY))
				{
					pause = true;
					invoker.execute(command1);
				}
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		g.fillRect(0, 0, d.width, d.height);
		g.setColor(Color.green);
		g.setFont(new Font("bold", Font.BOLD, 25));
		
		if(ingame) 
		{			
			g.drawImage(background, 0, 0, 1024, 720, this);
			g.drawLine(0, GROUND, BOARD_WIDTH, GROUND);
			g.drawImage(stop.getImage(), stop.getX(), stop.getY(), stop.getHeight(), stop.getWidth(), this);
			
			drawer.drawPlayer(g);
			drawer.drawAliens(g);
			drawer.drawShot(g);
			drawer.drawBombing(g);
			
			g.drawString("Score:" + getDeaths()*10, 880, 660);
		}
		else
		{
			invoker.execute(command);
		}
		
		if(pause)
		{
			invoker.execute(command1);
		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Shot getShot() {
		return shot;
	}

	public void setShot(Shot shot) {
		this.shot = shot;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	
	public Bomb getBomb() {
		return bomb;
	}

	public void setBomb(Bomb bomb) {
		this.bomb = bomb;
	}

	public Alien getAlien() {
		return alien;
	}
	
	public void end() { 
		ingame = false; 
	}

	public void setBackground(Image background) {
		this.background = background;
	}
	
}
