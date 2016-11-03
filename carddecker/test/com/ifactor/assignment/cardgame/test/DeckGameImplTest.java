package com.ifactor.assignment.cardgame.test;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ifactor.assignment.cardgame.DeckGame;
import com.ifactor.assignment.cardgame.DeckGameImpl;
import com.ifactor.assignment.cardgame.model.Card;

/**
 * Java program implementing driver library to test the Deck of Cards Game
 * 
 * @author SrikarRao
 *
 */
public class DeckGameImplTest {

	DeckGame gamer = new DeckGameImpl();
	Scanner scn = new Scanner(System.in);

	@Before
	public void beforeTest() {
		System.out.println("-------Implementing Driver Library!!--------");
	}

	@Test
	public void test() {

		// type-casting the instance
		DeckGameImpl gamer2 = (DeckGameImpl) gamer;
		// test case to validate shuffling
		System.out.println("Before Shuffling the Deck: "
				+ gamer2.getCardsDeck());
		System.out
				.println("After Shuffling the Deck: " + gamer2.getCardsDeck());
		gamer.shuffleCards();

		// test case to validate the split deck of cards
		System.out.println("Please pass a number to split the deck: ");
		int pos = scn.nextInt();
		gamer.cutTheDeck(pos);
		System.out.println("Before splitting the deck : "
				+ gamer2.getSplitDeck().get(11));
		System.out.println(DeckGameImpl.areDecksSimilar());

		// test case to validate the deal and turn over
		Card turnOvercard = gamer.turnOver();
		System.out.println("Card from deck without removing: " + turnOvercard);
		Card dealCard = gamer.deal();
		System.out.println("Card from deck after removing: " + dealCard);
		assertTrue(turnOvercard.equals(dealCard));

		// validate the index of the card in the deck
		int position = gamer.searchCard(new Card("Diamond", "K"));
		System.out.println("Position of the searched card: " + position);

		// validate the new order after sorting
		System.out.println("Split Card Deck before sorting: "
				+ gamer2.getSplitDeck());
		gamer.newOrder();
		System.out.println("Split Card Deck after sorting: "
				+ gamer2.getSplitDeck());

		// Pinochle Deck of cards
		System.out.println("Displaying Pinochle Deck of cards :"
				+ gamer2.getPinochleDeck());
	}

	@After
	public void afterTest() {
		System.out
				.println("-------Driver Library Implementation Successfull!!--------");
	}
}
