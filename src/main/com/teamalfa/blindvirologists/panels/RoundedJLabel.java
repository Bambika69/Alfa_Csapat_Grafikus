package main.com.teamalfa.blindvirologists.panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoundedJLabel extends JLabel {
    public RoundedJLabel() {
        setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
        setForeground(Color.RED);
        setOpaque(false);
        setBorder(new EmptyBorder(12, 10, 12, 10));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.BLACK);
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
        g2.dispose();
        super.paint(g);
    }
}
