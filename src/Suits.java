/*
 * Suits.java
 *
 * Version:
 * $Id$
 *
 * Revisions:
 * $Log$
 */

/**
 * An enum representing the suits in a normal poker deck
 *
 * @author paw: AUTHOR_FULL_NAME_HERE
 */

public enum Suits { 
	CLUBS ( 'C' , "|      _  |\n|     ( ) |\n|    (_Y_)|\n|      |  |"), 
	DIAMONDS ( 'D',  "|     A   |\n|    / \\  |\n|    \\ /  |\n|     V   |") , 
	HEARTS ( 'H' , "|    _ _  |\n|   ( V ) |\n|    \\ /  |\n|     V   |"),
	SPADES ( 'S', "|     /\\  |\n|    (  ) |\n|     )(  |" );

   /**
    * a constant for the total number of suits
    */
    public static final int NUM_SUITS = 4;
    private final char shortName;
    private final String pic;

   /**
    * initialize the suit enums, 
    *
    * @param    n       short name for the suit
    */
    Suits( char n, String p ){
	shortName = n;
	pic = p;
    }

   /**
    * accessor for the name
    *
    * @return   a char with the short name for this suit
    */
    public char getShortName(){
	return shortName;
    }
    
    public String getPic()
    {
    	return pic;
    }
}
