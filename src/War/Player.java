package War;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private List<Card>hand;
  private int score;
  private String name;
  final int TOPCARD = 0;
  
  public Player(String name) {
      hand = new ArrayList<Card>();
      setScore(0);
      setName(name);
  }

  public int getScore() {
      return score;
  }

  public void setScore(int score) {
      this.score = score;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }
  
  /**
   * Prints out player name
   */
  public void describe() {
      System.out.println("Player Name: "+getName());
  }
  
  /**
   * Removes and returns top card of the Hand .
   * @return
   */
  public Card flip() {
      Card cardFlipped = hand.get(TOPCARD);
      hand.remove(TOPCARD);
      return cardFlipped;
  }
  
  /**
   * Calls the draw method on the deck, adding the returned Card to the hand.
   * @param deck
   */
  public void draw(Deck deck) {
      for(int index = 1; index<=26;index++) {
          Card card = deck.draw();
          hand.add(card);
      }
  }
  
  /**
   * Adds 1 to the Player's score field
   */
  public void adjustScore() {
      score++;
  }
}