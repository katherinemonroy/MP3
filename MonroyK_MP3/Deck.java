// Katherine Monroy
// 2368029
// kmonroy@chapman.edu
// CPSC 231-02
// MP3: Programming Mastery Project 3: Crazy Eights



// A new deck consists of all 52 cards in a LinkedList. It contains a method, deal, that
// removes a random card from the list and returns that card. (This can be achieved by
// generating a random number between 0 (inclusive) and the length of the list (exclusive)
// and removing/returning the card at that list position. This class should only have a
// default constructor, that populates the list with the 52 cards.

import java.util.LinkedList; // imported so that you can use a linked list in this file
import java.util.Random; // imported so that you can use random
import java.util.Collections; // imported so that you can shuffle thru
import java.util.*; // imported just in case ngl

public class Deck{
  //private member variables
  private LinkedList<Card> m_deck; //deck for the game
  private Card m_card; //card
  private final static Random rand = new Random(); // made this final bc it doesnt rly change
  private int m_dealer; //"dealer" to deal card
  private int m_deckLength; // length of deck * only in this class tho
  private Card m_deltCard; // the dealt card from the dealer
  private Card m_topCard; // topcard from the deck
  private int m_deckSize; // size of the deck

  //Deck Constructor
  public Deck(){
    m_deck = new LinkedList<Card>(); //makes deck
    for(int i = 0; i < 4; ++i){ // iterates thru each suit
      for(int j = 0; j < 13; ++j){ // iterates thru each value
        m_card = new Card(i,j); // makes new card in order
        m_deck.add(m_card); // adds card to deck
      }
    }
    Collections.shuffle(m_deck); // needs to be shuffled otherwise the top card will be the same almost 100% of the time
  }

  //method that gets the size of the deck
  public int deckSize(){
    m_deckSize = m_deck.size(); //gets size of the deck and returns the deck size
    return m_deckSize;
  }

  // deal method that returns the delt card from the deck
  public Card Deal(){
    m_deckLength = m_deck.size(); //gets the size of the deck
    m_dealer = rand.nextInt(m_deckLength); // gets random index based on size of Deck
    m_deltCard = m_deck.remove(m_dealer); // removes card and random index
    return m_deltCard;
  }
//method that gets the top card from the deck
  public Card getTopCard(){
    m_topCard = m_deck.getFirst(); //gets the first card from the deck and sets its to the top card and then returns it
    return m_topCard;
  }


}
