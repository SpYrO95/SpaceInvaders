package Logic;

import java.awt.Image;
import java.awt.Rectangle;

public class Shot extends GameObjects  {

    @Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,8,20);
	}

	private Image shot;
    
    public Shot() 
    {
    	shot = loader.getShot();
    	setImage(shot);
		visible = false;
    }

    
}







