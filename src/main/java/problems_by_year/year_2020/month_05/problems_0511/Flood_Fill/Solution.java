package problems_by_year.year_2020.month_05.problems_0511.Flood_Fill;

public class Solution {

    public static void main(String[] args) {
//        int[][] image = {{0,0,0},{0,1,1}};
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        Solution solution = new Solution();
        solution.floodFill_A1(image, 1,1, 2);
    }

    int xLen = 0, yLen = 0;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        xLen = image.length-1;
        yLen = image[0].length-1;
        helper(image, sr, sc, newColor, oldColor);
        return image;
    }

    private void helper(int[][] image, int sr, int sc, int newColor, int oldColer) {
        if (sr < 0 || sc < 0 || sr > xLen || sc > yLen)
            return;
        image[sr][sc] = newColor;
        if (sr-1 >= 0 && image[sr-1][sc] == oldColer  && newColor != oldColer) {
            helper(image, sr-1, sc, newColor, oldColer);
        }
        if (sc-1 >= 0 && image[sr][sc-1] == oldColer && newColor != oldColer) {
            helper(image, sr, sc-1, newColor, oldColer);
        }

        if (sr+1 <= xLen && image[sr+1][sc] == oldColer && newColor != oldColer) {
            helper(image, sr+1, sc, newColor, oldColer);
        }
        if (sc+1 <= yLen && image[sr][sc+1] == oldColer && newColor != oldColer) {
            helper(image, sr, sc+1, newColor, oldColer);
        }
        return;
    }



    public int[][] floodFill_A1(int[][] image, int sr, int sc, int newColor) {
        if (image==null || image.length==0 || image[sr][sc]==newColor) return image;
        int srColor= image[sr][sc];
        dfs(image, sr, sc, srColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int srColor,int newColor){
        if (sr<0 || sr >= image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=srColor)
            return;
        if (image[sr][sc]==srColor)
            image[sr][sc]=newColor;
        dfs(image,sr-1,sc,srColor,newColor);
        dfs(image,sr+1,sc,srColor,newColor);
        dfs(image,sr,sc+1,srColor,newColor);
        dfs(image,sr,sc-1,srColor,newColor);
    }
}
