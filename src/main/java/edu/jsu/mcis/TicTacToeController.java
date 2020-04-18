package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToeController implements ActionListener{

    public final TicTacToeModel model;
    public final TicTacToeView view;
	
	public boolean gameWon = false;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);
        
    }
	
	public String getMarkAsString(int row, int col) {        
        return (model.getMark(row, col).toString());        
    }

    public TicTacToeView getView() {        
        return view;        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
            JButton button = (JButton)event.getSource();
            String buttonIDWithName = button.getName();
            String buttonID = buttonIDWithName.replaceFirst("Square", "");
            String[] rowColString = buttonID.split("");
            int row = Integer.parseInt(rowColString[0]);
            int col = Integer.parseInt(rowColString[1]);
            
            model.makeMark(row, col);
            view.updateSquares();
            if (model.isGameover()){
                gameWon = true;
                view.disableSquares();
                view.showResult(model.getResult().toString());
            }
        
    }

}
