package test.mypac;

public class Random {
      
   public int newRan() {
      double dValue = Math.random();
      int iValue = (int)(dValue * 10-1);

      return iValue;
   }
}