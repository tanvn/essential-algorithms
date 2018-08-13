package trees;

public class BinaryNode {
  private int value;
  protected BinaryNode leftNode;
  protected BinaryNode rightNode;

  public BinaryNode(int value) {
    super();
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public BinaryNode getLeftNode() {
    return leftNode;
  }

  public BinaryNode getRightNode() {
    return rightNode;
  }

  public void addNode(int newVal) {
    if (newVal == this.value)
      return;
    if (newVal < this.value) {
      if (leftNode == null)
        leftNode = new BinaryNode(newVal);
      leftNode.addNode(newVal);
    } else {
      if (rightNode == null)
        rightNode = new BinaryNode(newVal);
      rightNode.addNode(newVal);
    }

  }

}
