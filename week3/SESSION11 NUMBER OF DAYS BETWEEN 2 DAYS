class Solution {
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1900(date1) - daysFrom1900(date2));
    }

    private int daysFrom1900(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int totalDays = 0;

        // 1. Add days for full years from 1900 to year - 1
        for (int y = 1900; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        // 2. Add days for full months in the target year
        for (int m = 1; m < month; m++) {
            totalDays += DAYS_IN_MONTH[m];
            if (m == 2 && isLeapYear(year)) {
                totalDays += 1;
            }
        }

        // 3. Add days of the target month
        totalDays += day;

        return totalDays;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
