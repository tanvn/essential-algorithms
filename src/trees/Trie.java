package trees;

public class Trie {
  // case sensitive
  public static final int ALPHABET_SIZE = 26 * 2;
  public static final int ASCII_CHAR_DIFF = 6;

  class TrieNode {
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;

    TrieNode() {
      for (int i = 0; i < ALPHABET_SIZE; i++) {
        children[i] = null;
      }
      isEndOfWord = false;
    }

  }

  TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    final int length = word.length();
    TrieNode currentNode = root;
    for (int i = 0; i < length; i++) {
      int charCode = word.charAt(i) - 'A';
      // charCode is from 'a' to 'z' whose ascii values are from 97 to 122
      if (charCode > 25) {
        charCode = charCode - 6;
      }
      if (currentNode.children[charCode] == null) {
        currentNode.children[charCode] = new TrieNode();
      }
      currentNode = currentNode.children[charCode];
    }
    currentNode.isEndOfWord = true;
  }

  public boolean search(String word) {
    final int length = word.length();
    TrieNode currentNode = root;
    for (int i = 0; i < length; i++) {
      int charCode = word.charAt(i) - 'A';
      // charCode is from 'a' to 'z' whose ascii values are from 97 to 122
      if (charCode > 25) {
        charCode = charCode - 6;
      }
      if (currentNode.children[charCode] == null) {
        return false;
      }
      currentNode = currentNode.children[charCode];
    }
    return (currentNode != null && currentNode.isEndOfWord);

  }

  public static void main(String[] args) {
    Trie myTrie = new Trie();
    String[] words = new String[] { "hello", "hell", "world", "work", "apple",
        "Task", "tupple", "watch" };
    for (int i = 0; i < words.length; i++) {
      myTrie.insert(words[i]);
    }
    String keyWord = "hello";
    System.out
        .println("myTrie contains " + keyWord + " : " + myTrie.search(keyWord));
    String keyWord2 = "height";
    System.out.println(
        "myTrie contains " + keyWord2 + " : " + myTrie.search(keyWord2));
    String keyWord3 = "task";
    System.out.println(
        "myTrie contains " + keyWord3 + " : " + myTrie.search(keyWord3));
    String keyWord4 = "Task";
    System.out.println(
        "myTrie contains " + keyWord4 + " : " + myTrie.search(keyWord4));

  }

}
