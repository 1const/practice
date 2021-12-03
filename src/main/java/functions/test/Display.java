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
        this.addMouseWheelListener(mouse);
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
    }

    int initialY;
    int initialX;
    private void update() {
        int y = mouse.getMouseX();
        int x = mouse.getMouseY();
            if (mouse.getMouseB() == 1) {
                int difY = y - initialY;
                int difX = x - initialX;
                cube.rotate(0, -difX/2.0, difY/2.0);
            }
             initialY = y;
             initialX = x;
         //  cube.zoom(mouse.wheelRotation, 1);
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
