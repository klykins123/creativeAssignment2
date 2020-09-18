package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Drawing {

	public class Pos{
        public int x;
        public int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
	}
	
	private Pos[] p = new Pos[3];
    private Color color = Color.white; //default value

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public void setPos(int index, int x, int y){
        assert(0 <= index && index <= 2);
        p[index] = new Pos(x, y);
    }

    public void render(Graphics2D g2){
        g2.setColor(color);

        g2.fillOval(p[0].x, p[0].y, 4, 4);
    }
}
