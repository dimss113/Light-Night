package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.nio.file.FileSystemNotFoundException;
import java.util.Currency;
import java.util.function.LongBinaryOperator;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public abstract class GameSettings{
	

	private int originalTileSize;
	private int scale;
	
	
	private int tileSize = originalTileSize * scale;
	
	private int maxScreenCol;
	
	private int maxScreenRow;
	private int screenWidth = tileSize * maxScreenCol;
	private int screenHeight = tileSize * maxScreenRow;
	
	// world settings
	private int maxWorldCol;
	private int maxWorldRow;
	private int worldWidth = tileSize * maxWorldCol;
	private int worldHeight = tileSize * maxScreenRow;
	private int playerX;
	private int playerY;
	
	private int status;
	private int totalSize;
	private String file;
	private String fileCol;
	
	
	public GameSettings(int originalTileSize, int scale, int tileSize, int maxScreenCol, int maxScreenRow, int screenWidth,
			int screenHeight, int maxWorldCol, int maxWorldRow, int worldWidth, int worldHeight, int playerX, int playerY, 
			int status, int totalSize, String file, String fileCol) {
		this.originalTileSize = originalTileSize;
		this.scale = scale;
		this.tileSize = tileSize;
		this.maxScreenCol = maxScreenCol;
		this.maxScreenRow = maxScreenRow;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.maxWorldCol = maxWorldCol;
		this.maxWorldRow = maxWorldRow;
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
		this.playerX = playerX;
		this.playerY = playerY;
		this.status = status;
		this.totalSize = totalSize;
		this.file = file;
		this.fileCol = fileCol;
	}

	
	public int getPlayerX() {
		return playerX;
	}


	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}


	public int getPlayerY() {
		return playerY;
	}


	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}


	public int getOriginalTileSize() {
		return originalTileSize;
	}
	public void setOriginalTileSize(int originalTileSize) {
		this.originalTileSize = originalTileSize;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public int getTileSize() {
		return tileSize;
	}
	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}
	public int getMaxScreenCol() {
		return maxScreenCol;
	}
	public void setMaxScreenCol(int maxScreenCol) {
		this.maxScreenCol = maxScreenCol;
	}
	public int getMaxScreenRow() {
		return maxScreenRow;
	}
	public void setMaxScreenRow(int maxScreenRow) {
		this.maxScreenRow = maxScreenRow;
	}
	public int getScreenWidth() {
		return screenWidth;
	}
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}
	public int getScreenHeight() {
		return screenHeight;
	}
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}
	public int getMaxWorldCol() {
		return maxWorldCol;
	}
	public void setMaxWorldCol(int maxWorldCol) {
		this.maxWorldCol = maxWorldCol;
	}
	public int getMaxWorldRow() {
		return maxWorldRow;
	}
	public void setMaxWorldRow(int maxWorldRow) {
		this.maxWorldRow = maxWorldRow;
	}
	public int getWorldWidth() {
		return worldWidth;
	}
	public void setWorldWidth(int worldWidth) {
		this.worldWidth = worldWidth;
	}
	public int getWorldHeight() {
		return worldHeight;
	}
	public void setWorldHeight(int worldHeight) {
		this.worldHeight = worldHeight;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public String getFileCol() {
		return fileCol;
	}


	public void setFileCol(String fileCol) {
		this.fileCol = fileCol;
	}


	public int getTotalSize() {
		return totalSize;
	}


	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

}