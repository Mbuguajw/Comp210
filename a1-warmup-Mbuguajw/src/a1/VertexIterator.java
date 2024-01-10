package a1;

import java.util.Iterator;

public class VertexIterator implements Iterator<Point> {
    private Polygon pool;
    private int index;
    public VertexIterator(Polygon polygon) {
        // constructor code here
        pool = polygon;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < pool.getNumVertices();
    }

    @Override
    public Point next() {
        if (this.hasNext()) {
            Point hold = this.pool.getVertex(index);
            index++;
            return hold;
        }
        else {
            index = 0;
            Point hold = this.pool.getVertex(index);
            index++;
            return hold;
        }
    }
}
