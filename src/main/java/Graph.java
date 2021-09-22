

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Graph {

        public static void main(String [] args){
            BufferedImage report = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            Graphics2D render = (Graphics2D) report.getGraphics();

            render.setColor(Color.DARK_GRAY);
            render.fillRect(0,0,report.getWidth(), report.getHeight());


            render.setColor(Color.WHITE);
            render.fillRect(50 , 50, report.getWidth() - 100,report.getHeight() - 100 );

            render.setColor(Color.BLACK);
            render.drawLine(80, 500 , 720, 500);
            render.setColor(Color.BLACK);
            render.drawLine(80, 80 , 80, 500);
//            render.drawLine(report.getWidth()/2, report.getHeight()/2, report.getWidth()-10, 10);
//            render.setColor(Color.red);


            try{
                ImageIO.write (report, "PNG", new File("report.png"));
            }catch (IOException ioe){
                ioe.printStackTrace();

//            BufferedImage report = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
//            Graphics2D render = (Graphics2D) report.getGraphics();
//            Random r = new Random();
//            int data[]= new int [report.getWidth()];
//            for(int i = 0; i < data.length; i++){
//                data[i] = 300 + (r.nextInt()%2==0?-1:1) * r.nextInt(32);
//            }
//
//            render.setColor(Color.DARK_GRAY);
//            render.fillRect(0,0,report.getWidth(), report.getHeight());
//            render.setColor(Color.red);
//
//            for (int i = 1; i < data.length; i++)
//                render.drawLine(i-1, data[i-1], i, data[i]);
//
//            try{
//                ImageIO.write (report, "PNG", new File("report.png"));
//            }catch (IOException ioe){
//                ioe.printStackTrace();
            }

        }
}
