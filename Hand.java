import java.util.*;

public class Hand implements Comparable {
   private ArrayList<Card> hand;

   public Hand(){
      hand = new ArrayList<Card>();
   }

   public void add(Card c){
      hand.add(c);
   }

   public void sortHand(){
      Collections.sort(hand);
   }

   public String toString(){
      return hand.toString();
   }

   /*
   BEST
   Royal Flush
   Straight Flush
   Four of a Kind
   Full House
   Flush
   Straight
   Three of a Kind
   Two Pair
   One Pair
   High Card
   WORST
   */

   //hardest method, evaluate in order
   public String handValue() {
     if(checkStraight() && checkFlush()){
       //straight flush
       //must check for royal flush
       if(hand.get(0).value==10)
        return "Royal Flush";
      else {return "Straight Flush";}
     }


     return "TODO: String of Best Hand; may need helper methods";
   }

   private boolean checkStraight(){
     for(int i=0; i<hand.size(); i++){
       if(hand.get(i).value != hand.get(i+1).value+1)
        return false;
     }
     return true;
   }

   private boolean checkFlush(){
     String testSuit=hand.get(0).suit;
     for(Card c : hand){
       if(!(testSuit.equals(c.suit)))
        return false;
     }
     return true;
   }


   public int compareTo(Object x){
      Hand other = (Hand)x;
      //TODO: Compare hands by ordering above; return -1, 1, or 0
      return -1;
   }
}
