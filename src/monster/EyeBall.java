package monster;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;
import main.GameSettings;

public class EyeBall extends Entity{
	GamePanel gp;
	public int tileSize;
	
	public BufferedImage image;
	
	public EyeBall(GamePanel gp) {
		super(gp);
		this.gp = gp;
		this.tileSize = gp.getGs().getTileSize();
		
		name = "Eye Ball";
		maxLife = 4;
		speed = 1;
		direction = "down";
		
		solidArea = new Rectangle();
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = tileSize - 16;
		solidArea.height = tileSize - 16;
		
		// recall default value
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage(); 
		
	}
	
	
	public void getImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/monster/7.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/monster/7_2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/monster/7_3.png"));
			up4= ImageIO.read(getClass().getResourceAsStream("/monster/7_4.png"));
			up5 = ImageIO.read(getClass().getResourceAsStream("/monster/7_5.png"));
			up6 = ImageIO.read(getClass().getResourceAsStream("/monster/7_6.png"));

			down1 = ImageIO.read(getClass().getResourceAsStream("/monster/7.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/monster/7_2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/monster/7_3.png"));
			down4= ImageIO.read(getClass().getResourceAsStream("/monster/7_4.png"));
			down5 = ImageIO.read(getClass().getResourceAsStream("/monster/7_5.png"));
			down6 = ImageIO.read(getClass().getResourceAsStream("/monster/7_6.png"));
			
			left1 = ImageIO.read(getClass().getResourceAsStream("/monster/7.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/monster/7_2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/monster/7_3.png"));
			left4= ImageIO.read(getClass().getResourceAsStream("/monster/7_4.png"));
			left5 = ImageIO.read(getClass().getResourceAsStream("/monster/7_5.png"));
			left6 = ImageIO.read(getClass().getResourceAsStream("/monster/7_6.png"));
			
			right1 = ImageIO.read(getClass().getResourceAsStream("/monster/7.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/monster/7_2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/monster/7_3.png"));
			right4= ImageIO.read(getClass().getResourceAsStream("/monster/7_4.png"));
			right5 = ImageIO.read(getClass().getResourceAsStream("/monster/7_5.png"));
			right6 = ImageIO.read(getClass().getResourceAsStream("/monster/7_6.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setAction() {
		actionLockCounter++;
		
		if(actionLockCounter == 30) {
			Random rand = new Random();
			int i = rand.nextInt(100)+1;
			
			if(i <= 25) {
				direction = "up";
			}
			
			if(i > 25 && i <= 50 ) {
				direction = "down";
			}
			if(i > 50 && i <= 75 ) {
				direction = "left";
			}
			if(i > 25 && i <= 50 ) {
				direction = "right";
			}
			
			actionLockCounter = 0;
		}
	}
	
	public void update() {
		// CHECK TILE COLLISION
		setAction();
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkEntity(this, gp.monster);
		boolean contactPlayer = gp.cChecker.checkPlayer(this, gp.player);
		
		if(contactPlayer == true && gp.player.invisible == false) {
			gp.player.curLife -= 1;
			gp.playSE(5);
			gp.player.invisible = true;
		}
		
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
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;

		
		if(worldX + tileSize> gp.player.worldX - gp.player.screenX &&
				worldX - tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - tileSize < gp.player.worldY + gp.player.screenY) {
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
				if(spriteNum == 4) {
					image = up4;
				}
				if(spriteNum == 5) {
					image = up5;				
				}
				if(spriteNum == 6) {
					image = up6;
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
				if(spriteNum == 4) {
					image = down4;				
				}
				if(spriteNum == 5) {
					image = down5;
				}
				if(spriteNum == 6) {
					image = down6;
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
				if(spriteNum == 4) {
					image = left4;
				}
				if(spriteNum == 5) {
					image = left5;				
				}
				if(spriteNum == 6) {
					image = left6;
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
				if(spriteNum == 4) {
					image = right4;
				}
				if(spriteNum == 5) {
					image = right5;				
				}
				if(spriteNum == 6) {
					image = right6;
				}

				break;
			}
			
			g2.drawImage(image, screenX, screenY, tileSize, tileSize, null);				
		}
	}
}

