package DeckOfCards;

public class Card {
	
	private int number;
	private int suit;
	private Card next;
	
	public Card(int suit, int number){
		
		this.suit = suit;
		this.number = number;
		this.next = null;
	}
	
	public Card getNext(){	
		return this.next;
	}
	
	public void setNext(Card next){
		this.next = next;
	}
	
	public String toString(){
		
		String s = "suit";
		String n = Integer.toString(this.number);
			
		if(this.number > 10 || this.number == 1){
			switch(this.number){
			case 1: n = "Ace";
			break;
			case 11: n = "Jack";
			break;
			case 12: n = "Queen";
			break;
			case 13: n = "King";
			break;
			}
		}
		switch(this.suit){	
		case 0: s = "Spades";
		break;
		case 1: s = "Hearts";
		break;
		case 2: s = "Clubs";
		break;
		case 3: s = "Diamonds";
		break;
		}
		return n + " of " + s;
	}

}
