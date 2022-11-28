package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.PrimitiveIterator.OfDouble;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = gp.tileSize - 16;
		solidArea.height = gp.tileSize - 16;
		
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
//		worldX = gp.tileSize * 23; // starting position (center of screen)
//		worldY = gp.tileSize * 21; // starting position (center of screen)
		worldX = gp.tileSize * 36;
		worldY = gp.tileSize * 35;
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
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
