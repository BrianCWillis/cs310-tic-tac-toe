package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
	
    public TicTacToeView(TicTacToeModel model){
        this.model = model;
    }
	
    public void viewModel(){
        
        /* Print the board to the console (see examples) */
        
        String output = "\n  012\n";
		
		String line = "";
		for(int i=0; i<model.getWidth(); i++){
			line = "\n" + Integer.toString(i) + " ";
			for(int j=0; j<model.getWidth(); j++){
				if(model.getMark(i, j) == TicTacToeModel.Mark.EMPTY)
					line += "-";
				else
					line += model.getMark(i, j).toString();
			}
			output += line;
			line = "";
		}
		System.out.print(output + "\n\n\n\n");
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}