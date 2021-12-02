package functions.test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends Canvas implements Runnable {
    private final JFrame frame;
    private boolean running = true;
    public static final int WEIGH = 800;
    public static final int HEIGHT = 800;
    private cube cube;
    private Mouse mouse;
    private MyPolygon polygon;

    public Display() {
        this.frame = new JFrame();
        Dimension dimension = new Dimension(WEIGH, HEIGHT);
        frame.setPreferredSize(dimension);
        this.mouse = new Mouse();
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
    }

    public void render() {
        BufferStrategy strategy = this.getBufferStrategy();
        if (strategy == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = strategy.getDrawGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, WEIGH, HEIGHT);
        cube.render(graphics);
        //polygon.render(graphics);
        graphics.dispose();
        strategy.show();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60;
        double delta = 0;
        int frames = 0;
        init();
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            render();
        }
    }

    public void init() {
        this.cube = new cube(150);
        //this.polygon = new MyPolygon(
        //      new MyPoint(0, 0, 0),
        //      new MyPoint(0, 100, 0),
        //      new MyPoint(0, 100, 100),
        //      new MyPoint(0, 0, 100)
        //     );
    }

    int x2;
    int y2;

    private void update() {
       //  int x = mouse.getMouseX();
      //    int y = mouse.getMouseY();
      //   if (mouse.mouseISDragged) {
       //      int newX = x - x2;
      //     int newY = y - y2;
      //  cube.rotate(1, 1, 0);
             cube.rotate(1, 1, 1);

       //   }
      //    mouse.mouseISDragged = false;
      //    x2 = mouse.getMouseX();
       //   y2 = mouse.getMouseY();
    }

    public void stop() {
        running = false;
    }

    public static void main(String[] args) {
        Display display = new Display();
        display.frame.add(display);
        display.frame.pack();
        display.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.frame.setLocationRelativeTo(null);
        display.frame.setResizable(false);
        display.frame.setVisible(true);
        display.run();
    }
}
