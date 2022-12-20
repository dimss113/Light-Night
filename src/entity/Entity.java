package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.GameSettings;
import main.UtilityTool;

public class Entity {
	GamePanel gp;
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage up1, up2, up3,up4,up5, up6, down1, down2, down3, down4, down5, down6, left1, left2, left3,left4, left5, left6, right1, right2, right3, right4, right5,right6;
	public String direction;
	public boolean removeObj;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea = new Rectangle(0, 0, 50, 50);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	public int actionLockCounter = 0;
	
	String dialog[] = new String[20];
	private int dialogIndex = 0;
	
	//Character status
	public int maxLife;
	public int curLife;
	public String name;
	public boolean invisible = false;
	public int invisibleCounter = 0;

	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	
	public int getDialogIndex() {
		return dialogIndex;
	}
	
	public void setDialogIndex(int index) {
		dialogIndex = index;
	}
	
	public void increaseDialogIndex() {
		dialogIndex += 1;
	}
	
	
	public void setAction() {
	};
	
	public void update() {
		setAction();
		
		collisionOn = false;
//		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this, false);
		gp.cChecker.checkPlayerNpc(this);
		
		spriteCounter++;
		if(spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
		if(collisionOn == false) {
			spriteCounter++;
			if(spriteCounter > 4) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum =  1;
				}
			}
		}
	}

	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		
		if(worldX + gp.gs.getTileSize() > gp.player.worldX - gp.player.screenX &&
				worldX - gp.gs.getTileSize() < gp.player.worldX + gp.player.screenX &&
				worldY + gp.gs.getTileSize() > gp.player.worldY - gp.player.screenY &&
				worldY - gp.gs.getTileSize() < gp.player.worldY + gp.player.screenY) {
			
			switch(direction) {
			case "up" :
				if(spriteNum == 1) {
					image = up1;				
				}
				if(spriteNum == 2) {
					image = up2;
				}
				break;
			}
			g2.drawImage(image, screenX, screenY, gp.gs.getTileSize(),gp.gs.getTileSize(), null);				
		}
	}
	
	public BufferedImage setup(String imagePath) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, gp.gs.getTileSize(), gp.gs.getTileSize());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
	public void speak() {
		
	}
}
