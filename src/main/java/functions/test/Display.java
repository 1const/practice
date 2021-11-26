package functions.test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends Canvas {
    private JFrame frame;
    public static final int WEIGH = 800;
    public static final int HEIGHT = 800;
    public Display(){
        this.frame = new JFrame();
        Dimension dimension = new Dimension(WEIGH, HEIGHT);
        frame.setPreferredSize(dimension);
    }
    public  void render(){
        BufferStrategy strategy = this.getBufferStrategy();
        if(strategy == null){
            this.createBufferStrategy(3);
            return;
        }
            Graphics graphics = strategy.getDrawGraphics();
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, WEIGH, HEIGHT);
            graphics.dispose();
            strategy.show();
    }
    public static void main(String[] args) {
        Display display = new Display();
        display.frame.add(display);
        display.frame.pack();
        display.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.frame.setLocationRelativeTo(null);
        display.frame.setResizable(false);
        display.frame.setVisible(true);
        while(true)
            display.render();
    }
}
