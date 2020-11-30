package adventuregame.tests.location;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import adventuregame.model.Location;

class TestGetPaths {

	@Test
	void testGetPathsWithOneEntry() {
		Location place = new Location("placea", "placea.jpg", true, "plunger");
		place.addPath("jim");
		assertEquals("jim", place.getPaths().get(0));

	}

	@Test
	void testGetPathsWithNoEntry() {
		Location place = new Location("placeb", "placeb.jpg", true, "fork");
		assertEquals(0, place.getPaths().size());
	}

	@Test
	void testGetPathsWithMultipleEntries() {
		Location place = new Location("placec", "placec.jpg", true, "lunger");
		place.addPath("jim");
		place.addPath("carl");
		assertEquals("jim", place.getPaths().get(0));
		assertEquals("carl", place.getPaths().get(1));

	}

}
