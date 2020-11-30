package adventuregame.tests.item;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import adventuregame.model.Item;

class TestGetName {

	@Test
	void testGetName() {
		Item sword = new Item("Excalibur", "Not the Sword in the Stone, that was Caliburn");
		assertEquals("Excalibur", sword.getName());
	}

}
