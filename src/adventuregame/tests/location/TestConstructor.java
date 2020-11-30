package adventuregame.tests.location;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import adventuregame.model.Location;

class TestConstructor {

	@Test
	void testPositive() {
		Location lockedLocation = new Location("Temple", true);
		Location unlockedLocation = new Location("Beach", false);
		assertEquals("Temple", lockedLocation.getName());
		assertEquals("Beach", unlockedLocation.getName());
		assertTrue(lockedLocation.isLocked());
		assertFalse(unlockedLocation.isLocked());
		assertTrue(lockedLocation.getItems().isEmpty());
		assertTrue(lockedLocation.getPaths().isEmpty());
	}

}
