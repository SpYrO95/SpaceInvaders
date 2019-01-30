package Command;

import javax.swing.JPanel;

import GUI.MyFrame;
import GUI.Pause;

public class Stop implements Command
{
	public MyFrame frame;
	public static JPanel pause;
	
	public Stop(MyFrame frame) 
    {
        this.frame = frame;
    }
	
	@Override
	public void execute() 
	{
		pause = new Pause(frame);
		frame.switchPanel(pause);
	}

	@Override
	public void undo() 
	{
		
	}
}
