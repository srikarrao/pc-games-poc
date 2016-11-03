package com.ifactor.assignment.cardgame.model;

/**
 * Class holding Card details
 * 
 * @author SrikarRao
 *
 */
public class Card{

	// instance variables
	private String value;
	private String suit;

	public String getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}

	/**
	 * Constructor to initialize the values
	 * 
	 * @param suit
	 * @param value
	 */
	public Card(String suit, String value) {
		this.value = value;
		this.suit = suit;
	}

	/**
	 * Method to convert the string form
	 */
	@Override
	public String toString() {
		return "( " + suit + " , " + value + ")";
	}

	
}