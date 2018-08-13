package trees;

import java.util.LinkedList;
import java.util.List;

public class BinaryNode {
  private String name;
  private BinaryNode leftNode;
  private BinaryNode rightNode;

  public BinaryNode(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public BinaryNode getLeftNode() {
    return leftNode;
  }

  public BinaryNode getRightNode() {
    return rightNode;
  }

  public static void main(String[] args) {
    BinaryNode root = new BinaryNode("4");
    BinaryNode node1 = new BinaryNode("1");
    BinaryNode node2 = new BinaryNode("2");
    BinaryNode node3 = new BinaryNode("3");
    BinaryNode node5 = new BinaryNode("5");
    BinaryNode node6 = new BinaryNode("6");
    BinaryNode node7 = new BinaryNode("7");
    BinaryNode node8 = new BinaryNode("8");
    root.leftNode = node2;
    root.rightNode = node5;
    node2.leftNode = node1;
    node2.rightNode = node3;
    node5.rightNode = node7;
    node7.leftNode = node6;
    node7.rightNode = node8;

    // preOrder
    List<String> nodeNames = new LinkedList<>();
    Traversal.preOrder(root, nodeNames);
    System.out.println("PreOrder: " + nodeNames);
    // inOrder
    nodeNames.clear();
    Traversal.inOrder(root, nodeNames);
    System.out.println("InOrder: " + nodeNames);

    // postOrder
    nodeNames.clear();
    Traversal.postOrder(root, nodeNames);
    System.out.println("postOrder: " + nodeNames);
    // depthFirst
    nodeNames.clear();
    Traversal.depthFirst(root, nodeNames);
    System.out.println("depthFirst: " + nodeNames);

  }

}
