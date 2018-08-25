package chapter13.network;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildNetworkFromFile {

  public static void main(String[] args) {

    String fileName = "./network_data/network_data1.txt";
    Node[] nodes = build(fileName);
    for (int i = 0; i < nodes.length; i++) {
      System.out.println(nodes[i]);
    }

  }

  public static Node[] build(String fileName) {
    // read file into stream, try-with-resources
    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
      List<String> lines = stream.collect(Collectors.toList());
      int numberOfNodes = Integer.parseInt(lines.get(0));
      Node[] nodes = new Node[numberOfNodes];
      for (int i = 1; i < lines.size(); i++) {
        String[] data = lines.get(i).split(",");
        String name = data[0];
        int x = Integer.parseInt(data[1]);
        int y = Integer.parseInt(data[2]);
        if (nodes[i - 1] == null) {
          nodes[i - 1] = new Node(name, x, y);
        } else {
          nodes[i - 1].setName(name);
          nodes[i - 1].setX(x);
          nodes[i - 1].setY(y);
        }

        int numberOfLinks = (data.length - 3) / 3;
        List<Link> links = new ArrayList<>(numberOfLinks);
        for (int j = 3; j < data.length; j = j + 3) {
          int index = Integer.parseInt(data[j]);
          int cost = Integer.parseInt(data[j + 1]);
          int capacity = Integer.parseInt(data[j + 2]);
          Link link = new Link(cost, capacity);
          Node[] connectedNodes = link.getNodes();
          connectedNodes[0] = nodes[i - 1];
          if (nodes[index] == null) {
            nodes[index] = new Node();
          }
          connectedNodes[1] = nodes[index];
          links.add(link);
        }
        nodes[i - 1].setLinks(links);
      }
      return nodes;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
