package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.PrimitiveIterator.OfDouble;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.GameSettings;
import main.HomeSettings;
import main.KeyHandler;

public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyH;
	GameSettings gs;
	
	public final int screenX;
	public final int screenY;
	public int initialPosX;
	public int initialPosY;
	public int tileSize;
	
	
	
	public Player(GamePanel gp, GameSettings gs, KeyHandler keyH, int initialposX, int initialposY) {
		this.gp = gp;
		this.gs = gs;
		this.keyH = keyH;
		this.initialPosX = initialposX;
		this.initialPosY = initialposY;
		screenX = gs.getScreenWidth()/2 - (gs.getTileSize()/2);
		screenY = gs.getScreenHeight()/2 - (gs.getTileSize()/2);
		
		solidArea = new Rectangle();
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = gs.getTileSize() - 16;
		solidArea.height = gs.getTileSize() - 16;
		this.tileSize = gs.getTileSize();
		
		
		setDefaultValues();
		getPlayerImage(); 
	}
	

	public void setDefaultValues() {
		worldX = tileSize * initialPosX; // starting position (center of screen)
		worldY = tileSize * initialPosY; // starting position (center of screen)
//		worldX = gp.tileSize * 36;
//		worldY = gp.tileSize * 35;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/10.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/11.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player/12.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player/3.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/7.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/8.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/9.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/4.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/5.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/6.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed == true || keyH.rightPressed == true) {
			if(keyH.upPressed == true) {
				direction = "up";
			}
			else if(keyH.downPressed ==  true) {
				direction = "down";
			}else if(keyH.leftPressed == true) {
				direction = "left";
			}else if(keyH.rightPressed == true) {
				direction = "right";
			}		
			
			// CHECK TILE COLLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			if(collisionOn == false) {
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
			}
			
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 3;
				}
				else if(spriteNum == 3) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}			
		}
		
	}
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);	
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up" :
			if(spriteNum == 1) {
				image = up1;				
			}
			if(spriteNum == 2) {
				image = up2;
			}
			if(spriteNum == 3) {
				image = up3;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;				
			}
			if(spriteNum == 2) {
				image = down2;
			}
			if(spriteNum == 3) {
				image = down3;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;				
			}
			if(spriteNum == 2) {
				image = left2;
			}
			if(spriteNum == 3) {
				image = left3;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;				
			}
			if(spriteNum == 2) {
				image = right2;
			}
			if(spriteNum == 3) {
				image = right3;				
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, gs.getTileSize(), gs.getTileSize(), null);
	}
}
