package adventuregame.tests.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import adventuregame.model.Game;
import adventuregame.model.Location;

class TestSetCurrentLocation {

	@Test
	void testSetCurrentLocation() {
		Game game = new Game();
		game.setCurrentLocation(new Location("Testland", "ABC", true, "Swag"));
		assertEquals("Testland", game.getCurrentLocation().getName());
		assertEquals("ABC", game.getCurrentLocation().getImageUrl());
		assertTrue(game.getCurrentLocation().isLocked());
		assertEquals("Swag", game.getCurrentLocation().getUnlockItem());
	}
	
	@Test
	void testSetCurrentLocationToNull() {
		Game game = new Game();
		assertThrows(IllegalArgumentException.class, () -> {
			game.setCurrentLocation(null);
		});
	}

}
