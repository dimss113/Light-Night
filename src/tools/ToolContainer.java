package tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.GameSettings;

public class ToolContainer {
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	public boolean showTool = false;
	public int tileSize;
	
	public void draw(Graphics2D g2, GamePanel gp, GameSettings gs) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		this.tileSize = gs.getTileSize();
		
		if(worldX + tileSize> gp.player.worldX - gp.player.screenX &&
				worldX - tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - tileSize < gp.player.worldY + gp.player.screenY) {
			g2.drawImage(image, screenX, screenY, tileSize, tileSize, null);				
		}
		
	}
}
