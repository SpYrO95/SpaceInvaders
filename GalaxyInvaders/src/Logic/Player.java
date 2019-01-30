package Logic;

import java.awt.Image;

public class Player extends GameObjects
{

    private final static int START_Y = 550;
    private final static int START_X = 500;

    private Image player;
    
    private int life;

    public Player() 
    {
    	super(START_X, START_Y);
    	player = loader.getPlayer();
        initPlayer();
    }

    private void initPlayer() 
    {
        setImage(player);
        setX(START_X);
        setY(START_Y);
        life = 3;
    }

    public void act() 
    {
        x += dx;
        
        if (x <= 2) 
        {
            x = 2;
        }
        
        if (x >= BOARD_WIDTH - BORDER_RIGHT) 
        {
            x = BOARD_WIDTH - BORDER_RIGHT;
        }
    }
    
    public int getLife() { return life; }
    public void reduceLife() { life--; }
    
}
