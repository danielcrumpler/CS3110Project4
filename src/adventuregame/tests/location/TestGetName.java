package adventuregame.tests.location;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adventuregame.model.Location;

class TestGetName {

	@Test
	void testGetName() {
		Location place = new Location("place", "place.jpg", true, "plunger");
		assertEquals("place", place.getName());
	}

}
