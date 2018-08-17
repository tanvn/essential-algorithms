package trees;

import java.util.LinkedList;
import java.util.List;

public class ThreadedTreeTraversal {

  public static void inOrder(ThreadedBinaryNode root, List<Integer> container) {
    if (root == null)
      return;
    ThreadedBinaryNode node = root.getLeftMostNode();
    while (node != null) {
      // System.out.println("currently in node with value " + node.value);
      container.add(node.value);
      if (node.rightThread != null) {
        node = node.rightThread;
      } else {
        if (node.rightChild != null) {
          node = node.rightChild.getLeftMostNode();
        } else {
          node = null;
        }
      }
    }
  }

  public static ThreadedBinaryNode createTree() {
    ThreadedBinaryNode root = new ThreadedBinaryNode(5);
    root.addNode(2);
    root.addNode(6);

    root.addNode(1);
    root.addNode(4);
    root.addNode(9);

    root.addNode(3);
    root.addNode(7);

    root.addNode(8);
    return root;
  }

  public static void main(String[] args) {
    List<Integer> nodes = new LinkedList<>();
    inOrder(createTree(), nodes);
    System.out.println(nodes);

  }

}
