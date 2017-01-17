import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

/**
 * @author Walker Powell
 * @version 1.0
 *
 * This program takes a text file of GroupMe messages, formatted as below, and
 * and outputs all the dates to the terminal. This class was used to test
 * parsing the messages and using the Date class.
 * message format: DayOfWeek, Day Month Year: Message
 * example:         Saturday, 05 March 2016: "I feel like I'm going to regret everything I said" - Jason
 */ 

public class DateGrapher {
    public static void main(String[] args) {
        Scanner scanner;
        Map<Date, Integer> dateMap = new HashMap<>();

        try {
            File file = new File("jason.txt");
            scanner = new Scanner(file);

            //System.out.println(scanner.nextLine());
            //System.out.println(scanner.hasNext());

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] words = line.split(" ");
                Date date = new Date(Integer.parseInt(words[1]), words[2], Integer.parseInt(words[3].substring(0, words[3].length() - 1)));

                //System.out.println(date);

                if (dateMap.putIfAbsent(date, 1) != null) {
                    dateMap.put(date, dateMap.get(date) + 1);
                }
            }
            for (Date d : dateMap.keySet()) {
                //System.out.printf("%s %5d%n", s, map.get(s));
                System.out.println(d);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}