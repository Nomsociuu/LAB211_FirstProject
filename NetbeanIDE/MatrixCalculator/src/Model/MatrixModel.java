
package Model;


public class MatrixModel {
    private int[][] matrix;

    public MatrixModel(int rows, int columns) {
        matrix = new int[rows][columns];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}