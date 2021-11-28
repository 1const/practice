package functions.test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends Canvas implements Runnable {
    private final JFrame frame;
    private boolean running = true;
    public static final int WEIGH = 800;
    public static final int HEIGHT = 800;
    private MyPolygon myPolygon;
    public Display() {
        this.frame = new JFrame();
        Dimension dimension = new Dimension(WEIGH, HEIGHT);
        frame.setPreferredSize(dimension);
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
        myPolygon.render(graphics);
        graphics.dispose();
        strategy.show();
    }

    @Override
    public void run() {
        while (running) {
            init();
            update();
            render();
        }
    }
    public void init(){
        this.myPolygon = new MyPolygon(
                new MyPoint(0, 0, 0),
                new MyPoint(0, 100, 0),
                new MyPoint(0, 0, 100),
                new MyPoint(100, 0, 0)
        );
    }
    private void update() {
        myPolygon.rotate(20,0,0);
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
