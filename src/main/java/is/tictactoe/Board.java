package is.ru.tictactoe;


public class Board
{

	char[][] board;
	private final int constSize = 3;

	public Board() {
		board = new char[constSize][constSize];
		int count = 1;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = (char) count;
				count++;
			}
		}
	}

	public void print() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void changeBoard(Symbol symbol, int position)
	{
		int count = 1;
		char player = getSymbol(symbol);

		for(int i = 0; i < constSize; i++)
		{
			for(int j = 0; j < constSize; j++)
			{
				if(position == count)
				{
					board[i][j] = player;
					return;
				}
				count++;
			}
		}
	}

	public boolean checkWinner(Player p)
	{
		int counter = 0;
		char player = getSymbol(p.getSymbol());
		for(int i = 0; i < constSize; i++)
		{
			for(int j = 0; j < constSize; j++)
			{
				if (board[i][j] == player){ counter++; }
				else { counter = 0; }
				if(counter == constSize) return true;
			}
		}
		return false;
	}

	private char getSymbol(Symbol symbol){
		if (symbol == Symbol.CIRCLE) {
			return 'O';
		}
		else {
			return 'X';
		}
	}
}
