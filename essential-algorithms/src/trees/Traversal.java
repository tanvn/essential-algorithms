package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal {

  public static void preOrder(BinaryNode root, List<Integer> nodeNames) {
    // System.out.println(root.getName());
    nodeNames.add(root.getValue());
    if (root.getLeftNode() != null)
      preOrder(root.getLeftNode(), nodeNames);
    if (root.getRightNode() != null)
      preOrder(root.getRightNode(), nodeNames);

  }

  public static void inOrder(BinaryNode root, List<Integer> nodeNames) {
    if (root.getLeftNode() != null)
      inOrder(root.getLeftNode(), nodeNames);
    nodeNames.add(root.getValue());
    if (root.getRightNode() != null) {
      inOrder(root.getRightNode(), nodeNames);
    }
  }

  public static void postOrder(BinaryNode root, List<Integer> nodeNames) {
    if (root.getLeftNode() != null) {
      postOrder(root.getLeftNode(), nodeNames);
    }
    if (root.getRightNode() != null) {
      postOrder(root.getRightNode(), nodeNames);
    }
    nodeNames.add(root.getValue());

  }

  public static void depthFirst(BinaryNode root, List<Integer> nodeNames) {
    Queue<BinaryNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      BinaryNode node = nodes.poll();
      nodeNames.add(node.getValue());
      if (node.getLeftNode() != null)
        nodes.add(node.getLeftNode());
      if (node.getRightNode() != null)
        nodes.add(node.getRightNode());
    }
  }

}
