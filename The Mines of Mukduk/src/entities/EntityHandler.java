package entities;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This class handles all entities. It basically updates every single entity
 * every tick.
 *
 * @author Dustin
 */
public class EntityHandler {

    // This list holds every entity
    private static CopyOnWriteArrayList<Entity> entities;

    private Player player;

    public EntityHandler() {
        entities = new CopyOnWriteArrayList<>();
    }

    public void tick() {
        for (Entity e : entities) {
            e.tick();
        }
    }

    public void render(Graphics g) {
        for (Entity e : entities) {
            e.render(g);
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void removeMonsters() {
        for (Entity e : entities) {
            if (e.getId() == ID.Monster) {
                removeEntity(e);
            }
        }
    }

    // GETTERS AND SETTERS

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        entities.add(player);
    }

    public CopyOnWriteArrayList<Entity> getEntities() {
        return entities;
    }
}
