package p6Coding;

import java.util.ArrayList;

public class HandEvaluatorPatrickjack {
	// Each of these is passed a reference to an ArrayList<Card> object
	// with "UNKNOWN" length (so you'll need to "ask" it).

	public static int eval(ArrayList<Card> hand){	
		int size = hand.size();
		int value = 0; 
		int five = 0;

		if (hand.size()== 2){
			//check to see if it's a patrick jack
			if ((hand.get(0).getValue() == 7 && hand.get(1).getValue() == 2) ||
					(hand.get(0).getValue() == 2 &&
					hand.get(1).getValue() == 7)){
				return 22;
			}
			//check to see if it's a margie jack
			else if((hand.get(0).getValue() == 6 && 
					hand.get(1).getValue() == 9) || 
					(hand.get(0).getValue() == 9 && 
					hand.get(1).getValue() == 6)){
				return 21;
			}	
		}
			//add the values of the hand array
			for (int i = 0; i< size; i++) {
				//if it is five mark it and save for later
				if (hand.get(i).getValue() == 5)
					five ++;
				else{
					//add all values that aren't five
					value += hand.get(i).getValue();
				}
			}
			//while there are fives, do this
			while (five > 0){
				//check to see how far you're away from 21
				int check = 21-value;

				//if you're farther than 15, add 15 to value. Else, add 5
				if(check >= 15){
					value += 15;
				}
				else{
					value += 5;
				}
				five--;
			}
			//if it goes over, make it 0
			if (value > 21){
				return 0;
			}
		return value; 
	}

		public static boolean houseWins(ArrayList<Card> player, ArrayList<Card> dealer) {
			int evalPlay = eval(player);
			int evalDeal = eval(dealer);

			// player wins if they're equal
			if (evalPlay == evalDeal) {
				return false;
			}
			return (evalPlay < evalDeal);
		}
	}
