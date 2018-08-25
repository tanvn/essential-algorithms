package chapter13.network;

public class Link {
  private int cost;
  private int capacity;
  Node[] nodes;

  public Link(int cost, int capacity) {
    super();
    this.cost = cost;
    this.capacity = capacity;
    this.nodes = new Node[2];
  }

  public int getWeight() {
    return cost;
  }

  public void setWeight(int weight) {
    this.cost = weight;
  }

  public Node[] getNodes() {
    return nodes;
  }

  public void setNodes(Node[] nodes) {
    this.nodes = nodes;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  @Override
  public String toString() {
    return "Link [cost=" + cost + ", capacity=" + capacity + ", toNode="
        + nodes[1].getName() + "]";
    // return "Link [cost=" + cost + ", capacity=" + capacity + "]";
  }

}
