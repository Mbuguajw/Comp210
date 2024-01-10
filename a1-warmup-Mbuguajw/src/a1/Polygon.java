package a1;

public class Polygon {
    final private Point[] vertices;

    public Polygon(Point[] vertices) {
        if (vertices == null || vertices.length < 3) {
            throw new IllegalArgumentException();
        }
        this.vertices = vertices;
    }

    public Point getVertex(int i) {
        return vertices[i];
    }

    public int getNumVertices() {
        return vertices.length;
    }
}
