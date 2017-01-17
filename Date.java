/** 
 * @Author Walker Powell
 * @version 1.1
 *
 * A class for storing Date objects with a specific day, month, and year.
 */

public class Date {
    public int day;
    public int month;
    public int year;

    public Date(int day, String month, int year) {
        this.day = day;
        this.year = year;

        switch(month) {
            case "January":
                this.month = 1;
                break;
            case "February":
                this.month = 2;
                break;
            case "March":
                this.month = 3;
                break;
            case "April":
                this.month = 4;
                break;
            case "May":
                this.month = 5;
                break;
            case "June":
                this.month = 6;
                break;
            case "July":
                this.month = 7;
                break;
            case "August":
                this.month = 8;
                break;
            case "September":
                this.month = 9;
                break;
            case "October":
                this.month = 10;
                break;
            case "November":
                this.month = 11;
                break;
            case "December":
                this.month = 12;
                break;
            default:
                break;
        }

        if (year == 2015) {
            this.month = -1;
        }
    }

    public String toString() {
        return String.format("%d/%s/%d", day, month, year);
    }

    public boolean equals(Object other) {
        //System.out.println(day + " " + other.day);
        return (day == ((Date) other).day && month == ((Date) other).month && year == ((Date) other).year);
    }

    public int hashCode() {
        return year*(79^day);
    }
}