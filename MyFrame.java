/*
 * Maman 13 : Question 1
 * Author: Shai Gotlieb
 * Date: 09-05-2018
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class MyFrame extends JFrame {
	//size of the frame
	private final int WIDTH = 700;
	private final int HEIGHT = 500;
	
	//buttons
	private JButton cmdUndo, cmdClear;
	//comboBoxs
	private JComboBox colorBox, shapeBox;
	//checkBox
	private JCheckBox fillCBox;
	//panel that will hold all the components
	private JPanel menuPanel;
	//array of strings for comboBox
	private static final String[] shapesToDraw = {"Line", "Round Rectangle", "Circle", "Rectangle"};
	private static final String[] chooseColor = {"Black", "Blue", "Red", "Green", "Yellow"};
	//panel to draw
	private MyPanel gPanel;
	
	//class constructor
	public MyFrame() {
		
		//create panels by calling the methods
		createMenuePanel();
		createGPanel();
		
		//Initialize frame properties
		this.setTitle("MMN 13 Q1");
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//listening to the buttons
		ButtonListener lis = new ButtonListener();
		cmdUndo.addActionListener(lis);
		cmdClear.addActionListener(lis);
		
		//listening to the items in checkBox and comboBox
		MyItemListener itlis = new MyItemListener();
		colorBox.addItemListener(itlis);
		shapeBox.addItemListener(itlis);
		fillCBox.addItemListener(itlis);
	}	

	//method that create the menu panel that holds the components
		private void createMenuePanel() {
			menuPanel = new JPanel();
			
			//Initialize buttons 
			cmdUndo = new JButton("Undo");
			cmdClear = new JButton("Clear");
			
			//Initialize comboBox 
			colorBox = new JComboBox(chooseColor);
			shapeBox = new JComboBox(shapesToDraw);
			
			//Initialize checkBox 
			fillCBox = new JCheckBox("Filled");
			
			
			//add components to the menu panel
			menuPanel.add(cmdUndo);
			menuPanel.add(cmdClear);
			menuPanel.add(colorBox);
			menuPanel.add(shapeBox);
			menuPanel.add(fillCBox);
			
			//decide that the menu panel will be at the top
			this.add(menuPanel, BorderLayout.NORTH);
			
		}
		
		//create panel to draw
		private void createGPanel() {
			gPanel = new MyPanel();
			//decide to place the panel in center (under menu panel)
			add(gPanel, BorderLayout.CENTER);
		}
	
		//inner class for listening to the buttons
		private class ButtonListener implements ActionListener{
			
			@Override
			//override method and check if buttons were pressed
			public void actionPerformed(ActionEvent e) {
				//Undo button was pressed
				if(e.getSource() == cmdUndo)
				{
					gPanel.undo();
				}
				//Clear button was pressed
				if(e.getSource() == cmdClear)
				{
					gPanel.clearAll();
				}
					
			}
		}//end of inner class ButtonListener
		
		//inner class that listens to the Items: checkBox and comboBox
		private class MyItemListener implements ItemListener{

			@Override
			//check the selected item
			public void itemStateChanged(ItemEvent e) {
			//check if fill checkBox was selected or not
				if(e.getSource() == fillCBox) {
					if(e.getStateChange()==e.SELECTED)
						gPanel.setFill(true);
					else gPanel.setFill(false);
				}
				
				//check if comboBox of the colors was selected or not
				if(e.getSource() == colorBox) {
					//change color according to users choice 
					if(colorBox.getSelectedIndex()==0)
						gPanel.setCurrentColor(Color.BLACK);
					else if(colorBox.getSelectedIndex()==1)
						gPanel.setCurrentColor(Color.BLUE);
					else if(colorBox.getSelectedIndex()==2)
						gPanel.setCurrentColor(Color.RED);
					else if(colorBox.getSelectedIndex()==3)
						gPanel.setCurrentColor(Color.GREEN);
					else if(colorBox.getSelectedIndex()==4)
						gPanel.setCurrentColor(Color.YELLOW);
				}
				
				//check if shapes comboBox was selected or not
				if(e.getSource()== shapeBox) {
					//change the type of shape according to users choice
					if(shapeBox.getSelectedIndex()==0) {
						gPanel.setShapeType(gPanel.getShapeType().LINE);
					}
					else if(shapeBox.getSelectedIndex()==1) {
						gPanel.setShapeType(gPanel.getShapeType().ROUNDRECT);
					}
					else if(shapeBox.getSelectedIndex()==2) {
						gPanel.setShapeType(gPanel.getShapeType().CIRCLE);
					}
					else if(shapeBox.getSelectedIndex()==3) {
						gPanel.setShapeType(gPanel.getShapeType().RECTANGLE);
					}					
				}				
			}
		}//end of inner class MyItemListener
	
		//main method - creating new frame to start the app
	public static void main(String[] args) {
		
		MyFrame frame = new MyFrame();

	}//end of main

}//end of class MyFrame
