package main;

import entity.Entity;

public class CollisionChecker {
	
	GamePanel gp;
	GameSettings gs;
	
	private int tileSize;
	
	public CollisionChecker(GamePanel gp, GameSettings gs) {
		this.gp = gp;
		this.gs = gs;
		this.tileSize = gs.getTileSize();
		
	}

public void checkTile(Entity entity) {
		
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
	
		int entityLeftCol = entityLeftWorldX/tileSize;
		int entityRightCol = entityRightWorldX/tileSize;
		int entityTopRow = entityTopWorldY/tileSize;
		int entityBottomRow = entityBottomWorldY/tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed)/tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "down":
			entityBottomRow = (entityBottomWorldY + entity.speed)/tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed)/tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
		
	}
	
	public int checkObject(Entity entity, boolean player) {
		
		int index = 99999;
		
		for(int i = 0;i < gp.tool.length; i++) {
			if(gp.tool[i] != null) {
				// get entity solid area position
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				// get the tools solid area position
				gp.tool[i].solidArea.x = gp.tool[i].worldX + gp.tool[i].solidArea.x;
				gp.tool[i].solidArea.y = gp.tool[i].worldY + gp.tool[i].solidArea.y;
			
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(gp.tool[i].solidArea)) {
						System.out.println("up collision");
						if(gp.tool[i].collision  ==  true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "down":
					System.out.println("masuk down coll");
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(gp.tool[i].solidArea)) {
						System.out.println("down collision");
						if(gp.tool[i].collision  ==  true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}					
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(gp.tool[i].solidArea)) {
						System.out.println("left collision");
						if(gp.tool[i].collision  ==  true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}					
					break;
				case "right":
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(gp.tool[i].solidArea)) {
						System.out.println("right collision");
						if(gp.tool[i].collision  ==  true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}					
					break;
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.tool[i].solidArea.x = gp.tool[i].solidAreaDefaultX;
				gp.tool[i].solidArea.y = gp.tool[i].solidAreaDefaultY;
			}
		}
		
		return index;
		
	}
}