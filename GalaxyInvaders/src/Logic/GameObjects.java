package Logic;

import java.awt.Image;
import java.awt.Rectangle;
import Utility.Commons;

public class GameObjects implements Commons
{
	public int x, y;
	public boolean visible;
    private Image image;
    public boolean dying;
    public int dx;
    
	public GameObjects(int x, int y) 
	{
		this.x = x;
		this.y = y;
		visible = true;
	}
	
	public GameObjects() {
		visible = false;
	}
	
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, 50, 50); 
	}
	
	public void die() 
    {
        visible = false;
    }

    public boolean isVisible() 
    {
        return visible;
    }

    public void setVisible(boolean visible) 
    {
        this.visible = visible;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public Image getImage() 
    {
        return image;
    }

    public void setX(int x) 
    {
        this.x = x;
    }

    public void setY(int y) 
    {
        this.y = y;
    }

    public int getY() 
    {
        return y;
    }

    public int getX() 
    {
        return x;
    }

    public void setDying(boolean dying) 
    {
        this.dying = dying;
    }

    public boolean isDying() 
    {
        return this.dying;
    }
}
