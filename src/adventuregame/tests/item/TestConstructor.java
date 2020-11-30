package adventuregame.tests.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adventuregame.model.Item;

class TestConstructor {

	@Test
	void testPositive() {
		Item theItem = new Item("Hammer", "It hits things.");
		
		assertEquals("Hammer", theItem.getName());
		assertEquals("It hits things.", theItem.getDescription());
	}
	
	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Item(null, "It hits things.");
		});
	}
	
	@Test
	void testNullDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("Hammer", null);
		});
	}
	
	@Test
	void testNullNameAndDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Item(null, null);
		});
	}
	
	@Test
	void testEmptyName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("", "It hits things.");
		});
	}
	
	@Test
	void testEmptyDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("Hammer", "");
		});
	}
	
	@Test
	void testEmptyNameAndDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("", "");
		});
	}

}
