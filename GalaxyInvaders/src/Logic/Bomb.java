package Logic;

import java.awt.Image;

public class Bomb extends GameObjects
{
	private final static int H_SPACE = 6;
    private final static int V_SPACE = 1;
    
    private Image bomb;
    
    public Bomb()
    {
    	super(H_SPACE, V_SPACE);
    	bomb = loader.getBomb();
    	initBomb(x, y);
    }

    public Bomb(int x, int y) 
    {
    	super(x, y);
    	bomb = loader.getBomb();
        initBomb(x, y);
    }

    private void initBomb(int x, int y) 
    {
        this.x = x;
        this.y = y;
        setImage(bomb);

    }
}