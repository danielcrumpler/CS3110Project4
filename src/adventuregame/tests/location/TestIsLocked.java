package adventuregame.tests.location;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import adventuregame.model.Location;

class TestIsLocked {

	@Test
	void testIsLocked() {
		Location lockedLocation = new Location("Temple", "noimg.png", true, "Not a thing");
		assertTrue(lockedLocation.isLocked());
	}

	@Test
	void testIsNotLocked() {
		Location unlockedLocation = new Location("Beach", "no.png", false, "Nothing");
		assertFalse(unlockedLocation.isLocked());
	}

}
