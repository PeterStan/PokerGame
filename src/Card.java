
public class Card {
	
	private Ranks rank;
	private Suits suit;
	
	//initializes new card
	public Card (Ranks r, Suits s)
	{
		this.rank = r;
		this.suit = s;
	}
	
	//Returns the rank
	public Ranks getRank()
	{
		return rank;		
	}
	
	//returns a short name for the card
	public String getShortName()
	{
		return rank.getShortName() + suit.getShortName();
	}
	
	//returns the Suit
	public Suits getSuit()
	{
		return suit;
	}
		
	//toString
	public String toString()
	{
		return rank + " of " + suit;
		 
	}
	
	//returns the value
	public int value()
	{
	return rank.getValue();	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Card f = new Card(Ranks.THREE, Suits.CLUBS);
		System.out.println( f.getRank() +" "+ f.value() + f.getShortName() +" "+ f);
		
		
	}

}
