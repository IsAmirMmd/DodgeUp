import java.util.ArrayList;
import processing.core.PApplet;

public class Block implements makeBlock, showBlock {
    public static ArrayList<Block> blocks= new ArrayList<>();
    private final int width  = 60;
    private final int height = 30;
    public float speedY = -50;
    private float BlockX;
    private float BlockY;
    private int colorR;
    private int colorG;
    private int colorB;


    public Block(float blockX, float blockY, int colorR, int colorG, int colorB) {
        this.BlockX = blockX;
        this.BlockY = blockY;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public void makeBlocks() {
        for (int i = 0 ; i<100 ; i++){
            blocks.add(new Block(DodgeUp.pApplet.random(10,70),speedY,10,10,10));
            speedY -= 50;
            blocks.add(new Block(DodgeUp.pApplet.random(110,170),speedY,15,18,56));
            speedY -= 50;
            blocks.add(new Block(DodgeUp.pApplet.random(210,280),speedY,85,85,85));
            speedY -= 50;
            blocks.add(new Block(DodgeUp.pApplet.random(320,390),speedY,115,95,213));
            speedY -= 50;
        }
    }

    public void showBlocks() {
        for (Block tempBlock : blocks){
            DodgeUp.pApplet.fill(tempBlock.colorB,tempBlock.colorG,tempBlock.colorB);
            DodgeUp.pApplet.rect(tempBlock.BlockX,tempBlock.BlockY,width,height);
        }
    }

    public void moveBlock() {
        for (Block block : blocks){
            block.setBlockY(getBlockY()+10);

        }
    }

    public float getBlockY() {
        return BlockY;
    }

    public void setBlockY(float blockY) {
        BlockY = blockY;
    }
}
