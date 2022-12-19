package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Wizard extends Entity{
	
	public Wizard(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getImage();
		setDialog();
		
	}
	public void getImage() {		
		
		up1 = setup("/npc/npc");
		up2 = setup("/npc/npc (1)");
		
	}
	
	public void setDialog() {
		dialog[0] = "Mr Albert: Hello Eugene, My Name is Albert Laros, \nThe Sorcerer Supreme";
		dialog[1] = "Mr Albert: i know your purpose. You want to remove \nthe curse of the darkness in your world";
		dialog[2] = "Eugene: what should i do?";
		dialog[3] = "Mr Albert: You have to 2 book orb to remove the curse";
		dialog[4] = "Eugene: where i can find it?";
		dialog[5] = "You have to finish the challenge. Start from here";
	}
	
	public void setAction() {
		
		actionLockCounter++;
		
		direction = "up";
	}
	
	public void speak() {
		if(dialog[getDialogIndex()] == null) {
			setDialogIndex(0);
		}
		gp.ui.currentDialog = dialog[getDialogIndex()];
		increaseDialogIndex();
	}

}
