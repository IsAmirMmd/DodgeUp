import processing.core.PApplet;

public class DodgeUp extends PApplet {
    private final int width = 400;
    private final int height = 600;
    private int bodyColor;
    private int headColor;
    private float bodyWidth;
    private float bodyHeight;
    private float headWidth;
    private float headHeight;
    private float xPos;
    private float yPos;


    public void setup() {
        // Creating character
        bodyColor = color(255, 204, 0);
        headColor = color(255);
        bodyWidth = 20;
        bodyHeight = 30;
        headWidth = 15;
        headHeight = 15;
        xPos = width / 2;
        yPos = height / 2;
    }

    public void draw() {
        background(200);
        // Update position based on mouse cursor
        xPos = mouseX;
        yPos = mouseY;
        // Draw body
        stroke(0);
        fill(bodyColor);
        rectMode(CENTER);
        rect(xPos, 500, bodyWidth, bodyHeight);
        // Draw head
        fill(headColor);
        ellipse(xPos, 477, headWidth, headHeight);
        // Draw legs
        strokeWeight(4);
        line(xPos - bodyWidth / 4, 515, xPos - bodyWidth / 4, 530);
        line(xPos + bodyWidth / 4, 515, xPos + bodyWidth / 4, 530);

    }

    public void settings() {
        size(width, height);
    }


    public static void main(String[] args) {
        PApplet.main("DodgeUp", args);
    }
}
