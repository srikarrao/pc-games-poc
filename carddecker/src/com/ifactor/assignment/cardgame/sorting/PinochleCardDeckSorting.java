package com.ifactor.assignment.cardgame.sorting;

import java.util.Comparator;
import com.ifactor.assignment.cardgame.model.Card;
import com.ifactor.assignment.cardgame.model.CardValues;
import com.ifactor.assignment.cardgame.model.Suits;

/**
 * Java class implementing comparator to sort Pinochle deck of cards
 * 
 * @author SrikarRao
 *
 */
public class PinochleCardDeckSorting implements Comparator<Card> {

	/**
	 * Method to compare the card values
	 */
	@Override
	public int compare(Card o2, Card o1) {

		if (o1 == null || !(o1 instanceof Card) || o2 == null
				|| !(o2 instanceof Card)) {
			throw new IllegalArgumentException();
		}
		int s1 = Suits.getOrdinal(o1);
		int s2 = Suits.getOrdinal(o2);

		if (s1 != s2) {
			if (s1 < s2)
				return 1;
			else
				return -1;
		}

		int c1 = CardValues.getOrdinal(o1);
		int c2 = CardValues.getOrdinal(o2);

		if (c1 != c2) {
			if (c1 == 9) {
				return 1;
			} else {
				if (c1 == 11) {
					return 1;
				} else {
					if (c1 == 12) {
						return 1;
					} else {
						if (c1 == 13) {
							return 1;
						} else {
							if (c1 == 10) {
								return -1;
							} else {
								if (c1 == 1) {
									return 1;
								} else {
									return -1;
								}
							}
						}
					}
				}
			}
		}
		return 0;
	}
}