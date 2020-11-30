package adventuregame.tests.location;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adventuregame.model.Location;

class TestGetPaths {

	@Test
	void testGetPathsWithOneEntry() {
		Location place = new Location("place", "place.jpg", true, "plunger");
		place.addPath("jim");
		assertEquals("jim", place.getPaths().get(0));

	}

	@Test
	void testGetPathsWithNoEntry() {
		Location place = new Location("place", "place.jpg", true, "plunger");
		assertEquals(0, place.getPaths().size());
	}

	@Test
	void testGetPathsWithMultipleEntries() {
		Location place = new Location("place", "place.jpg", true, "plunger");
		place.addPath("jim");
		place.addPath("carl");
		assertEquals("jim", place.getPaths().get(0));
		assertEquals("carl", place.getPaths().get(1));

	}

}
