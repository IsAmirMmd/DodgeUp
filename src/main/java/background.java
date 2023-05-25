import processing.core.PApplet;

public class background {
    public static PApplet bgc = DodgeUp.pApplet;
    public DodgeUp dodge = new DodgeUp();

    public static void setBackGround() {
        bgc.background(200);
//        bottom line
        bgc.fill(150);
        bgc.noStroke();
        bgc.rect(200, 531, 400, 62);
    }

    public static void setScore() {
        bgc.textSize(15);
        bgc.fill(5);
        bgc.text("score : " + bgc.frameCount / 10, 10, 20);
    }

    public static void setLife() {
        bgc.textSize(15);
        bgc.fill(150, 150, 250);
        bgc.text("Life : " + 5 / 3, 350, 20);
    }

}
