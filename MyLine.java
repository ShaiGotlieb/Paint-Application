import java.awt.Color;
import java.awt.Graphics;

//class represent a line - inheritance from Shape
public class MyLine extends Shape {
	
	//inheritance constructor from Shape
	public MyLine() {
		super();
	}
	
	//inheritance constructor from Shape
	public MyLine(int x1, int y1, int x2, int y2, Color color, boolean fill) {
		super(x1,y1,x2,y2,color,fill);
	}
	
	//draw method to draw a specific shape - line
	public void draw(Graphics g) {
		g.setColor(getMyColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}

}
