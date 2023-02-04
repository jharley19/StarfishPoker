package p6Coding;

import java.util.ArrayList;

public class Deck {

	// You need to use this ArrayList<Card> structure to hold the deck
	private ArrayList<Card> cards;

	public Deck() {
		//make a new ArrayList
		cards = new ArrayList<Card>();
		
		//add 45 cards with each one between 1-9 on values with 0-4 with suits
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= 9; j++) {
				cards.add(new Card(j, i));
			}
		}
	}

	public Deck(Deck other) {
		cards = new ArrayList<Card>();
		
		for(Card c : other.cards){
			cards.add(c);
		}
	}

	public Card getCardAt(int position) {
		return cards.get(position);
	}

	public int getNumCards() {
		return cards.size();
	}

	public Card[] deal(int numCards) {
		// make the array of removed objects that we will return
		Card[] removed = new Card[numCards];
		
		// set the removed item in cards to the new array
		for (int i=0; i<numCards; i++){
			removed[i] = cards.get(0);
			cards.remove(0);
		}
		return removed;
	}

	public void cut(int position) throws StarDeckException {
		if(position < 3 || position > 42) {
		 throw new StarDeckException("Too few cards in one part of the cut.");
		}
		else {
			// removes all elements at the front until position and
			// adds them to the end of the array
			for (int i=0; i<position; i++){
				Card first = new Card(cards.get(0).getValue(), 
						cards.get(0).getSuit());
				cards.remove(0);
				cards.add(first);
			}
		}
	}

	public void shuffle() {	
		int packet = cards.size()/5;
		int mod = cards.size()%5;
		int size = cards.size(); 
		// if evenly divisible by 5, set the mod equal to packet size
		if(mod == 0)
			mod = packet; 

		// size has to be more than 5
		if (!(size < 5)){
			// make 5 separate array lists, one for each packet
			ArrayList<Card> p1 = new ArrayList<Card>(packet);
			ArrayList<Card> p2 = new ArrayList<Card>(packet);
			ArrayList<Card> p3 = new ArrayList<Card>(packet);
			ArrayList<Card> p4 = new ArrayList<Card>(packet);
			ArrayList<Card> p5 = new ArrayList<Card>(mod);
			
			for(int i = 0; i< size; i++){
				// add all elements in the first packet to the p1 array list
				if(i<packet){
					p1.add(cards.get(i));
				} else if(i<packet*2){
					p2.add(cards.get(i));
				} else if(i<packet*3){
					p3.add(cards.get(i));
				} else if(i<packet*4){
					p4.add(cards.get(i));
				} else{
					p5.add(cards.get(i));
				}
			}
			// clear the cards list to add the new shuffled contents
			cards.clear();
			
			for(int j = 0 ; j<packet; j++){
				// add the first element in each array list
				// to cards starting with the 5th packet
				cards.add(p5.get(j));
				cards.add(p4.get(j));
				cards.add(p3.get(j));
				cards.add(p2.get(j));
				cards.add(p1.get(j));
			}
		}
	}
}
