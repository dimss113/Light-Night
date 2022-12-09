package main;

public class Cave02Settings extends GameSettings{
	
	private static  int originalTileSize = 16; // 16 x 16 tile
	private static int scale = 3;
	
	private static int tileSize = originalTileSize * scale;
	
	private static int maxScreenCol = 16; // 16 -> ukuran asli 
	private static int maxScreenRow = 9; // 12 -> ukuran asli
	private static int screenWidth = tileSize * maxScreenCol; //768 px
	private static int screenHeight = tileSize * maxScreenRow; //576 px
	
	// world settings
	private static int maxWorldCol = 14;
	private static int maxWorldRow = 20;
	private static int worldWidth = tileSize * maxWorldCol;
	private static int worldHeight = tileSize * maxScreenRow;
	
	
	private static int initialX = 7;
	private static int initialY = 18;
	private static int status = 4;
	private static int maxCol = 320;
	
	private static String file = "/maps/cave02.txt";
	private static String fileCol = "/maps/cave02_collide.txt";
	
	public Cave02Settings() {
		super(originalTileSize, scale, tileSize, maxScreenCol, maxScreenRow, screenWidth, screenHeight, maxWorldCol, maxWorldRow, 
				worldWidth, worldHeight, initialX, initialY, status, maxCol ,file , fileCol);
	}
}
