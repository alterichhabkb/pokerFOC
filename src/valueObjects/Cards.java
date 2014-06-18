package valueObjects;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;



public enum Cards {
	
	//herz
	ace_hearts(new Card("Ace", "hearts", 14), ""),
	Two_hearts(new Card("2", "hearts", 2), ""),
	three_hearts(new Card("3", "hearts", 3), ""),
	four_hearts(new Card("4", "hearts", 4), ""),
	five_hearts(new Card("5", "hearts", 5), ""),
	six_hearts(new Card("6", "hearts", 6), ""),
	seven_hearts(new Card("7", "hearts", 7), ""),
	eight_hearts(new Card("8", "hearts", 8), ""),
	nine_hearts(new Card("9", "hearts", 9), ""),
	ten_hearts(new Card("10", "hearts", 10), ""),
	jack_hearts(new Card("Jack", "hearts", 11), ""),
	queen_hearts(new Card("Queen", "hearts", 12), ""),
	king_hearts(new Card("King", "hearts", 13), ""),
	
	//Pik
	ace_spades(new Card("Ace", "spades", 14), ""),
	two_spades(new Card("2", "spades", 2), ""),
	three_spades(new Card("3", "spades", 3), ""),
	four_spades(new Card("4", "spades", 4), ""),
	five_spades(new Card("5", "spades", 5), ""),
	six_spades(new Card("6", "spades", 6), ""),
	seven_spades(new Card("7", "spades", 7), ""),
	eight_spades(new Card("8", "spades", 8), ""),
	nine_spades(new Card("9", "spades", 8), ""),
	ten_spades(new Card("10", "spades", 10), ""),
	jack_spades(new Card("Jack", "spades", 11), ""),
	queen_spades(new Card("Queen", "spades", 12), ""),
	king_spades(new Card("King", "spades", 13), ""),
	
	//Karo
	ace_diamond(new Card("14", "diamonds", 14), ""),
	two_diamond(new Card("2", "diamonds", 2), ""),
	three_diamond(new Card("3", "diamonds", 3), ""),
	four_diamond(new Card("4", "diamonds", 4), ""),
	five_diamond(new Card("5", "diamonds", 5), ""),
	six_diamond(new Card("6", "diamonds", 6), ""),
	seven_diamond(new Card("7", "diamonds", 7), ""),
	eight_diamond(new Card("8", "diamonds", 8), ""),
	nine_diamond(new Card("9", "diamonds", 9), ""),
	ten_diamond(new Card("10", "diamonds", 10), ""),
	jack_diamond(new Card("Jack", "diamonds", 11), ""),
	queen_diamond(new Card("Queen", "diamonds", 12), ""),
	king_diamond(new Card("King", "diamonds", 13), ""),
	
	//Kreuz
	ace_clubs(new Card("14", "clubs", 14), ""),
	two_clubs(new Card("2", "clubs", 2), ""),
	three_clubs(new Card("3", "clubs", 3), ""),
	four_clubs(new Card("4", "clubs", 4), ""),
	five_clubs(new Card("5", "clubs", 5), ""),
	six_clubs(new Card("6", "clubs", 6), ""),
	seven_clubs(new Card("7", "clubs", 7), ""),
	eight_clubs(new Card("8", "clubs", 8), ""),
	nine_clubs(new Card("9", "clubs", 9), ""),
	ten_clubs(new Card("10", "clubs", 10), ""),
	jack_clubs(new Card("Jack", "clubs", 11), ""),
	queen_clubs(new Card("Queen", "clubs", 12), ""),
	king_clubs(new Card("King", "clubs", 13), "");
	
	
	private Card card;
	private String image;
	
	private final static Stack<Cards> cardsDeck = new Stack<Cards>();
	private final static ArrayList<Cards> cardsArrayList = new ArrayList<Cards>();
	private final static Cards[] cardsArray = Cards.values();
	
	private Cards(Card card, String image){
		this.image = image;
		this.card = card;
	}
	
	public Card getCard() {
		return card;
	}

	public String getImage() {
		return image;
	}
	
	//Method to create a Card Deck (implements in a Stack)
	public static void createDeck(){
		//from Array to Arraylist
		for(int i =0; i< cardsArray.length; i++){
			cardsArrayList.add(cardsArray[i]);
		}
				
		//shuffle cards
		Collections.shuffle(cardsArrayList);
		
		// shuffeld cards push to Stack
		for(int i=0; i< cardsArrayList.size(); i++){
			cardsDeck.push(cardsArrayList.get(i));
		}
	}
	
	//Method to get a random Card from CardsDeck(Satck)
	public static Cards getKarte(){
		Cards oneCard = null; 
		
		//check if cardsdeck is empty false => pop a Card from Stack
		if(! (cardsDeck.isEmpty())){
			oneCard = cardsDeck.pop();
			System.out.println("Cards in Deck: " + cardsDeck.size());	
		}
		//if cardsDeck is empty create a new one && if cardsdeck is empty false => pop a Card from Stack
		else if(cardsDeck.isEmpty()){
			System.out.println("Stack(cardsDeck) is empty try to create a new one");
			System.out.println("\n");
			Cards.createDeck();
			if(! (cardsDeck.isEmpty())){
				System.out.println("Stack(cardsDeck) is now available");
				System.out.println("\n");
				oneCard = cardsDeck.pop();
			//Error no Card in stack
			}else{
				System.err.println("ERROR in Cards.cardsDeck (Stack ist empty)");
				System.out.println("\n");
			}
		}
		return oneCard;
	}
	
	
}

	
