import java.awt.Color;
import java.awt.Graphics;

//class represent a circle - inheritance from Shape
public class MyCircle extends Shape {
	
	//inheritance constructor from Shape
	public MyCircle() {
		super();
	}
	
	//inheritance constructor from Shape
	public MyCircle(int x1, int y1, int x2, int y2, Color color, boolean fill) {
		super(x1,y1,x2,y2,color,fill);

	}
	
	//draw method to draw a specific shape - circle
	public void draw(Graphics g) {
		g.setColor(getMyColor());
		//circle will be filled
		if(isFill())
			g.fillOval(getX1(), getY1(), getX2(), getY2());
		//circle will be unfilled
		else g.drawOval(getX1(), getY1(), getX2(), getY2());
	}

}
