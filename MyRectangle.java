import java.awt.Color;
import java.awt.Graphics;

//class represent a rectangle - inheritance from Shape
public class MyRectangle extends Shape {
	
	//inheritance constructor from Shape
	public MyRectangle() {
		super();
	}
	
	//inheritance constructor from Shape
	public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean fill) {
		super(x1,y1,x2,y2,color,fill);
	}
	
	//draw method to draw a specific shape - rectangle
	public void draw(Graphics g) {
		g.setColor(getMyColor());
		//rectangle will be filled
		if(isFill())
			g.fillRect(getX1(), getY1(), getX2(), getY2());
		//rectangle will be unfilled
		else g.drawRect(getX1(), getY1(), getX2(), getY2());
	}

}
