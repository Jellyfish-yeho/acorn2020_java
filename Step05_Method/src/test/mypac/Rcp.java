package test.mypac;

public class Rcp {
   public void testing(String str) {
      String str1 = "가위";
      String str2 = "바위";
      String str3 = "보자기";
      long now = System.currentTimeMillis();
      if(now%3 == 0) {
         System.out.println(str + "를 내었습니다.");
         System.out.println("컴퓨터는 " + str1 +"를 내었습니다.");
      } else if(now%3 == 1) {
         System.out.println(str + "를 내었습니다.");
         System.out.println("컴퓨터는 " + str2 +"를 내었습니다.");
      } else if(now%3 == 2) {
         System.out.println(str + "를 내었습니다.");
         System.out.println("컴퓨터는 " + str3 +"를 내었습니다.");
      }
   }

}
