import java.util.ArrayList;
import java.util.Scanner;


class Human {
	
	ArrayList<Card> hand = new ArrayList <Card> ();
	Scanner input = new Scanner(System.in);
	String stand;
	int money = 200;
	
	//initialize human
	public Human()
	{
		
	}
	
	//adds card to hand
	public void addCard(Card c)
	{
		hand.add(c);
	}

	public int bet()
	{
		int d;
		
		System.out.println("How much would you like to bet?\t You have have $" + money);
		d = input.nextInt();
		while(d >= money || d < 0 )
		{
			System.out.println("You can not bet that amount");
			d = input.nextInt();
		}
		return d;			
	}
	
	public void addMoney(int k)
	{
		money += k;
	}
	
	//clears all cards out of the  hand
	public void newHand()
	{
		hand.clear();
	}
	
	//prints the hand
	public void printHand()
	{
		System.out.println(" _________\n|         |\n|" + hand.get(0).getRank().getShortName() + "       |\n" + hand.get(0).getSuit().getPic() + "\n|         |\n|_________|");
		System.out.println(" _________\n|         |\n|" + hand.get(1).getRank().getShortName() + "       |\n" + hand.get(1).getSuit().getPic() + "\n|         |\n|_________|");
		System.out.println(" _________\n|         |\n|" + hand.get(2).getRank().getShortName() + "       |\n" + hand.get(2).getSuit().getPic() + "\n|         |\n|_________|");
		System.out.println(  hand.get(0) +", "+ hand.get(1) +" and " + hand.get(2) +"\n\n");
	
	}
	
	//asks if they want to stand
	public boolean stand()
	{
		System.out.println("Would you like to bet or fold?");
		stand = input.nextLine();
		
		while( !((stand.toUpperCase().equals("BET")) || (stand.toUpperCase().equals("FOLD"))) )
		{
			System.out.println("Please enter \"bet\" or \"fold\" ");
			stand = input.nextLine();
		}
		
		if(stand.toUpperCase().equals("BET"))
			return true;
		else
			return false;
	}
	
	//gives value of hand -  flush, straight, triple, double, high card
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
		if(hand.get(0).getSuit().equals(hand.get(1).getSuit()))
		{
			
				//if three cards
			if((hand.size() == 3) && (hand.get(1).getSuit().equals(hand.get(2).getSuit())))
			{				
				return hand.get(2).getRank().getValue() + 500;
			}
				//if only two cards
			else if(hand.size() == 2)
			{
				return hand.get(2).getRank().getValue() + 500;
			}
				
		}		
		//straight
		else if((hand.get(0).getRank().getValue()+1 ==   hand.get(1).getRank().getValue()) && (hand.get(1).getRank().getValue()+1 == hand.get(2).getRank().getValue()))
			return 400 + hand.get(0).getRank().getValue();
		
		//triple
		else if((hand.get(0).getRank().getValue() ==   hand.get(1).getRank().getValue()) && (hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue()))
			return 300 + hand.get(1).getRank().getValue();
		
		//double
		else if((hand.get(0).getRank().getValue() !=   hand.get(1).getRank().getValue()) && (hand.get(1).getRank().getValue() == hand.get(2).getRank().getValue()) )
			return 200 + hand.get(2).getRank().getValue();
		else if((hand.get(0).getRank().getValue() ==   hand.get(1).getRank().getValue()) && (hand.get(1).getRank().getValue() != hand.get(2).getRank().getValue()))
			return 200 + hand.get(0).getRank().getValue();
		//high card
		return 100 + hand.get(2).getRank().getValue();
	}

	
	//compares the human hand to the computer's
	public int compareTo(Computer c)
	{
	  if(this.value() > c.value())     //person greater
		  return 100;
	  else if(this.value() < c.value()) //computer greater 
		  return -100;
	  else 								//draw
		  return 0;
				  
	}
	
	
	public static void main(String[] args) {

		Human q = new Human();
		q.addCard(new Card(Ranks.FIVE, Suits.CLUBS));
		q.addCard(new Card(Ranks.FOUR, Suits.DIAMONDS));
		q.addCard(new Card(Ranks.FIVE, Suits.CLUBS));
		q.printHand();
		System.out.println(q.value());
		q.newHand();
		q.addCard(new Card(Ranks.EIGHT, Suits.SPADES));
		q.addCard(new Card(Ranks.EIGHT, Suits.CLUBS));
		q.addCard(new Card(Ranks.ACE, Suits.CLUBS));
		q.printHand();
		System.out.println(q.value());
		q.newHand();
		q.addCard(new Card(Ranks.THREE, Suits.SPADES));
		q.addCard(new Card(Ranks.QUEEN, Suits.SPADES));
		q.addCard(new Card(Ranks.QUEEN, Suits.CLUBS));
		q.printHand();
		System.out.println(q.value());
		
	}
}