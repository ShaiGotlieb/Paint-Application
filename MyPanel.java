import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

//class MyPanel
public class MyPanel extends JPanel{
	//arrayList that store all the shapes that were drawing
	private ArrayList<Shape> shapeList;
	//enum of the shape type
	public enum ShapeType {LINE, ROUNDRECT, RECTANGLE, CIRCLE};
	public ShapeType shapeType;
	//variables to hold the current shape and color that a user draw
	public Shape currentShape;
	public Color currentColor;
	//bool var to decide if to fill the shape or not
	private boolean fill;
	
	//constructor of class MyPanel
	public MyPanel() {
		//Initialize an arrayList with size of 1000 (didn't get any instructions of size of arrayList)
		shapeList = new ArrayList<Shape>(1000);
		
		//default shape type will be line
		setShapeType(ShapeType.LINE);
		
		//default shape is unfilled
		setFill(false);
		
		//var that holds the current shape in order to draw it interactively 
		currentShape = null;
		
		//Listening to the mouse
		MouseHandler mouseHandler = new MouseHandler();
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);

	}
	
	//method that set the color of the shape
	public void setCurrentColor(Color c) {
		currentColor = c;
	}
	
	//paint component method that paint all the shapes on the panel
	public void paintComponent(Graphics g) {
		//inheritance
		super.paintComponent(g);
		
		//draw the shapes in the list using each shapes draw method - polymorphism 
		if(!shapeList.isEmpty()) {
		for(int i=0; i<shapeList.size();i++) {
			shapeList.get(i).draw(g);
		}
		}
		
		//draw the shape as user move the mouse
		if(currentShape != null)
			currentShape.draw(g);
	}

	//getters and setter of type of Shape
	public ShapeType getShapeType() {
		return shapeType;
	}

	public void setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
	}

	//method that return the bool var of filling shape
	public boolean isFill() {
		return fill;
	}

	//set the fill var 
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	
	//method to delete the last shape that was drawing
	public void undo() {
		if(!shapeList.isEmpty())
			shapeList.remove(shapeList.get(shapeList.size()-1));
		repaint();
	}
	
	//method to delete all shapes that were drawing
	public void clearAll() {
		shapeList.clear();
		repaint();
	}
	
	//inner class that listening to the mouse motion/clicked/etc.
	private class MouseHandler extends MouseAdapter implements MouseMotionListener{
		
		//@Override first when mouse was pressed - check which shape to create
		public void mousePressed(MouseEvent e) {
			//create new shape according to user's choice
			switch(shapeType) {
			case LINE: 
						currentShape = new MyLine(e.getX(),e.getY(),e.getX(),e.getY(), currentColor, fill);
						break;						
			case ROUNDRECT: 
						currentShape = new MyRoundRect(e.getX(),e.getY(),e.getX(),e.getY(), currentColor, fill);
						break;
			case CIRCLE:
						currentShape = new MyCircle(e.getX(),e.getY(),e.getX(),e.getY(), currentColor, fill);
						break;
			case RECTANGLE: 
						currentShape = new MyRectangle(e.getX(),e.getY(),e.getX(),e.getY(), currentColor, fill);
						break;
			}
		}
		
		//@Override method that take the coordinates of the pixels where the mouse is
		public void mouseReleased(MouseEvent e) {
			//set new coordinators
			if(currentShape != null && getShapeType() != ShapeType.LINE) {
				currentShape.setX2(e.getX()-currentShape.getX1());
				currentShape.setY2(e.getY()-currentShape.getY1());
				
				//add the shape to the list
				shapeList.add(currentShape);
				currentShape = null;
				repaint();
			}
			//if the user pick a line to draw we set the coordinate differently 
			else if(getShapeType() == ShapeType.LINE) {
				currentShape.setX2(e.getX());
				currentShape.setY2(e.getY());
				
				//add the shape to the list
				shapeList.add(currentShape);
				currentShape = null;
				repaint();
			}
		}
		//setting the x2.y2 position wherever i'm on the screen
		public void mouseDragged(MouseEvent e) {
			if(currentShape != null && getShapeType() != ShapeType.LINE) {
				currentShape.setX2(e.getX()-currentShape.getX1());
				currentShape.setY2(e.getY()-currentShape.getY1());
				repaint();
			}
			//if the user pick a line to draw we set the coordinate differently 
			else if(getShapeType() == ShapeType.LINE) {
				currentShape.setX2(e.getX());
				currentShape.setY2(e.getY());
				repaint();
			}
		}
	}//end of inner class MouseHandler
}//end of class MyPanel
