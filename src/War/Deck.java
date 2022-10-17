package War;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  protected List<Card>cards;
  final int TOPCARD = 0;
  
  /**
   * Populates cards List with 52 cards.
   */
  public Deck() {
      cards = new ArrayList<Card>();
      for(int cardName = 0; cardName<4;cardName++) {
          for(int cardValue = 2; cardValue<=14;cardValue++) {
              cards.add(new Card(cardName, cardValue));
          }
      }
  }
  
  public List<Card> getCards(){
      return cards;
  }
  
  /**
   * Shuffles cards.
   */
  public void shuffle() {
      Collections.shuffle(cards);
  }
  
  /**
   * Removes and returns the top card of the Cards field
   * @return
   */
  public Card draw() {
      Card drawnCard = cards.get(TOPCARD);
      cards.remove(TOPCARD);
      return drawnCard;
  }

}