// Katherine Monroy
// 2368029
// kmonroy@chapman.edu
// CPSC 231-02
// MP3: Programming Mastery Project 3: Crazy Eights


// A card consists of a value (2-10, J, Q, K, A) and a suit (hearts, spades, clubs,
// diamonds). Provide appropriate constructors as well as accessor methods. For
// example, you will want a constructor to create a card from a given suit and rank.


public class Card {

  private int m_suitIndex; // keeps track of index for suit array
  private int m_valueIndex;// keeps track of index for value array
  private String m_value; //(2-10)
  private String m_suit; //(hearts, spades, clubs, diamonds)
  //final since  i dont want these changed:
  private final static String[] suit = {"Hearts", "Spades","Clubs", "Diamonds"}; // all the suits
  private final static String[] value = {"Ace", "2", "3","4","5","6","7","8", "9","10", "Jack", "Queen", "King"}; // all the values

//default constructor for card class
  public Card(){
    m_suitIndex = 0; // initilize suit index to 0
    m_valueIndex = 0;// initilize value index to 0
    m_suit = suit[m_suitIndex]; //default is hearts ** this is so iterating thru lists is easy**
    m_value = suit [m_valueIndex]; // default is Ace
  }
//overloaded constructor :: paramaters: suitIndex, and valueIndex. sets the suit to the suit at suitIndex and same for value
  public Card(int suitIndex, int valueIndex){
   m_suit = suit[suitIndex];
   m_value = value[valueIndex];
  }

// this mightve been another way to make cards but for some reason it was hard to make into a deck so rip
  // public String Card(int numCard){ // this will end up being 52
  //
  //   String cardString = "";
  //   m_value = value[numCard/4];
  //   // int specialagain = numCard/4;
  //   // int special = (numCard/specialagain);
  //   m_suit = suit[numCard%4];
  //
  //   cardString = m_value + " of "+ m_suit;
  //   return cardString;
  // }


  //Getters (accesors)
  public String getValue(){
    return m_value;
  }

  public String getSuit(){
    return m_suit;
  }
//Setters (mutators)
  public void setSuit(String suit){
    m_suit = suit;
  }

}
