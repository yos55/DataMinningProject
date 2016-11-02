package Algo;

import java.io.IOException;
import java.io.PrintWriter;

public class MatrixCreator {

    private static final String[] attributes = {"job", "street", "city", "salary", "language", "hobby"};
    private String[][] matrix;
    int rows;
    int cols;
    static final String fileName = "matrix_init.txt";
    PrintWriter pw;

    public MatrixCreator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j) {
                    matrix[i][j] = "MYSELF";
                    continue;
                }
                if (matrix[j][i] != null) {
                    matrix[i][j] = matrix[j][i];
                } else {
                    matrix[i][j] = insertAttributes();
                }
            }
        }
        writeToFile();
    }

    private String insertAttributes() {
        int sumOfAttribute;
        int attributeRandom;
        boolean randomArray[] = new boolean[attributes.length];
        sumOfAttribute = (int) (Math.random() * 4);
        if (sumOfAttribute == 0) {
            return "NOTHING";
        }
        String s = "";
        while (sumOfAttribute > 0) {
            attributeRandom = (int) (Math.random() * attributes.length);
            if (randomArray[attributeRandom] == true) {
                continue;
            } else {
                randomArray[attributeRandom] = true;
                s += attributes[attributeRandom] + " ";
                sumOfAttribute--;
            }
        }
        return s;
    }

    private void writeToFile() {
        try {
            pw = new PrintWriter(fileName);
            pw.println(rows + "," + cols);
            pw.flush();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    pw.append(matrix[i][j] + ", ");
                    pw.flush();
                }
                pw.println();
                pw.flush();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
    }

    

}
