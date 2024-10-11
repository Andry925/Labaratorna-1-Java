import java.util.Scanner;
import java.util.InputMismatchException;

class MatrixOperation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Enter the number of matrix rows");
            int matrixRow = scan.nextInt();
            if (matrixRow <= 0) {
                throw new IllegalArgumentException("Number of rows must be a positive number.");
            }

            System.out.println("Enter the number of matrix columns");
            int matrixCol = scan.nextInt();
            if (matrixCol <= 0) {
                throw new IllegalArgumentException("Number of columns must be a positive number.");
            }


            float[][] matrix = new float[matrixRow][matrixCol];
            enterMatrixData(scan, matrix, matrixRow, matrixCol);
            float[][] transformedMatrix = transposeMatrix(matrix, matrixRow, matrixCol);

            printMatrix(transformedMatrix, matrixRow, matrixCol);
            float average = findAverageSumMatrix(transformedMatrix, matrixRow, matrixCol);
            System.out.println("The average sum of matrix elements is: " + average);
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
        }
        catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scan.close();
        }
    }

    public static void enterMatrixData(Scanner scan, float[][] matrix, int matrixRow, int matrixCol) {
        System.out.println("Enter Matrix Data");
        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixCol; j++) {
                System.out.println("Enter element");
                matrix[i][j] = scan.nextFloat();
                
            }
        }
    }

    public static float[][] transposeMatrix(float[][] matrix, int matrixRow, int matrixCol) {
        float[][] transposedMatrix = new float[matrixCol][matrixRow];
        
        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixCol; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        
        return transposedMatrix;
    }

 
    public static void printMatrix(float[][] matrix, int matrixRow, int matrixCol) {
        System.out.println("Your Matrix is: ");
        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixCol; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static float findAverageSumMatrix(float[][] matrix, int matrixRow, int matrixCol) {
        int elementCount = matrixRow * matrixCol;
        float matrixSum = 0;
        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixCol; j++) {
                matrixSum += matrix[i][j];
            }
        }
        return matrixSum / elementCount;

    }
}