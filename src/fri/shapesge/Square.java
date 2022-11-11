package fri.shapesge;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 *
 * @author original: Michael Kölling and David J. Barnes
 * @author engine: Ján Janech
 * @version 1.0  (9.11.2022)
 */
public class Square {
    private int size;
    private int xPosition;
    private int yPosition;
    private Color color;
    private boolean isVisible;

    /**
     * Create a new square at default position with default color.
     */
    public Square() {
        this.size = 30;
        this.xPosition = 60;
        this.yPosition = 50;
        this.color = Color.red;
        this.isVisible = false;

        Game.getGame().registerDrawable(new SquareDrawable());
    }

    /**
     * Make this square visible. If it was already visible, do nothing.
     */
    public void makeVisible() {
        this.isVisible = true;
    }

    /**
     * Make this square invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible() {
        this.isVisible = false;
    }

    /**
     * Move the square a few pixels to the right.
     */
    public void moveRight() {
        this.moveHorizontal(20);
    }

    /**
     * Move the square a few pixels to the left.
     */
    public void moveLeft() {
        this.moveHorizontal(-20);
    }

    /**
     * Move the square a few pixels up.
     */
    public void moveUp() {
        this.moveVertical(-20);
    }

    /**
     * Move the square a few pixels down.
     */
    public void moveDown() {
        this.moveVertical(20);
    }

    /**
     * Move the square horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance) {
        this.xPosition += distance;
    }

    /**
     * Move the square vertically by 'distance' pixels.
     */
    public void moveVertical(int distance) {
        this.yPosition += distance;
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newSize) {
        this.size = newSize;
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor) {
        this.color = Parser.parseColor(newColor);
    }

    private class SquareDrawable extends GameDrawable {
        @Override
        public void draw(Graphics2D canvas) {
            if (!Square.this.isVisible) {
                return;
            }

            var shape = new Rectangle2D.Double(Square.this.xPosition, Square.this.yPosition, Square.this.size, Square.this.size);
            canvas.setColor(Square.this.color);
            canvas.fill(shape);
        }
    }
}
