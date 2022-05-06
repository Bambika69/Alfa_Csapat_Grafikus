package main.com.teamalfa.blindvirologists.panels;

import javax.swing.*;
import java.awt.*;

public class RoundedOutlinedButton extends JButton {
    public RoundedOutlinedButton(String text) {
        super(text);
        setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
        setForeground(Color.RED);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setMargin(new Insets(15, 20, 15, 20));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.BLACK);
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
        g2.setPaint(Color.RED);
        g2.drawRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 30, 30);
        g2.dispose();
        super.paint(g);
    }
}
