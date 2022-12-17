package main;

import java.util.Arrays;
import java.util.GregorianCalendar;

import monster.EyeBall;
import tools.AxeTool;
import tools.BookOrbPurple;
import tools.BookOrbneon;
import tools.BucketEmpty;
import tools.Cave01Door;
import tools.Cave02Door;
import tools.Chest;
import tools.Chest2;
import tools.Hammer;
import tools.HouseDoor;
import tools.Jamur;
import tools.Key;
import tools.Potion;
import tools.Root;
import tools.ShovelTool;
import tools.Stone;
import tools.Sword;
import tools.ToolBoots;
import tools.Water;
import tools.Well;
import tools.exitHouse;

public class AssetSetter {
	
	GamePanel gp;
	GameSettings gs;
	
	private int tileSize;
	
	public AssetSetter(GamePanel gp, GameSettings gs) {
		this.gp = gp;
		this.gs = gs;
		this.tileSize = gs.getTileSize();
	}

	public void setObject() {
		if(gp.curMap == 0) {
				gp.tool[0] = new ShovelTool();
				gp.tool[0].worldX = 17 * tileSize;
				gp.tool[0].worldY = 34 * tileSize;
				
				gp.tool[1] = new AxeTool();
				gp.tool[1].worldX = 5 * tileSize;
				gp.tool[1].worldY = 31 * tileSize;
				
				gp.tool[2] = new Key();
				gp.tool[2].worldX = 48 * tileSize;
				gp.tool[2].worldY = 9 * tileSize;
			
				gp.tool[3] = new Jamur();
				gp.tool[3].worldX = 38 * tileSize;
				gp.tool[3].worldY = 3 * tileSize;
				
				gp.tool[4] = new Chest2(2);
				gp.tool[4].worldX = 38 * tileSize;
				gp.tool[4].worldY = 1 * tileSize;
				
				gp.tool[5] = new BucketEmpty();
				gp.tool[5].worldX = 50 * tileSize;
				gp.tool[5].worldY = 34 * tileSize;
				
				gp.tool[6] = new Hammer();
				gp.tool[6].worldX = 10 * tileSize;
				gp.tool[6].worldY = 31 * tileSize;
				
				gp.tool[7] = new Sword();
				gp.tool[7].worldX = 27 * tileSize;
				gp.tool[7].worldY = 31 * tileSize;
				
				gp.tool[8] = new Potion();
				gp.tool[8].worldX = 39 * tileSize;
				gp.tool[8].worldY = 30 * tileSize;
				
				gp.tool[9] = new ToolBoots();
				gp.tool[9].worldX = 11 * tileSize;
				gp.tool[9].worldY = 26 * tileSize;
				
				gp.tool[10] = new Chest(2);
				gp.tool[10].worldX = 11 * tileSize;
				gp.tool[10].worldY = 26 * tileSize;
				
				gp.tool[11] = new Root(1);
				gp.tool[11].worldX = 17 * tileSize;
				gp.tool[11].worldY = 33 * tileSize;
	
				gp.tool[12] = new Root(2);
				gp.tool[12].worldX = 18 * tileSize;
				gp.tool[12].worldY = 33 * tileSize;
				
				gp.tool[13] = new Stone();
				gp.tool[13].worldX = 27 * tileSize;
				gp.tool[13].worldY = 29 * tileSize;
				
				gp.tool[14] = new Stone();
				gp.tool[14].worldX = 26 * tileSize;
				gp.tool[14].worldY = 30 * tileSize;
				
				gp.tool[15] = new Chest(1);
				gp.tool[15].worldX = 17 * tileSize;
				gp.tool[15].worldY = 34 * tileSize;
				
				gp.tool[16] = new Chest(2);
				gp.tool[16].worldX = 27 * tileSize;
				gp.tool[16].worldY = 31 * tileSize;
				
				gp.tool[17] = new Chest(3);
				gp.tool[17].worldX = 39 * tileSize;
				gp.tool[17].worldY = 30 * tileSize;
				
				gp.tool[18] = new Stone();
				gp.tool[18].worldX = 46 * tileSize;
				gp.tool[18].worldY = 14 * tileSize;
				
				gp.tool[19] = new Well();
				gp.tool[19].worldX = 46 * tileSize;
				gp.tool[19].worldY = 9 * tileSize;
				
				gp.tool[20] = new Chest(1);
				gp.tool[20].worldX = 50 * tileSize;
				gp.tool[20].worldY = 34 * tileSize;
				
				gp.tool[21] = new Water(1);
				gp.tool[21].worldX = 42 * tileSize;
				gp.tool[21].worldY = 10 * tileSize;
				
				gp.tool[22] = new Water(2);
				gp.tool[22].worldX = 42 * tileSize;
				gp.tool[22].worldY = 11 * tileSize;
				
				gp.tool[23] = new Chest2(1);
				gp.tool[23].worldX = 48 * tileSize;
				gp.tool[23].worldY = 9 * tileSize;
				
				gp.tool[24] = new BookOrbneon();
				gp.tool[24].worldX = 38 * tileSize;
				gp.tool[24].worldY = 0 * tileSize;
	
				
				gp.tool[25] = new Chest(4);
				gp.tool[25].worldX = 25 * tileSize;
				gp.tool[25].worldY = 14 * tileSize;
				
				gp.tool[26] = new BookOrbPurple();
				gp.tool[26].worldX = 25 * tileSize;
				gp.tool[26].worldY = 14 * tileSize;
				
				gp.tool[27] = new HouseDoor();
				gp.tool[27].worldX = 23 * tileSize;
				gp.tool[27].worldY = 16 * tileSize;
				
				gp.tool[28] = new Cave01Door();
				gp.tool[28].worldX = 2 * tileSize;
				gp.tool[28].worldY = 9 * tileSize;
	
			}
		
			if(gp.curMap == 1) {
				gp.tool[0] = new HouseDoor();
				gp.tool[0].worldX = 8 * tileSize;
				gp.tool[0].worldY = 6 * tileSize;
			}
			
			if(gp.curMap == 2) {
				gp.tool[0] = new Cave02Door();
				gp.tool[0].worldX = 14 * tileSize;
				gp.tool[0].worldY = 1 * tileSize;
			}
		}
	
		public void setMonster() {
			if(gp.curMap == 0) {
				gp.monster[0] = new EyeBall(gp);
				gp.monster[0].worldX = 32 * tileSize;
				gp.monster[0].worldY = 28 * tileSize;
				
				gp.monster[1] = new EyeBall(gp);
				gp.monster[1].worldX = 29 * tileSize;
				gp.monster[1].worldY = 30 * tileSize;
			}
		}
	}

