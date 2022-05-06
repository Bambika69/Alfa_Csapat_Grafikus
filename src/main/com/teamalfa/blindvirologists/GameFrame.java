package main.com.teamalfa.blindvirologists;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {
    GameFrame(int numberOfPlayers){
        this.setTitle("BV");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700,700);
        ImageIcon imageIcon = new ImageIcon("logo.png");
        this.setIconImage(imageIcon.getImage());
        this.getContentPane().setBackground(new Color(0,0,0));

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}