package world_gen;

import java.awt.Color;
import java.awt.Graphics;

import display.GUImain;
import entities.EntityHandler;
import entities.ID;
import entities.Monster;
import entities.Player;
import gfx.Assets;
import items.Inventory;
import main.Handler;

public class World {

	private int gridSize;

	private Map map;

	private Handler handler;
	private EntityHandler entityHandler;
	private Inventory inventory;

	public World(Handler handler) {
		this.handler = handler;

		entityHandler = new EntityHandler();
		map = new Map(entityHandler);
		inventory = new Inventory();

		gridSize = map.getGridSize();

		genPlayer();
		genMonsters();
	}

	public void tick() {
		entityHandler.tick();
		inventory.tick();
		handler.getGuiMain().getWindow().setTitle("The Mines of Mukduk - Level " + map.getLevelNum());
	}

	public void render(Graphics g) {
		renderMap(g);
		entityHandler.render(g);
		inventory.render(g);
	}

	// Creates a player entity and places it on the map
	private void genPlayer() {
		for (int c = 0; c < gridSize; c++) {
			for (int r = 0; r < gridSize; r++) {
				if (map.getTile(r, c).isSpawn() == true) {
					entityHandler.addEntity(new Player(r, c, ID.Player, handler, map));
					r = c = gridSize; // Break out of the loop
				}
			}
		}
	}

	// Places monster entities on every tile that has that attribute
	private void genMonsters() {
		for (int c = 0; c < gridSize; c++) {
			for (int r = 0; r < gridSize; r++) {
				if (map.getTile(r, c).isMonster() == true) {
					entityHandler.addEntity(new Monster(r, c, ID.Monster, map));
				}
			}
		}
	}

	// Renders the elements of the map onto the screen
	private void renderMap(Graphics g) {
		for (int r = 0; r < gridSize; r++) {
			for (int c = 0; c < gridSize; c++) {
				g.setColor(Color.white);

				int x = c * Assets.width;
				int y = r * Assets.height;

				if (map.getTile(r, c).isWall()) {
					g.drawImage(Assets.wall, x, y, Assets.width, Assets.height, null);
				} else if (map.getTile(r, c).isFloor()) {
					g.drawImage(Assets.dirt, x, y, Assets.width, Assets.height, null);
				} else if (map.getTile(r, c).isSpawn()) {
					g.drawImage(Assets.dirt, x, y, Assets.width, Assets.height, null);
				} else if (map.getTile(r, c).isLadder()) {
					g.setColor(Color.green);
					g.drawString("▼", x, y);
				} else if (map.getTile(r, c).isTreasure()) {
					g.drawImage(Assets.dirt, x, y, Assets.width, Assets.height, null);
					g.setColor(Color.yellow);
					g.drawString("₧", x + Assets.width / 4, y + Assets.height * 5 / 8);
				} else if (map.getTile(r, c).isMonster()) {
					g.drawImage(Assets.dirt, x, y, Assets.width, Assets.height, null);
				} else
					g.drawImage(Assets.wall, x, y, Assets.width, Assets.height, null);
			}
		}
	}

	// GETTERS AND SETTERS

	public EntityHandler getEntityHandler() {
		return entityHandler;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public Map getMap() {
		return map;
	}
}
