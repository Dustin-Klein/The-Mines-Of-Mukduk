package gfx;

import java.awt.image.BufferedImage;

import display.GUImain;

/**
 * This class loads in all of the assets so they can be accessed easily.
 * 
 * @author Dustin
 */
public class Assets {

	public static final int width = GUImain.WIDTH / 11, height = GUImain.WIDTH / 11;

	public static BufferedImage dirt, wall;
	public static BufferedImage player, monster;
	public static BufferedImage menuBackground;
	public static BufferedImage combatBackground;
	public static BufferedImage[] button = new BufferedImage[2];
	public static BufferedImage alert;
	public static BufferedImage combatHUD, combatButtons, pointer;
	public static BufferedImage seamlessRock;
	public static BufferedImage[] noise = new BufferedImage[5];

	public static void init() {
		dirt = ImageLoader.loadImage("res/Dirt.png");
		wall = ImageLoader.loadImage("res/Wall.png");

		player = ImageLoader.loadImage("res/Dwarf.png");
		monster = ImageLoader.loadImage("res/Goblin.png");
		
		menuBackground = ImageLoader.loadImage("res/Main Menu Background.png");
		combatBackground = ImageLoader.loadImage("res/Cave_Background.png");
		
		button[0] = ImageLoader.loadImage("res/Button.png");
		button[1] = ImageLoader.loadImage("res/Button-Hovered.png");
		
		alert = ImageLoader.loadImage("res/Dialogue.png");
		
		combatHUD = ImageLoader.loadImage("res/CombatGUI.png");
		combatButtons = ImageLoader.loadImage("res/CombatButtons.png");
		pointer = ImageLoader.loadImage("res/pointer.png");
		
		seamlessRock = ImageLoader.loadImage("res/Seamless Rock Texture.png");
		
		noise[0] = ImageLoader.loadImage("res/Noise/Noise1.png");
		noise[1] = ImageLoader.loadImage("res/Noise/Noise2.png");
		noise[2] = ImageLoader.loadImage("res/Noise/Noise3.png");
		noise[3] = ImageLoader.loadImage("res/Noise/Noise4.png");
		noise[4] = ImageLoader.loadImage("res/Noise/Noise5.png");
	}
}
