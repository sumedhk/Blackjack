package coe318.lab5;

public class Card implements Comparable {
  
  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;
 
  private int r, s;
  private boolean fUp;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  public Card(int rank, int suit, boolean faceUp) {
      r = rank;
      s = suit;
      fUp = faceUp;      
      
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    return fUp; 
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    fUp = faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return r; 
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return s;
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    if (getRank() == c.getRank() && getSuit() == c.getSuit()){
        return true;
    } else { 
        return false;
    }
     
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) {
      if (getRank() > c.getRank()){
        return 1;  
      }
       else if (getRank() < c.getRank()){
          return -1;
      }
       else if (getRank() == c.getRank()){
                if (getSuit() > c.getSuit()){
                return 1;
                }  else if (getSuit() < c.getSuit()){
                    return -1;
                } else if (getSuit() == c.getSuit()){
                    return 0;
                } 
                else return 0;
             
  } else {
           return 0;
       }
      
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
    if (r == 11){
          return ("Jack");
      } 
      else if (r == 12){
          return ("Queen");
      }
      else if (r == 13){
          return ("King");
      }
      else if (r == 14){
          return ("Ace");
      }
      else {return (Integer.toString(r));
      }
      
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
    if(s == 0){
          return ("Club");
      }

        else  if(s == 1){
          return ("Diamond");
      }

        else  if(s == 2){
          return ("Heart");
      }

          else {
          return ("Spade");
      } 
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
    if (fUp == true){
          return (getRankString() + " " + getSuitString() + " " + "fUp");    
      } 
      else {
          return ("?");
      } 
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: " + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: " + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: " + club5.equals(spadeAce));
    System.out.println("club5 equals club5: " + club5.equals(club5));
  }
}