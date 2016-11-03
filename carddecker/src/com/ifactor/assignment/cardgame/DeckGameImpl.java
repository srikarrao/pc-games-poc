package com.ifactor.assignment.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.ifactor.assignment.cardgame.model.Card;
import com.ifactor.assignment.cardgame.model.Suits;
import com.ifactor.assignment.cardgame.model.CardValues;
import com.ifactor.assignment.cardgame.sorting.CardDeckSorting;
import com.ifactor.assignment.cardgame.sorting.PinochleCardDeckSorting;

/**
 * JAVA program to implement the deck game
 * 
 * @author SrikarRao
 *
 */
public class DeckGameImpl implements DeckGame {

	private static List<Card> cardsDeck = new ArrayList<Card>(52);
	private static List<Card> splitDeck = new ArrayList<Card>(52);
	private static List<Card> pinochleDeck = new ArrayList<Card>(48);
	private static final CardDeckSorting deckSorting = new CardDeckSorting();
	private static final PinochleCardDeckSorting pinochleDeckSorting = new PinochleCardDeckSorting();

	static {
		insertAllCards();
		insertInPincohleDeck();
		sortPincohleDeck();
	}

	/**
	 * method to split the cards
	 */
	public void cutTheDeck(int number) {
		if (number < 1 && number > 52) {
			throw new IllegalArgumentException("Number of cards only 52!!");
		}

		number += 1;
		// adding elements below the selected card
		for (int i = number + 1; i < 52; i++) {
			splitDeck.add(cardsDeck.get(i));
		}

		while (number >= 0) {
			splitDeck.add(cardsDeck.get(number));
			number--;
		}
	}

	/**
	 * method to shuffle cards
	 */
	public void shuffleCards() {
		for (int i = 0; i < 52; i++) {
			int rand = new Random().nextInt(52 - i) + i;
			Card temp = cardsDeck.get(i);
			cardsDeck.set(i, cardsDeck.get(rand));
			cardsDeck.set(rand, temp);
		}
	}

	/**
	 * method to find the position of the given card
	 * 
	 * @param card
	 * @return
	 */
	@Override
	public int searchCard(Card card) {
		int position = -1;
		for (int i = 0; i < cardsDeck.size(); i++) {
			Card c = cardsDeck.get(i);
			if (c.getSuit().equalsIgnoreCase(card.getSuit())) {
				if (c.getValue().equalsIgnoreCase(card.getValue())) {
					position = i;
					break;
				}
			}
		}
		return position;
	}

	/**
	 * method to retrieve the first card from the deck
	 * 
	 * @return
	 */
	public Card turnOver() {
		Card card = splitDeck.get(0);
		return card;
	}

	/**
	 * method to remove the first card from the deck
	 * 
	 * @return
	 */
	public Card deal() {
		Card card = splitDeck.get(0);
		splitDeck.remove(0);
		splitDeck.subList(1, 51);
		return card;
	}

	/**
	 * method to implement new order for the deck
	 */
	public void newOrder() {
		Collections.sort(splitDeck, deckSorting);
	}

	/**
	 * method to check if the list has been shuffled
	 * 
	 * @return
	 */
	public static boolean areDecksSimilar() {
		for (int i = 0; i < 52; i++) {
			if (!(cardsDeck.get(i).getValue()
					.equals(splitDeck.get(i).getValue()) && cardsDeck.get(i)
					.getSuit().equals(splitDeck.get(i).getSuit()))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * method to insert cards
	 */
	public static void insertAllCards() {
		for (Suits suit : Suits.values()) {
			String sVal = suit.getValue();
			for (CardValues card : CardValues.values()) {
				String val = card.getValue();
				cardsDeck.add(new Card(sVal, val));
			}
		}
	}

	public List<Card> getCardsDeck() {
		return cardsDeck;
	}

	public List<Card> getSplitDeck() {
		return splitDeck;
	}

	public List<Card> getPinochleDeck() {
		return pinochleDeck;
	}

	private static void insertInPincohleDeck() {

		int i = 0;
		while (i++ < 2) {
			for (Suits suit : Suits.values()) {
				String sVal = suit.getValue();
				for (CardValues card : CardValues.values()) {
					String val = card.getValue();
					if (val.equals("K") || val.equals("A") || val.equals("J")
							|| val.equals("Q") || Integer.valueOf(val) > 8) {
						pinochleDeck.add(new Card(sVal, val));
					}
				}
			}
		}
	}

	private static void sortPincohleDeck() {
		Collections.sort(pinochleDeck, pinochleDeckSorting);
	}
}