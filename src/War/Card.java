package War;

import java.util.HashMap;
import java.util.Map;

public class Card {
  private Map<Integer, String>cardValue;
  private Map<Integer, String>cardName;
  private int value;
  private int name;
  
  public Card(int name, int value) {
      this.setName(name);
      this.setValue(value);
  }
  
  public int getValue() {
      return value;
  }
  
  public void setValue(int value) {
      if(value<=14 && value>=2) {
      this.value = value;
      }
      else {
          throw new IllegalArgumentException("Card value needs to be between 2 and 14.");
      }
  }
  
  public int getName() {
      return name;
  }
  
  public void setName(int name) {
      if(name>=0 && name<4) {
      this.name = name;
      }
      else {
          throw new IllegalArgumentException("Card value needs to be between 0 and 3.");
      }
  }
  
  /**
   * Prints out information about a card
   * @return
   */
  public StringBuilder describe() {
      StringBuilder info = new StringBuilder();
      cardValue = new HashMap<Integer,String>();
      cardName = new HashMap<Integer,String>();
      cardValue.put(2, "Two");
      cardValue.put(3, "Three");
      cardValue.put(4, "Four");
      cardValue.put(5, "Five");
      cardValue.put(6, "Six");
      cardValue.put(7, "Seven");
      cardValue.put(8, "Eight");
      cardValue.put(9, "Nine");
      cardValue.put(10, "Ten");
      cardValue.put(11, "Jack");
      cardValue.put(12, "Queen");
      cardValue.put(13, "King");
      cardValue.put(14, "Ace");
      
      cardName.put(0,"Clubs");
      cardName.put(1,"Diamonds");
      cardName.put(2,"Hearts");
      cardName.put(3, "Spades");
      
      return info.append(cardValue.get(getValue())).append(" of ").append(cardName.get(getName()));
  }
}