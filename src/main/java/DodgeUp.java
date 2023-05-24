import processing.core.PApplet;

public class DodgeUp extends PApplet {

    public static PApplet pApplet;
    public Human human = new Human();

    public void setup() {
        human.humanBody();
    }

    public void draw() {
        background(200);
        human.humanFPS();
    }

    public void settings() {
        size(width, height);
    }


    public static void main(String[] args) {
        PApplet.main("DodgeUp", args);
    }
}
