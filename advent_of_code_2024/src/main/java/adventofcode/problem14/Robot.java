package adventofcode.problem14;

public class Robot {
    private int positionX;
    private int positionY;
    private final int velocityX;
    private final int velocityY;

    public Robot(int positionX, int positionY, int velocityX, int velocityY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public void tick(int width, int height) {
        positionX = positionX + velocityX;
        if (positionX >= width) {
            positionX = positionX - width;
        } else if (positionX < 0) {
            positionX = width + positionX;
        }
        positionY = positionY + velocityY;
        if (positionY >= height) {
            positionY = positionY - height;
        } else if (positionY < 0) {
            positionY = height + positionY;
        }
    }
}
