package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[2400];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		
		getTileImage();
		loadMap("/maps/vilg.txt");
	}
	
	public void loadMap(String filepath) {
		try {
			InputStream is = getClass().getResourceAsStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0; 
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String lineString = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = lineString.split(" ");
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getTileImage() {
		try {		
			for(int i=0;i<2304;i++) {
				String pathString = "/tiles/villagemap_" + i + ".png";
				tile[i] = new Tile();
				tile[i].image = ImageIO.read(getClass().getResourceAsStream(pathString));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {	
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX =  worldCol * gp.tileSize; 
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
					worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
					worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
					worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);				
			}
			worldCol++;
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
}
