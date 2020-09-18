package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import model.Drawing;

public class DrawingCanvas extends JPanel {

	private DrawingPanel panel;
	private ArrayList<Drawing> lines = new ArrayList<>();

	public  DrawingCanvas(DrawingPanel panel){
		this.panel = panel;
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.black);
	}

	@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(var s: lines){
            s.render(g2);
        }
    }

    public ArrayList<Drawing> getShapes(){
        return lines;
    }
	
}
