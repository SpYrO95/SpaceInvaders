package Event;

import Logic.*;

public class Collision 
{
	public static boolean CollisionShot(Shot shot, Player player) 
	{
		if(shot.getBounds().intersects(player.getBounds())) 
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean CollisionBomb(Bomb bomb, Alien alien) 
	{
		if(alien.getBounds().intersects(bomb.getBounds())) 
		{
			return true;
		}
		
		return false;
	}
}
