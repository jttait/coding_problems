package adventofcode.problem14;

import adventofcode.problem14.Robot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class PartTwo {
    private final List<adventofcode.problem14.Robot> robots;
    private final int width;
    private final int height;

    public PartTwo(List<adventofcode.problem14.Robot> robots, int width, int height) {
        this.robots = robots;
        this.width = width;
        this.height = height;
    }

    public void calculateIterationsForEasterEgg() throws Exception {
        int iteration = 1;
        while (iteration < 10000) {
            for (adventofcode.problem14.Robot robot : robots) {
                robot.tick(width, height);
            }
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            for (Robot robot : robots) {
                int x = robot.getPositionX();
                int y = robot.getPositionY();
                g2d.setColor(Color.green);
                g2d.drawRect(x, y, 1, 1);
                File file = new File("src/test/java/adventofcode/year2024/problem14/outputs/" + iteration + ".png");
                ImageIO.write(bufferedImage, "png", file);
            }
            iteration++;
        }
    }
}
