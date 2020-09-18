package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

import java.awt.Container;
import java.awt.Dimension;

public class MenuScreen {
	
	private JFrame window;

    public MenuScreen(JFrame window){
        this.window = window;
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(400, 200));
        menuPanel.setLayout(new GridLayout(2, 1));
        cp.add(BorderLayout.CENTER, menuPanel);

        var drawingButton = new JButton("Let's Draw!");
		menuPanel.add(drawingButton);
		
		drawingButton.addActionListener(event -> {
			window.getContentPane().removeAll();
            var panel = new DrawingPanel(window);
            panel.init();
            window.pack();
            window.setVisible(true);
		});

        
    }
}
