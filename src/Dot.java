import java.awt.*;

public class Dot {
    private int positionX, positionY;
    private Color color;

    public Dot(int positionX, int positionY, Color color){
        this.positionX = positionX;
        this.positionY = positionY;
        this.color = color;
    }

    public int getX() {
        return positionX;
    }

    public void setX(int positionX) {
        this.positionX = positionX;
    }

    public int getY() {
        return positionY;
    }

    public void setY(int positionY) {
        this.positionY = positionY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillOval(positionX - 4, positionY - 4, 7, 7);
    }

}
