package War;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  
  static Scanner scan = new Scanner(System.in);

/**
* Gathers list for players
* @param scan - The user input
* @return Players for the game 
*/ 
  public static List<Player>getPlayers(Scanner scan){
      List<Player>players = new ArrayList<Player>(2);
      for(int index = 0;index<2;index++) {
          System.out.printf("Enter Player %d name: ", index+1);
          String name = scan.nextLine();
          if((name == null)||(name.isEmpty())) {
              name = String.format("Player %d", index+1);
          }
          Player player = new Player(name);
          players.add(player);
      }
      return players;
  }

  public static void main(String[]args) {
      List<Player>players = getPlayers(scan);
      Player player1 = players.get(0);
      Player player2 = players.get(1);
      Deck deck = new Deck();
      deck.shuffle();
      player1.draw(deck);
      player2.draw(deck);
      
      //Plays 26 rounds of War with both players
      for(int counter = 0; counter<26;counter++) { 
          Card player1Card = player1.flip();
          Card player2Card = player2.flip();
          
          if(player1Card.getValue()>player2Card.getValue()) {
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              System.out.println("Player 1 Card: "+ player1Card.describe());
              System.out.println("Player 2 Card: "+ player2Card.describe());
              System.out.println("Player 1 gets a point");
              player1.adjustScore();
              System.out.println("Player 1 Score: "+player1.getScore());
              System.out.println("Player 2 Score: "+player2.getScore());
          }
          else if(player1Card.getValue()<player2Card.getValue()) {
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              System.out.println("Player 1 Card: "+ player1Card.describe());
              System.out.println("Player 2 Card: "+ player2Card.describe());
              System.out.println("Player 2 gets a point");
              player2.adjustScore();
              System.out.println("Player 1 Score: "+player1.getScore());
              System.out.println("Player 2 Score: "+player2.getScore());
          }
          else {
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              System.out.println("Player 1 Card: "+ player1Card.describe());
              System.out.println("Player 2 Card: "+ player2Card.describe());
              System.out.println("Tie. No points awarded");
              System.out.println("Player 1 Score: "+player1.getScore());
              System.out.println("Player 2 Score: "+player2.getScore());
          }
      }
      
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("Player 1 Score: "+player1.getScore());
      System.out.println("Player 2 Score: "+player2.getScore());
      
      if(player1.getScore()>player2.getScore()) {
          System.out.println("Player 1 is the winner!");
      }
      else if(player1.getScore()<player2.getScore()) {
          System.out.println("Player 2 is the winner!");
      }
      else {
          System.out.println("Tie!");
      }
  } 
}