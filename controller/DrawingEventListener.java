package controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import model.Drawing;
import view.MenuScreen;
import view.DrawingPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;


public class DrawingEventListener implements ActionListener, MouseListener {

	private DrawingPanel panel;
    private Color color = Color.white;
    private int clicks = 0;
	private Drawing drawing;
	public 	boolean inf = false;
	
	public DrawingEventListener(DrawingPanel panel){
		this.panel = panel;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
        if (source == panel.getExitButton()) {
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        } else if (source == panel.getClearButton()) {
            panel.getCanvas().getShapes().clear();
            panel.getCanvas().repaint();
        } else if (source == panel.getRedButton()) {
            color = Color.red;
        } else if (source == panel.getYellowButton()) {
            color = Color.yellow;
        } else if (source == panel.getBlueButton()) {
            color = Color.blue;
        }
	} 

	@Override
	public void mouseClicked(MouseEvent e) { }
	
	@Override
    public void mousePressed(MouseEvent e) { 
		drawing = new Drawing();
		drawing.setColor(color);
		panel.getCanvas().getShapes().add(drawing);
	
		while(inf != true){
			drawing.setPos(0, e.getX(), e.getY());
		}
	}


	@Override
    public void mouseReleased(MouseEvent e) { 
		inf = true;
	}

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
	public void mouseExited(MouseEvent e) { }
	
}
