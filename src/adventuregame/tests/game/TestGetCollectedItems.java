package adventuregame.tests.game;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import adventuregame.model.Game;
import adventuregame.model.Item;

class TestGetCollectedItems {

	@Test
	void testGetCollectedItemsWithEmptyList() {
		Game game = new Game();
		assertEquals(0, game.getCollectedItems().size());
	}

	@Test
	void testGetCollectedItemsWithSingleItem() {
		Game game = new Game();
		Item jim = new Item("Aa", "ABa");
		game.getCollectedItems().add(jim);
		assertEquals(jim, game.getCollectedItems().get(0));
	}

	@Test
	void testGetCollectedItemsWithMultipleItems() {
		Game game = new Game();
		Item jim = new Item("Aaa", "ABaa");
		Item tim = new Item("Aaaa", "ABaaaa");
		Item slim = new Item("Aaaaaaa", "ABaaaaaa");
		game.getCollectedItems().add(jim);
		game.getCollectedItems().add(tim);
		game.getCollectedItems().add(slim);
		assertEquals(jim, game.getCollectedItems().get(0));
		assertEquals(tim, game.getCollectedItems().get(1));
		assertEquals(slim, game.getCollectedItems().get(2));
	}

}
