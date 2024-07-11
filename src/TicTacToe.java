public class TicTacToe {

    public static void main(String[] args) {
        
        Field[][] ticTacToeBoard = new Field[3][3];
        initializeGame(ticTacToeBoard);

        char winner = ' ';
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (winner == ' ') {
            drawGameBoard(ticTacToeBoard); // desenha o tabuleiro na tela
            winner = checkForWinner(ticTacToeBoard); // verifica se há um vencedor
            if (winner != ' ') break;

            int[] move = makeMove(scanner, 'X'); // obtém a jogada do jogador
            if (makeValidMove(ticTacToeBoard, move, 'X')) { // faz a jogada
                drawGameBoard(ticTacToeBoard); // desenha o tabuleiro na tela
                winner = checkForWinner(ticTacToeBoard); // verifica se há um vencedor
                if (winner != ' ') break;

                move = makeMove(scanner, 'O'); // obtém a jogada do jogador
                makeValidMove(ticTacToeBoard, move, 'O'); // faz a jogada
            }
        }

        System.out.println("O vencedor é: " + winner);
    }

    public static void initializeGame(Field[][] ticTacToeBoard) { // inicializa o tabuleiro
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                ticTacToeBoard[row][col] = new Field();
            }
        }
    }

    public static void drawGameBoard(Field[][] ticTacToeBoard) { // desenha o tabuleiro
        System.out.println("  0 1 2"); // Imprime os índices das colunas
        for (int row = 0; row < 3; row++) { // loop através de cada linha do tabuleiro
            System.out.print(row + " "); // Imprime o índice da linha
            for (int col = 0; col < 3; col++) { // loop através de cada coluna do tabuleiro
                System.out.print(ticTacToeBoard[row][col].getSimbolo());
                if (col < 2) System.out.print("|"); // imprime um separador de coluna '|' se não for a última coluna
            }
            System.out.println(); // pula para a próxima linha após imprimir uma linha completa do tabuleiro
            if (row < 2) System.out.println("  -----"); // imprime uma linha separadora '-----' se não for a última linha
        }
    }
    


    public static boolean makeValidMove(Field[][] ticTacToeBoard, int[] move, char currentSymbol) { // faz a jogada
        int row = move[0];
        int col = move[1];
        if (ticTacToeBoard[row][col].getSimbolo() == ' ') {
            ticTacToeBoard[row][col].setSimbolo(currentSymbol);
            return true;
        }
        return false;
    }

    public static char checkForWinner(Field[][] ticTacToeBoard) { // verifica se há um vencedor
        // Verificar linhas
        for (int row = 0; row < 3; row++) {
            if (ticTacToeBoard[row][0].getSimbolo() != ' ' &&
                ticTacToeBoard[row][0].getSimbolo() == ticTacToeBoard[row][1].getSimbolo() &&
                ticTacToeBoard[row][1].getSimbolo() == ticTacToeBoard[row][2].getSimbolo()) {
                return ticTacToeBoard[row][0].getSimbolo();
            }
        }
        // Verificar colunas
        for (int col = 0; col < 3; col++) {
            if (ticTacToeBoard[0][col].getSimbolo() != ' ' &&
                ticTacToeBoard[0][col].getSimbolo() == ticTacToeBoard[1][col].getSimbolo() &&
                ticTacToeBoard[1][col].getSimbolo() == ticTacToeBoard[2][col].getSimbolo()) {
                return ticTacToeBoard[0][col].getSimbolo();
            }
        }
        // Verificar diagonais
        if (ticTacToeBoard[0][0].getSimbolo() != ' ' &&
            ticTacToeBoard[0][0].getSimbolo() == ticTacToeBoard[1][1].getSimbolo() &&
            ticTacToeBoard[1][1].getSimbolo() == ticTacToeBoard[2][2].getSimbolo()) {
            return ticTacToeBoard[0][0].getSimbolo();
        }
        if (ticTacToeBoard[2][0].getSimbolo() != ' ' &&
            ticTacToeBoard[2][0].getSimbolo() == ticTacToeBoard[1][1].getSimbolo() &&
            ticTacToeBoard[1][1].getSimbolo() == ticTacToeBoard[0][2].getSimbolo()) {
            return ticTacToeBoard[2][0].getSimbolo();
        }
        return ' '; // Retorna ' ' se não houver vencedor
    }

    public static int[] makeMove(java.util.Scanner scanner, char currentSymbol) {
        System.out.println("Jogador " + currentSymbol + ", faça sua jogada (linha e coluna): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }
}
