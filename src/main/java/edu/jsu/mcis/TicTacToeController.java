package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeController {

    private TicTacToeModel model;
    private TicTacToeView view;
    private Scanner keyboard;
	
    public TicTacToeController(TicTacToeModel model, TicTacToeView view){
        this.model = model;
        this.view = view;
        keyboard = new Scanner(System.in);
    }

    public void controlModel(){
        view.showNextMovePrompt();
        
        /* Receive and validate input, which should be read at the keyboard as
           two integers, the row and the column (for example, "1 1" for the
           center square of a 3 x 3 grid).  Make mark if input is valid, or show
           error message using view's showInputError() if input is invalid. */
        int row = keyboard.nextInt();
		int col = keyboard.nextInt();
		if(!model.makeMark(row, col))
			view.showInputError();
    }
}