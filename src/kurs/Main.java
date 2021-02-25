package kurs;

import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------------------- задание 1 --------------------");
        String[] inWords = {"apple banana", "orange", "banana", "kiwi strawberry blueberry"};
        System.out.println("БЫЛО: " + Arrays.toString(inWords));
        String[] outWords = splitWords(inWords);
        System.out.println("СТАЛО: " + Arrays.toString(outWords));
        System.out.println("-------------------- задание 2 --------------------");
        String inText = "Ну что ж  я, я  найти   решения  правильного не смогу ж? " +
                "Смогу ж конечно, я ж   старательный все ж таки.";
        System.out.println(inText);
        System.out.println(analysis(inText, 2));
    }

    private static String analysis(String text, int max_amount) {
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String, Integer> entry: mapCounted(text).entrySet()) {
            int amount = entry.getValue();
            if (amount >= max_amount)
                jsonObject.put(entry.getKey(), amount);
        }
        return jsonObject.toString();
    }

    private static HashMap<String, Integer> mapCounted(String text) {
        String[] words = text
                .toLowerCase()
                .trim()
                .replaceAll("\\s{2,}", " ")
                .replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "")
                .split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word: words)
            map.put(word, 1 + map.getOrDefault(word, 0));
        return map;
    }

    private static String[] splitWords(String[] words) {
        LinkedList<String> list = new LinkedList<>();
        for (String word: words)
            list.addAll(Arrays.asList(word.split(" ")));
        return list.toArray(new String[0]);
    }
}
