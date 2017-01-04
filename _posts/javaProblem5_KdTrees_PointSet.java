import java.util.Set;
import java.util.HashSet;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.RectHV;

public class PointSET {
   private Set<Point2D> points;
   public         PointSET()                               // construct an empty set of points 
   {
       points  = new HashSet<Point2D>(); 
   }
   public           boolean isEmpty()                      // is the set empty? 
   {
       if (points.isEmpty())
           return true;
       else
           return false;
   }
   public               int size()                         // number of points in the set 
   {
       return points.size();
   }
   public              void insert(Point2D p)              // add the point to the set (if it is not already in the set)
   {
       if (!points.contains(p))
           points.add(p);
   }
   public           boolean contains(Point2D p)            // does the set contain point p? 
   {
       if (!points.contains(p))
           return false;
       return true;
   }
   public              void draw()                         // draw all points to standard draw 
   {
    StdDraw.enableDoubleBuffering();
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    for (Point2D p : points) {
        p.draw();
    }
    StdDraw.show();   
   }
   public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle 
   {
       Set<Point2D> temp = new HashSet<Point2D>();
       for (Point2D point : points) {
           if (rect.contains(point))
               temp.add(point);
       }
       // do I need to return null or not if it's empty
       return temp;
   }
   public           Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty 
   {
       if (points.isEmpty())
           return null;
       double distance;
       double minDistance = 0;
       Point2D temp = null;
       int i = 0;
       for (Point2D point : points) {
           distance = point.distanceTo(p);
           if (i == 0) {
               i ++;
               minDistance = distance;
           } else {
               if (distance < minDistance) {
                   temp = point;
                   minDistance = distance;
               }
           }
       }
       return temp;
   }
  // public static void main(String[] args)                  // unit testing of the methods (optional) 
}
