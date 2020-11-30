package adventuregame.tests.location;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import adventuregame.model.Location;

class TestRemoveItem {

	@Test
	void testRemoveItemWithNullName() {
		Location place = new Location("plac", "p", true, "a");
		assertThrows(IllegalArgumentException.class, () -> {
			place.removeItem(null, "aaa");
		});
	}

	@Test
	void testAddItemWithEmptyName() {
		Location place = new Location("plae", "pa", true, "d");
		assertThrows(IllegalArgumentException.class, () -> {
			place.removeItem("", "aaa");
		});
	}

	@Test
	void testAddItemWithNullDescription() {
		Location place = new Location("pace", "paa", true, "c");
		assertThrows(IllegalArgumentException.class, () -> {
			place.removeItem("aaa", null);
		});
	}

	@Test
	void testAddItemWithEmptyDescription() {
		Location place = new Location("plce", "paaaa", true, "b");
		assertThrows(IllegalArgumentException.class, () -> {
			place.removeItem("aaa", "");
		});
	}

	@Test
	void testAddItem() {
		Location place = new Location("place", "paaa", true, "ab");
		place.addItem("slam", "welcome to the jam");
		assertEquals(place.getItems().get(0).getName(), "slam");
		assertEquals(place.getItems().get(0).getDescription(), "welcome to the jam");
		assertTrue(place.removeItem("slam", "welcome to the jam"));

	}

}
