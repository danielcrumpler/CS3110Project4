package adventuregame.tests.location;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adventuregame.model.Item;
import adventuregame.model.Location;

class TestAddItem {

	@Test
	void testAddItemWithNullName() {
		Location place = new Location("plac", "p", true, "a");
		assertThrows(IllegalArgumentException.class, () -> {
			place.addItem(null, "aaa");
		});
	}

	@Test
	void testAddItemWithEmptyName() {
		Location place = new Location("plae", "pa", true, "d");
		assertThrows(IllegalArgumentException.class, () -> {
			place.addItem("", "aaa");
		});
	}

	@Test
	void testAddItemWithNullDescription() {
		Location place = new Location("pace", "paa", true, "c");
		assertThrows(IllegalArgumentException.class, () -> {
			place.addItem("aaa", null);
		});
	}

	@Test
	void testAddItemWithEmptyDescription() {
		Location place = new Location("plce", "paaaa", true, "b");
		assertThrows(IllegalArgumentException.class, () -> {
			place.addItem("aaa", "");
		});
	}

	@Test
	void testAddItem() {
		Location place = new Location("place", "paaa", true, "ab");
		place.addItem("slam", "welcome to the jam");
		assertEquals(place.getItems().get(0).getName(), "slam");
		assertEquals(place.getItems().get(0).getDescription(), "welcome to the jam");
	}

}
