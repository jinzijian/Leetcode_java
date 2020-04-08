//思路
//先对角线（左上右下为轴）翻转
//再中点翻转
class Solution {
    //只遍历一半 每次交换两个
    //注意利用tmp
    public void rotate(int[][] matrix) {
        //对角线翻转
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            //注意是 j = i+1
            for(int j = i + 1; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //左右翻转
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n / 2; j++){
                int tmp = matrix[i][j];
                //注意是 n - 1 - j；
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }
}