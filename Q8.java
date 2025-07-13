public class Q8 {
    public static void main(String[] args) {
        //System.out.println("Hello, World!");
        int[][] matrix = {
            {0, 3, 3},
            {3, 3, 3},
            {3, 3, 3},
            {3, 3, 0}
        };
        Q8 q8 = new Q8();
        q8.zeroMatrix(matrix);
        // Print Results
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    //Set entire column to zero
    public void nullifyCol (int[][] matrix, int col){
      for (int row = 0; row < matrix.length; row++){
        matrix[row][col]=0;
      }
    }
    //Set entire row to zero
    public void nullifyRow (int[][] matrix, int row){
      for (int col = 0; col < matrix[0].length; col++){
        matrix[row][col]=0;
      }
    }
  
    public int [][] zeroMatrix(int[][] matrix) {
        boolean row1_has_zero = false;
        boolean col1_has_zero = false;

        //Check if first row has zeroes
        for (int row = 0; row < matrix.length; row++){
          if (matrix[row][0]==0){
            row1_has_zero = true;
          }
        }
        //Check if first column has zeroes
        for (int col = 0; col < matrix[0].length; col++){
          if (matrix[0][col]==0){
            col1_has_zero = true;
          }
        }
        //Check if remaining cells have zeroes
        for(int row=1; row < matrix.length; row++){
          for(int col=1; col<matrix[row].length; col++){
           if (matrix[row][col] == 0) { //Set corresponding 1st col n row cells to zero 
             matrix[row][0]=0;
             matrix[0][col]=0;
           }
          }
        }
        //Read through 1st row n set entire row to zero
        for(int row=1; row<matrix.length; row++){
          if (matrix[row][0] == 0) {
            nullifyRow(matrix, row);
          }
        }
        //Read through 1st column n set columns to zero
        for(int col=1; col<matrix[0].length; col++){
          if (matrix[0][col] == 0) {
            nullifyRow(matrix, col);
          }
        }
        //nullify 1st row if it contained 0
        if (row1_has_zero){
          nullifyRow(matrix, 0);
        }
        //nullify 1st col if it contained 0
        if (col1_has_zero){
          nullifyCol(matrix, 0);
        }
        return matrix;
    }
}
