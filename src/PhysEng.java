import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;




public class PhysEng extends JPanel {




    int width = 512;
    int height = 512;
    int[] ARGB;


    static PhysEng me = new PhysEng();
    BufferedImage rgb_image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    ArrayList<Hitbox> staticBoxes = new ArrayList<>();
    ArrayList<Hitbox> dynamicBoxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.print("Perlin.main( ");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + ", ");
        }
        System.out.println(")");
        me = new PhysEng();
        int w = me.width;
        int h = me.height;
        me.init(w, h);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(w, h);
        frame.add(me);
        frame.setVisible(true);


        Thread animThread = new Thread() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5);
                        me.update();
                        frame.repaint();
                    } catch (Exception e) {




                    }
                }
            }
        };
        animThread.start();


        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }


            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {




                }
            }


            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE:


                        break;
                }
            }
        });




    }


    public void init(int w, int h) {
        width = w;
        height = h;
        ARGB = new int[width * height];
        int i = 0;
        for (int y = 0; y < height; y++) {
            int red = (y * 255) / (height - 1);
            for (int x = 0; x < width; x++) {
                int green = (x * 255) / (width - 1);
                int blue = 128;
                ARGB[i++] = (red << 16) | (green << 8) | blue;
            }
        }
        dynamicBoxes.clear();
        staticBoxes.clear();
        staticBoxes.add(new Hitbox (0.5, 0.9, 1, 0.1, 0, 0));
        dynamicBoxes.add(new Hitbox(0.5, 0.5, 0.1, 0.1, 0, 0));
    }


    public static PhysEng get() {
        return me;
    }

    public void drawHitBox (Hitbox hb, Graphics g) {
        g.drawRect((int)((hb.x - (hb.w/2)) * me.width), (int)((hb.y - (hb.h / 2)) * me.height), (int)(hb.w * me.width), (int)(hb.h * me.height));
    }

    public void update () {
        dynamicBoxes.get(0).update(0, 0.0001, 0.5);
        staticBoxes.get(0).collBounce(dynamicBoxes.get(0));
    }

    public void paint (Graphics g) {


        g.setColor(Color.white);
        g.clearRect(1, 0, this.getWidth(), this.getHeight());


        g.setColor(Color.black);
        if (staticBoxes.get(0).collide(staticBoxes.get(0)) != 0) {
            g.setColor(Color.red);
        }
        drawHitBox (staticBoxes.get(0), g);
        drawHitBox (dynamicBoxes.get(0), g);

        //rgb_image.setRGB(0, 0, width, height, ARGB, 0, width);
        //g.drawImage(rgb_image, 0, 0, null);
    }




}
