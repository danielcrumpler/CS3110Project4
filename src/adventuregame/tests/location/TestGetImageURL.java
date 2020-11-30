package adventuregame.tests.location;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adventuregame.model.Location;

class TestGetImageURL {

	@Test
	void testGetURL() {
		Location place = new Location("place", "place.jpg", true, "plunger");
		assertEquals("place.jpg", place.getImageUrl());
	}
}
