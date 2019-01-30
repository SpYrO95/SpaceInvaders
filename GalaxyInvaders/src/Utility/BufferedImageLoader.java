package Utility;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader 
{	
	private Image player;
	private Image alien;
	private Image shot;
	private Image bomb;
	private Image backgroundGame;
	private Image gameOver;
	private Image play;
	private Image scoreBoard;
	private Image exit;
	private Image galaxyInvades;
	private Image pause;
	private Image replay;
	private Image score;
	private Image menuPause;

	public BufferedImageLoader()
	{
		try 
		{
			player = ImageIO.read(new File("src/images/player.png"));
			alien = ImageIO.read(new File("src/images/alien.png"));
			shot = ImageIO.read(new File("src/images/bomb.png"));
			bomb = ImageIO.read(new File("src/images/shot.png"));
			backgroundGame = ImageIO.read(new File("src/images/background.png"));
			play = ImageIO.read(new File("src/images/Play.png"));
			scoreBoard = ImageIO.read(new File("src/images/ScoreBoard.png"));
			exit = ImageIO.read(new File("src/images/Exit.png"));
			galaxyInvades = ImageIO.read(new File("src/images/galaxyInvaders.png"));
			pause = ImageIO.read(new File("src/images/pause.png"));
			replay = ImageIO.read(new File("src/images/Replay.png"));
			score = ImageIO.read(new File("src/images/score.png"));
			menuPause = ImageIO.read(new File("src/images/menupause.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public Image getPlayer() 
	{
		return player;
	}

	public Image getAlien() 
	{
		return alien;
	}

	public Image getShot() 
	{
		return shot;
	}

	public Image getBomb() 
	{
		return bomb;
	}

	public Image getBackgroundGame() 
	{
		return backgroundGame;
	}

	public Image getGameOver() 
	{
		return gameOver;
	}

	public Image getPlay() {
		return play;
	}

	public Image getScoreBoard() {
		return scoreBoard;
	}

	public Image getExit() {
		return exit;
	}

	public Image getGalaxyInvades() {
		return galaxyInvades;
	}

	public Image getPause() {
		return pause;
	}

	public void setPause(Image pause) {
		this.pause = pause;
	}

	public Image getReplay() {
		return replay;
	}

	public Image getScore() {
		return score;
	}

	public Image getMenuPause() {
		return menuPause;
	}

}
