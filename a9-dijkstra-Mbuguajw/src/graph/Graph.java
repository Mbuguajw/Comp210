package graph;

import minBinHeap.MinBinaryHeap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {
  private Map<String, Vertex> _vertices;
  private List<List<String>> _data;

  public Graph(String fileName) {
    _vertices = new HashMap<>();
    createGraph(fileName);
  }

  public Graph() {
    _vertices = new HashMap<>();
  }

  public double calculateWeight(int distance, int traffic, int scenery, int attractions) {
    /*Your code here*/
    float operator = distance / traffic;
    float zeroCounter = operator + scenery;
    float edge = zeroCounter / traffic;
    double attractionValue = edge / attractions;
    return attractionValue;
  }

  public Map<String, Double> dijkstra(Vertex start) {
    /*Your code here*/
    Map<String, Double> finalMap = new HashMap<>();
    MinBinaryHeap<Vertex, Double> priority = new MinBinaryHeap<>();
    for (String vertexes : _vertices.keySet()) {
      if (vertexes.equals(start.getLabel())) {
        finalMap.put(vertexes, 0.0);
      } else {
        finalMap.put(vertexes, Double.MAX_VALUE);
      }
    }
    priority.enqueue(start, 0.0);
    while (priority.size() > 0) {
      Vertex next = priority.dequeue();
      String cityName = next.getLabel();
      ArrayList<Edge> vertexEdges = (ArrayList<Edge>) next.getEdges();
      for (int i = 0; i < vertexEdges.size(); i++) {
        String newCity = vertexEdges.get(i).getDestination().getLabel();
        if (finalMap.get(newCity) > finalMap.get(cityName) + vertexEdges.get(i).getWeight()) {
          finalMap.replace(newCity, finalMap.get(next.getLabel()) + vertexEdges.get(i).getWeight());
          priority.enqueue(vertexEdges.get(i).getDestination(), finalMap.get(newCity));
        }
      }
    }
    if (finalMap.size() < 2) {
      finalMap.replace(start.getLabel(), 0.0);
    }
    return finalMap;
  }

  // Do not edit anything below

  /*
  reads through each entry in csv and calls readLine to create edges and vertices.
   */
  public void createGraph(String fileName) {
    readCSV(fileName);
    for (List<String> list : _data) {
      readLine(
          list.get(0),
          list.get(1),
          Integer.parseInt(list.get(2)),
          Integer.parseInt(list.get(3)),
          Integer.parseInt(list.get(4)),
          Integer.parseInt(list.get(5)));
    }
  }

  /*
  reads through each line of csv and puts data into an ArrayList
   */
  public void readCSV(String fileName) {
    _data = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String header = br.readLine();
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        _data.add(Arrays.asList(values));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /*
  converts one entry of data into vertices and edges
   */
  public void readLine(
      String src, String dest, int distance, int traffic, int scenery, int attractions) {
    // find source and destination nodes, if they don't exist, create them
    Vertex source = _vertices.get(src);
    if (source == null) source = new VertexImpl(src);
    Vertex destination = _vertices.get(dest);
    if (destination == null) destination = new VertexImpl(dest);

    // calculate weight of edge
    double weight = calculateWeight(distance, traffic, scenery, attractions);

    // create edge
    Edge e = new EdgeImpl(source, destination, weight);
    source.addEdge(e);

    // add reverse direction edge
    e = new EdgeImpl(destination, source, weight);
    destination.addEdge(e);

    // add to graph
    _vertices.put(src, source);
    _vertices.put(dest, destination);
  }

  public Map<String, Vertex> getVertices() {
    return _vertices;
  }
}
