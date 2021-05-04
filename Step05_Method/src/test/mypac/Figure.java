package test.mypac;

public class Figure {
   public double width;
   public double height;
   public double radius;
   
   public double rightTriangle(){
      double area=this.width*this.height*0.5;
      return area;
   }
   
   public double circle() {
      double area=Math.pow(this.radius, 2)*Math.PI;
      return area;
   }
   
   public double round() {
      double round=2*this.radius*Math.PI;
      return round;
   }
   public void showArea() {
      if(this.radius==0) {
         double area=this.width*this.height*0.5;
         System.out.println("이 삼각형의 넓이는"+area);
      }else {
         double area=Math.pow(this.radius, 2)*Math.PI;
         System.out.println("이 원의 넓이는"+area);
      }
      
   }
}