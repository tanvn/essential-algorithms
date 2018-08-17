package trees;

/**
 * Threaded binary tree : "A binary tree is threaded by making all right child
 * pointers that would normally be null point to the inorder successor of the
 * node (if it exists), and all left child pointers that would normally be null
 * point to the inorder predecessor of the node."
 * 
 * @see <a href= "https://www.geeksforgeeks.org/threaded-binary-tree/">Threaded
 *      Binary Tree </a>
 * 
 * @author tan.vu
 *
 */
public class ThreadedBinaryNode {
  int value;
  ThreadedBinaryNode leftChild;
  ThreadedBinaryNode rightChild;
  ThreadedBinaryNode leftThread;
  ThreadedBinaryNode rightThread;

  public ThreadedBinaryNode(int value) {
    super();
    this.value = value;
  }

  public ThreadedBinaryNode getLeftMostNode() {
    ThreadedBinaryNode leftMost = this;
    while (leftMost.leftChild != null) {
      leftMost = leftMost.leftChild;
    }
    return leftMost;
  }

  public void addNode(int newVal) {
    if (newVal == this.value) {
      System.out.println("Value already exists");
      return;
    }
    if (newVal < this.value) {
      // add to the left child
      if (this.leftChild != null) {
        this.leftChild.addNode(newVal);
      } else {

        ThreadedBinaryNode node = new ThreadedBinaryNode(newVal);
        this.leftChild = node;
        node.leftThread = this.leftThread;
        node.rightThread = this;
        this.leftThread = null;
      }
    } else {
      // add to the right child
      if (this.rightChild != null) {
        this.rightChild.addNode(newVal);
      } else {
        ThreadedBinaryNode node = new ThreadedBinaryNode(newVal);
        this.rightChild = node;
        node.rightThread = this.rightThread;
        node.leftThread = this;
        this.rightThread = null;
      }
    }

  }

}
