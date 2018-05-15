
import java.awt.Color;
import java.awt.Graphics;

//class of Shape - other classes will inherit from this class
public abstract class Shape {
//points - coordinators of shape
	private int x1,y1,x2,y2,width,height;
	//color of shape
	private Color myColor;
	//if fill is true - shape should be filled
	private boolean fill;
	
	//constructor of Shape initialize coordinators to zero
	public Shape() {
		setX1(setY1(setX2(setY2(0))));
		setWidth(0);
		setHeight(0);
		setMyColor(Color.BLACK);
	}
	
	//constructor of shape that get the properties to create new shape
	public Shape(int x1, int y1, int x2 , int y2, Color color, boolean fill) {
		setX1(x1);
		setY1(y1);
		setX2(x2);
		setY2(y2);
		setMyColor(color);
		setFill(fill);
	}

	//getters and setters
	public int getY1() {
		return y1;
	}

	public int setY1(int y1) {
		this.y1 = y1;
		return y1;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public int setX2(int x2) {
		this.x2 = x2;
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public int setY2(int y2) {
		this.y2 = y2;
		return y2;
	}

	public Color getMyColor() {
		return myColor;
	}

	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}
	
	//abstract method in order to make other shapes to create method to draw the shapes
	public abstract void draw(Graphics g);

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
}//end of class Shape
