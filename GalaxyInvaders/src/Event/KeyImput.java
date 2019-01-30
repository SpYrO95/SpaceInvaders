package Event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GUI.Board;


public class KeyImput implements KeyListener
{
	Board game;
	
	public KeyImput(Board game) 
	{
		this.game = game;
	}
	
	/*
	 * Funzioni dei tasti. Definiscono i movimenti del player. In initBoard() viene
	 * creato un keyListener attraverso la classe keyImput.
	 */

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int x = game.getPlayer().getX();
		int y = game.getPlayer().getY();

		int key = e.getKeyCode();

		if(key == KeyEvent.VK_P)
			Board.pause = !Board.pause;
		
		if(game.ingame && !Board.pause ) 
		{
			if(key == KeyEvent.VK_SPACE)  
			{
				if (!game.getBomb().isVisible()) 
				{
					game.getBomb().setVisible(true);
					game.getBomb().setX(x+23);
					game.getBomb().setY(y);
				}
			}
			
			if (key == KeyEvent.VK_LEFT)
	        {
	            game.getPlayer().dx = -2;
	        }

	        if (key == KeyEvent.VK_RIGHT) 
	        {
	        	game.getPlayer().dx = 2;
	        }
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT)
        {
            game.getPlayer().dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) 
        {
        	game.getPlayer().dx = 0;
        }
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
	}	

}
