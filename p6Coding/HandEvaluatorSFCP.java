package p6Coding;

import java.util.Arrays;

public class HandEvaluatorSFCP {
	// ALL OF THESE ARE PASSED AN ARRAY OF LENGTH 5
	private static int counter;

	// Cluster 1: Think about how a helper might be useful for these...
	public static boolean hasPair(Card[] cards) {
		int track = 0;
		boolean ret = false;
		// this code takes each element of the array and compares the values
		// of it to every other element in the array. If there is two elements
		// with the same value, the track variable will increase by 1.
		// At the end of the inner loop, if track is more than 1 (so had
		// the same value as itself as well as another in the array)
		// it will return true, if not it will reset track back to 0
		// and then traverse through the array again but comparing a different
		// element
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					track++;
				}
			}
			if (track > 1)
				ret = true;
			track = 0;
		}
		return ret;
	}

	public static boolean hasThreeOfAKind(Card[] cards) {
		// this code takes each element of the array and compares the values
		// of it to every other element in the array. If there is two elements
		// with the same value, the track variable will increase by 1.
		// At the end of the inner loop, if track is more than 2 (so had
		// the same value as itself as well as 2 others in the array)
		// it will return true, if not it will reset track back to 0
		// and then traverse through the array again but comparing a different
		// element
		int track = 0;
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					track++;
				}
			}
			if (track > 2) {
				return true;
			}
			track = 0;
		}

		return false;
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		// this code takes each element of the array and compares the values
		// of it to every other element in the array. If there is two elements
		// with the same value, the track variable will increase by 1.
		// At the end of the inner loop, if track is more than 3 (so had
		// the same value as itself as well as 3 others in the array)
		// it will return true, if not it will reset track back to 0
		// and then traverse through the array again but comparing a different
		// element

		int track = 0;
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					track++;
				}
			}
			if (track > 3) {
				return true;
			}
			track = 0;
		}

		return false;
	}

	public static boolean hasFiveOfAKind(Card[] cards) {
		// this code takes each element of the array and compares the values
		// of it to every other element in the array. If there is two elements
		// with the same value, the track variable will increase by 1.
		// At the end of the inner loop, if track is more than 4 (so had
		// the same value as itself as well as 4 others in the array)
		// it will return true, if not it will reset track back to 0
		// and then traverse through the array again but comparing a different
		// element

		int track = 0;
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					track++;
				}
			}
			if (track > 4) {
				return true;
			}
			track = 0;
		}

		return false;
	}

	// Cluster 2
	public static boolean hasRainbow(Card[] cards) {
		/* this code takes each element of the array and compares the suits
		 * of it to every other element in the array. If there is two elements
		 * with the same value, the track variable will
		 * increase by 1. At the end of the inner loop, 
		 * if track is more than 1 (so had the same value
		 * as itself as well as 1 other in the array) it will return false,
		 * if not it will reset track back to 0 and then traverse through
		 *  the array again but comparing a different element
		 */

		int track = 0;
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (cards[i].getSuit() == cards[j].getSuit()) {
					track++;
				}
			}
			if (track > 1) {
				return false;
			}
			track = 0;
		}
		return true;
	}

	public static boolean hasStraight(Card[] cards) {
		// set the first element in the array to both the max and min and then traverse
		// through the array to find the max value and min value in the entire array.
		// If the max minus the min is four, then there is a straight. But first we
		// check to
		// see if there is an Ace and if there is, and the value of 1 is not suitable,
		// then it changes the
		// max to 10 and the min to the next smallest value in the array and then checks
		// to see if
		// max - min = 4 again.

		if (hasPair(cards) == true || hasTwoPair(cards) == true) {
			return false;
		}

		int[] check = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		int one = 0;

		for (int i = 0; i < cards.length; i++) {
			int find = cards[i].getValue();
			if (find == 1) {
				one++;
			}
			check[find - 1] = 1;
		}

		if (helperStraight(check) == false) {
			if (one == 1) {
				check[0] = 0;
				check[check.length - 1] = 1;
				return helperStraight(check);
			}
		}
		return helperStraight(check);
	}

	public static boolean helperStraight(int[] check) {
		int[] c1 = { 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 };
		int[] c2 = { 0, 1, 1, 1, 1, 1, 0, 0, 0, 0 };
		int[] c3 = { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 };
		int[] c4 = { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 };
		int[] c5 = { 0, 0, 0, 0, 1, 1, 1, 1, 1, 0 };
		int[] c6 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };

		if (Arrays.equals(check, c1)) {
			return true;
		} else if (Arrays.equals(check, c2)) {
			return true;
		} else if (Arrays.equals(check, c3)) {
			return true;
		} else if (Arrays.equals(check, c4)) {
			return true;
		} else if (Arrays.equals(check, c5)) {
			return true;
		} else if (Arrays.equals(check, c6)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasFlush(Card[] cards) {
		// this code takes the first element of the array and compares the suits of it
		// to every other
		// element in the array. If there is two elements with the same suit, the track
		// variable will
		// increase by 1. At the end of the inner loop, if track is more than 4 (so had
		// the same value
		// as itself as well as the 4 others in the array) it will return true, if not
		// it will return false
		int track = 0;

		for (int i = 0; i < cards.length; i++) {
			track = 0;
			for (int j = 0; j < cards.length; j++) {
				if (cards[i].getSuit() == cards[j].getSuit()) {
					track++;
				}
			}
		}
		if (track == 5) {
			return true;
		}

		return false;
	}

	// Cluster 3: Think about how to make use of existing methods to
	// make the following ones easier to write...
	public static boolean hasStraightRainbow(Card[] cards) {
		// checks to see if it has a straight and rainbow
		return (hasStraight(cards) && hasRainbow(cards));
	}

	public static boolean hasStraightFlush(Card[] cards) {
		// checks to see if it has a straight and flush
		return (hasStraight(cards) && hasFlush(cards));
	}

	public static boolean hasTwoPair(Card[] cards) {
		// checks to see if it has either a five or four of a kind, if it
		// does, it doesn't have two pairs. It then checks to see if it has at
		// least one pair. After that, it takes each element of the array and compares
		// the values of it to every other
		// element in the array. If there is two elements with the same value, the track
		// variable will
		// increase by 1. At the end of the inner loop, if track is more than 1 (so had
		// the same value
		// as itself as well as another in the array) it will increase value by 1, it
		// will then reset track
		// back to 0 and then traverse through the array again but comparing a different
		// element. At the end of the
		// nested loop, if value is 4, then it does have two pairs.
		if (hasFiveOfAKind(cards) || hasFourOfAKind(cards)) {
			return false;
		}
		if (hasPair(cards) == false) {
			return false;
		}
		int track = 0;
		int value = 0;
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					track++;
				}
			}
			if (track > 1) {
				value++;
			}
			track = 0;
		}
		if (value == 4) {
			return true;
		}
		return false;
	}
}
