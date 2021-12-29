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
    private final Mouse mouse;
    private MyPolygon polygon;
    private Wall wall;

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
        // wall.render(graphics);
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
        this.wall= new Wall(new MyPolygon(
                new MyPoint(200, -300, 0),
                new MyPoint(-180, -280, 0),
                new MyPoint(-180, -280, 200),
                new MyPoint(200, -300, 200)
        ));
    }

    int initialY;
    int initialX;

    private void update() {
        int y = mouse.getMouseX();
        int x = mouse.getMouseY();
        if (mouse.getMouseB() == 1) {
            int difY = y - initialY;
            int difX = x - initialX;
            cube.rotate(0, -difX / 2.0, difY / 2.0, cube.vector);
        }
        if (mouse.wheelRotation == -1) {
            cube.zoom(1.01);
        }
        else if (mouse.wheelRotation == 1){
            cube.zoom(0.99);
        }
        if (mouse.getMouseB() == 3 ) {
            int difY = y - initialY;
            int difX = x - initialX;
            cube.bias(difX, difY);
        }
        initialY = y;
        initialX = x;
        mouse.wheelRotation = 0;
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
