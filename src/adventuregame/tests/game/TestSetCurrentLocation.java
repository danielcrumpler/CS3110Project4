package adventuregame.tests.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adventuregame.model.Game;

class TestSetCurrentLocation {

	@Test
	void testSetCurrentLocationToNull() {
		Game game = new Game();
		assertThrows(IllegalArgumentException.class, () -> { game.setCurrentLocation(null);});
	}

}
