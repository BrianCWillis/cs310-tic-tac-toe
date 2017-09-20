package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
	
    public TicTacToeView(TicTacToeModel model){
        this.model = model;
    }
	
    public void viewModel(){
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

    public void showNextMovePrompt(){
        if(model.isXTurn())
			System.out.print("Player 1 (X) Move:\nEnter the row and column numbers, separated bya  space:");
		else
			System.out.print("Player 2 (O) Move:\nEnter the row and column numbers, separated bya  space:");
    }

    public void showInputError(){
		System.out.println("Selection Invalid!");
    }

    public void showResult(String r){
        System.out.println(r + "!");
    }
}