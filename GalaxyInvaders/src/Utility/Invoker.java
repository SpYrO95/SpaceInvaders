package Utility;

import Command.Command;

public class Invoker 
{	
	public Invoker() {}
	
	public void execute(Command cmd)
	{
		cmd.execute();
	}
	
	public void undo(Command cmd) 
	{
		cmd.undo();
	}
}
