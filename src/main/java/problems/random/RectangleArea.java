package problems.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RectangleArea {
    public static String RectangleAreaMethod(String string) {
        // code goes here  
        return "";
      }

      public static void main (String[] args) {  
        // keep this function call here     
        Scanner s = new Scanner(System.in);
        System.out.print(RectangleAreaMethod(s.nextLine())); 
        
        String name = "";;
      
        List<Point> points = new ArrayList<>();
        
        points.add(new Point(0, 0));
        points.add(new Point(1, 0));
        points.add(new Point(0, 1));
        points.add(new Point(1, 1));
        Collections.sort(points, (p1, p2) -> p1.getXYSum() - p2.getXYSum());
        
      }
}


class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
      this.x = x; 
      this.y = y;
    }

    public int getX() {
      return this.x;
    }

    public int getY() {
      return this.y;
    }

    public int getXYSum() {
        return x + y;
    }
  }