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
		if(width >= 3)
			this.width = width;
		else{
			System.out.println("X cannot lose on anything smaller than a standard grid.\nDefaulting to width of 3.");
			this.width = DEFAULT_WIDTH;
		}
        xTurn = true;
        grid = new Mark[width][width];
		for(int i=0; i<width; i++)
			for(int j=0; j<width; j++)
				grid[i][j] = Mark.EMPTY;
    }
	
    public boolean makeMark(int row, int col) {
        if(isValidSquare(row, col) && isSquareMarked(row, col)){
			if(xTurn)
				grid[row][col] = Mark.X;
			else
				grid[row][col] = Mark.O;
			return true;
		}
		else{
			System.out.println("Selection Invalid!");   
			return false;
		}
    }
	
    private boolean isValidSquare(int row, int col) {
        return (row < width && col < width);
    }
	
    private boolean isSquareMarked(int row, int col) {
        return (grid[row][col] != Mark.EMPTY);
    }
	
    public Mark getMark(int row, int col) {
        return grid[row][col];
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        for(int i=0; i<width; i++){
			for(int j=0; j<width; j++){
				if(isMarkWin(grid[i][j])){
					if(grid[i][j] == Mark.X)
						return Result.X;
					else
						return Result.O;
				}
			}
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