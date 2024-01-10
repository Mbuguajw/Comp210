package a5;

public class EdgeImpl implements Edge {
    private Node _source;
    private Node _destination;
    private double _weight;

    public EdgeImpl(Node source, Node destination, double weight) {
        _source = source;
        _destination = destination;
        _weight = weight;
        if (weight < 0)
            _weight = 0;
    }

    public Node getSource() {
        return _source;
    }

    public Node getDestination() {
        return _destination;
    }

    public double getWeight() {
        return _weight;
    }
}
