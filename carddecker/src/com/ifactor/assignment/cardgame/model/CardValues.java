package com.ifactor.assignment.cardgame.model;

/**
 * ENUM holding the card values
 * 
 * @author SrikarRao
 *
 */
public enum CardValues {
	Ace("A"), Two("2"), Three("3"), Four("4"), Five("5"), Six("6"), Seven("7"), Eight(
			"8"), Nine("9"), Ten("10"), Jack("J"), Queen("Q"), King("K");

	String value;

	CardValues(String p) {
		value = p;
	}

	public static int getOrdinal(Card o) {
		int val;
		if (o.getValue().equals("A")) {
			val = 0;
		} else if (o.getValue().equals("J")) {
			val = 11;
		} else if (o.getValue().equals("Q")) {
			val = 12;
		} else if (o.getValue().equals("K")) {
			val = 13;
		} else {
			val = Integer.valueOf(o.getValue());
		}
		return val;
	}

	public String getValue() {
		return value;
	}
}