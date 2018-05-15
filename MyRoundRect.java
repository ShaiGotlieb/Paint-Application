import java.awt.Color;
import java.awt.Graphics;

//class represent a round rectangle - inheritance from Shape
public class MyRoundRect extends Shape{
	
	//inheritance constructor from Shape
	public MyRoundRect() {
		super();
	}
	
	//inheritance constructor from Shape
	public MyRoundRect(int x1, int y1, int x2, int y2, Color color, boolean fill) {
		super(x1,y1,x2,y2,color,fill);
	}
	
	//draw method to draw a specific shape - round rectangle
	public void draw(Graphics g) {
		g.setColor(getMyColor());
		//round rectangle will be filled
		if(isFill())
			g.fillRoundRect(getX1(), getY1(), getX2(), getY2(), getX1(), getY1());
		//round rectangle will be unfilled
		else g.drawRoundRect(getX1(), getY1(), getX2(), getY2(),getX1(), getY1());
	}

}
