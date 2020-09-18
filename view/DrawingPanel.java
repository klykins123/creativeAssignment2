package view;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;


import controller.DrawingEventListener;

public class DrawingPanel {

	private JFrame window;
	private DrawingCanvas canvas;
    private JRadioButton redButton = new JRadioButton("Red");
    private JRadioButton yellowButton = new JRadioButton("Yellow");
    private JRadioButton blueButton = new JRadioButton("Blue");
    private JButton clearButton = new JButton("Clear");
    private JButton exitButton = new JButton("Exit");

	public DrawingPanel(JFrame window){
		this.window = window;
	}
	

	public void init(){
		Container cp = window.getContentPane();

        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);

        southPanel.setLayout(new GridLayout(2, 1));
        JPanel radioPanel = new JPanel();
        radioPanel.add(redButton);
        radioPanel.add(yellowButton);
        radioPanel.add(blueButton);
		southPanel.add(radioPanel);
		
		TitledBorder title = BorderFactory.createTitledBorder("Color");
        radioPanel.setBorder(title);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
        southPanel.add(buttonPanel);

        canvas = new DrawingCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        // attatch event listener
        DrawingEventListener listener = new DrawingEventListener(this);
        exitButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        redButton.addActionListener(listener);
        yellowButton.addActionListener(listener);
        blueButton.addActionListener(listener);
        canvas.addMouseListener(listener);
	}

	public JButton getExitButton() {
        return exitButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JRadioButton getRedButton() {
        return redButton;
    }

    public JRadioButton getYellowButton() {
        return yellowButton;
    }

    public JRadioButton getBlueButton() {
        return blueButton;
    }

    public JFrame getWindow() {
        return window;
    }

    public DrawingCanvas getCanvas(){
        return canvas;
    }

}
