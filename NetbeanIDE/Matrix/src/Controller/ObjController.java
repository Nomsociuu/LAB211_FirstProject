package Controller;

import DataAccess.ObjDAO;
import Model.Obj;
import View.ObjView;

public class ObjController {

    private ObjView view;
    private ObjDAO dao;
    
    public ObjController(ObjDAO dao, ObjView view) {
        this.dao = dao;
        this.view = view;
    }

    public void A() {
        Obj obj = view.getObjDetails();
        if(dao.AddObj(obj)){
            view.displayMessage("Obj added succesfully");
        }
        else{
            view.displayMessage("Failed to add Obj...");
        }
    }

    public void B() {
        view.displayObj(dao.getObj());
    }

    public void C() {
        int id = view.getObjbyId();
        if(dao.removeObj(id)){
            view.displayMessage("Obj removed succesfully");
        }
        else{
            view.displayMessage("Obj removed failed...");
        }
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
