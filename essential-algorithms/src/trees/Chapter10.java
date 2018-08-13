package trees;

import java.util.LinkedList;
import java.util.List;

public class Chapter10 {
  public static void main(String[] args) {
    BinaryNode root = new BinaryNode(4);
    BinaryNode node1 = new BinaryNode(1);
    BinaryNode node2 = new BinaryNode(2);
    BinaryNode node3 = new BinaryNode(3);
    BinaryNode node5 = new BinaryNode(5);
    BinaryNode node6 = new BinaryNode(6);
    BinaryNode node7 = new BinaryNode(7);
    BinaryNode node8 = new BinaryNode(8);
    root.leftNode = node2;
    root.rightNode = node5;
    node2.leftNode = node1;
    node2.rightNode = node3;
    node5.rightNode = node7;
    node7.leftNode = node6;
    node7.rightNode = node8;

    // preOrder
    List<Integer> nodeNames = new LinkedList<>();
    Traversal.preOrder(root, nodeNames);
    System.out.println("preOrder: " + nodeNames);
    // inOrder
    nodeNames.clear();
    Traversal.inOrder(root, nodeNames);
    System.out.println("inOrder: " + nodeNames);

    // postOrder
    nodeNames.clear();
    Traversal.postOrder(root, nodeNames);
    System.out.println("postOrder: " + nodeNames);
    // depthFirst
    nodeNames.clear();
    Traversal.depthFirst(root, nodeNames);
    System.out.println("depthFirst: " + nodeNames);

    testAddNode();

  }

  public static void testAddNode() {
    BinaryNode root = new BinaryNode(6);
    root.addNode(5);
    root.addNode(4);
    root.addNode(9);
    root.addNode(8);
    root.addNode(10);
    root.addNode(15);
    root.addNode(3);
    List<Integer> nodeValues = new LinkedList<>();
    Traversal.inOrder(root, nodeValues);
    System.out.println("inOrder : " + nodeValues);
  }

}
