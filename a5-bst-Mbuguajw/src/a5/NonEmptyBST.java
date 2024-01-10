package a5;


import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {

		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}


	// TODO: size
	@Override
	public int size() {
		BST<T> newRoot;
		BST<T> newRoots;
		if(this.isEmpty()) {
			return 1;
		}
		else if(!(this.getLeft().isEmpty()) && !(this.getRight().isEmpty())) {
			newRoot = this.getLeft();
			newRoots = this.getRight();
			if(newRoot.size() != newRoots.size()) {
				return 1 + (int)Math.ceil(((double) (newRoot.size() + newRoots.size()) / 2));
			}
			return 1 + ((newRoot.size() + newRoots.size()) / 2);
		}
		else if(this.getLeft().isEmpty() && this.getRight().isEmpty()) {
			return 1;
		}
		else if(!(this.getLeft().isEmpty()) && this.getRight().isEmpty()) {
			return (this._left.size() + 1 + this._right.size());
		}
		else if((!this.getRight().isEmpty()) && (this.getLeft().isEmpty())) {
			return (this._left.size() + 1 + this._right.size());
		}
		return (this._left.size() + 1 + this._right.size());
	}

	// TODO: findMin
	@Override
	public T findMin() {
		if(this._left.isEmpty()) {
			return this._element;
		}
		else {
			return this._left.findMin();
		}
	}

	// TODO: findMax
	@Override
	public T findMax() {
		if(this._right.isEmpty()) {
			return this._element;
		}
		else {
			return this._right.findMax();
		}
	}

	// TODO: contains
	@Override
	public boolean contains(T element) {
		if(this.getElement() == element) {
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

	// TODO: insert
	@Override
	public BST<T> insert(T element) {
		if(this == null) {
			BST<T> newTree = new NonEmptyBST<T>(element);
			return newTree;
		}
		if(element.compareTo(this.getElement()) < 0) {
			this._left = this.getLeft().insert(element);
		}
		else if(element.compareTo( this.getElement()) > 0) {
			this._right = this.getRight().insert(element);
		}
		return this;
	}

	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		if(this.isEmpty()) {
			return null;
		}
		else if(element == null) {
			return this.getRight();
		}
		else if(this.getElement().compareTo(element) > 0) {
			this._left = this.getLeft().remove(element);
			return this;
		}
		else if(this.getElement().compareTo(element) == 0) {
			if(this.getLeft().isEmpty()) {
				return this._right;
			}
			if(this.getRight().isEmpty()) {
				return this._left;
			}
			if(this.getLeft().isEmpty() && this.getRight().isEmpty()) {
				return null;
			}
		}
		this._right = this.getRight().remove(element);
		return this;
	}

	// TODO: printInOrderTraversal
	@Override
	public void printInOrderTraversal() {
		if(this != null) {
			this._left.printInOrderTraversal();
			System.out.print(this._element + " ");
			this._right.printInOrderTraversal();
		}
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		if(this != null) {
			System.out.print(this._element + " ");
			this.getLeft().printPreOrderTraversal();
			this.getRight().printPreOrderTraversal();
		}
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if(this != null) {
			this.getLeft().printPostOrderTraversal();
			this.getRight().printPostOrderTraversal();
			System.out.print(this._element + " ");
		}
	}

	// TODO: printBreadthFirstTraversal
	@Override
	public void printBreadthFirstTraversal() {
		Queue<BST<T>> weirdTree = new LinkedList<>();

		if(this.getElement() == null) {
			return;
		}
		weirdTree.add(this);
		while(!weirdTree.isEmpty()) {
			BST<T> newTree = weirdTree.poll();
			System.out.print(newTree.getElement() + " ");
			if(!(newTree.getLeft().isEmpty())) {
				weirdTree.add(newTree.getLeft());
			}
			if(!(newTree.getRight().isEmpty())) {
				weirdTree.add(newTree.getRight());
			}
		}
	}

	@Override
	public int getHeight() {
		return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
