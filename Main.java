import java.util.Scanner;

class MatrixOperation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter The Number Of Matrix Rows");
        int matrixRow = scan.nextInt();

        System.out.println("Enter The Number Of Matrix Columns");
        int matrixCol = scan.nextInt();

        System.out.println("Enter the constant to multiply matrix by");
        float matrixMultiply = scan.nextFloat();

        float[][] matrix = new float[matrixRow][matrixCol];
        enterMatrixData(scan, matrix, matrixRow, matrixCol, matrixMultiply);

        printMatrix(matrix, matrixRow, matrixCol);
    }

    public static void enterMatrixData(Scanner scan, float[][] matrix, int matrixRow, int matrixCol, float matrixMultiply) {
        System.out.println("Enter Matrix Data");

        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixCol; j++) {
                matrix[i][j] = scan.nextFloat();
                matrix[i][j] *= matrixMultiply;
            }
        }
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
}
