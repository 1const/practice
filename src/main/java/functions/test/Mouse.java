package functions.test;

import java.awt.event.*;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
    private int mouseX;
    private int mouseY;
    private int mouseB;
    public int wheelRotation;
    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public int getMouseB() {
        return mouseB;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.mouseX =  e.getX();
        this.mouseY =  e.getY();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseB = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseB = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.mouseX =  e.getX();
        this.mouseY =  e.getY();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        wheelRotation = e.getWheelRotation();
    }
}
