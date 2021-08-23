// Katherine Monroy
// 2368029
// kmonroy@chapman.edu
// CPSC 231-02
// MP3: Programming Mastery Project 3: Crazy Eights

// // A player consists of a number (1 or 2) and a LinkedList of owned cards. At the start of
// // the game each player holds 5 unique cards dealt from the deck/stock. A method,
// // takeTurn, removes and returns a playable card from this list, adding to the list from the
// // stock as needed. If the player must pass the turn, this method should return null. If the
// // method returns an Eight, then another method newSuit() is called which returns the new
// // suit to start using. The player class should contain the appropriate constructors and
// // other helper methods as required. For example, you will want a constructor that takes a
// // player id and LinkedList containing the 5 initial cards to add to their owned cards.
//
//
import java.util.LinkedList; // since i am using a linked list in this class
import java.util.Random; // since i need a random number
import java.util.*; //imported just incase

public class Player{

  private int m_playerNum; // 1 or 2
  private LinkedList<Card> m_playerHand; //players hand
  private Card m_deltCard; // the delt card
  private int m_deckSize; // deck size
  private Card m_playedCard;//played card when suitable
  private String m_randSuit; //random suit
  private int m_randSuitIndex; //index if the random suit
  private final static String[] suit = {"Diamonds" , "Hearts" , "Spades" , "Clubs"}; // final since i dont want these to be altered
  private final static Random rand = new Random(); //final since it doesnt change
  private int m_instanceEight; //instance of an 8
  private int m_randomEight; // random 8
  private int m_eightIndex; //index of eight
  private int m_suitableCards; //suitable card



  //default Constructor
  public Player(){
    m_playerNum = 0; // 1 or 2
  }

  //overloaded Constructor takes playernum and makes a deck for each player
  public Player(int playerNum, Deck gameDeck){
    m_playerNum = playerNum; //1 or 2
    m_playerHand = new LinkedList<Card>(); //makes the player hand
    for(int i = 0; i < 5; ++i){ // a hand is the size of 5 cards
      m_deltCard = gameDeck.Deal(); //fills the hand with delt cards
      m_playerHand.add(m_deltCard); // adds the delt card to the hand
    }
  }

  //GETTER (accesor) for player Num
  public int getplayerNum(){
    return m_playerNum; //returns 1 or 2
  }

  //player deck accessor
  public LinkedList<Card> getplayerHand(){
    return m_playerHand;
  }


  //method for newSuit
  public void newSuit(Card eight){ // takes in eight card as a parameter
    m_randSuitIndex = rand.nextInt(4); //randomly chooses index
    m_randSuit = suit[m_randSuitIndex]; //chooses new suit
    eight.setSuit(m_randSuit); //sets the above card to a new suit
  }

  public Card takeTurn(Card topCard, Deck gameDeck){
    m_instanceEight = 0; // checks if there is an instance of an eight
    m_suitableCards = 0; //counts the suitable cards
    m_deckSize = m_playerHand.size(); //gets size of player's deck
    m_randomEight = rand.nextInt(10); //the 10% counter

    // while there are no suitable cards or 8s check and grab from deck in order to take a turn
    while(m_suitableCards == 0 || m_instanceEight == 0){
      //for each loops make it easy to iterate through linked lists
    for(Card hand : m_playerHand){// classify each card as suitable or an 8
      if(hand.getValue() == "8"){ // if the player has an eight
        m_instanceEight += 1; //keep track of the 8
        m_eightIndex = m_playerHand.indexOf(hand); //and keep the eights index
      }

      if(hand.getValue() == topCard.getValue() || hand.getSuit() == topCard.getSuit()){ //checks to see if the top card value is the same as hand value
        if(hand.getValue() != "8"){ //if the card isn't an 8; track it as suitable
          m_suitableCards += 1; //add for all playable cards
          }
      }
      }

      //probability of playing a crazy 8 if there are other suitable cards to play
      if(m_instanceEight > 0 && m_suitableCards > 0 && m_randomEight == 7){
        m_playedCard = m_playerHand.remove(m_eightIndex); //removes the 8 card at that index
        newSuit(m_playedCard); //changes suit of the 8 card
        return m_playedCard; // returns the played card
        }


      // if player has an eight and has no suitable cards
      if(m_instanceEight > 0 && m_suitableCards == 0){
        m_playedCard = m_playerHand.remove(m_eightIndex);
        newSuit(m_playedCard); //changes suit of the 8 card
        return m_playedCard; // returns the played card
        }


      // for each loop continues if above if statements are not met and puts down a suitable card
      for(Card hand : m_playerHand){
      if(hand.getValue() == topCard.getValue() || hand.getSuit() == topCard.getSuit() ){
        m_playedCard = hand; //stores played Card as long as it doesn't get chosen to be an 8
        m_playerHand.remove(m_playedCard); //removes from the hand
        if(m_playedCard.getValue() == "8"){ //if the played card is 8
          newSuit(m_playedCard); //sets new suit of 8 randomly
        }
        return m_playedCard; //returns played card
      }
    }
    if (gameDeck.deckSize()==0){ // if decksize is zero then it returns null
      return null;
    }
      if(m_suitableCards == 0 && m_instanceEight == 0){ // if there are no suitable cards or 8s get dealed another card
        m_deltCard = gameDeck.Deal();
        m_playerHand.add(m_deltCard);
      }
  }
      return null; //returns null if there are no moves to do
  }


}
