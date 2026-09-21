class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int row = 0;row < board.length ;row++){
            for(int col = 0;col < board[0].length;col++){
                char c = board[row][col];
                if(c == '.'){
                    continue;
                }
                String str = c+"row"+row;
                if(!set.add(str)){
                    return false;x
                }
                String str1 = c+"col"+col;
                if(!set.add(str1)){
                    return false;
                }
                String str2 = c + "" + row/3 + "-" + col/3;
                if(!set.add(str2)){
                    return false;
                }

            }
        }
        return true;
    }
}