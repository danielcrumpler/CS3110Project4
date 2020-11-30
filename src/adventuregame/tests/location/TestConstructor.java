package adventuregame.tests.location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import adventuregame.model.Item;
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
	
	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Location(null, "img", true, "Plunger");
		});
		
	}
	
	@Test
	void testNullURL() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Location("Place", null, true, "Plunger");
		});
		
	}
	
	@Test
	void testNullItem() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Location("Place", "img", true, null);
		});
		
	}

}
