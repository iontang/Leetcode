package problems_by_year.year_2020.month_05.problems_0504.Check_If_It_Is_a_Straight_Line;

public class Solution {

    public static void main(String[] args) {
        int[][] co = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
        Solution solution = new Solution();
        solution.checkStraightLine(co);
        System.out.println(3d/5d);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        double slope = (double) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        for (int i =  2; i < coordinates.length; i++) {
            double tmp = (double) (coordinates[i][1] - coordinates[i-1][1]) / (coordinates[i][0] - coordinates[i-1][0]);
            if (slope != tmp) {
                return false;
            }
        }
        return true;
    }
}
