import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.io.OptionalDataException;

public class Populus3 extends JPanel
{
    public static void main(String[] args) throws IOException {

        final Populus3 pop = new Populus3();

        JFrame f = new JFrame(); //where I want to plot the graph
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new GraphingData());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);


        JFrame frame = new JFrame("Animation Frame"); //where I'm running animation for another element of the program
        frame.add(pop, BorderLayout.CENTER);
        int graphSize = 0;
        frame.setSize(graphSize, graphSize);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //insert all sort of things

    }


    public void paint(Graphics g)
    {
        super.paint(g);
        paintCell(g, 1);
        Toolkit.getDefaultToolkit().sync(); // necessary for linux users to draw  and animate image correctly
        g.dispose();
    }

    private void paintCell(Graphics g, int i) {
    }


    public void actionPerformed(ActionEvent e) {
        repaint();
    }



    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        OptionalDataException particleType = null;
        for(int i = 0; i < particleType.length; i++)
            paintCell(g, i);  //a method that draws a small circle for the animation panel
    }



    public static class GraphingData extends JPanel {
        int[] data = {
                21, 14, 18, 03, 86, 88, 74, 87, 54, 77,
                61, 55, 48, 60, 49, 36, 38, 27, 20, 18
        };
        final int PAD = 20;

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth();
            int h = getHeight();
            // Draw ordinate.
            g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));

            // Draw abcissa.
            g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
            double xInc = (double)(w - 2*PAD)/(data.length-1);
            double scale = (double)(h - 2*PAD)/getMax();
            // Mark data points.
            g2.setPaint(Color.red);
            for(int i = 0; i < data.length; i++) {
                double x = PAD + i*xInc;
                double y = h - PAD - scale*data[i];
                g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
            }
        }

        private int getMax() {
            int max = -Integer.MAX_VALUE;
            for(int i = 0; i < data.length; i++) {
                if(data[i] > max)
                    max = data[i];
            }
            return max;
        }
    }
}