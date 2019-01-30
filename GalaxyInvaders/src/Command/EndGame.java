package Command;

import javax.swing.JPanel;

import GUI.GameOver;
import GUI.MyFrame;

public class EndGame implements Command
{
	private MyFrame frame;
	public static JPanel gameover;
	 
    public EndGame(MyFrame frame) 
    {
        this.frame = frame;
    }

	@Override
	public void execute() 
	{
		gameover = new GameOver(frame);
        frame.switchPanel(gameover);
	}

	@Override
	public void undo() 
	{
		System.exit(0);
	}

}
