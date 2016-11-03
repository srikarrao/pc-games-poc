package com.ifactor.assignment.cardgame;

import com.ifactor.assignment.cardgame.model.Card;

/**
 * Interface specifying the methods to be implemented
 * 
 * @author SrikarRao
 *
 */
public interface DeckGame {

	public void shuffleCards();

	public void cutTheDeck(int index);

	public Card turnOver();

	public Card deal();

	public int searchCard(Card card);

	public void newOrder();
}
