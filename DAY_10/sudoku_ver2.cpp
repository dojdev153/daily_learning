#include <iostream>
using namespace std;

#define N 9   // Sudoku size

// Function to print the Sudoku board
void printBoard(int grid[N][N]) {
    for (int row = 0; row < N; row++) {
        for (int col = 0; col < N; col++) {
            cout << grid[row][col] << " ";
        }
        cout << endl;
    }
}

// Check if placing num in grid[row][col] is valid
bool isSafe(int grid[N][N], int row, int col, int num) {
    for (int x = 0; x < N; x++)
        if (grid[row][x] == num) return false;  // Row check

    for (int x = 0; x < N; x++)
        if (grid[x][col] == num) return false;  // Column check

    int startRow = row - row % 3;
    int startCol = col - col % 3;
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
            if (grid[i + startRow][j + startCol] == num)
                return false;  // Subgrid check

    return true;
}

// Recursive Sudoku solver
bool solveSudoku(int grid[N][N], int row, int col) {
    if (row == N - 1 && col == N) return true;

    if (col == N) {
        row++;
        col = 0;
    }

    if (grid[row][col] != 0) 
        return solveSudoku(grid, row, col + 1);

    for (int num = 1; num <= 9; num++) {
        if (isSafe(grid, row, col, num)) {
            grid[row][col] = num;

            if (solveSudoku(grid, row, col + 1))
                return true;

            grid[row][col] = 0; // Backtrack
        }
    }

    return false;
}

int main() {
    int grid[N][N];

    cout << "Enter your Sudoku puzzle (9x9 grid)." << endl;
    cout << "Use 0 for empty cells." << endl;

    // Input loop
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> grid[i][j];
        }
    }

    cout << "\nYour Sudoku puzzle:\n";
    printBoard(grid);

    cout << "\nSolving...\n\n";

    if (solveSudoku(grid, 0, 0))
        printBoard(grid);
    else
        cout << "No solution exists!" << endl;

    return 0;
}
