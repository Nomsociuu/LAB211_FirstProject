package Common;

public class Algo {

    Validate vali;
//    ArrayList<Worker> list_w;
//    ArrayList<SalaryHistory> list_s;
//    Worker w;

    public Algo(Validate vali) {
        this.vali = vali;
//        list_w = new ArrayList<>();
//        list_s = new ArrayList<>();
    }

    private void displayMatrix(int[][] matrix1, String operation, int[][] matrix2, int[][] result) {
        System.out.println("----------Result----------");
        view.displayMatrix(matrix1);
        System.out.println(operation);
        view.displayMatrix(matrix2);
        System.out.println("=");
        view.displayMatrix(result);
        System.out.println();
    }

    private int[][] additionMatrix (int[][] matrix1, int[][]matrix2) {
//        •	Input:
//	matrix1: The first matrix.
//	matrix2: The second matrix.
//•	Return values: The result.

        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    private int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
//        •	Input:
//	matrix1: The first matrix.
//	matrix2: The second matrix.
//•	Return values: The result.

        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    private int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
//        •	Input:
//	matrix1: The first matrix.
//	matrix2: The second matrix.
//•	Return values: The result.

        int rows = matrix1.length;
        int columns = matrix2[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

}
