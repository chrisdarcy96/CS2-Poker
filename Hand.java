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
     int tester=checkSameCard();
     if(tester==4) {return "Four of a Kind";}
     else if(tester==5) {return "Full House";}
     else if(checkFlush()) {return "Flush";}
     else if(checkStraight()) {return "Straight";}
     else if(tester==3) {return "Three of a Kind";}
     else if(tester==2) {return "Two Pair";}
     else if(tester==1) {return "One Pair";}
     else if (tester==0){return "High Card";}
     else {return "Error";}
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

   private int checkSameCard(){
     int pairs=0;
     int sames;
     int triples=0;
     int four=0;
     for(Card c : hand){
       sames=0;
       System.out.print(c.value+": ");
       for(int i=0; i<hand.size(); i++){
         //System.out.print(hand.get(i).value+ ",");
         if(c.value==hand.get(i).value){
          //System.out.println("SAME "+hand.get(i).value);
          sames++;
         }
       }
       sames--; //removes case where card is compared to itself
       if(sames == 1) {pairs++;}
       if(sames== 2) {triples++;}
       if(sames == 3) {four++;}
       //System.out.println("\n"+sames+" PAIRS "+pairs+" TRIPLES "+triples+" FOUR "+four);
     }
     pairs=pairs/2;
     if(four==1) {return 4;}
     else if(triples == 1 && pairs ==1) {return 5;}
     else if(triples == 1){return 3;}
     else if(pairs==2){return 2;}
     else if(pairs==1){return 1;}
     else {return 0;}

   }

   public int compareTo(Object x){
      Hand other = (Hand)x;
      //TODO: Compare hands by ordering above; return -1, 1, or 0
      return -1;
   }
}
