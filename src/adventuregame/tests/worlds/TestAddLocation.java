package adventuregame.tests.worlds;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adventuregame.model.Item;
import adventuregame.model.Location;
import adventuregame.model.World;

class TestAddLocation {

	@Test
	void testAddLocationWithNullName() {
		World world = new World();
		assertThrows(IllegalArgumentException.class, () -> {
			world.addLocation(null, "p", true, "a");
		});
	}

	@Test
	void testtAddLocationWithEmptyName() {
		World world = new World();
		assertThrows(IllegalArgumentException.class, () -> {
			world.addLocation("", "p", true, "a");
		});
	}

	@Test
	void testtAddLocationWithNullURL() {
		World world = new World();
		assertThrows(IllegalArgumentException.class, () -> {
			world.addLocation("a", null, true, "a");
		});
	}

	@Test
	void testtAddLocationWithEmptyURL() {
		World world = new World();
		assertThrows(IllegalArgumentException.class, () -> {
			world.addLocation("abc", "", true, "a");
		});
	}

	@Test
	void testtAddLocationWithNullUnlockItem() {
		World world = new World();
		assertThrows(IllegalArgumentException.class, () -> {
			world.addLocation("a", "aa", true, null);
		});
	}

	@Test
	void testtAddLocationWithEmptyInlockItem() {
		World world = new World();
		assertThrows(IllegalArgumentException.class, () -> {
			world.addLocation("abc", "aaaaaaa", true, "");
		});
	}

	@Test
	void testAddLocation() {
		World world = new World();
		assertTrue(world.addLocation("a", "url", false, "aaa"));
	}

}
