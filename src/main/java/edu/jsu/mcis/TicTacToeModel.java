package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    public enum Mark {
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
    };
    
    public enum Result {
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
    };
    
    private Mark[][] grid;
    private boolean xTurn;
    private int width;
    
    public TicTacToeModel() {
        this(DEFAULT_WIDTH);      
    }
    
    public TicTacToeModel(int width) {
		this.width = width;
        xTurn = true;
        grid = new Mark[width][width];
		for(int i=0; i<width; i++)
			for(int j=0; j<width; j++)
				grid[i][j] = Mark.EMPTY;
    }
	
    public boolean makeMark(int row, int col) {
        if(isValidSquare(row, col) && !isSquareMarked(row, col)){
			if(xTurn){
				grid[row][col] = Mark.X;
				xTurn = false;
			}
			else{
				grid[row][col] = Mark.O;
				xTurn = true;
			}
			return true;
		}
		else{
			System.out.println("Selection Invalid!");   
			return false;
		}
    }
	
    private boolean isValidSquare(int row, int col) {
        return (row < width && col < width
			&& row >= 0 && col >= 0);
    }
	
    private boolean isSquareMarked(int row, int col) {
        return (grid[row][col] != Mark.EMPTY);
    }
	
    public Mark getMark(int row, int col) {
        return grid[row][col];
    }
	
    public Result getResult() {
		if(isMarkWin(Mark.X)){
			return Result.X;
		}
		if(isMarkWin(Mark.O)){
			return Result.O;
		}
		if(isTie())
			return Result.TIE;
		
		return Result.NONE;
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */

        return false; /* remove this line! */

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        for(int i=0; i<width; i++){
			for(int j=0; j<width; j++){
				if(grid[i][j] == Mark.EMPTY)
					return false;
			}
		}
        return true;
    }

    public boolean isGameover(){
        return Result.NONE != getResult();
    }

    public boolean isXTurn(){
        return xTurn;
    }

    public int getWidth(){
        return width;
    }
}