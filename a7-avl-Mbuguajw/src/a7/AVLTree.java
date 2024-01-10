package a7;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Put your fields here.
    private AVLTree<T> _left;
    private AVLTree<T> _right;
    private T _item;
    public AVLTree() {
        // You code for constructor here.
        _left = null;
        _right = null;
        _item = null;
    }
    public AVLTree(T item) {
        _left = new AVLTree<>();
        _right = new AVLTree<>();
        _item = item;
    }

        /**
         *
         * Rotates the tree left and returns
         * AVLTree root for rotated result.
         */
        public SelfBalancingBST<T> balancing() {
            int balancingFactor = this._left.height() - this._right.height();
            if (balancingFactor < -11) {
                if (this._right._left.height() > this._right._right.height()) {
                    this._right = this._right.rotateRight();
                }
                return this.rotateLeft();
            }
            else {
                if (this._left._left.height() < this._left._right.height()) {
                    this._left = this._left.rotateLeft();
                }
                return this.rotateRight();
            }
        }

        private AVLTree<T> rotateLeft() {
            // You should implement left rotation and then use this
            // method as needed when fixing imbalances.
            AVLTree<T> A = this._left;
            AVLTree<T> B = this._right._left;
            AVLTree<T> C = this._right._right;
            this._item = this._right._item;
            this._left._left = A;
            this._left._right = B;
            this._right = C;
            return this;
        }

        /**
         *
         * Rotates the tree right and returns
         * AVLTree root for rotated result.
         */

        private AVLTree<T> rotateRight() {
            // You should implement right rotation and then use this
            // method as needed when fixing imbalances.
            AVLTree<T> C = this._right;
            AVLTree<T> B = this._left._right;
            AVLTree<T> A = this._left._left;
            this._item = this._left._item;
            this._right._right = C;
            this._right._left = B;
            this._left = A;
            return this;
        }

    @Override
    public boolean isEmpty() {
        if (this._item == null && this._left == null && this._right == null) {
            return true;
        }
        return false;
    }

    @Override
    public int height() {
        if (this.isEmpty()) {
            return -1;
        }
        return Math.max(this._left.height(), this._right.height()) + 1;
    }

    @Override
    public int size() {
        if (!this._left.isEmpty() && this._right.isEmpty()) {
            return this._left.size() + 1;
        }
        else if (this._left.isEmpty() && !this._right.isEmpty()) {
            return this._right.size() + 1;
        }
        else if (!this._left.isEmpty() && !this._right.isEmpty()) {
            return this._left.size() + this._right.size() + 1;
        }
        else {
            return 1;
        }
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
        if (this.isEmpty()) {
            return new AVLTree<T>(element);
        }
        else{
            if (element.compareTo(this._item) > 0) {
                this._right = (AVLTree<T>) this._right.insert(element);
            }
            else {
                this._left = (AVLTree<T>) this._left.insert(element);
            }
        }
        return this.balancing();
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
        SelfBalancingBST<T> tree = this;
        if (this == null) {
            return tree;
        }
        if (this._item.compareTo(element) < 0) {
            this._right = (AVLTree<T>) this._right.remove(element);
        }
        else if (this._item.compareTo(element) >= 0) {
            this._left = (AVLTree<T>) this._left.remove(element);
        }
        else {
            if (this._left.isEmpty() && this._right.isEmpty()) {
                tree = new AVLTree<>();
            }
            else if (this._left.isEmpty()) {
                tree = this._right;
            }
            else if (this._right.isEmpty()) {
                tree = this._left;
            }
            else {
                T value = this._right.findMin();
                tree = tree.remove(value);
                this._item = value;
            }
        }
        return tree;
    }

    @Override
    public T findMin() {
        if (this._left.isEmpty()) {
            return this._item;
        }
        else {
            return this._left.findMin();
        }
    }

    @Override
    public T findMax() {
        if (this._right.isEmpty()) {
            return this._item;
        }
        else {
            return this._right.findMax();
        }
    }

    @Override
    public boolean contains(T element) {
        if(this.getValue() == element) {
            return true;
        }
        else {
            if(this.getLeft().isEmpty() && this.getRight().isEmpty()) {
                return false;
            }
            else if(this.getLeft().isEmpty()) {
                return this.getRight().contains(element);
            }
            else if(this.getRight().isEmpty()) {
                return this.getLeft().contains(element);
            }
            else {
                return this.getLeft().contains(element) || this.getRight().contains(element);
            }
        }
    }

    @Override
    public T getValue() {
        return this._item;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        return this._left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        return this._right;
    }

    // Your code for public methods here.
    }
