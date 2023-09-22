import java.util.*;
public class tictactoe {
    static String checkWinner(String[] board,String turn)
	{
		for (int a = 0; a < 8; a++)
        {
			String line = null;
			switch (a) 
            {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
			}
			if (line.equals("XXX"))
				return "X";
			else if (line.equals("OOO"))
				return "O";
		}		
		for (int a = 0; a < 9; a++) 
        {
            String ch=""+(char)(a+49);
			if (board[a].equals(ch)) 
				break;
			else if (a == 8) 
				return "draw";
		}
		System.out.println(turn + "'s turn; enter a slot number to place "+ turn +" in:");
		return null;
	}
    static void printBoard(String[] board)
    {
        System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | "+ board[1] + " | " + board[2]+ " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[3] + " | "+ board[4] + " | " + board[5]+ " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[6] + " | "+ board[7] + " | " + board[8]+ " |");
		System.out.println("|---|---|---|");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String board[]=new String[9];
        for(int i=0;i<9;i++)
        board[i]="";
        for(int i=0;i<9;i++)
        board[i]+=(char)(i+49);
        printBoard(board);
        String turn="X";
        int b=0;
        while(checkWinner(board,turn)==null)
        {
            int a=sc.nextInt();
	    if(a>9)
            {
                System.out.println("Invalid input; re-enter slot number:");
                continue;
            }
            if(board[a-1].equals("X")||board[a-1].equals("O"))
            {
                System.out.println("Slot already taken; re-enter slot number:");
                continue;
            }
            board[a-1]=turn;
            b++;
            if(b%2==0)
            turn="X";
            else
            turn = "O";
            printBoard(board);
        }
        if(checkWinner(board, turn).equals("X"))
            System.out.print("Player X is the winner.");
        if(checkWinner(board, turn).equals("O"))
            System.out.print("Player O is the winner.");
        if(checkWinner(board, turn).equals("draw"))
            System.out.print("The match is draw.");
        sc.close();
    }
}
