package Event;

import java.util.ArrayList;
import java.util.Random;

import GUI.Board;
import Logic.Alien;
import Logic.Shot;
import Utility.Commons;

public class Animation implements Commons
{
	private Board game;
	private int direction;
	private int i = 1;
	private int j = -1;

	public Animation(Board g)
	{
		game = g;
		direction = j;
	}

	/*
	 * Funzione che regola il comportamento delle immagini durante la partita.
	 */

	public void animationCycle() 
	{
		if (game.getDeaths() == Commons.NUMBER_OF_ALIENS_TO_DESTROY) 
		{
			game.ingame = false;
		}

		animatePlayer();
		animateShot();
		animateAliens();
		animateBomb();
	}

	// Il player si muove a destra e a sinisstra mentre spara.
	public void animatePlayer()
	{
		game.getPlayer().act();
	}

	/*
	 * Quando il player spara viene disegnata nella sua posizione un proittile.
	 * Finch� non entrer� in contatto con il nemico la sua posizione verr�
	 * aggiornata. Altrimenti continua il suo percorso.
	 */

	public void animateShot()
	{			
		ArrayList<Shot> lista = game.listaShot;

		for(Shot o : lista) {
			if(!o.isVisible()) 
			{

				Random random = new Random();
				int r;

				for(Alien alieno : game.listaAlieni) 
				{
					if (alieno.isVisible()) 
					{
						r = random.nextInt(NUMBER_OF_ALIENS_TO_DESTROY);
						if(r==0)
						{
							o.setY(alieno.getY());
							o.setX(alieno.getX());
							o.setVisible(true);
						}
					}
				}
			}
			else {


				o.setY(o.getY()+3);

				if (Collision.CollisionShot(o,game.getPlayer()))
				{
					game.getPlayer().reduceLife();
					o.die();
					if(game.getPlayer().getLife() == 0) {
						game.end();
					}	

				}

			}
			if (o.getY() > GROUND + PLAYER_HEIGHT) 
			{
				o.die();
			} 
		}
	}

	/*
	 * Vengono disegnati i nemici e ne viene aggiornata la posizione. Se i nemici
	 * entrano in contatto con il ground vincono.
	 */

	public void animateAliens()
	{
		for(Alien alieno : game.listaAlieni) 
		{			
			if (alieno.isVisible()) 
			{
				if (alieno.getX() >= Commons.BOARD_WIDTH - Commons.BORDER_RIGHT && direction > 0)  
				{
					direction = j--;
					aliensGoDown();
				}
				
				if (alieno.getX() <= Commons.BORDER_LEFT && direction < 0) 
				{
					direction = i++;
					aliensGoDown();
				}
				
				if (alieno.getY() > Commons.GROUND - Commons.ALIEN_HEIGHT) 
				{
					game.ingame = false;
				}
				
				alieno.act(direction);
				
				if(alieno.isDying()) 
				{
					alieno.die();
				}
			}
		}
	}

	/*
	 * Vengono generate delle bombe e disegnate nella posizione dei nemici, scalando
	 * poi l'altezza finche la bomba non entra in contatto con il player. Altrimenti
	 * continua il suo percorso.
	 */

	public void animateBomb()
	{
		if (game.getBomb().getY() < 0) 
			game.getBomb().die();
		else 
			game.getBomb().setY(game.getBomb().getY() - 4);

		for(Alien alieno : game.listaAlieni) 
		{
			if (Collision.CollisionBomb(game.getBomb(), alieno) && alieno.isVisible()) 
			{
				if(game.getBomb().isVisible()) {
					alieno.setDying(true);
					game.setDeaths(game.getDeaths() + 1);
					game.getBomb().die();
				}
			}
		}
	}

	public void aliensGoDown() 
	{
		for(Alien alieno : game.listaAlieni) 
		{
			if(alieno.isVisible()) {
				alieno.setY(alieno.getY() + Commons.GO_DOWN);
			}
		}
	}
}












