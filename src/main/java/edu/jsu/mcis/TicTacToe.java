package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {

    private static final int DEFAULT_WIDTH = 3;
    public static void main(String[] args) {
        int width = DEFAULT_WIDTH;
        if(args.length >= 1) {
            try {
                width = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e) {}
        }
        TicTacToeModel model = new TicTacToeModel(width);
        TicTacToeView view = new TicTacToeView(model);
        
        JFrame win = new JFrame("Tic-Tac-Toe");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.add(view);
        win.pack();
        win.setVisible(true);
    }
}