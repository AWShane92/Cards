package DeckOfCards;

import java.util.*;
import java.io.*;

public class Deck {

	private Card top;
	private int size;
	
	
	public int getSize(){
		return this.size;
	}
	public boolean isEmpty(){
		
		return this.top == null;
	}
	public void add(Card card){
		
		if(card == null){
			System.out.println("There's no card bruh");
			return;
		}
		else if(this.top == null){
			this.top = card;		
		}else{
			card.setNext(this.top);
			this.top = card;	
		}	
	}
	
	public Card draw(){
		
		if(this.top == null){
			System.out.println("There's no card bruh");
			return null;
		}
		else{	
		Card temp = this.top;
		this.top = temp.getNext();
		temp.setNext(null);
		return temp;
		}
				
	}
	public void buildDeck(){
		
		for(int i = 0; i < 4; i++){
			for(int j = 1; j < 14;j++){
				this.add(new Card(i,j));
				size++;
			}
		}
	}
	public void shuffle(){
		
		Card [] tempDeck = new Card[this.size];
		Random rand = new Random();
		
		for(int i = 0; i < tempDeck.length;i++){
			tempDeck[i] = null;
		}
		while(!this.isEmpty()){
			
			 int index = rand.nextInt(52);
			 
		      if (tempDeck[index] == null){
		        tempDeck[index] = this.draw();
		      }
		      else {
		        while (tempDeck[index] != null) {
		          index++;
		          if (index > 51){
		        	  index = 0;
		          }
		        }
		        tempDeck[index] = this.draw();
		      }
		}
		for (int i = 0; i < tempDeck.length; i++) {
		      if (tempDeck[i] != null)
		        this.add(tempDeck[i]);
		}
		
	}
	public void printDeck(){
		Card temp = this.top;
		
		while(temp != null){
			System.out.println(temp.toString());
			temp = temp.getNext();
		}
		
	}
	
	public static void main(String[]args){
		
		Deck deck = new Deck();
		Scanner handSize = new Scanner(System.in);
		Card [] myHand = new Card[handSize.nextInt()];
		
		
		deck.buildDeck();
		deck.shuffle();
		//deck.printDeck();
		
		System.out.println("I DRAW!!!");	
		for(int i = 0; i < myHand.length; i++){
			myHand[i] = deck.draw();
		}
		System.out.println("My hand is...");
		System.out.println(" ");
		for(int i = 0; i < myHand.length; i ++)
			System.out.println(myHand[i].toString());
	}
}
