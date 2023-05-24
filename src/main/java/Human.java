public class Human {
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

    public void humanBody(){
        // Creating character
        bodyColor = DodgeUp.pApplet.color(255, 204, 0);
        headColor = DodgeUp.pApplet.color(255);
        bodyWidth = 20;
        bodyHeight = 30;
        headWidth = 15;
        headHeight = 15;
        xPos = width / 2;
        yPos = height / 2;
    }
    public void humanFPS(){
        // Update position based on mouse cursor
        xPos = DodgeUp.pApplet.mouseX;
        yPos = DodgeUp.pApplet.mouseY;
        // Draw body
        DodgeUp.pApplet.stroke(0);
        DodgeUp.pApplet.fill(bodyColor);
        DodgeUp.pApplet.rectMode(DodgeUp.pApplet.CENTER);
        DodgeUp.pApplet.rect(xPos, 500, bodyWidth, bodyHeight);
        // Draw head
        DodgeUp.pApplet.fill(headColor);
        DodgeUp.pApplet.ellipse(xPos, 477, headWidth, headHeight);
        // Draw legs
        DodgeUp.pApplet.strokeWeight(4);
        DodgeUp.pApplet.line(xPos - bodyWidth / 4, 515, xPos - bodyWidth / 4, 530);
        DodgeUp.pApplet.line(xPos + bodyWidth / 4, 515, xPos + bodyWidth / 4, 530);
    }

}
