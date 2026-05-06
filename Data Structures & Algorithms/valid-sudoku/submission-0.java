/*
    - manter um hash set com os elementos visitados
    - se o set contem o elemento, return false
    - buscar elementos repetidos em cada linha
    - reset set
    - buscar elementos repetidos em cada coluna
    - reset set
    - buscar elementos repetidos em cada quadrante
    - return true 
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        var length = 9;
        var groupLength = 3;
        HashSet<Character> set;

        for (int i = 0; i < length; i++) {

            // Check lines
            set = new HashSet<>(9);
            for (int j = 0; j < length; j++) {
                var digit = board[i][j];
                if (digit == '.') {
                    continue;
                }
                if (set.contains(digit)) {
                    return false;
                }
                set.add(digit);
            }

            // Check columns
            set = new HashSet<>(9);
            for (int j = 0; j < length; j++) {
                var digit = board[j][i];
                if (digit == '.') {
                    continue;
                }
                if (set.contains(digit)) {
                    return false;
                }
                set.add(digit);
            }
        }

        // Check groups
        for (int i = 0; i < groupLength; i++) {
            for (int j = 0; j < groupLength; j++) {
                set = new HashSet<>(9);
                for (int k = 0; k < groupLength; k++) {
                    for (int l = 0; l < groupLength; l++) {
                        var colPosition = k + (j * 3);
                        var rowPosition = l + (i * 3);
                        var digit = board[colPosition][rowPosition];
                        if (digit == '.') {
                            continue;
                        }
                        if (set.contains(digit)) {
                            return false;
                        }
                        set.add(digit);
                    }
                }
            }
        }

        return true;
    }
}
