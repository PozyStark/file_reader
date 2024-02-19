import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        String file = Objects.requireNonNull(Main.class.getResource("words.txt")).getPath();

        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(file)
        );

        TreeMap<String, Integer> map_words = new TreeMap<>();

        String []words = bufferedReader.readLine().split(" ");

        for (String word : words) {
            int map_word_counter = map_words.getOrDefault(word, 0);
            if (map_word_counter != 0) {
                map_words.replace(word, map_word_counter + 1);
            } else {
                map_words.put(word, 1);
            }
        }
        Map.Entry<String, Integer> max_word = map_words.firstEntry();
        for (Map.Entry<String, Integer> entry : map_words.entrySet()) {
            if (max_word.getValue() <= entry.getValue()) {
                max_word = entry;
            }
            System.out.printf("%s %d \n", entry.getKey(), entry.getValue());
        }

        System.out.printf("**Winner**\nСлово-%s Встречается-%d", max_word.getKey(), max_word.getValue());

    }
}
