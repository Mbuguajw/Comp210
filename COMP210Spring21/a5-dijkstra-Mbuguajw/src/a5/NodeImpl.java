package a5;

import java.util.ArrayList;
import java.util.List;

public class NodeImpl implements Node {

  private String name;
  private double weight;
  private Node next;

  public NodeImpl(String userName, Node _next) {
    name = userName;
    next = _next;
    weight = 0;
  }
  public NodeImpl(String userName, double _weight, Node _next) {
    new NodeImpl(userName, _next);
    weight = _weight;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setWeight(double _weight) {
    weight = weight;
  }

  @Override
  public double getWeight() {
    return weight;
  }

  @Override
  public void setValue(String value) { name = value; }

  @Override
  public Node getNext() { return next; }

  @Override
  public void setNext(Node _next) { next = _next; }
}

