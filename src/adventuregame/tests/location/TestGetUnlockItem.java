package adventuregame.tests.location;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import adventuregame.model.Location;

class TestGetUnlockItem {

	@Test
	void testGetName() {
		Location place = new Location("place", "place.jpg", true, "plunger");
		assertEquals("plunger", place.getUnlockItem());
	}

}
