import java.util.ArrayList;
import processing.core.PApplet;

public class Block implements makeBlock, showBlock {
    public PApplet block = DodgeUp.pApplet;
    public static ArrayList<Block> blocks= new ArrayList<>();
    private final int width  = 50;
    private final int height = 30;
    private float speedY = -50;
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

    @Override
    public void makeBlocks() {
        for (int i = 0 ; i<10 ; i++){
            blocks.add(new Block(block.random(35,80),speedY,10,10,10));
            speedY -= 50;
            blocks.add(new Block(block.random(100,160),speedY,15,18,56));
            speedY -= 50;
            blocks.add(new Block(block.random(200,290),speedY,85,85,85));
            speedY -= 50;
            blocks.add(new Block(block.random(310,350),speedY,115,95,213));
        }
    }

    @Override
    public void showBlocks() {
        for (Block tempBlock : blocks){
            block.fill(tempBlock.colorB,tempBlock.colorG,tempBlock.colorB);
            block.rect(tempBlock.BlockX,tempBlock.BlockY,width,height);
            tempBlock.setBlockY(getBlockY()+10);
        }
    }

    public float getBlockY() {
        return BlockY;
    }

    public void setBlockY(float blockY) {
        BlockY = blockY;
    }
}
