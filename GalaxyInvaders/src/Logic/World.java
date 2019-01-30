package Logic;

import GUI.Board;
import Utility.Commons;

public class World extends Thread implements Commons
{
	Board board;
	
	public World(Board b)
	{
		this.board = b;
	}
	
	/*
	 * Game loop.
	 */
	
	@Override
	public void run() 
	{
		super.run();
		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while(true) 
		{
			board.repaint();
			
			if(!Board.pause)
				board.animate.animationCycle();

			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = DELAY - timeDiff;

			try 
			{
				Thread.sleep(sleep);
			} 
			catch (InterruptedException e) 
			{
				System.out.println("interrupted");
			}

			beforeTime = System.currentTimeMillis();
		}
	}
	
}
