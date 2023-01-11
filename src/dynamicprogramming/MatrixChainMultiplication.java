package dynamicprogramming;

public class MatrixChainMultiplication {
    public static int matrixChainOrder(int[] p) {
        int[][] m = new int[p.length][p.length];
        int[][] s = new int[p.length - 1][p.length];

        // chain length of 1
        for (int k = 0; k < p.length; k++) {
            m[k][k] = 0;
        }

        for (int l = 2; l < p.length; l++) {    // l is chain length
            for (int i = 0; i < p.length - l + 1; i++) {    // chain begins at Ai
                int j = i + l - 1;  // chain ends at Aj
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {   // try Ai:k * Ak+1:j
                    int min = m[i][k] + m[k + 1][j] + p[i] * p[k] * p[j];
                    if (min < m[i][j]) {
                        m[i][j] = min;  // remember this cost
                        s[i][j] = k;    // remember this index
                    }
                }
            }
        }
        return m[0][p.length - 1];
    }

    public static void main(String[] args) {

    }
}
