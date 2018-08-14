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

  /**
   * add a node to the tree, maintain its sorted order.
   * adding N nodes will take normally 0(NlogN) to build the tree.
   * in worst case, when N nodes are sorted, the tree will be tall and thin
   * (every node has 1 child),
   * then it takes 0(N^2).
   * 
   * @param newVal
   */

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

  public BinaryNode find(int searchVal) {
    if (this.value == searchVal)
      return this;
    if (searchVal > this.value) {
      if (this.rightNode != null) {
        return this.rightNode.find(searchVal);
      }
      return null;
    } else {
      if (this.leftNode != null) {
        return this.leftNode.find(searchVal);
      }
      return null;
    }
  }

  /**
   * check if the tree contains the {@code searchVal }.
   * if so, return true, otherwises, return false.
   * 
   * @param searchVal
   * @return
   */
  public boolean contains(int searchVal) {
    if (this.value == searchVal) {
      return true;
    } else if (searchVal > this.value) {
      if (this.rightNode != null) {
        return this.rightNode.contains(searchVal);
      }
      return false;
    } else {
      if (this.leftNode != null) {
        return this.leftNode.contains(searchVal);
      }
      return false;
    }

  }

  public BinaryNode findParentNode(int targetVal) {
    if (this.leftNode != null && this.getLeftNode().getValue() == targetVal) {
      return this;
    }
    if (this.getRightNode() != null
        && this.getRightNode().getValue() == targetVal) {
      return this;
    }
    if (targetVal > this.value) {
      if (this.getRightNode() != null) {
        return this.getLeftNode().findParentNode(targetVal);
      }
      return null;
    } else {
      if (this.getLeftNode() != null) {
        return this.getLeftNode().findParentNode(targetVal);
      }
      return null;
    }
  }

  public void deleteNode(int targetVal) {
    BinaryNode targetNode = find(targetVal);
    if (targetNode == null) {
      System.out.println("target node does not exist");
    }
    BinaryNode parentNode = findParentNode(targetVal);
    // parentNode is root
    if (parentNode == null) {
      parentNode = this;
    }

    // System.out.println("parent node " + parentNode);

    // if targetNode is a leaf, just remove the node from the tree
    if (targetNode.isLeaf()) {
      // in case the tree has only one node which is targetNode
      if (parentNode == this) {
        // set the node value to a special one, which is -1 here.
        parentNode.value = -1;
      }
      if (parentNode.leftNode == targetNode)
        parentNode.leftNode = null;
      if (parentNode.rightNode == targetNode)
        parentNode.rightNode = null;
    } else if (targetNode.leftNode == null) {
      if (parentNode.leftNode == targetNode)
        parentNode.leftNode = targetNode.rightNode;
      if (parentNode.rightNode == targetNode)
        parentNode.rightNode = targetNode.rightNode;

    } else if (targetNode.rightNode == null) {
      if (parentNode.leftNode == targetNode)
        parentNode.leftNode = targetNode.leftNode;
      if (parentNode.rightNode == targetNode)
        parentNode.rightNode = targetNode.leftNode;
    } else {
      // target node has 2 children.
      BinaryNode leftChild = targetNode.leftNode;
      // left child of target node does not have a right child
      if (leftChild.rightNode == null) {
        targetNode.value = leftChild.value;
        targetNode.leftNode = null;
      } else {
        BinaryNode rightMostNode = targetNode.leftNode.rightNode;
        BinaryNode rightMostNodeParent = targetNode.leftNode;
        while (rightMostNode.rightNode != null) {
          rightMostNodeParent = rightMostNode;
          rightMostNode = rightMostNode.rightNode;
        }
        System.out.println("rightMostNode " + rightMostNode);
        if (rightMostNode.isLeaf()) {
          targetNode.value = rightMostNode.value;
          rightMostNodeParent.rightNode = null;

        } else {
          int rightMostval = rightMostNode.value;
          rightMostNode.value = rightMostNode.leftNode.value;
          targetNode.value = rightMostval;
          rightMostNode.leftNode = null;
        }
      }

    }

  }

  public boolean isLeaf() {
    return this.leftNode == null && this.rightNode == null;
  }

  @Override
  public String toString() {
    return "BinaryNode [value=" + value + ", leftNode=" + leftNode
        + ", rightNode=" + rightNode + "]";
  }

}
