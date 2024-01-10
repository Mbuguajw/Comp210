package a3;

public class BSTImpl implements BST {

    private Node root;
    private int size;

    public BSTImpl() {
        root = null;
        size = 0;
    }

    public BSTImpl(String s) {
        root = new NodeImpl(s);
        size = 0;
    }

    // The implementation of "height" is given to you below
    // it is here to illustrate for you how to set up
    // the method implementation as recursion.
    // You should follow this pattern for implementing the other recursive methods
    // by adding your own private recursive methods

    @Override
    public int height() { // public interface method signature
        // this method is the public interface method
        // it is not recursive, but it calls a recursive
        // private method and passes it access to the tree cells
        return height_recursive(this.root);
    }
    private int height_recursive(Node c) {
        // inner method with different signature
        // this helper method uses recursion to traverse
        // and process the recursive structure of the tree of cells
        if (c==null) return -1;
        int lht = height_recursive(c.getLeft());
        int rht = height_recursive(c.getRight());
        return Math.max(lht,rht) + 1;
    }

    @Override
    public Node getRoot() {
        return this.root;
    }

    @Override
    public String insert(String value) {
        this.root = insert_i(value, this.root);
        this.size ++;
        return value;
    }

    private Node insert_i(String value, Node c) {
        if(c == null) {
            NodeImpl newTree = new NodeImpl(value);
            return newTree;
        }
        if(value.compareTo(c.getValue()) < 0) {
            c.setLeft(insert_i(value, c.getLeft()));
        }
        else if(value.compareTo(c.getValue()) > 0) {
            c.setRight(insert_i(value, c.getRight()));
        }
        return c;
    }

    // remove implementation given to you, do NOT change
    @Override
    public void remove(String value) {
        remove_r(value,this.root);
        size--;
    }
    private Node remove_r(String k, Node c) {
        if (c==null) return null; // item not found, nothing to do

        // now we know we have a real node to examine
        int cflag = k.compareTo(c.getValue());

        if (cflag<0) { // k is smaller than node
            c.setLeft(remove_r(k,c.getLeft()));
            return c;
        }
        else
        if (cflag>0) { // k is larger than node
            c.setRight(remove_r(k,c.getRight()));
            return c;
        }
        else //cflag==0
        { // found it... now figure out how to rearrange

            // cases
            if (c.getLeft()==null && c.getRight()==null) { c = null; } // leaf
            else if (c.getLeft()==null && c.getRight()!=null) { c = c.getRight(); } // RC only
            else if (c.getLeft()!=null && c.getRight()==null) { c = c.getLeft(); } // LC only
            else { // 2 children
                Node max = maxCell(c.getLeft());
                c.setValue(max.getValue());
                c.setLeft(remove_r(c.getValue(), c.getLeft()));   // recurse
            }
            return c;
        }

    }

    private Node maxCell(Node c) { // this is used in remove too
        if (c.getRight()==null) return c;
        return maxCell(c.getRight());
    } ;

    @Override
    public boolean isFull() {
        if(this.getRoot() == null) {
            return true;
        }
        return isFull_f(this.root);
    }

    private boolean isFull_f(Node c) {
        if(c.getLeft() == null && c.getRight() == null) {
            return true;
        }
        else if(c.getLeft() != null && c.getRight() != null) {
            return isFull_f(c.getRight()) && isFull_f(c.getLeft());
        }
        return false;
    }

    @Override
    public String findMin() {
        return findMin_n(this.root);
    }
    private String findMin_n(Node c) {
        if(c.getLeft() == null) {
            return c.getValue();
        }
        else {
            return findMin_n(c.getLeft());
        }
    }

    @Override
    public String findMax() {
        return findMax_x(this.root);
    }

    private String findMax_x(Node c) {
        if(c.getRight() == null) {
            return c.getValue();
        }
        else {
            return findMax_x(c.getRight());
        }
    }

    @Override
    public boolean contains(String s) {
        return contains_c(s, this.root);
    }

    private boolean contains_c(String s, Node c) {
        if(c.getValue() == s) {
            return true;
        }
        else {
            if(c.getLeft() == null && c.getRight() == null) {
                return false;
            }
            else if(c.getLeft() == null) {
                return contains_c(s, c.getRight());
            }
            else if(c.getRight() == null) {
                return contains_c(s, c.getLeft());
            }
            else {
                return contains_c(s, c.getLeft()) || contains_c(s, c.getRight());
            }
        }
    }

    @Override
    public Node get(String s) {
        if(this.contains(s)) {
            return get_g(s, this.root);
        }
       return null;
    }

    private Node get_g(String s, Node c) {
        if(c.getValue().equals(s)) {
            return c;
        }
        if(c.getLeft() != null) {
            if (s.compareTo(c.getLeft().getValue()) < 0) {
                return get_g(s, c.getLeft());
            }
        }
        if(c.getRight() != null) {
            if (s.compareTo(c.getRight().getValue()) > 0) {
                return get_g(s, c.getRight());
            }
        }
        return null;
    }

    @Override
    public int size() { return this.size; }
}
