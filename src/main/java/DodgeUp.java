import processing.core.PApplet;
import processing.sound.*;
import processing.event.MouseEvent;
import com.jsyn.util.soundfile.*;

import java.util.ArrayList;

public class DodgeUp extends PApplet {
    public static PApplet pApplet;
    private final int width = 400;
    private final int height = 600;
    public Human human = new Human();
    public Block block = new Block(0, 0, 0, 0, 0);
    public int life = 15; // equal to 5
    public int score = 0;
    public boolean gameOver = false;

    public SoundFile soundFileGameOver;
    public SoundFile startGame;

    public void setup() {
        pApplet = this;
        soundFileGameOver = new SoundFile(this, "C:\\Users\\amir\\Desktop\\practice\\DodgeUp\\src\\test\\gameover.wav");
        startGame = new SoundFile(this, "C:\\Users\\amir\\Desktop\\practice\\DodgeUp\\src\\test\\start.wav");
        startGame.play();
        human.humanBody();
        block.makeBlocks();
    }

    public void draw() {
        if (!gameOver) {
            background.setBackGround();
            float humanC = human.getHeadXPos();
            float humanL = human.getHeadXPos() - human.getHeadWidth() / 2;
            float humanR = human.getHeadXPos() + human.getHeadWidth() / 2;
            float humanT = human.getHeadYPos() + human.getHeadHeight() / 2;
            float humanB = human.getHeadYPos() - human.getHeadHeight() / 2;
            human.humanFPS();
            block.showBlocks();
//        checking hit...
            for (Block b : Block.blocks) {
                float blockL = b.getBlockX() - b.getWidth() / 2;
                float blockR = b.getBlockX() + b.getWidth() / 2;
                float blockT = b.getBlockY() + b.getHeight() / 2;
                float blockB = b.getBlockY() - b.getHeight() / 2;
//               if (humanL > blockL && humanR < blockR && humanT < blockT && humanB > blockB) {
                if (humanC >= blockL && humanC <= blockR && humanT < blockT && humanB > blockB) {
                    life--;
                    if (life <= 1) {
                        score = frameCount / 3;
                        gameOver = true;
                        startGame.stop();
                        gameOver(score);
                    }
                }
            }
//        moving block in each frame
            for (Block tempBlock : Block.blocks) {
                tempBlock.setBlockY(tempBlock.getBlockY() + 3);
            }
            background.setScore();
            textSize(15);
            fill(150, 150, 250);
            text("Life : " + life / 3, 350, 20);


        }
    }

    public void settings() {
        size(width, height);
    }

    public void mouseClicked() {
        if (gameOver) {
            exit();
        }
    }

    public void gameOver(int score) {
        background(0);
        startGame.stop();
        soundFileGameOver.cue(0);
        soundFileGameOver.play();
        textSize(25);
        text("your score is : " + score, 120, 200);
        fill(143, 11, 25);
        text("Exit", 150, 400);
    }


    public static void main(String[] args) {
        PApplet.main("DodgeUp", args);
    }
}
