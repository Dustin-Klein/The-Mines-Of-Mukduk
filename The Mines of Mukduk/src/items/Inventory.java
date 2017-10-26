package items;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import display.GUImain;

/**
 * This holds an arraylist of items that acts as the inventory for the player.
 * 
 * @author Dustin
 */
public class Inventory {

	// Stores all the items in the inventory
	private static ArrayList<Item> inventoryItems;
	// Used to determine whether or not the inventory should be rendered
	private static boolean active;
	
	private Comparator<Item> comp = new Comparator<Item>(){
		@Override
		public int compare(Item a, Item b) {
			return a.getName().compareTo(b.getName());
		}
	};

	public Inventory() {
		inventoryItems = new ArrayList<Item>();
		active = false;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		if (active) {
			// Create the background of the inventory screen
			g.setColor(Color.BLACK);
			g.fillRect(50, 50, GUImain.WIDTH - 100, GUImain.HEIGHT - 130);

			// Add the titles of the columns
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.BOLD, 30));
			g.drawString("Item", 250, 100);
			g.drawString("Count", 550, 100);

			// Display each item in the inventory
			g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
			for (int i = 1; i <= inventoryItems.size(); i++) {
				g.drawString(inventoryItems.get(i - 1).getName(), 250, 100 + 50 * i);
				g.drawString(Integer.toString(inventoryItems.get(i - 1).getCount()), 550, 100 + 50 * i);
			}
		}

	}

	// Adds an item to the inventory
	public void addItem(Item item) {
		for (Item i : inventoryItems) {
			// If it is already in the inventory, increase the count
			if (i.getID() == item.getID()) {
				i.setCount(i.getCount() + item.getCount());
				inventoryItems.sort(comp);
				return;
			}
		}
		// If it is not in the inventory, add it
		inventoryItems.add(item);
		inventoryItems.sort(comp);
	}

	// GETTERS AND SETTERS

	public boolean isActive() {
		return active;
	}

	public void toggleActive() {
		active = !active;
	}
}
