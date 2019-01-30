package Utility;

import java.awt.Graphics;

import GUI.Board;
import Logic.Alien;
import Logic.GameObjects;

public class Drawer implements Commons
{
	private Board game;
	
	public Drawer(Board g)
	{
		this.game = g;
	}
	
	/*
	 * Graphics: Funzioni che disegnano sul pannello le immagini dei nemici, del
	 * player, dei proiettili e delle bombe.
	 */
	
	public void drawPlayer(Graphics g) 
	{
		g.drawImage(game.getPlayer().getImage(), game.getPlayer().getX(), game.getPlayer().getY(), 50, 50, null);
		
		for(int i=0; i<game.getPlayer().getLife(); i++) {
			g.drawImage(game.getPlayer().getImage(), 10 + i*40, 630, 30, 30, null);
		}
	}
	
	public void drawAliens(Graphics g) 
	{
		for(Alien alieno : game.listaAlieni) {
			if(alieno.isVisible()) {
				g.drawImage(alieno.getImage(), alieno.getX(), alieno.getY(), 45, 45, null);
			}
		}
	}
	
	public void drawShot(Graphics g) 
	{		
		for(GameObjects o : game.listaShot) {
			if(o.isVisible()) {
				g.drawImage(game.getShot().getImage(), (int)o.getX(), (int)o.getY(),8,20, null);
			}
		}
	}
	
	public void drawBombing(Graphics g) 
	{		
		if (game.getBomb().isVisible()) 
		{
			g.drawImage(game.getBomb().getImage(), (int)game.getBomb().getX(), (int)game.getBomb().getY(), 8, 20, null);
		}
	}
}
