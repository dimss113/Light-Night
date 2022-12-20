package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.nio.file.FileSystemNotFoundException;
import java.util.Currency;
import java.util.function.LongBinaryOperator;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class HomeSettings extends GameSettings{
	// Screen Settings
	
	private static int originalTileSize = 16; // 16 x 16 tile
	private static int scale = 3;
	
	private static int tileSize = originalTileSize * scale;
	
	private static int maxScreenCol = 16; // 16 -> ukuran asli 
	private static int maxScreenRow = 9; // 12 -> ukuran asli
	private static int screenWidth = tileSize * maxScreenCol; //768 px
	private static int screenHeight = tileSize * maxScreenRow; //576 px
	
	// world settings
	private static int maxWorldCol = 16;
	private static int maxWorldRow = 9;
	private static int worldWidth = tileSize * maxWorldCol;
	private static int worldHeight = tileSize * maxScreenRow;
	
	private static int initialX = 7;
	private static int initialY = 7;
	private static int status = 1;
	private static int totalSize = 144;
	
	private static String file = "/maps/home.txt";
	private static String fileCol = "/maps/home_collide.txt";
			
	// set player default position
	int playerX ;
	int playerY;
	int playerSpeed = 4;

	public HomeSettings() {
		super(originalTileSize, scale, tileSize, maxScreenCol, maxScreenRow, screenWidth, screenHeight, maxWorldCol, maxWorldRow, 
				worldWidth, worldHeight, initialX, initialY, status, totalSize ,file , fileCol);
	}
}