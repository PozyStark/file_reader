import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {


        String file = Objects.requireNonNull(Main.class.getResource("words.txt")).getPath();

        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(file)
        );

        String []words = bufferedReader.readLine().split(" ");
        bufferedReader.close();
        Arrays.sort(words);

        // * Подсчет и вывод уникальных значений с поиском слова с максимальным повтором
        ArrayList<String> printed = new ArrayList<>();

        int indexOfMax = 0;
        int maxCounter = 1;
        int counter = 1;
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            for (int j=0; j<words.length; j++) {
                if (i != j && word.equals(words[j])) {
                    counter += 1;
                }
                if (maxCounter < counter) {
                    indexOfMax = i;
                    maxCounter = counter;
                }
            }
            if (!printed.contains(word)) {
                System.out.printf("%s-%d\n",word, counter);
                printed.add(word);
            }
            counter = 1;
        }

        System.out.printf("**Winner**\nСлово-%s Встречается-%d", words[indexOfMax], maxCounter);

    }
}
