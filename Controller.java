import java.util.*;

public class Controller
{
   private static Deck deck;
   private static Hand hand1;
   private static Hand hand2;

   public static void main(String[] args){
      deck = new Deck();
      //System.out.println(deck);
      hand1 = new Hand();
      hand2 = new Hand();

      dealHands(5);
      //System.out.println(hand1);
      //System.out.println(hand2);

      hand1.sortHand();
      hand2.sortHand();
      System.out.println(hand1);
      System.out.println(hand2);

      System.out.println("Best Hand: " + hand1.handValue());
      System.out.println("Best Hand: " + hand2.handValue());
      System.out.println(findWinner());
   }

   public static void dealHands(int x){
      //TODO: Deal x cards to each player
      for(int i=0; i<x; i++){
        Card temp1=deck.remove();
        Card temp2=deck.remove();
        //add Cards to hands
        hand1.add(temp1);
        hand2.add(temp2);
      }

   }

   public static String findWinner(){
      int result = hand1.compareTo(hand2);
      if(result>0) {return "Hand 1 wins";}
      else if(result<0) {return "Hand 2 wins";}
      else{return "Tie";}
   }

}
