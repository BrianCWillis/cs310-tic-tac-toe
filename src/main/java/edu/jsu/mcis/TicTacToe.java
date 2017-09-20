package edu.jsu.mcis;

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
        TicTacToeController controller = new TicTacToeController(model, view);
        
        while (!model.isGameover()){
            view.viewModel();
            controller.controlModel();
        }
        
        view.viewModel();
        view.showResult(model.getResult().toString());
    }
}