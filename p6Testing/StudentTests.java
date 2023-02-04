package p6Testing;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import p6Coding.Card;
import p6Coding.Deck;
import p6Coding.HandEvaluatorSFCP;
import p6Coding.HandEvaluatorPatrickjack;

public class StudentTests {

	@Test
	public void testExampleTest_SinglePairTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,1);
		testHand[2] = new Card(3,1);
		testHand[3] = new Card(4,1);
		testHand[4] = new Card(5,1);
		assertFalse(HandEvaluatorSFCP.hasPair(testHand));
	}


	@Test
	public void testExampleTest_SingleRainbowTest() {
		Card testHand[] = new Card[5];

		testHand[0] = new Card(4,0);
		testHand[1] = new Card(5,1);
		testHand[2] = new Card(5,2);
		testHand[3] = new Card(5,3);
		testHand[4] = new Card(9,4);
		assertTrue(HandEvaluatorSFCP.hasRainbow(testHand));
	}


	@Test
	public void testExampleTest_SinglePatrickjackEvalTest() {
		ArrayList<Card> player = new ArrayList<Card>();
		player.add(new Card(3,1));
		player.add(new Card(2,1));

		assertEquals(5, HandEvaluatorPatrickjack.eval(player));
	}


	@Test
	public void testExampleTest_DeckDealCardsLengthTest() {
		Deck theDeck = new Deck();
		Card[] cards = theDeck.deal(41);
		assertEquals(41, cards.length);
	}

	@Test
	public void testhasPair() {
		
		Card[] cards = {new Card(2,0),new Card(4,0),new Card(2,0),new Card(6,0), new Card(1,0)};
		Card[] cards1 = {new Card(2,0),new Card(4,0),new Card(3,0),new Card(6,0), new Card(1,0)};
		Card[] cards2 = {new Card(2,0),new Card(2,0),new Card(2,0),new Card(2,0), new Card(2,0)};
		assertEquals(true, HandEvaluatorSFCP.hasPair(cards));
		assertEquals(true, HandEvaluatorSFCP.hasPair(cards2));
		assertEquals(false, HandEvaluatorSFCP.hasPair(cards1));
	}
	@Test
	public void testhasThreeOfAKind() {
		
		Card[] cards = {new Card(2,0),new Card(4,0),new Card(2,0),new Card(6,0), new Card(2,0)};
		Card[] cards1 = {new Card(2,0),new Card(4,0),new Card(4,0),new Card(6,0), new Card(1,0)};
		assertEquals(true, HandEvaluatorSFCP.hasThreeOfAKind(cards));
		assertEquals(false, HandEvaluatorSFCP.hasThreeOfAKind(cards1));
	}
	@Test
	public void testhasFourOfAKind() {
		
		Card[] cards = {new Card(2,0),new Card(2,0),new Card(2,0),new Card(6,0), new Card(2,0)};
		Card[] cards1 = {new Card(2,0),new Card(4,0),new Card(4,0),new Card(6,0), new Card(1,0)};
		assertEquals(true, HandEvaluatorSFCP.hasFourOfAKind(cards));
		assertEquals(false, HandEvaluatorSFCP.hasFourOfAKind(cards1));
	}
	@Test
	public void testhasFiveOfAKind() {
		
		Card[] cards = {new Card(2,0),new Card(2,0),new Card(2,0),new Card(2,0), new Card(2,0)};
		Card[] cards1 = {new Card(4,0),new Card(4,0),new Card(4,0),new Card(4,0), new Card(1,0)};
		assertEquals(true, HandEvaluatorSFCP.hasFiveOfAKind(cards));
		assertEquals(false, HandEvaluatorSFCP.hasFiveOfAKind(cards1));
	}
	@Test
	public void testhasRainbow() {
		
		Card[] cards = {new Card(2,0),new Card(2,1),new Card(2,3),new Card(2,2), new Card(2,4)};
		Card[] cards1 = {new Card(2,3),new Card(4,2),new Card(4,4),new Card(6,0), new Card(1,3)};
		assertEquals(true, HandEvaluatorSFCP.hasRainbow(cards));
		assertEquals(false, HandEvaluatorSFCP.hasRainbow(cards1));
	}
	@Test
	public void testhasStraight() {
		
		Card[] cards = {new Card(8,4),new Card(7,4),new Card(9,4),new Card(6,4), new Card(5,4)};
		Card[] cards1 = {new Card(1,0),new Card(7,0),new Card(8,0),new Card(9,0), new Card(1,3)};
		Card[] cards2 = {new Card(9,0),new Card(7,1),new Card(8,3),new Card(1,2), new Card(6,4)};
		assertEquals(true, HandEvaluatorSFCP.hasStraight(cards));
		assertEquals(false, HandEvaluatorSFCP.hasStraight(cards1));
		assertTrue(HandEvaluatorSFCP.hasStraight(cards2));
	}
	@Test
	public void testhasFlush() {
		
		Card[] cards = {new Card(1,3),new Card(7,3),new Card(6,3),new Card(9,3), new Card(8,3)};
		Card[] cards1 = {new Card(1,2),new Card(2,0),new Card(2,0),new Card(2,0), new Card(2,0)};
		Card[] cards2 = {new Card(9,0),new Card(7,1),new Card(8,3),new Card(1,2), new Card(6,4)};
		assertEquals(true, HandEvaluatorSFCP.hasFlush(cards));
		assertEquals(false, HandEvaluatorSFCP.hasFlush(cards1));
		assertEquals(false, HandEvaluatorSFCP.hasFlush(cards2));
	}
	@Test
	public void testhasStraightRainbow() {
		
		Card[] cards = {new Card(2,0),new Card(3,1),new Card(1,3),new Card(5,2), new Card(4,4)};
		Card[] cards1 = {new Card(2,0),new Card(4,2),new Card(4,0),new Card(6,0), new Card(1,3)};
		Card[] cards2 = {new Card(9,0),new Card(7,1),new Card(8,3),new Card(1,2), new Card(6,4)};
		assertEquals(true, HandEvaluatorSFCP.hasStraightRainbow(cards));
		assertEquals(false, HandEvaluatorSFCP.hasStraightRainbow(cards1));
		assertEquals(true, HandEvaluatorSFCP.hasStraightRainbow(cards2));
	}
	@Test
	public void testhasStraightFlush() {
		
		Card[] cards = {new Card(1,4),new Card(2,4),new Card(4,4),new Card(3,4), new Card(5,4)};
		Card[] cards1 = {new Card(7,0),new Card(8,0),new Card(9,0),new Card(1,1), new Card(2,0)};
		Card[] cards2 = {new Card(1,4),new Card(3,4),new Card(4,4),new Card(2,4), new Card(9,4)};
		Card[] cards3 = {new Card(7,4),new Card(8,4),new Card(6,4),new Card(9,4), new Card(1,4)};
		assertEquals(true, HandEvaluatorSFCP.hasStraightFlush(cards));
		assertEquals(false, HandEvaluatorSFCP.hasStraightFlush(cards1));
		assertEquals(false, HandEvaluatorSFCP.hasStraightFlush(cards2));
		assertEquals(true, HandEvaluatorSFCP.hasStraightFlush(cards3));
	}
	@Test
	public void testhasTwoPair() {
		
		Card[] cards = {new Card(2,0),new Card(2,0),new Card(2,0),new Card(2,0), new Card(4,0)};
		Card[] cards1 = {new Card(2,0),new Card(2,2),new Card(2,0),new Card(2,0), new Card(2,3)};
		Card[] cards2 = {new Card(9,4),new Card(9,4),new Card(8,4),new Card(1,4), new Card(6,4)};
		Card[] cards3 = {new Card(9,4),new Card(9,4),new Card(8,4),new Card(1,4), new Card(8,4)};
		assertEquals(false, HandEvaluatorSFCP.hasTwoPair(cards));
		assertEquals(false, HandEvaluatorSFCP.hasTwoPair(cards1));
		assertEquals(false, HandEvaluatorSFCP.hasTwoPair(cards2));
		assertEquals(true, HandEvaluatorSFCP.hasTwoPair(cards3));
	}
	@Test
	public void testHouseWins() {
		
		ArrayList<Card> cards = new ArrayList();
		ArrayList<Card> cards1 = new ArrayList();
		ArrayList<Card> cards2 = new ArrayList();
		ArrayList<Card> cards3 = new ArrayList();
		
		cards.add(new Card(7,0));
		cards.add(new Card(2,0));
		
		cards1.add(new Card(5,0));
		cards1.add(new Card(6,0));
		
		cards2.add(new Card(7,0));
		cards2.add(new Card(8,0));
		
		cards3.add(new Card(9,0));
		cards3.add(new Card(6,0));
		
		assertEquals(false, HandEvaluatorPatrickjack.houseWins(cards,cards));
		assertEquals(false, HandEvaluatorPatrickjack.houseWins(cards,cards3));
		assertEquals(true, HandEvaluatorPatrickjack.houseWins(cards3, cards));
		assertEquals(false, HandEvaluatorPatrickjack.houseWins(cards1, cards2));
		cards1.remove(1);
		cards1.add(new Card(9,0));
		cards1.add(new Card(7,0));
		assertEquals(false, HandEvaluatorPatrickjack.houseWins(cards1, cards2));
	}
	//You will add many other tests here.  You can also modify the ones above.




}
