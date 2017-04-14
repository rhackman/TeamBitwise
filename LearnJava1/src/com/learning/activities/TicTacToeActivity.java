package com.learning.activities;

import com.learning.CommonUtilities;
import com.learning.IActivity;

/**
 * Created by rconroy on 4/13/2017.
 */
public class TicTacToeActivity implements IActivity {
    public String title = "Tic Tac Toe";
    public String description = "Tic Tac Toe Game";
    private char[][] ticTacToeBoard;
    private char currentPlayerMark;

    @Override
    public void run()
    {
        System.out.println("Tic Tac Toe Activity Loaded Successfully");

        ticTacToeBoard = new char[3][3];
        setupTicTacToeBoard();

        while (!BoardIsFull() && !winnerDetected())
        {
            printCurrentBoard();
            System.out.println();
            System.out.println();
            String userInput = CommonUtilities.GetUserInput("It's player " + currentPlayerMark + "'s turn. Where would you like to go? (x y)");
            String[] userInputSplit = userInput.split(" ");
            if (IsUserInputValid(userInputSplit))
            {
                fillBoardCell(Integer.parseInt(userInputSplit[0]), Integer.parseInt(userInputSplit[1]));
            }
            else
            {
                System.out.println("Input string was not valid");
            }
        }

        System.out.println((winnerDetected() ? "We have a Winner!" : "We have a Draw!") + " The final board was:");
        printCurrentBoard();
        System.out.println("Tic Tac Toe Activity Complete!");
    }

    public void setupTicTacToeBoard()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column++)
            {
                ticTacToeBoard[row][column] = '-';
            }
        }
        currentPlayerMark = 'X';
    }

    public boolean IsUserInputValid(String[] userInput)
    {
        return userInput.length == 2 && Integer.parseInt(userInput[0]) >= 0 && Integer.parseInt(userInput[0]) < 3  && Integer.parseInt(userInput[1]) >= 0 && Integer.parseInt(userInput[1]) < 3;
    }

    public void printCurrentBoard()
    {
        System.out.println("-------------");
        for (int rowBoard = 0; rowBoard < 3; rowBoard++)
        {
            System.out.print("| ");
            for (int columnBoard = 0; columnBoard < 3; columnBoard++)
            {
                System.out.print(ticTacToeBoard[rowBoard][columnBoard] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public void fillBoardCell(int row, int column)
    {
        if (ticTacToeBoard[row][column] == '-')
        {
            ticTacToeBoard[row][column] = currentPlayerMark;
            changePlayer();
        }
        else
        {
            System.out.println("This spot is currently occupied by player " + ticTacToeBoard[row][column]);
        }
    }

    public void changePlayer()
    {
        if (currentPlayerMark == 'X')
        {
            currentPlayerMark = 'O';
        }
        else
        {
            currentPlayerMark = 'X';
        }
    }

    public boolean BoardIsFull()
    {
        boolean isBoardFull = true;
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column++)
            {
                if (ticTacToeBoard[row][column] == '-')
                {
                    isBoardFull = false;
                }
            }
        }

        return isBoardFull;
    }

    public boolean winnerDetected()
    {
        return (checkColumns() || checkRows() || checkDiagonals());
    }

    public boolean checkSequence(char first, char second, char third)
    {
        return (first == second && second == third && first != '-') ? true : false;
    }

    public boolean checkColumns()
    {
        for (int row = 0; row < 3; row++)
        {
            if (checkSequence(ticTacToeBoard[row][0], ticTacToeBoard[row][1], ticTacToeBoard[row][2]))
            {
                return true;
            }
        }
        return false;
    }

    public boolean checkRows()
    {
        for (int column = 0; column < 3; column++)
        {
            if (checkSequence(ticTacToeBoard[0][column], ticTacToeBoard[1][column], ticTacToeBoard[2][column]))
            {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonals()
    {
        return checkSequence(ticTacToeBoard[0][0], ticTacToeBoard[1][1], ticTacToeBoard[2][2]) || checkSequence(ticTacToeBoard[0][2], ticTacToeBoard[1][1], ticTacToeBoard[2][0]);
    }
}
