package GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class desenharRetangulo extends JPanel {

		
		public void paint(Graphics g)  
	    {  
	         
	        g.draw3DRect(100, 100, 100, 100, false);  
	        g.drawLine(100, 100, 200, 200);
	        g.drawLine(200, 100, 100, 200);  
	    } 
	
		
	
		
}

