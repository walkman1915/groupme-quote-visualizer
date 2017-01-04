import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        Date d1 = new Date(04, "March", 2016);
        Date d2 = new Date(04, "March", 2016);
        System.out.println(d1.equals(d2));
    }
}