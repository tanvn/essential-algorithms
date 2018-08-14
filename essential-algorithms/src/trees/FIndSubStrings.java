package trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FIndSubStrings {

  public static void main(String[] args) {
    String[] words = new String[] { "Apple", "Melon", "Orange", "Watermelon" };
    String[] parts = new String[] { "a", "mel", "lon", "el", "An" };

    String[] words2 = new String[] { "Aaaaaaaaa", "bcdEFGh" };
    String[] parts2 = new String[] { "aaaaa", "Aaaa", "E", "z", "Zzzzz" };

    String[] words3 = new String[] { "neuroses", "myopic", "sufficient",
        "televise", "coccidiosis", "gules", "during", "construe", "establish",
        "ethyl" };
    String[] parts3 = new String[] { "aaaaa", "Aaaa", "E", "z", "Zzzzz", "a",
        "mel", "lon", "el", "An", "ise", "d", "g", "wnoVV", "i", "IUMc", "P",
        "KQ", "QfRz", "Xyj", "yiHS" };
    findSubstrings(words3, parts3);

  }

  public static String[] findSubstrings(String[] words, String[] parts) {
    final int MAX_LENGTH = 5;
    final Map<String, Integer> INDEX_AND_VALUES = new HashMap<>();
    for (int i = 0; i < parts.length; i++) {
      INDEX_AND_VALUES.put(parts[i], i);
    }
    System.out.println(INDEX_AND_VALUES);
    System.out.println(Arrays.toString(words));
    Trie myTrie = new Trie();
    for (int i = 0; i < parts.length; i++) {
      myTrie.insert(parts[i]);

    }
    Map<String, String> wordAndSubStrings = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      wordAndSubStrings.put(word, null);

      for (int k = 0; k < word.length(); k++) {

        StringBuilder sb = new StringBuilder().append(word.charAt(k));

        for (int j = 1; j <= MAX_LENGTH; j++) {
          String subStr = sb.toString();
          // System.out.println(j + " now substring to test is " + subStr);
          if (myTrie.search(subStr)) {

            String currentSubStr = wordAndSubStrings.get(word);
            if (currentSubStr != null) {
              // new subStr is longer
              // System.out.println(currentSubStr + " vs " + subStr);
              if (currentSubStr.length() < subStr.length()) {
                wordAndSubStrings.put(word, subStr);
              } else if (currentSubStr.length() == subStr.length()) {
                // new substring has a smaller index
                if (INDEX_AND_VALUES.get(currentSubStr) > INDEX_AND_VALUES
                    .get(subStr)) {
                  System.out.println("for word: " + word + " "
                      + INDEX_AND_VALUES.get(currentSubStr) + currentSubStr
                      + " vs " + INDEX_AND_VALUES.get(subStr) + subStr);
                  wordAndSubStrings.put(word, subStr);
                }
              }
            } else {
              wordAndSubStrings.put(word, subStr);
            }
          }
          if (j + k < word.length()) {
            sb.append(word.charAt(j + k));
          } else {
            break;
          }
        }

      }

    }
    System.out.println(wordAndSubStrings);
    String[] result = new String[words.length];
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      String subStr = wordAndSubStrings.get(word);
      if (subStr != null) {
        result[i] = word.replaceFirst(subStr, "[" + subStr + "]");
      } else {
        result[i] = word;
      }

    }

    System.out.println(Arrays.toString(result));

    return result;

  }
}
