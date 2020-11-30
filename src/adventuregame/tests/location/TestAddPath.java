package adventuregame.tests.location;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adventuregame.model.Item;
import adventuregame.model.Location;

class TestAddPath {

	@Test
	void testAddPathWithNullName() {
		Location place = new Location("plac", "p", true, "a");
		assertThrows(IllegalArgumentException.class, () -> {
			place.addPath(null);
		});
	}

	@Test
	void testAddPathWithEmptyName() {
		Location place = new Location("plae", "pa", true, "d");
		assertThrows(IllegalArgumentException.class, () -> {
			place.addPath("");
		});
	}

	@Test
	void testAddPath() {
		Location place = new Location("place", "paaa", true, "ab");
		place.addPath("slam");
		assertEquals(place.getPaths().get(0), "slam");

	}

}
