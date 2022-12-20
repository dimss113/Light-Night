package main;

import java.util.Arrays;
import entity.*;
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
import tools.Heart;
import tools.HouseDoor;
import tools.Jamur;
import tools.Key;
import tools.Lava;
import tools.OrbNeon;
import tools.OrbPurple;
import tools.Potion;
import tools.Root;
import tools.ShovelTool;
import tools.Soil;
import tools.Stone;
import tools.Sword;
import tools.ToolBoots;
import tools.Water;
import tools.Well;
import tools.exitCave;
import tools.exitHome;

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
//				gp.tool[0] = new ShovelTool();
//				gp.tool[0].worldX = 17 * tileSize;
//				gp.tool[0].worldY = 34 * tileSize;
				
				gp.tool[1] = new AxeTool();
				gp.tool[1].worldX = 5 * tileSize;
				gp.tool[1].worldY = 31 * tileSize;
				
//				gp.tool[2] = new Key();
//				gp.tool[2].worldX = 48 * tileSize;
//				gp.tool[2].worldY = 9 * tileSize;
			
				gp.tool[2] = new Heart();
				gp.tool[2].worldX = 48 * tileSize;
				gp.tool[2].worldY = 9 * tileSize;	
				
				gp.tool[3] = new Jamur();
				gp.tool[3].worldX = 38 * tileSize;
				gp.tool[3].worldY = 3 * tileSize;
				
				gp.tool[29] = new Chest2(2);
				gp.tool[29].worldX = 38 * tileSize;
				gp.tool[29].worldY = 1 * tileSize;
				
				gp.tool[4] = new Key();
				gp.tool[4].worldX = 38 * tileSize;
				gp.tool[4].worldY = 0 * tileSize;
				
				gp.tool[5] = new BucketEmpty();
				gp.tool[5].worldX = 50 * tileSize;
				gp.tool[5].worldY = 34 * tileSize;
				
				gp.tool[31] = new Chest2(1);
				gp.tool[31].worldX = 58 * tileSize;
				gp.tool[31].worldY = 2 * tileSize;				
				
				gp.tool[30] = new BookOrbPurple();
				gp.tool[30].worldX = 58 * tileSize;
				gp.tool[30].worldY = 2 * tileSize;
				
				gp.tool[6] = new Hammer();
				gp.tool[6].worldX = 10 * tileSize;
				gp.tool[6].worldY = 31 * tileSize;
				
//				gp.tool[7] = new Sword();
//				gp.tool[7].worldX = 27 * tileSize;
//				gp.tool[7].worldY = 31 * tileSize;
//				
				gp.tool[7] = new Hammer();
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
				
				gp.tool[13] = new Stone(1);
				gp.tool[13].worldX = 27 * tileSize;
				gp.tool[13].worldY = 29 * tileSize;
				
				gp.tool[14] = new Stone(1);
				gp.tool[14].worldX = 26 * tileSize;
				gp.tool[14].worldY = 30 * tileSize;
				
				gp.tool[32] = new Chest(1);
				gp.tool[32].worldX = 17 * tileSize;
				gp.tool[32].worldY = 34 * tileSize;
//				
				gp.tool[15] = new Heart();
				gp.tool[15].worldX = 17 * tileSize;
				gp.tool[15].worldY = 34 * tileSize;
				
				gp.tool[16] = new Chest(2);
				gp.tool[16].worldX = 27 * tileSize;
				gp.tool[16].worldY = 31 * tileSize;
				
				gp.tool[17] = new Chest(3);
				gp.tool[17].worldX = 39 * tileSize;
				gp.tool[17].worldY = 30 * tileSize;
				
				gp.tool[18] = new Stone(1);
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
				
				gp.tool[24] = new Chest(4);
				gp.tool[24].worldX = 25 * tileSize;
				gp.tool[24].worldY = 14 * tileSize;
				
//				gp.tool[25] = new BookOrbPurple();
//				gp.tool[25].worldX = 25 * tileSize;
//				gp.tool[25].worldY = 14 * tileSize;
//				
				gp.tool[26] = new HouseDoor();
				gp.tool[26].worldX = 23 * tileSize;
				gp.tool[26].worldY = 16 * tileSize;
				
				gp.tool[28] = new Cave01Door();
				gp.tool[28].worldX = 2 * tileSize;
				gp.tool[28].worldY = 9 * tileSize;
			}
		
			if(gp.curMap == 1) {
				gp.tool[0] = new exitHome();
				gp.tool[0].worldX = 7 * tileSize;
				gp.tool[0].worldY = 7 * tileSize;
				
				gp.tool[1] = new BookOrbneon();
				gp.tool[1].worldX = 12 * tileSize;
				gp.tool[1].worldY = 0 * tileSize;
			}
			
			
			if(gp.curMap == 2) {
				gp.tool[0] = new Cave02Door();
				gp.tool[0].worldX = 14 * tileSize;
				gp.tool[0].worldY = 1 * tileSize;
				
				gp.tool[1] = new exitCave();
				gp.tool[1].worldX =  10 * tileSize;
				gp.tool[1].worldY = 13 * tileSize;
				
				gp.tool[2] = new exitCave();
				gp.tool[2].worldX =  11 * tileSize;
				gp.tool[2].worldY = 13 * tileSize;
				
				gp.tool[3] = new exitCave();
				gp.tool[3].worldX =  12 * tileSize;
				gp.tool[3].worldY = 13 * tileSize;
				
				gp.tool[4] = new ShovelTool();
				gp.tool[4].worldX =  3 * tileSize;
				gp.tool[4].worldY = 4 * tileSize;
				
				gp.tool[5] = new Chest2(3);
				gp.tool[5].worldX =  3 * tileSize;
				gp.tool[5].worldY = 4 * tileSize;
				
				
				gp.tool[6] = new Stone(2);
				gp.tool[6].worldX = 4 * tileSize;
				gp.tool[6].worldY = 4 * tileSize;
				
				if(gp.player.hasLava == true) {
					gp.tool[8] = new Lava(1);
					gp.tool[8].worldX = 11 * tileSize;
					gp.tool[8].worldY = 0 * tileSize;
					
					gp.tool[9] = new Lava(1);
					gp.tool[9].worldX = 11 * tileSize;
					gp.tool[9].worldY = 2 * tileSize;
					
					gp.tool[10] = new Lava(1);
					gp.tool[10].worldX = 11 * tileSize;
					gp.tool[10].worldY = 1 * tileSize;
					
					gp.tool[11] = new Lava(1);
					gp.tool[11].worldX = 14 * tileSize;
					gp.tool[11].worldY = 4 * tileSize;
					
					gp.tool[12] = new Lava(1);
					gp.tool[12].worldX = 15 * tileSize;
					gp.tool[12].worldY = 4 * tileSize;
					
					gp.tool[13] = new Lava(1);
					gp.tool[13].worldX = 14 * tileSize;
					gp.tool[13].worldY = 4 * tileSize;
					
					gp.tool[14] = new Lava(2);
					gp.tool[14].worldX = 10 * tileSize;
					gp.tool[14].worldY = 0 * tileSize;
					
					gp.tool[15] = new Lava(2);
					gp.tool[15].worldX = 10 * tileSize;
					gp.tool[15].worldY = 1 * tileSize;
					
					gp.tool[16] = new Lava(2);
					gp.tool[16].worldX = 10 * tileSize;
					gp.tool[16].worldY = 2 * tileSize;
					
					gp.tool[17] = new Lava(3);
					gp.tool[17].worldX = 10 * tileSize;
					gp.tool[17].worldY = 3 * tileSize;
					
					gp.tool[18] = new Lava(4);
					gp.tool[18].worldX = 11 * tileSize;
					gp.tool[18].worldY = 3 * tileSize;
					
					gp.tool[19] = new Lava(5);
					gp.tool[19].worldX = 13 * tileSize;
					gp.tool[19].worldY = 3 * tileSize;
					
					gp.tool[20] = new Lava(6);
					gp.tool[20].worldX = 13 * tileSize;
					gp.tool[20].worldY = 4 * tileSize;
					
					gp.tool[21] = new Lava(4);
					gp.tool[21].worldX = 14 * tileSize;
					gp.tool[21].worldY = 4 * tileSize;
					
					gp.tool[22] = new Lava(4);
					gp.tool[22].worldX = 15 * tileSize;
					gp.tool[22].worldY = 4 * tileSize;
					
					gp.tool[23] = new Lava(7);
					gp.tool[23].worldX = 16 * tileSize;
					gp.tool[23].worldY = 4 * tileSize;
					
					gp.tool[24] = new Lava(4);
					gp.tool[24].worldX = 12 * tileSize;
					gp.tool[24].worldY = 3 * tileSize;
					
					gp.tool[25] = new Lava(7);
					gp.tool[25].worldX = 16 * tileSize;
					gp.tool[25].worldY = 4 * tileSize;
					
					gp.tool[26] = new Lava(8);
					gp.tool[26].worldX = 16 * tileSize;
					gp.tool[26].worldY = 3 * tileSize;
					
					gp.tool[27] = new Lava(7);
					gp.tool[27].worldX = 17 * tileSize;
					gp.tool[27].worldY = 3 * tileSize;
					
					gp.tool[28] = new Lava(8);
					gp.tool[28].worldX = 17 * tileSize;
					gp.tool[28].worldY = 2 * tileSize;
								
					gp.tool[29] = new Lava(7);
					gp.tool[29].worldX = 18 * tileSize;
					gp.tool[29].worldY = 2 * tileSize;
					
					gp.tool[30] = new Lava(9);
					gp.tool[30].worldX = 18 * tileSize;
					gp.tool[30].worldY = 1 * tileSize;
					
					gp.tool[31] = new Lava(10);
					gp.tool[31].worldX = 17 * tileSize;
					gp.tool[31].worldY = 1 * tileSize;
					
					gp.tool[32] = new Lava(11);
					gp.tool[32].worldX = 16 * tileSize;
					gp.tool[32].worldY = 1 * tileSize;
					
					gp.tool[33] = new Lava(12);
					gp.tool[33].worldX = 16 * tileSize;
					gp.tool[33].worldY = 2 * tileSize;
					
					gp.tool[34] = new Lava(13);
					gp.tool[34].worldX = 15 * tileSize;
					gp.tool[34].worldY = 2 * tileSize;
					
					gp.tool[35] = new Lava(14);
					gp.tool[35].worldX = 14 * tileSize;
					gp.tool[35].worldY = 2 * tileSize;
					
					gp.tool[36] = new Lava(15);
					gp.tool[36].worldX = 13 * tileSize;
					gp.tool[36].worldY = 2 * tileSize;
					
					gp.tool[37] = new Lava(16);
					gp.tool[37].worldX = 12 * tileSize;
					gp.tool[37].worldY = 2 * tileSize;
					
					gp.tool[38] = new Lava(17);
					gp.tool[38].worldX = 12 * tileSize;
					gp.tool[38].worldY = 1 * tileSize;
					
					gp.tool[38] = new Lava(18);
					gp.tool[38].worldX = 12 * tileSize;
					gp.tool[38].worldY = 0 * tileSize;
					
					gp.tool[39] = new Lava(18);
					gp.tool[39].worldX = 12 * tileSize;
					gp.tool[39].worldY = 0 * tileSize;
					
					gp.tool[40] = new Lava(1);
					gp.tool[40].worldX = 14 * tileSize;
					gp.tool[40].worldY = 3 * tileSize;
					
					gp.tool[41] = new Lava(1);
					gp.tool[41].worldX = 15 * tileSize;
					gp.tool[41].worldY = 3 * tileSize;
					
					
					gp.tool[42] = new Soil();
					gp.tool[42].worldX = 18 * tileSize;
					gp.tool[42].worldY = 1 * tileSize;
					
					gp.tool[8] = new Lava(1);
					gp.tool[8].worldX = 11 * tileSize;
					gp.tool[8].worldY = 0 * tileSize;
					
					gp.tool[9] = new Lava(1);
					gp.tool[9].worldX = 11 * tileSize;
					gp.tool[9].worldY = 2 * tileSize;
					
					gp.tool[10] = new Lava(1);
					gp.tool[10].worldX = 11 * tileSize;
					gp.tool[10].worldY = 1 * tileSize;
					
					gp.tool[11] = new Lava(1);
					gp.tool[11].worldX = 14 * tileSize;
					gp.tool[11].worldY = 4 * tileSize;
					
					gp.tool[12] = new Lava(1);
					gp.tool[12].worldX = 15 * tileSize;
					gp.tool[12].worldY = 4 * tileSize;
					
					gp.tool[13] = new Lava(1);
					gp.tool[13].worldX = 14 * tileSize;
					gp.tool[13].worldY = 4 * tileSize;
					
					gp.tool[14] = new Lava(2);
					gp.tool[14].worldX = 10 * tileSize;
					gp.tool[14].worldY = 0 * tileSize;
					
					gp.tool[15] = new Lava(2);
					gp.tool[15].worldX = 10 * tileSize;
					gp.tool[15].worldY = 1 * tileSize;
					
					gp.tool[16] = new Lava(2);
					gp.tool[16].worldX = 10 * tileSize;
					gp.tool[16].worldY = 2 * tileSize;
					
					gp.tool[17] = new Lava(3);
					gp.tool[17].worldX = 10 * tileSize;
					gp.tool[17].worldY = 3 * tileSize;
					
					gp.tool[18] = new Lava(4);
					gp.tool[18].worldX = 11 * tileSize;
					gp.tool[18].worldY = 3 * tileSize;
					
					gp.tool[19] = new Lava(5);
					gp.tool[19].worldX = 13 * tileSize;
					gp.tool[19].worldY = 3 * tileSize;
					
					gp.tool[20] = new Lava(6);
					gp.tool[20].worldX = 13 * tileSize;
					gp.tool[20].worldY = 4 * tileSize;
					
					gp.tool[21] = new Lava(4);
					gp.tool[21].worldX = 14 * tileSize;
					gp.tool[21].worldY = 4 * tileSize;
					
					gp.tool[22] = new Lava(4);
					gp.tool[22].worldX = 15 * tileSize;
					gp.tool[22].worldY = 4 * tileSize;
					
					gp.tool[23] = new Lava(7);
					gp.tool[23].worldX = 16 * tileSize;
					gp.tool[23].worldY = 4 * tileSize;
					
					gp.tool[24] = new Lava(4);
					gp.tool[24].worldX = 12 * tileSize;
					gp.tool[24].worldY = 3 * tileSize;
					
					gp.tool[25] = new Lava(7);
					gp.tool[25].worldX = 16 * tileSize;
					gp.tool[25].worldY = 4 * tileSize;
					
					gp.tool[26] = new Lava(8);
					gp.tool[26].worldX = 16 * tileSize;
					gp.tool[26].worldY = 3 * tileSize;
					
					gp.tool[27] = new Lava(7);
					gp.tool[27].worldX = 17 * tileSize;
					gp.tool[27].worldY = 3 * tileSize;
					
					gp.tool[28] = new Lava(8);
					gp.tool[28].worldX = 17 * tileSize;
					gp.tool[28].worldY = 2 * tileSize;
								
					gp.tool[29] = new Lava(7);
					gp.tool[29].worldX = 18 * tileSize;
					gp.tool[29].worldY = 2 * tileSize;
					
					gp.tool[30] = new Lava(9);
					gp.tool[30].worldX = 18 * tileSize;
					gp.tool[30].worldY = 1 * tileSize;
					
					gp.tool[31] = new Lava(10);
					gp.tool[31].worldX = 17 * tileSize;
					gp.tool[31].worldY = 1 * tileSize;
					
					gp.tool[32] = new Lava(11);
					gp.tool[32].worldX = 16 * tileSize;
					gp.tool[32].worldY = 1 * tileSize;
					
					gp.tool[33] = new Lava(12);
					gp.tool[33].worldX = 16 * tileSize;
					gp.tool[33].worldY = 2 * tileSize;
					
					gp.tool[34] = new Lava(13);
					gp.tool[34].worldX = 15 * tileSize;
					gp.tool[34].worldY = 2 * tileSize;
					
					gp.tool[35] = new Lava(14);
					gp.tool[35].worldX = 14 * tileSize;
					gp.tool[35].worldY = 2 * tileSize;
					
					gp.tool[36] = new Lava(15);
					gp.tool[36].worldX = 13 * tileSize;
					gp.tool[36].worldY = 2 * tileSize;
					
					gp.tool[37] = new Lava(16);
					gp.tool[37].worldX = 12 * tileSize;
					gp.tool[37].worldY = 2 * tileSize;
					
					gp.tool[38] = new Lava(17);
					gp.tool[38].worldX = 12 * tileSize;
					gp.tool[38].worldY = 1 * tileSize;
					
					gp.tool[38] = new Lava(18);
					gp.tool[38].worldX = 12 * tileSize;
					gp.tool[38].worldY = 0 * tileSize;
					
					gp.tool[39] = new Lava(18);
					gp.tool[39].worldX = 12 * tileSize;
					gp.tool[39].worldY = 0 * tileSize;
					
					gp.tool[40] = new Lava(1);
					gp.tool[40].worldX = 14 * tileSize;
					gp.tool[40].worldY = 3 * tileSize;
					
					gp.tool[41] = new Lava(1);
					gp.tool[41].worldX = 15 * tileSize;
					gp.tool[41].worldY = 3 * tileSize;
				
					gp.tool[42] = new Soil();
					gp.tool[42].worldX = 19 * tileSize;
					gp.tool[42].worldY = 1 * tileSize;
				}
				
				
			}
			
			if(gp.curMap == 3) {
				gp.tool[0] = new exitCave();
				gp.tool[0].worldX =  7 * tileSize;
				gp.tool[0].worldY = 19 * tileSize;
				
				gp.tool[1] = new exitCave();
				gp.tool[1].worldX =  8 * tileSize;
				gp.tool[1].worldY = 19 * tileSize;
				
				gp.tool[2] = new exitCave();
				gp.tool[2].worldX =  6 * tileSize;
				gp.tool[2].worldY = 19 * tileSize;
				
				gp.tool[3] = new BookOrbneon();
				gp.tool[3].worldX =  5 * tileSize;
				gp.tool[3].worldY = 6 * tileSize;
				
				gp.tool[3].showTool = false;
				gp.tool[3].collision = true;
				
				gp.tool[4] = new BookOrbPurple();
				gp.tool[4].worldX =  10* tileSize;
				gp.tool[4].worldY = 6 * tileSize;
				
				gp.tool[4].showTool = false;
				gp.tool[4].collision = true;
				
				gp.tool[5] = new OrbPurple();
				gp.tool[5].worldX = 8* tileSize;
				gp.tool[5].worldY = 4 * tileSize;
				
				gp.tool[6] = new OrbNeon();
				gp.tool[6].worldX = 7* tileSize;
				gp.tool[6].worldY = 3 * tileSize;
			}
		}
	
		public void setMonster() {
			if(gp.curMap == 0) {
				gp.monster[0] = new EyeBall(gp);
				gp.monster[0].worldX = 7 * tileSize;
				gp.monster[0].worldY = 32 * tileSize;
				
				gp.monster[1] = new EyeBall(gp);
				gp.monster[1].worldX = 29 * tileSize;
				gp.monster[1].worldY = 30 * tileSize;
				
				gp.monster[2] = new EyeBall(gp);
				gp.monster[2].worldX = 17 * tileSize;
				gp.monster[2].worldY = 26 * tileSize;
				
				gp.monster[3] = new EyeBall(gp);
				gp.monster[3].worldX = 52 * tileSize;
				gp.monster[3].worldY = 15 * tileSize;
				
				gp.monster[4] = new EyeBall(gp);
				gp.monster[4].worldX = 28 * tileSize;
				gp.monster[4].worldY = 27 * tileSize;
				
				gp.monster[5] = new EyeBall(gp);
				gp.monster[5].worldX = 48 * tileSize;
				gp.monster[5].worldY = 10 * tileSize;
				
				gp.monster[6] = new EyeBall(gp);
				gp.monster[6].worldX =  53 * tileSize;
				gp.monster[6].worldY = 21 * tileSize;
				
				gp.monster[7] = new EyeBall(gp);
				gp.monster[7].worldX = 36 * tileSize;
				gp.monster[7].worldY = 8 * tileSize;
				
				gp.monster[8] = new EyeBall(gp);
				gp.monster[8].worldX = 32 * tileSize;
				gp.monster[8].worldY = 4 * tileSize;
				
				gp.monster[9] = new EyeBall(gp);
				gp.monster[9].worldX = 47 * tileSize;
				gp.monster[9].worldY = 2 * tileSize;
				
				gp.monster[10] = new EyeBall(gp);
				gp.monster[10].worldX = 53 * tileSize;
				gp.monster[10].worldY = 3 * tileSize;
				
				gp.monster[11] = new EyeBall(gp);
				gp.monster[11].worldX = 57 * tileSize;
				gp.monster[11].worldY = 3 * tileSize;
				
				gp.monster[12] = new EyeBall(gp);
				gp.monster[12].worldX = 20 * tileSize;
				gp.monster[12].worldY = 16 * tileSize;
				
				gp.monster[13] = new EyeBall(gp);
				gp.monster[13].worldX = 18 * tileSize;
				gp.monster[13].worldY = 11 * tileSize;
				
				gp.monster[14] = new EyeBall(gp);
				gp.monster[14].worldX = 17 * tileSize;
				gp.monster[14].worldY = 8 * tileSize;
				
				gp.monster[15] = new EyeBall(gp);
				gp.monster[15].worldX = 8 * tileSize;
				gp.monster[15].worldY = 9 * tileSize;
				
				gp.monster[16] = new EyeBall(gp);
				gp.monster[16].worldX = 7 * tileSize;
				gp.monster[16].worldY = 15 * tileSize;
				
				gp.monster[17] = new EyeBall(gp);
				gp.monster[17].worldX = 21 * tileSize;
				gp.monster[17].worldY = 24 * tileSize;
				
				gp.monster[18] = new EyeBall(gp);
				gp.monster[18].worldX = 23 * tileSize;
				gp.monster[18].worldY = 10 * tileSize;
				
				gp.monster[19] = new EyeBall(gp);
				gp.monster[19].worldX = 28 * tileSize;
				gp.monster[19].worldY = 7 * tileSize;
				
				gp.monster[20] = new EyeBall(gp);
				gp.monster[20].worldX = 46 * tileSize;
				gp.monster[20].worldY = 11 * tileSize;
				
			}
		}
		
		public void setNPC() {
			gp.npc[0] = new Wizard(gp);
			gp.npc[0].worldX = gp.gs.getTileSize() *36;
			gp.npc[0].worldY = gp.gs.getTileSize() *30;
			
		}
		
		
	}

