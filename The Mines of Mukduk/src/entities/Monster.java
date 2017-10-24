package entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gfx.Assets;
import world_gen.Map;

public class Monster extends Entity {

	public Monster(int row, int col, ID id, Map map) {
		super(row, col, ID.Monster, map);
	}

	public void tick() {
		// Update the position of the player
		xPos = (col * tileSizeX) + gridOffsetX;
		yPos = (row * tileSizeY) + gridOffsetY;
	}

	public void render(Graphics g) {
		g.drawImage(Assets.monster, xPos, yPos, tileSizeY, tileSizeY, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(xPos, yPos, tileSizeX, tileSizeY);
	}
}
