package adventuregame.tests.location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import adventuregame.model.Location;

class TestConstructor {

	@Test
	void testIsLocked() {
		Location lockedLocation = new Location("Temple", "noimg.png", true, "Not a thing");
		assertEquals("Temple", lockedLocation.getName());
		assertTrue(lockedLocation.isLocked());
	}
	
	@Test
	void testIsNotLocked() {
		Location unlockedLocation = new Location("Beach", "no.png", false, "Nothing");
		assertEquals("Beach", unlockedLocation.getName());
		assertFalse(unlockedLocation.isLocked());
	}

}
