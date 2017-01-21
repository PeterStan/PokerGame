import java.util.ArrayList;

public class Computer {

	private ArrayList <Card>  hand = new ArrayList<Card>();	
	
	//initializes computer
	public Computer ()
	{
		
	}
	
	
	//adds card to computers hand
	public void addCard(Card c)
	{
		hand.add(c);	
	}
	
	//if computer should bet
	public boolean compBet(int b)
	{
		if( b < ((Math.random()*20)+30))
			return false;
		return true;
	}
	
	//clears all cards out of the computers hand
	public void newHand()
	{
		hand.clear();
	}
	
	//prints the hand
	public void printHand()
	{
		System.out.println("\n\n" + hand.get(0) +", "+ hand.get(1) +" and " + hand.get(2) + " " + this.value());
		System.out.println(" _________\n|         |\n|" + hand.get(0).getRank().getShortName() + "       |\n" + hand.get(0).getSuit().getPic() + "\n|         |\n|_________|");
		System.out.println(" _________\n|         |\n|" + hand.get(1).getRank().getShortName() + "       |\n" + hand.get(1).getSuit().getPic() + "\n|         |\n|_________|");
		System.out.println(" _________\n|         |\n|" + hand.get(2).getRank().getShortName() + "       |\n" + hand.get(2).getSuit().getPic() + "\n|         |\n|_________|\n\n");
		
	
	}
	
	//decides if computer should fold
	public boolean stand()
	{
		if(this.value() >= 300)
			return true;
		else if(this.value() >= 200)
			if((this.value() > (int)((Math.random()*5)+200)))
			{
				return true;
			}
			else
				return false;
		else 
			if((this.value() > (int)((Math.random()*5)+100)))
			{
				return true;
			}
			else
				return false;
	}
	
	//gives value of hand - flush, straight, triple, double, high card
	public int value() 
	{
		//sort
				boolean swapped = false;
				do{
					swapped = false;
					
					for(int i = 0; i < (hand.size() - 1); i++){
						if(hand.get(i).getRank().getValue() > hand.get(i+1).getRank().getValue()){
							
							Card temp = (hand.get(i + 1));
							hand.set(i + 1, hand.get(i));
							hand.set(i,temp);
							swapped = true;
						}
					}
					
				}while (swapped == true);
		//flush
		if((hand.get(0).getSuit().equals(hand.get(1).getSuit())) && ((hand.get(1).getSuit().equals(hand.get(2).getSuit())))){
			return hand.get(2).getRank().getValue() + 500;	
		}
		//straight
		else if((hand.get(0).getRank().getValue()+1 ==   hand.get(1).getRank().getValue()) && (hand.get(1).getRank().getValue()+1 == hand.get(2).getRank().getValue())){
			return 400 + hand.get(0).getRank().getValue();
			}
		//triple
		else if((hand.get(0).getRank().getValue() ==   hand.get(1).getRank().getValue()) && (hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue())){
			return 300 + hand.get(0).getRank().getValue();
			}
		//double
		else if( (hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue()) ){
			return 200 + hand.get(2).getRank().getValue();
			}
		else if((hand.get(0).getRank().getValue() ==   hand.get(1).getRank().getValue()) && (hand.get(1).getRank().getValue() != hand.get(2).getRank().getValue())){
			return 200 + hand.get(0).getRank().getValue();
			}
		//high card
		return 100 + hand.get(2).getRank().getValue();
	}
	
	public static void main(String[] args) {
		
		Computer q = new Computer();
		q.addCard(new Card(Ranks.DEUCE, Suits.DIAMONDS));
		q.addCard(new Card(Ranks.THREE, Suits.DIAMONDS));
		q.addCard(new Card(Ranks.THREE, Suits.CLUBS));
		q.printHand();
		System.out.println(q.value() +" " + q.stand());
		q.newHand();
		q.addCard(new Card(Ranks.FIVE, Suits.CLUBS));
		q.addCard(new Card(Ranks.QUEEN, Suits.CLUBS));
		q.addCard(new Card(Ranks.KING, Suits.HEARTS));
		q.printHand();
		System.out.println(q.value() +" " + q.stand());
		q.newHand();
		q.addCard(new Card(Ranks.THREE, Suits.SPADES));
		q.addCard(new Card(Ranks.QUEEN, Suits.CLUBS));
		q.addCard(new Card(Ranks.QUEEN, Suits.SPADES));
		q.printHand();
		System.out.println(q.value() +" " + q.stand());
	}

}
