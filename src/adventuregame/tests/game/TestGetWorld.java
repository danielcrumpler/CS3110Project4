package adventuregame.tests.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adventuregame.model.Game;
import adventuregame.model.World;

class TestGetWorld {

	@Test
	void testGetWorld() {
		Game game = new Game();
		World world = new World();
		game.loadWorldOne();
		world = game.getWorld();
		assertEquals(world.getLocations().get(0).getName(), game.getWorld().getLocations().get(0).getName());
	}

}
