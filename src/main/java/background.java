import processing.core.PApplet;
public class background {
    public PApplet bgc = DodgeUp.pApplet;
    public void setBackGround(){
        bgc.background(200);
//        bottom line
        bgc.fill(150);
        bgc.rect(0,531,400,600);
    }

}
