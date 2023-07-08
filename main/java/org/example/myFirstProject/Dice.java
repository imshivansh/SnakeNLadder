package org.example.myFirstProject;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
   private  int noOfDice;


   public Dice(int noOfDice) {
      this.noOfDice = noOfDice;
   }

   public int getNoOfDice() {
      return noOfDice;
   }

   public void setNoOfDice(int noOfDice) {
      this.noOfDice = noOfDice;
   }

   public int  rollDice(int noOfDice){
      int max = noOfDice*6;
      return ThreadLocalRandom.current().nextInt(noOfDice, max + 1);

   }
}
