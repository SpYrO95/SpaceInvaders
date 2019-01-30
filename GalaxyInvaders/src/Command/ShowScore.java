package Command;

import javax.swing.JPanel;

import GUI.MyFrame;
import GUI.ScoreBoard;

public class ShowScore implements Command 
{

	private MyFrame frame;
	public static JPanel scoreBoard;
	 
    public ShowScore(MyFrame frame) 
    {
        this.frame = frame;
    }

	@Override
	public void execute() 
	{
		scoreBoard = new ScoreBoard(frame);
        frame.switchPanel(scoreBoard);
	}

	@Override
	public void undo() 
	{
		//vuoto
	}

}
