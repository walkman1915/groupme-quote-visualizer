import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Quotes {
    public static void main(String[] args) {
        Scanner scanner;
        Map<String, Integer> map = new HashMap<>();
        //System.out.println("Hello");

        try {
            File file = new File("jason.txt");
            scanner = new Scanner(file);

            //System.out.println(scanner.nextLine());
            //System.out.println(scanner.hasNext());

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                //System.out.println(line);

                try {
                    int start = line.indexOf("\"") + 1;
                    int end = line.lastIndexOf("\"");

                    //System.out.println("START: " + start + "\t END: " + end);

                    line = line.substring(start, end);
                    String[] words = line.split("[^\\w\\']");

                    // for (String word : words) {
                    //     System.out.print(word.trim() + "|");
                    // }
                    // System.out.println();

                    for (String word : words) {
                        if (!word.equals("")) {
                            if (map.putIfAbsent(word.toLowerCase(), 1) != null) {
                                map.put(word.toLowerCase(), map.get(word.toLowerCase()) + 1);
                            }
                        }
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    // happens when formatting of the quote was wrong
                }
            }
            for (String s : map.keySet()) {
                //System.out.printf("%s %5d%n", s, map.get(s));
                System.out.printf("\n%-14s %3d", s, map.get(s));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        BufferedWriter writer = null;
        try {
            File writeFile = new File("words.csv");
            writer = new BufferedWriter(new FileWriter(writeFile));
            for (String word : map.keySet()) {
                writer.write(word + ",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}














