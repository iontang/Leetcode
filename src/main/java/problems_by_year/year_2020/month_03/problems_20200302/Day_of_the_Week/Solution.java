package year.year_2020.month_03.problems_20200302.Day_of_the_Week;

import java.util.Arrays;
import java.util.List;
public class Solution {



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfTheWeek_A1(27,2,2020));

        String[] str = new String[]{"a", "b"};
        List list = Arrays.asList(str);

        list.add("c");
    }


    /**
     *
     * 基姆拉尔森计算公式:
     * Week=(Day + 2*Month + 3*(Month+1）/5 + Year + Year/4 - Year/100 + Year/400) % 7
     * @param day
     * @param month
     * @param year
     * @return
     */
    public String dayOfTheWeek(int day, int month, int year) {
        if (month == 1) {
            month = 13;
            year--;
        }
        if (month == 2) {
            month = 14;
            year--;
        }
        int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;

        String weekstr = "";
        switch (week) {
            case 0:
                weekstr = "Monday";
                break;
            case 1:
                weekstr = "Tuesday";
                break;
            case 2:
                weekstr = "Wednesday";
                break;
            case 3:
                weekstr = "Thursday";
                break;
            case 4:
                weekstr = "Friday";
                break;
            case 5:
                weekstr = "Saturday";
                break;
            case 6:
                weekstr = "Sunday";
                break;
        }
        return weekstr;
    }


    public String dayOfTheWeek_A1(int day, int month, int year) {
        // 2019-12-31 is Tuesday.
        String[] days = {"Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday"};
        int curr = daysFromStart(31, 12, 2019);
        int cnt = daysFromStart(day, month, year);
        return days[((cnt - curr) % 7 + 7) % 7];
    }

    private int daysFromStart(int day, int month, int year) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        for (int i = 1971; i < year; i++) {
            sum += 365;
            if (isLeapYear(i)) {
                sum++;
            }
        }
        for (int i = 1; i < month; i++) {
            sum += months[i - 1];
            if (i == 2 && isLeapYear(year)) {
                sum++;
            }
        }
        sum += day - 1;
        return sum;
    }


    public String dayOfTheWeek_A2(int day, int month, int year) {
        int days = 0;
        for(int i = 1971 ; i< year ; i++){
            days+= daysOfYear(i);
        }

        for(int i = 1; i< month; i++){
            days += daysOfMonth(year, i);
        }

        days+=day;

        String[] week = new String[]{
                "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday","Wednesday"};

        return week[days % 7];
    }

    private boolean isLeapYear(int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private int daysOfYear(int year){
        return isLeapYear(year) ? 366:365;
    }

    private int daysOfMonth(int year,int month){
        if(month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12 ){
            return 31;
        } else if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        return 30;
    }

}
