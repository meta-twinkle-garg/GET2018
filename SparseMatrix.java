package SparseMatrix;

/***
 * This class stores a sparse matrix by storing only non zero elements and
 * perform certain operations 1. Transpose 2. Check symmetry 3. Add 2 matrices
 * 4. Multiply 2 matrices
 * 
 * @author Twinkle-Garg
 *
 */
public class SparseMatrix {
    int[][] sparseMatrix;
    int length, rows, columns;

    /***
     * This constructor will accept a 2D matrix as input and stores non zero
     * elements in sparse array
     * 
     * @param inputMatrix
     */
    public SparseMatrix(int[][] inputMatrix) {
        rows = inputMatrix.length;
        columns = inputMatrix[0].length;
        for (int count = 0; count < rows; count++) {
            for (int count2 = 0; count2 < columns; count2++) {
                if (inputMatrix[count][count2] != 0) {
                    length++;
                }
            }
        }

        sparseMatrix = new int[length][3];
        int index = 0;
        for (int count = 0; count < rows; count++) {
            for (int count2 = 0; count2 < columns; count2++) {
                if (inputMatrix[count][count2] != 0) {
                    sparseMatrix[index][0] = count;
                    sparseMatrix[index][1] = count2;
                    sparseMatrix[index++][2] = inputMatrix[count][count2];
                }
            }
        }
    }

    /***
     * This method will perform transpose of given matrix
     * 
     * @return transposed object
     */
    public SparseMatrix transposeMatrix() {
        SparseMatrix transpose;
        int[][] newMatrix = new int[length][3];

        for (int count = 0; count < length; count++) {
            newMatrix[count][0] = sparseMatrix[count][1];
            newMatrix[count][1] = sparseMatrix[count][0];
            newMatrix[count][2] = sparseMatrix[count][2];
        }
        int[][] sparse = new int[columns][rows];

        for (int count = 0; count < length; count++) {

            sparse[newMatrix[count][0]][newMatrix[count][1]] = newMatrix[count][2];
        }
        transpose = new SparseMatrix(sparse);

        return transpose;
    }

    /***
     * This method will check if matrix is symmetric or not
     * 
     * @return true if it satisfies symmetry else false
     */
    public boolean isSymmetric() {
        if (rows != columns) {
            throw new AssertionError("Not a square matrix");
        } else {
            SparseMatrix object1 = this.transposeMatrix();
            int[][] array1 = object1.sparseMatrix;
            for (int count = 0; count < length; count++) {
                if (array1[count][0] == this.sparseMatrix[count][0]
                        && array1[count][1] == this.sparseMatrix[count][1]
                        && array1[count][2] == this.sparseMatrix[count][2]) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    /***
     * This method will add 2 matrices(1 is passed in argument, other by which
     * function is called)
     * 
     * @param object
     * @return object containing addition matrix
     */
    public SparseMatrix add(SparseMatrix object) {
        if (!(object.rows == this.rows && object.columns == this.columns)) {
            throw new AssertionError("Matrices must have same dimensions");
        }
        int[][] newSparse = new int[rows][columns];
        for (int count = 0; count < rows; count++) {
            for (int count2 = 0; count2 < columns; count2++) {
                newSparse[count][count2] = object.getElement(count, count2)
                        + this.getElement(count, count2);
            }
        }
        SparseMatrix additionObject = new SparseMatrix(newSparse);
        return additionObject;

    }

    /***
     * This method will multiply 2 matrices(1 is passed in argument, other by
     * which function is called)
     * 
     * @param object
     * @return object containing multiplication result matrix
     */
    public SparseMatrix multiply(SparseMatrix object) {
        if (this.columns != object.rows) {
            throw new AssertionError("Matrices cant be multiplied");
        }
        int newRow = this.rows;
        int index = this.columns;
        int tempVariable;
        int newColumn = object.columns;
        int[][] newSparse = new int[newRow][newColumn];
        for (int count = 0; count < rows; count++) {
            for (int count2 = 0; count2 < columns; count2++) {
                tempVariable = 0;
                for (int count3 = 0; count3 < index; count3++) {
                    tempVariable += this.getElement(count, count3)
                            * object.getElement(count3, count2);
                }
                newSparse[count][count2] = tempVariable;
            }
        }
        SparseMatrix multiplicationObject = new SparseMatrix(newSparse);
        return multiplicationObject;

    }

    /***
     * This method will return element from sparse matrix specified by row and
     * column If no element is present then it returns 0
     * 
     * @param row
     * @param column
     * @return element
     */
    public int getElement(int row, int column) {
        int element = 0;
        for (int count = 0; count < length; count++) {
            if (sparseMatrix[count][0] == row
                    && sparseMatrix[count][1] == column) {
                element = sparseMatrix[count][2];
            }
        }
        return element;
    }

    /***
     * This method will print the sparse matrix in form of actual matrix
     */
    public void printMatrix() {
        System.out.println("Row\tColumn\tValue");
        for (int count = 0; count < rows; count++) {
            for (int count2 = 0; count2 < columns; count2++) {
                System.out.print("" + getElement(count, count2) + "\t");
            }
            System.out.println();
        }
    }
    public int[][] getMatrix(){
        int[][] actualMatrix=new int[rows][columns];
        for (int count = 0; count < rows; count++) {
            for (int count2 = 0; count2 < columns; count2++) {
                 actualMatrix[count][count2]=getElement(count, count2);
            }
        }
        return actualMatrix;
    }

}
