import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class newGraph {


    public void newGraph() {

        BufferedImage report = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D render = (Graphics2D) report.getGraphics();


        int dados = (1);


        render.setColor(Color.DARK_GRAY);
        render.fillRect(0, 0, report.getWidth(), report.getHeight());

        render.setColor(Color.WHITE);
        render.fillRect(50, 50, report.getWidth() - 100, report.getHeight() - 100);

        render.setColor(Color.BLACK);
        render.drawLine(80, 500, 720, 500);
        render.setColor(Color.BLACK);
        render.drawLine(80, 80, 80, 500);


        try {
            ImageIO.write(report, "PNG", new File("report.png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        newGraph teste = new newGraph();
        teste.newGraph();
    }
}
