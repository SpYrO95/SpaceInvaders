package Logic;

import java.awt.Image;

public class Alien extends GameObjects
{
	private final static int ALIEN_INIT_X = 1;
	private final static int ALIEN_INIT_Y = 1;
	
    private Image alien;
    private Bomb bomb;
    
    public Alien()
    {
    	super(ALIEN_INIT_X, ALIEN_INIT_Y);
    	alien = loader.getAlien();
    	initAlien(x, y);
    }

    public Alien(int x, int y) 
    {
    	super(x, y);
    	alien = loader.getAlien();
    	initAlien(x, y);
    }

    private void initAlien(int x, int y) 
    {
        this.x = x;
        this.y = y;
        setImage(alien);
        bomb = new Bomb(x, y);
    }

    public void act(int direction) 
    {
        this.x += direction;
    }
    
    public void setBomb(Bomb b)
    {
    	bomb = b;
    }
    
    public Bomb getBomb()
    {
    	return bomb;
    }
}
