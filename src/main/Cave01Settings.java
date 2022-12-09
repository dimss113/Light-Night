package main;

public class Cave01Settings extends GameSettings{
	
	private static  int originalTileSize = 16; // 16 x 16 tile
	private static int scale = 3;
	
	private static int tileSize = originalTileSize * scale;
	
	private static int maxScreenCol = 16; // 16 -> ukuran asli 
	private static int maxScreenRow = 9; // 12 -> ukuran asli
	private static int screenWidth = tileSize * maxScreenCol; //768 px
	private static int screenHeight = tileSize * maxScreenRow; //576 px
	
	// world settings
	private static int maxWorldCol = 24;
	private static int maxWorldRow = 14;
	private static int worldWidth = tileSize * maxWorldCol;
	private static int worldHeight = tileSize * maxScreenRow;
	
	
	private static int initialX = 13;
	private static int initialY = 13;
	private static int status = 3;
	private static int maxCol = 336;
	
	private static String file = "/maps/cave01.txt";
	private static String fileCol = "/maps/cave01_collide.txt";
	
	public Cave01Settings() {
		super(originalTileSize, scale, tileSize, maxScreenCol, maxScreenRow, screenWidth, screenHeight, maxWorldCol, maxWorldRow, 
				worldWidth, worldHeight, initialX, initialY, status, maxCol ,file , fileCol);
	}
}
