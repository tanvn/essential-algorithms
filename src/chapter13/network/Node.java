package chapter13.network;

import java.util.List;

public class Node {
  private String name;
  private int x;
  private int y;
  List<Link> links;

  public Node(String name, int x, int y) {
    super();
    this.name = name;
    this.x = x;
    this.y = y;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }

  @Override
  public String toString() {
    return "Node [name=" + name + ", x=" + x + ", y=" + y + ", links=" + links
        + "]";
  }

}
