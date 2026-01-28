package arrays;

public class MultiDimension {
    public MultiDimension() {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        new MultiDimension();
    }
}