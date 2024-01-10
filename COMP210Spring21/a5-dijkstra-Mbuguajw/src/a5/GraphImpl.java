package a5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphImpl implements Graph {
    Map<String, Node> nodes; //do not delete, use this field to store your nodes
    // key: name of node. value: a5.Node object associated with name

    public GraphImpl() {
        nodes = new HashMap<>();
    }

    private boolean isEdge(String src, String des) {
        if (nodes.containsKey(src) && nodes.containsKey(des)) {
            boolean contains = false;
            while (nodes.get(src).hasNext()) {
                if (nodes.get(src).getName().equals(des)) {
                    contains = true;
                    break;
                } else {
                    contains = false;
                    nodes.get(src).getNext();
                }
            }
            while (nodes.get(des).hasNext()) {
                if (nodes.get(des).getName().equals(src)) {
                    contains = true;
                    break;
                } else {
                    contains = false;
                    nodes.get(des).getNext();
                }
            }
            return contains;
        }
        return false;
    }

    @Override
    public boolean addNode(String name) {
        if (name == null && nodes.containsKey(name)) {
            return false;
        } else {
            nodes.put(name, new NodeImpl(name, null));
            return true;
        }
    }

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (weight < 0 || !nodes.containsKey(src) || !nodes.containsKey(dest) || isEdge(src, dest)) {
            return false;
        } else {
            while (nodes.get(src).hasNext()) {
                if (!nodes.get(src).hasNext()) {
                    nodes.get(src).setNext(nodes.get(dest));
                    nodes.get(src).setWeight(weight);
                }
                nodes.get(src).getNext();
            }
            while (nodes.get(dest).hasNext()) {
                if (!nodes.get(dest).hasNext()) {
                    nodes.get(dest).setNext(nodes.get(src));
                    nodes.get(dest).setWeight(weight);
                }
                nodes.get(dest).getNext();
            }
            return true;
        }
    }

    @Override
    public boolean deleteNode(String name) {
        if (!nodes.containsKey(name)) {
            return false;
        } else {
            nodes.remove(name);
            for (String vertices : nodes.keySet()) {
                deleteEdge(vertices, name);
            }
            return true;
        }
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        if (!isEdge(src, dest)) {
            return false;
        }
        while (nodes.get(src).hasNext()) {
            if (nodes.get(src).getNext().getName().equals(dest)) {
                Node newNext = nodes.get(src).getNext().getNext();
                nodes.get(src).setNext(newNext);
            }
            nodes.get(src).getNext();
        }
        if (nodes.containsKey(dest)) {
            while (nodes.get(dest).hasNext()) {
                if (nodes.get(dest).getNext().getName().equals(src)) {
                    Node newNext = nodes.get(dest).getNext().getNext();
                    nodes.get(dest).setNext(newNext);
                }
                nodes.get(dest).getNext();
            }
        }
        return true;
    }

    @Override
    public int numNodes() {
        int counter = 0;
        for (Node each : nodes.values()) {
            counter++;
        }
        return counter;
    }

    @Override
    public int numEdges() {
        int counter = 0;
        ArrayList verticies = new ArrayList<String>();
        for (String each : nodes.keySet()) {
            if (nodes.values().size() == verticies.size()) {
                return counter;
            }
            while (nodes.get(each).hasNext()) {
                if (!verticies.contains(nodes.get(each).getName())) {
                    verticies.add(nodes.get(each).getName());
                    counter++;
                }
                counter++;
                nodes.get(each).getNext();
            }
        }
        return counter / 2;
    }

    @Override
    public Map<String, Double> dijkstra(String start) {
        /*Your code here*/
        Map<String, Double> finalMap = new HashMap<>();
        for (String vertexes : nodes.keySet()) {
            if (vertexes.equals(start)) {
                finalMap.put(vertexes, 0.0);
            } else {
                finalMap.put(vertexes, Double.MAX_VALUE);
            }
        }
        ArrayList visited = new ArrayList();
        ArrayList unvisited = (ArrayList) nodes.keySet();
        Node vert = null;
        String vertex = "";
        double weight = 0;
        while (visited.size() != unvisited.size()) {
            if (visited.size() == 0) {
                vert = nodes.get(start);
            }
            else {
                vert = nodes.get(vertex);
            } 
            vertex = "";
            weight = 0;
            while (vert.hasNext()) {
                if(weight < vert.getWeight() && !visited.contains(vert.getName())) {
                    weight = vert.getWeight();
                    vertex = vert.getName();
                }
                nodes.get(vertex).getNext();
            }
            visited.add(vertex);
        }
        return finalMap;
    }
}
