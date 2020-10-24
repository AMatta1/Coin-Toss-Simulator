// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   
   private int labelBottom;
   private int barLeft;
   private int barWidth;
   private int height;
   private double barScale;
   private Color barColor;
   private String barLabel;
   
   

   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label) {    
      
      labelBottom= bottom;
      barLeft=left;
      barWidth=width;
      height=barHeight;
      barScale=scale;
      barColor=color;
      barLabel=label;
      
   }

   
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
      
      final int BUFFER = 50;
      
      
      String message = barLabel;
      
      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(message, context);
      int widthOfLabel = (int) labelBounds.getWidth();
      int heightOfLabel = (int) labelBounds.getHeight();  
      
      
      // Retrieving  windowHeight (a.k.a variable getHeight()) using parameter labelBottom (or bottom )
      int windowHeight = labelBottom + BUFFER;
      
      
      // Calculating bottom of bar using labelBottom
      int barBottom = labelBottom - heightOfLabel;
     
      
      // Calculating the bar height based on scale and outcome of a trial 
      double heightOfBar = barScale * height;
      
      //This represents x coordinate of the label obtained w.r.t width of label and bar width
      double xCoordLabel = barLeft + (barWidth/2) - (widthOfLabel/2) ;
       
      // Since bar grows downward in positive y direction, hence shifting y-coordinate of bar upward by value equal to its height
      Rectangle rect = new Rectangle (barLeft , (int)(barBottom - heightOfBar) , barWidth , (int)heightOfBar); 
   
      
      g2.setColor(barColor);  
      g2.fill(rect);
      
                      
      g2.setColor(Color.BLACK);  
      g2.drawString (message , (int)xCoordLabel , labelBottom);
      
      }
   }
