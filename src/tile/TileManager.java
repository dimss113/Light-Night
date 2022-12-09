package tile;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.GameSettings;
import entity.Entity;

public class TileManager {
	
	GamePanel gp;
	GameSettings gs;
	public Tile[] tile;
	public int mapTileNum[][];
//	public int num[];
	
	List<Integer>num = new ArrayList<Integer>(); 
	
	public TileManager(GamePanel gp, GameSettings gs, int status, int size, String file, String fileCollide) {
		this.gp = gp;
		this.gs = gs;
		
		tile = new Tile[2900];
		mapTileNum = new int[gs.getMaxWorldCol()][gs.getMaxWorldRow()];
		
		getTileImage(size, status);
		loadMap(file);
		loadColl(fileCollide);
		getCollision();
	}
	
	public void loadMap(String filepath) {
		try {
			InputStream is = getClass().getResourceAsStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0; 
			int row = 0;
			
			while(col < gs.getMaxWorldCol() && row < gs.getMaxWorldRow()) {
				String lineString = br.readLine();
				
				while(col < gs.getMaxWorldCol()) {
					String numbers[] = lineString.split(" ");
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gs.getMaxWorldCol()) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadColl(String filepath) {
		try {
			InputStream isColl = getClass().getResourceAsStream(filepath);
			BufferedReader brColl = new BufferedReader(new InputStreamReader(isColl));
			String lineString = brColl.readLine();
			
			int cek =0;
			
			String[] numbers;
			numbers = lineString.split(" ");
			for(String nums: numbers) {
//				num[cek] =  new int(Integer.parseInt(nums));
				num.add(Integer.parseInt(nums));
				if(num.get(cek) == 2303) {
					break;
				}
				cek++;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getCollision() {
		for(int i=0;i<num.size();i++) {
			int getCol;
			getCol = num.get(i);
			tile[getCol].collision = true;
		}
	}
	
	public void getTileImage(int num, int status) {
		try {		
			for(int i=0;i<num;i++) {
				String pathString = null;
				if(status == 1) {
					pathString = "/tiles/villagemap_" + i + ".png";
				}
				else if(status == 2) {
					pathString = "/tiles/home_" + i + ".png";
				}
				
				else if(status == 3) {
					pathString = "/tiles/cave01_" + i + ".png";
				}
				
				else if(status == 4) {
					pathString = "/tiles/cave02_" + i + ".png";
				}
				
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
		
		while(worldCol < gs.getMaxWorldCol() && worldRow < gs.getMaxWorldRow()) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX =  worldCol * gs.getTileSize(); 
			int worldY = worldRow * gs.getTileSize();
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gs.getTileSize()> gp.player.worldX - gp.player.screenX &&
					worldX - gs.getTileSize() < gp.player.worldX + gp.player.screenX &&
					worldY + gs.getTileSize() > gp.player.worldY - gp.player.screenY &&
					worldY - gs.getTileSize() < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, gs.getTileSize(), gs.getTileSize(), null);				
			}
			worldCol++;
			if(worldCol == gs.getMaxWorldCol()) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
}