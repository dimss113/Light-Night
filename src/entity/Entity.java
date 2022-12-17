package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.GameSettings;

public class Entity {
	GamePanel gp;
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage up1, up2, up3,up4,up5, up6, down1, down2, down3, down4, down5, down6, left1, left2, left3,left4, left5, left6, right1, right2, right3, right4, right5,right6;
	public String direction;
	public boolean removeObj;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	public int actionLockCounter = 0;
	
	//Character status
	public int maxLife;
	public int curLife;
	public String name;
	public boolean invisible = false;
	public int invisibleCounter = 0;

	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setAction() {
	};
	
	public void update() {};

	public void draw(Graphics2D g2) {
	};
	
	
}
