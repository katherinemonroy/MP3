// Katherine Monroy
// 2368029
// kmonroy@chapman.edu
// CPSC 231-02
// MP3: Programming Mastery Project 3: Crazy Eights



// This class contains a constructor that takes the number of games to simulate as well as
// a function, simulate, that plays the specified number of games. A method, calculate,
// computes the aggregate statistics from all games, which will require you to define the
// appropriate class member variables to keep track of the results of each game. Another
// method, report, prints the required statistics to the screen in a nicely-formatted manner.
// The main method for running your Crazy Eights program is contained in this class.

import java.util.LinkedList; //imported so that linked lists can be used in this file
import java.util.*; // imported just in case

public class Simulation {

  // these are all the stats that need to be displayed once the simulation runs
  private double numGames;
  private int total_p1Dubs = 0;
  private int total_p2Dubs = 0;
  private int total_Draws = 0;
  private int total_p1Points = 0;
  private int total_p2Points = 0;
  private int total_empties = 0;
  private double total_loosercards;
  private int total_crazyeights = 0;
  private Game Crazy;

  public void Simulate(Player player1, Player player2, Deck gameDeck, LinkedList<Card> gameTable ){
    numGames +=1;
    Crazy = new Game(player1, player2, gameDeck,gameTable); // initilizes a game
    Crazy.Play();
    calculate(Crazy);

  }
  //
  private void calculate(Game crazy){ // this is where all the stats get added up
    total_p1Dubs+= Crazy.getP1Wins(); // just keeps adding the num of wins P1 has ( for the total numGames)
    total_p2Dubs+= Crazy.getP2Wins(); // just keeps adding the num of wins P2 has ( for the total numGames)
    total_Draws+= Crazy.getDraws(); //just keeps adding the num of Draws ( for the total numGames)
    total_p1Points += Crazy.getP1Points(); // just keeps adding num of points for P1( for the total numGames) ** points are the number of cards left in the opposite players hand i believe
    total_p2Points+= Crazy.getP2Points(); // just keeps adding num of points for P2 ( for the total numGames) ** points are the number of cards left in the opposite players hand i believe
    total_empties += Crazy.getEmpties(); // just keeps addding the number of empty stocks for the total numGames played
    total_loosercards += Crazy.getLoosercards(); // adds the total number of cards that the looser ends up with ( ie. looser still has 5 cards left so thus 5 looser points)
    total_crazyeights += Crazy.getCrazies(); // adds the total number of eights played for the total numGames

  }


    public String report(){ // this prints out all the stats for the total number of games in a beautiful way
      String ret = "";
      ret+= " ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ⓒ ⓡ ⓐ ⓩ ⓨ ⓔ ⓘ ⓖ ⓗ ⓣ ⓢ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ "+"\n";
      ret +=" ╭━ ⋅𖥔⋅ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━✶━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ⋅𖥔⋅ ━╮"+"\n";
      ret += "   Games played♤ "+ numGames+"\n";
      ret += "   Player 1 wins♡ "+ total_p1Dubs+"\n";
      ret += "   Player 2 wins♥ "+ total_p2Dubs+"\n";
      ret += "   Games w/ no wins☛ "+ total_Draws+"\n";
      ret += "   Player 1 points➯ "+ total_p1Points+"\n";
      ret += "   Player 2 points➱ "+ total_p2Points+"\n";
      ret += "   Total empty stocks➜ "+ total_empties+"\n";
      ret += "   Avg number of cards in loosers hand➜ "+ (total_loosercards/numGames)+"\n"; // gets avg number of cards in loosers hands as an int
      ret += "   Avg of Crazy 8's played➜ "+ (total_crazyeights/numGames)+"\n";// gets avg num of eights played as an int
      ret+= " ╰━ ⋅𖥔⋅ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━✶━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ⋅𖥔⋅ ━╯"+"\n";
      return ret;

      }

  public static void main(String[] args){ //main for the entire project
    Simulation CrazyEights = new Simulation(); //initializes a game
    int n = Integer.parseInt(args[0]); // takes in number directly from the command line * from a string into an int
    for(int i = 0; i < n ; ++i){ // runs a game n number of times
      Deck gameDeck = new Deck(); // makes a deck for the game
      Player player1 = new Player(1, gameDeck); // makes the first player
      Player player2 = new Player(2, gameDeck);// makes the second player
      LinkedList<Card> gameTable = new LinkedList<Card>(); //sets the game table
      CrazyEights.Simulate(player1, player2, gameDeck, gameTable); //simulates a game
    }
    System.out.println(CrazyEights.report()); //prints out all the calculations the unpaid stats student did after all the crazy eights games played out
    }
  }
