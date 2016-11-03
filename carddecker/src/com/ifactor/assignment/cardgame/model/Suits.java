package com.ifactor.assignment.cardgame.model;

/**
 * ENUM holding the suit values
 * @author SrikarRao
 *
 */
public enum Suits {

	Heart("Heart"), Club("Club"), Diamond("Diamond"), Spade("Spade");
	
	String value;

	Suits(String p) {
		value = p;
	}
	public static int getOrdinal(Card o) {
		int val;
		if (o.getSuit().equals("Heart")) {
			val = 0;
		} else if (o.getSuit().equals("Club")) {
			val = 1;
		} else if (o.getSuit().equals("Diamond")) {
			val = 2;
		} else {
			val = 3;
		}
		return val;
	}

	public String getValue() {
		return value;
	}
}
