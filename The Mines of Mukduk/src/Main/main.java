package Main;

import user_interface.GUIMain;
import user_interface.UI;
import world_gen.Map;
import world_gen.World;

public class main {

	public static final int gridSize = 30;

	public static void main(String[] args) {
		World world = new World();
		new GUIMain(world);
	}
}