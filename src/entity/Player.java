package entity;

import java.awt.AlphaComposite;
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
	public GameSettings gs;
	
	public final int screenX;
	public final int screenY;
	public int initialPosX;
	public int initialPosY;
	public int tileSize;
	public int hasAxe = 0; // indicates how tools karakter has
	public int hasHammer = 1;
	public boolean hasShovel = false;
	public int fillBucket = 0;
	public int count = 0;
	public int prevPress = 0;
	public boolean frontHome = false;
	public boolean exitHome = false;
	public boolean frontCave = false;
	public boolean exitCave = false;
	public int shoveCount = 0;
	public boolean hasLava = true;
	public boolean frontSoil = false;
	public boolean frontPurple = false;
	public boolean frontNeon = false;
	


	

	
	public Player(GamePanel gp, GameSettings gs, KeyHandler keyH, int initialposX, int initialposY) {
		super(gp);
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
		
		// recall default value
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		setDefaultValues();
		getPlayerImage(); 
	}
	

	public void setDefaultValues() {
		worldX = tileSize * initialPosX; // starting position (center of screen)
		worldY = tileSize * initialPosY; // starting position (center of screen)
//		worldX = gp.tileSize * 36;
//		worldY = gp.tileSize * 35;
		speed = 3;
		direction = "down";
		removeObj = false;
		
		maxLife = 6;
		curLife = maxLife;
	}
	
	public void setDefaultItem() {
		hasAxe = 0;
		hasHammer = 0;
		hasShovel = false;
		fillBucket = 0;
		count = 0;
		
		hasShovel = false;
		fillBucket = 0;
		prevPress = 0;
		frontHome = false;
		exitHome = false;
		frontCave = false;
		exitCave = false;
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
		
		if(keyH.xPressed == true) {
			System.out.println("masukk x pressed");
			prevPress++;
			if(prevPress > 1) {
				removeObj = false;
			}else {
				removeObj = true;				
			}
			keyH.xPressed = false;
		}
		
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
			
			//Check Monster Collision
			int monsterInd = gp.cChecker.checkEntity(this, gp.monster);
			contactMonster(monsterInd);
			
			// check tools collision
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);
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
		
		if(invisible == true) {
			invisibleCounter++;
			if(invisibleCounter > 60) {
				invisible = false;
				invisibleCounter = 0;
			}
		}
		
		if(curLife <= 0) {
			gp.playSE(8);
			gp.gameState = gp.gameOverState;
		}
		
	}
	
	public void pickUpObject(int i) {
//		if(gp.gameState == gp.playState) {
			if(i != 99999) {
//			gp.tool[i] = null;
				String toolName = gp.tool[i].name;
				switch(toolName) {
				case "Shovel":
					gp.playSE(1);
					gp.tool[i] = null;
//				hasShovel = true;
					gp.ui.hasShovel  = true;
					gp.ui.showMessage("You got Shovel");
					break;
					
				case "Axe":
					gp.playSE(1);
					hasAxe +=2;
					gp.tool[i] = null;
//				System.out.println("Shovel: " + hasShovel);
					gp.ui.showMessage("You got Axe for remove tree ");
					break;
				case "hammer":
					gp.playSE(1);
					hasHammer +=2;
					gp.tool[i] = null;
//				System.out.println("Shovel: " + hasShovel);
					gp.ui.showMessage("You got Hammer for remove stone");
					break;
				case "bucket empty":
					gp.playSE(3);
					gp.tool[i] = null;
					fillBucket += 1;
					gp.ui.hasBucketEmpty = true;
					gp.ui.isBucketFull = false;
					gp.ui.showMessage("You got empty bucket");
					break;
				case "Boots":
					gp.playSE(2);
					speed += 0.5;
					gp.tool[i] = null;
					gp.ui.hasBoots = true;
					gp.ui.showMessage("+ 0.5 speed!");
					break;
				case "stone":
					prevPress = 0;
					if(hasHammer > 0) {
						gp.ui.showMessage("preseed x to remove stone");
						if(removeObj == true) {
							System.out.println("masuk press x");
							gp.tool[i] = null;
							hasHammer--; 
							removeObj = false;
						}
					}else {
						gp.ui.showMessage("you dont have hammer to remove stone");
					}
					break;
				case "Root 1":
					prevPress = 0;
					if(hasAxe > 0) {
						gp.ui.showMessage("press x to remove root");
						if(removeObj == true) {
//						System.out.println("masuk presx");
							gp.tool[i] = null;
							hasAxe--;
							removeObj = false;
						}
					}else {
						gp.ui.showMessage("you dont have axe to remove root");
					}
					break;
				case "Root 2":
					prevPress = 0;
					if(hasAxe > 0) {
						gp.ui.showMessage("press x to remove root");
						if(removeObj == true) {
							gp.tool[i] = null;
//						System.out.println("masuk presx");
							hasAxe--;
							removeObj = false;
						}
					}else {
						gp.ui.showMessage("you dont have shovel to remove root");
					}
					break;
				case "Chest 1":
					prevPress = 0;
					gp.ui.showMessage("press x to open chest");
					if(removeObj == true) {
						System.out.println("remove chest 1");
						gp.tool[i] = null;
						if(i == 10) {
							gp.tool[9].showTool = true;						
						}
						if(i == 32) {
							gp.tool[15].showTool =  true;
							curLife++;
						}
						if(i == 20) {
							gp.tool[5].showTool = true;
						}
						removeObj = false;
					}
					break;
				case "heart":
					prevPress = 0;
					System.out.println("masuk nulllll");
					gp.playSE(1);
					curLife++;
					gp.tool[i] = null;
					break;
				case "Chest 2":
					gp.ui.showMessage("press x to open chest");
					prevPress = 0;
					if(removeObj == true) {
						System.out.println("remove chest 2");
						gp.tool[i] = null;
						if(i == 16) {
							gp.tool[7].showTool = true;
						}
						removeObj = false;
					}
					break;
				case "sword":
					gp.playSE(2);
					gp.tool[i] = null;
					gp.ui.hasSword = true;
					gp.ui.showMessage("you got a sword");
					break;
				case "potion":
					gp.playSE(1);
					gp.tool[i] = null;
					gp.ui.hasPotion = true;
					gp.ui.showMessage("you got a potion");
					break;
				case "Chest 3":
					prevPress = 0;
					gp.ui.showMessage("press x to open chest");
					if(removeObj == true) {
						System.out.println("remove chest 3");
						gp.tool[i] = null;
						if(i == 8) {
							gp.tool[8].showTool = true;
						}
						removeObj = false;
					}
					break;
				case "well":
					prevPress = 0;
					if(gp.ui.isBucketFull == true) {
						gp.ui.showMessage("Throw water from you bucket here");
						if(removeObj == true) {
							fillBucket -= 1;
							gp.ui.isBucketFull = false;
							if(fillBucket < 0) {
								fillBucket = 0;
							}
						}
					}else if(gp.ui.isBucketFull == false && gp.ui.hasBucketEmpty == true) {
						gp.ui.showMessage("your bucket is empty");
					}else {
						gp.ui.showMessage("you do not have bucket water");
					}
					removeObj = false;
					break;
				case "water 1":
					prevPress = 0;
					if(gp.ui.hasBucketEmpty == true) {
						gp.ui.showMessage("You can Bucket the water once | press x to do it");
						if(removeObj == true && gp.ui.isBucketFull == false) {
							count++;
							if(count == 2) {
								gp.tool[21] = null;
								gp.tool[22] = null;		
								count = 0;
							}
							fillBucket += 1;
							gp.ui.isBucketFull = true;
						}
						else if(gp.ui.isBucketFull == true){
							gp.ui.showMessage("your bucket is full of water");
						}
					}else {
						gp.ui.showMessage("find bucket water to drain the lake");
					}
					removeObj = false;
					break;
				case "chest2 1":
					prevPress = 0;
					gp.ui.showMessage("press x to open chest 2");
					if(removeObj == true) {
						System.out.println("remove chest 2");
						gp.tool[i] = null;
						if(i == 23) {
							gp.tool[2].showTool = true;
							curLife++;
						}
						if(i == 31) {
							gp.tool[30].showTool = true;
						}
					}
					break;
				case "chest2 " + 2:
					prevPress = 0;
				gp.ui.showMessage("press x to open chest 2");
				if(removeObj == true) {
					System.out.println("remove chest 2");
					gp.tool[i] = null;
					if(i == 4) {
						gp.tool[24].showTool = true;
					}
					if(i == 29) {
						gp.tool[4].showTool = true;
					}
					removeObj = false;
				}
				break;			
				
				case "chest2 " + 3:
					prevPress = 0;
				gp.ui.showMessage("press x to open chest");
				if(removeObj == true) {
					System.out.println("remove chest in cave 3");
					gp.tool[i] = null;
					if(i == 5) {
						gp.tool[4].showTool = true;
					}
					removeObj = false;
				}
				break;
				
				case "key":
					gp.playSE(1);
					gp.tool[i] = null;
					gp.ui.hasKey = true;
					gp.ui.showMessage("You can use key to open the house");
					break;
				case "jamur":
					gp.ui.showMessage("use potion to remove jamur | press x to do it");
					prevPress = 0;
					if(removeObj == true) {
						if(gp.ui.hasPotion == false) {
							gp.ui.showMessage("you do not have potion to remove it");
						}
						if(gp.ui.hasPotion == true) {
							gp.ui.showMessage("jamur has been removed");
							gp.tool[i] = null;
						}
						removeObj = false;
					}
					break;
				case "Book Orbneon":
					gp.playSE(1);
					prevPress = 0;
					if(gp.curMap == 1) {
						gp.tool[i] = null;
						gp.ui.hasBookOrbneon = true;
						gp.ui.showMessage("you can use this book to remove the curse");
					}
					if(gp.curMap == 3 && gp.ui.hasBookOrbneon == true) {
						frontNeon = true;
						frontPurple = false;
						gp.ui.showMessage("Press X to press Neon book");
						if(removeObj == true) {
							gp.ui.hasBookOrbneon = false;
							keyH.lightning++;
						}
					}
					removeObj = false;
					break;
				case "Chest 4":
					prevPress = 0;
					gp.ui.showMessage("press x to open chest");
					if(removeObj == true) {
						System.out.println("remove chest 4");
						gp.tool[i] = null;
						if(i == 25) {
							gp.tool[26].showTool = true;
						}
						removeObj = false;
					}
					break;	
				case "Book Orb Purple":
					gp.playSE(1);
					prevPress = 0;
					if(gp.tool[25] == null) {
						gp.tool[26] = null;
						gp.ui.hasBookOrbpurple = true;
						gp.ui.showMessage("you can use this book to remove the curse");					
					}
					
					if(gp.curMap == 3 && gp.ui.hasBookOrbpurple == true) {
						frontPurple = true;
						frontNeon = false;
						gp.ui.showMessage("Press X to press Purple book");
						if(removeObj == true) {
							gp.ui.hasBookOrbpurple = false;
							keyH.lightning ++;
						}
					}
					removeObj = false;
					break;
					
				case "House Door": 
					prevPress = 0;
					gp.ui.showMessage("press e to enter house");
					frontHome = true;
					exitHome = false;
					break;
					
				case "Exit Home":
					prevPress = 0;
					gp.ui.showMessage("press e to exit house");
					exitHome = true;
					frontHome = false;
					break;
					
				case "Cave01 Door":
					prevPress = 0;
					gp.ui.showMessage("press e to enter Cave");
					frontCave = true;
					exitCave = false;
					break;
					
				case "Cave02 Door":
					prevPress = 0;
					gp.ui.showMessage("press e to enter Cave");
					frontCave = true;
					exitCave = false;
					break;
					
					
				case "Exit Cave":
					prevPress = 0;
					gp.ui.showMessage("press e to exit Cave");
					exitCave = true;
					frontCave = false;
					break;
					
				case "Soil":
					if(gp.ui.hasShovel == true) {
						
						prevPress = 0;
						frontSoil = true;
						if(shoveCount == 0) {
							gp.ui.showMessage("Press X to shove the soil");
						}
						
						else if(shoveCount > 5) {
							hasLava = false;
							for(int x = 8; x < 42; x++) {
								gp.tool[x] = null;
							}
						}
						else {
							gp.ui.showMessage("Keep shoving!!!");
						}
					}
					else {
						gp.ui.showMessage("You dont have shovel to remove soil");
					}
				break;
				}
			}
			
//		}
		
	}
	
	public void interactNPC(int i) {
		if(i != 99999) {
			gp.ui.showMessage("press enter to talk to the wizard");
			if(gp.keyH.enterPressed == true) {
				gp.gameState = gp.dialogState;
//			System.out.println("you are hitting npc");
				gp.npc[i].speak();				
			}
		}
		gp.keyH.enterPressed = false;
	}
	
	public void draw(Graphics2D g2) {
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
		if(invisible == true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		}
		g2.drawImage(image, screenX, screenY, tileSize, tileSize, null);
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	}
	
	public void contactMonster(int i) {
		if(i != 99999) {
			if(invisible == false) {
				curLife -= 1;
				gp.playSE(5);
				invisible = true;
			}
			
		}
	}
}
