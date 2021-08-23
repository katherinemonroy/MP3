// Katherine Monroy
// 2368029
// kmonroy@chapman.edu
// CPSC 231-02
// MP3: Programming Mastery Project 3: Crazy Eights


// A game consists of two players, the stock, the starter pile, as well as other instance
// variables for keeping track of the statistics for each game. A method, play, carries out
// the rules of the game until one of the players has won. This class should have a default
// constructor and accessor methods, as well as well as any other methods you feel are
// appropriate.

import java.util.LinkedList; //imported so that you can use linked lists in this file
import java.util.Random; //imported in order to use random
import java.util.*; //imported just in case

public class Game{
  //member variables
  private Player m_player1; // player 1 of game
  private Player m_player2; // player 2 of game
  private Deck m_gameDeck; // game deck
  private LinkedList<Card> m_table; // acts as table
  private int m_P1Wins; //to keep track of p1 wins
  private int m_P2Wins; //to keep track of p2 wins
  private int m_P1Points; //to keep track of p1 points
  private int m_P2Points; //to keep track of p2 points
  private double m_looserCards; //to keep track of looser cards
  private int m_countEmpties; //to keep track of empty stocks
  private double m_eightsPlayed; //to keep track of total eights played
  private int m_draws; //to keep track of draws
  private Card m_startingCard;  //starting card
  private int m_tipoff; // tip off of who gets to go first in a game
  private Card m_playedCard; // played card
  private int m_gameDeckSize; // size of the game deck
  private int m_P1Hand; // player 1 hand
  private int m_P2Hand; // player 2 hand
  private boolean m_runGame; // boolean that runs a game
  private final static Random rand = new Random(); //so that random can be used

  //default constructor
  public Game(){
    m_player1 = new Player(); //makes player 1 for the game
    m_player2 = new Player(); //makes player 2 for the game
    m_gameDeck = null;
    m_table = null;
  }

  //overloaded constructor
  public Game(Player player1, Player player2, Deck gameDeck,  LinkedList<Card> table){
    m_player1 = player1; //sets player 1
    m_player2 = player2; //sets player 2
    m_gameDeck = gameDeck; //sets gameDeck after each player has a hand
    m_table = table; //sets table to be played on - should be blank
    m_tipoff = rand.nextInt(10); //simulates a 50/50 tip off to decide which player goes first
    m_startingCard = m_gameDeck.Deal(); //deals starting card
    m_table.addFirst(m_startingCard); //adds starting card to the table
  }

  // GETTERS for all the stats: accessors
  public int getP1Wins(){ // gets the p1 wins
    return m_P1Wins;
  }

  public int getP2Wins(){ // gets the p2 wins
    return m_P2Wins;
  }

  public int getDraws(){ // gets the num draws
    return m_draws;
  }

  public int getP1Points(){ // gets the p1 points
    return m_P1Points;
  }

  public int getP2Points(){ // gets the p2 points
    return m_P2Points;
  }

  public double getLoosercards(){ // gets the looser cards
    return m_looserCards;
  }

  public int getEmpties(){ // gets the empty stocks
    return m_countEmpties;
  }

  public double getCrazies(){ // gets the crazy eights played
    return m_eightsPlayed;
  }

  //method play -- will continue to run unless it reaches a break/win
  public void Play(){
    //initialize the member variables for stats
    m_P1Wins = 0;
    m_P2Wins = 0;
    m_P1Points = 0;
    m_P2Points = 0;
    m_looserCards = 0;
    m_eightsPlayed = 0;
    m_countEmpties = 0;
    m_runGame = true; //runs a game till the game is over (reaches a break statement)

    while(m_runGame == true){ //starts to run the game
      if(m_tipoff < 5){ // if the tipoff is randomly under 5 then player 1 goes first
        m_startingCard = m_table.getFirst(); //checks to see what the top card is on the table
        m_playedCard = m_player1.takeTurn(m_startingCard, m_gameDeck); //P1 takes turn
        m_gameDeckSize = m_gameDeck.deckSize(); //checks deck size to see if its empty
        if(m_gameDeckSize == 0 || m_playedCard == null){
          m_countEmpties +=1; // adds to the count of empties
          break; // consitutes as a win
        }
        if(m_playedCard.getValue() == "8"){ //checks if card placed on table is an 8
          m_eightsPlayed +=1; // adds to the 8's played
        }
        m_table.addFirst(m_playedCard); //adds card to table
        m_P1Hand = m_player1.getplayerHand().size(); //checks P1 hand size
        if(m_P1Hand == 0){
          break;// consitutes as a win
        }

        m_startingCard = m_table.getFirst(); //checks to see what the top card is on the table
        m_playedCard = m_player2.takeTurn(m_startingCard, m_gameDeck); //player 2 takes turn
        m_gameDeckSize = m_gameDeck.deckSize();//checks deck size to see if its empty
        if(m_gameDeckSize == 0 || m_playedCard == null){
          m_countEmpties +=1; // adds to the count of empties
          break;// consitutes as a win
        }
        if(m_playedCard.getValue() == "8"){ //checks if card placed on table is an 8
          m_eightsPlayed +=1;// adds to the 8's played
        }
        m_table.addFirst(m_playedCard); //adds card to table
        m_P2Hand = m_player2.getplayerHand().size(); //checks P2 hand size
        if(m_P2Hand == 0){
          break;// consitutes as a win
        }
      }


      else{// if the tipoff is not under 5 then player 2 goes first
        m_startingCard = m_table.getFirst(); //checks to see what the top card is on the table
        m_playedCard = m_player2.takeTurn(m_startingCard, m_gameDeck); //player 2 takes turn
        m_gameDeckSize = m_gameDeck.deckSize(); //checks deck size to see if its empty
        if(m_gameDeckSize == 0 || m_playedCard == null){
          m_countEmpties +=1; // adds to the count of empties
          break;// consitutes as a win
        }
        if(m_playedCard.getValue() == "8"){ //checks if card placed on table is an 8
          m_eightsPlayed +=1;// adds to the 8's played
        }
        m_table.addFirst(m_playedCard); //adds card to table
        m_P2Hand = m_player2.getplayerHand().size();  //checks P2 hand size
        if(m_P2Hand == 0){
          break;// consitutes as a win
        }

        m_startingCard = m_table.getFirst(); //checks to see what the top card is on the table
        m_playedCard = m_player1.takeTurn(m_startingCard, m_gameDeck); //player 1 takes turn
        m_gameDeckSize = m_gameDeck.deckSize(); // checks deck size to see if empty
        if(m_gameDeckSize == 0 || m_playedCard == null){
          m_countEmpties +=1; // adds to the count of empties
          break;// consitutes as a win
        }
        if(m_playedCard.getValue() == "8"){ //checks if card placed on table is an 8
          m_eightsPlayed +=1;// adds to the 8's played
        }
        m_table.addFirst(m_playedCard); //adds card to table
        m_P1Hand = m_player1.getplayerHand().size(); //checks P1 hand size
        if(m_P1Hand == 0){
          break;// consitutes as a win
        }
      }
    }

    //all the ways a player could win and adds up the stats
    if(m_player1.getplayerHand().size() == 0){
      m_P1Wins +=1;
    }
    else if(m_player2.getplayerHand().size() == 0){
      m_P2Wins +=1;
    }
    else if(m_player1.getplayerHand().size() < m_player2.getplayerHand().size()){
      m_P1Wins +=1;
    }
    else if(m_player2.getplayerHand().size() < m_player1.getplayerHand().size()){
      m_P2Wins +=1;
    }
    else{
      m_draws +=1; // if it isnt a win then its a draw
    }
    //calculates the points won by player 1
    if(m_draws == 0){
      if(m_P1Wins > m_P2Wins){
        //for each loop makes it easy to iterate through the hand
        for(Card hand : m_player2.getplayerHand()){
          m_looserCards +=1; //adds all of the looser's cards in their hand as points
          if(hand.getValue() == "8"){ // if its an 8 its worth 50 points
            m_P1Points += 50;
          }
          else if(hand.getValue() == "King" || hand.getValue() == "Queen" || hand.getValue() == "Jack" || hand.getValue() == "10"){ // if its a royalty card then its worth 10 points
            m_P1Points += 10;
          }
          else if(hand.getValue() == "Ace"){ // if its an ace then its only worth 1 point
            m_P1Points += 1;
          }
          else{
            m_P1Points += Integer.parseInt(hand.getValue()); //converts the String into an Int
          }

        }
      }

      //calculates the points won by player 2
      else{
        //for each loop makes it easy to iterate through the hand
        for(Card hand : m_player1.getplayerHand()){
          m_looserCards +=1; //adds all of the looser's cards in their hand as points
          if(hand.getValue() == "8"){// if its an 8 its worth 50 points
            m_P2Points += 50;
          }
          else if(hand.getValue() == "King" || hand.getValue() == "Queen" || hand.getValue() == "Jack" || hand.getValue() == "10"){ // if its a royalty card then its worth 10 points
            m_P2Points += 10;
          }
          else if(hand.getValue() == "Ace"){// if its an ace then its only worth 1 point
            m_P2Points += 1;
          }
          else{
            m_P2Points += Integer.parseInt(hand.getValue()); //converts the String into an Int
          }
        }
      }
    }
  }


}
