package adventuregame.tests.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adventuregame.model.Item;

class TestGetDescription {

	@Test
	void testGetDescription() {
		Item sword = new Item("Excalibur", "Not the Sword in the Stone, that was Caliburn");
		assertEquals("Not the Sword in the Stone, that was Caliburn", sword.getDescription());
	}

}
