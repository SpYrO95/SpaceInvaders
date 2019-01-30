package Utility;

import java.awt.Image;

public class MyButton 
{
	public int x, y, height, width;
	public Image img;
	
	public MyButton(int x, int y, int height, int width, Image image)
	{
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.img = image;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public Image getImage()
	{
		return img;
	}
	
	public void setImage(Image img)
	{
		this.img = img;
	}
	
	public boolean isOver(int mouseX,int mouseY)
	{
		if(mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height)
			return true;
		return false;
	}
}
