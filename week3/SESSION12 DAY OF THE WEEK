class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalDays = 0;

        // 1. Add days for all past years starting from 1971
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // 2. Add days for past months in the target year
        for (int i = 0; i < month - 1; i++) {
            if (i == 1 && isLeapYear(year)) { // February in a leap year
                totalDays += 29;
            } else {
                totalDays += daysInMonth[i];
            }
        }

        // 3. Add remaining days of current month
        totalDays += (day - 1);

        // January 1, 1971 was a Friday (index 5 in our days array)
        return days[(5 + totalDays) % 7];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
