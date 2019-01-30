package Command;

import javax.swing.JPanel;

import GUI.Board;
import GUI.MyFrame;

public class NewGame implements Command
{
	private MyFrame frame;
	public static JPanel board;
	 
    public NewGame(MyFrame frame) 
    {
        this.frame = frame;
    }
 
    @Override
    public void execute() 
    {
    	board = new Board(frame);
        frame.switchPanel(board);
    }

	@Override
	public void undo() 
	{
		Board.pause = false;
		frame.switchPanel(board);
	}
}
