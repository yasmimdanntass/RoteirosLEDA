package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}

	private int height(BSTNode<T> node) {
		int height = -1;

		if (node != null && !node.isEmpty()){
			BSTNode<T> leftNode = (BSTNode<T>) node.getLeft();
			BSTNode<T> rightNode = (BSTNode<T>) node.getRight();
			height = 1 + Math.max(height(leftNode), height(rightNode));
		}

		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		return searchTree(root, element);
	}

	private BSTNode<T> searchTree(BSTNode<T> node, T element) {
		BSTNode<T> rNode = null;

		if (node.isEmpty() || element.equals(node.getData())){
			rNode = node;
		} else if (element.compareTo(node.getData()) < 0){
			rNode = searchTree((BSTNode<T>) node.getLeft(), element);
		} else {
			rNode = searchTree((BSTNode<T>) node.getRight(), element);
		}

		return rNode;
	}

    @Override
    public void insert(T element) {
        if (element != null){
			treeInsert(root, element);
		} 
    }

    private void treeInsert(BSTNode<T> node, T element) {
        if (node.isEmpty()) {
            node.setData(element);
            BSTNode<T> left = new BSTNode<>();
            left.setParent(node);
            node.setLeft(left);

            BSTNode<T> right = new BSTNode<>();
            right.setParent(node);
            node.setRight(right);
        } else if (element.compareTo(node.getData()) < 0) {
            treeInsert((BSTNode<T>) node.getLeft(), element);
        } else {
            treeInsert((BSTNode<T>) node.getRight(), element);
        }
    }

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> auxNode = null;
        if (!isEmpty()) {
            auxNode = minimum(this.root);
        }
        return auxNode;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> result;
		if (node == null || node.isEmpty()) {
			result = null;
		} else if (node.getLeft().isEmpty()) {
			result = node;
		} else {
			result = minimum((BSTNode<T>) node.getLeft());
		}
		return result;
	}

    @Override
    public BSTNode<T> maximum() {
        BSTNode<T> auxNode = null;
        if (!isEmpty()) {
            auxNode = maximum(this.root);
        }
        return auxNode;
    }

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> result;
		if (node == null || node.isEmpty()) {
			result = null;
		} else if (node.getRight().isEmpty()) {
			result = node;
		} else {
			result = maximum((BSTNode<T>) node.getRight());
		}
		return result;
	}
	
	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> result = null;

		if (node != null && !node.isEmpty()) {
			if (!node.getRight().isEmpty()) {
				result = minimum((BSTNode<T>) node.getRight());
			} else {
				result = sucessorParent(node);
			}
		}

		return result;
	}

	private BSTNode<T> sucessorParent(BSTNode<T> node) {
		if (node.getParent() == null) {
			return null;
		}
		if (node == node.getParent().getLeft()) {
			return (BSTNode<T>) node.getParent();
		}
		return sucessorParent((BSTNode<T>) node.getParent());
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> result = null;

		if (node != null && !node.isEmpty()) {
			if (!node.getLeft().isEmpty()) {
				result = maximum((BSTNode<T>) node.getLeft());
			} else {
				result = predecessorParent(node);
			}
		}

		return result;
	}

	private BSTNode<T> predecessorParent(BSTNode<T> node) {
		if (node.getParent() == null) {
			return null;
		}
		if (node == node.getParent().getRight()) {
			return (BSTNode<T>) node.getParent();
		}
		return predecessorParent((BSTNode<T>) node.getParent());
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {
			root = remove(root, element);
			if (root != null) root.setParent(null);
		}
	}

	private BSTNode<T> remove(BSTNode<T> node, T element) {
		BSTNode<T> result = node; 

		if (!node.isEmpty()) {
			int cmp = element.compareTo(node.getData());

			if (cmp < 0) {
				BSTNode<T> left = remove((BSTNode<T>) node.getLeft(), element);
				node.setLeft(left);
				if (!left.isEmpty()) { 
					left.setParent(node);
				}
			} else if (cmp > 0) {
				BSTNode<T> right = remove((BSTNode<T>) node.getRight(), element);
				node.setRight(right);
				if (!right.isEmpty()) { 
					right.setParent(node);
				}
			} else {

				if (node.getLeft().isEmpty() && node.getRight().isEmpty()) {
					result = new BSTNode<>();
					result.setParent(node.getParent());
				} else if (node.getLeft().isEmpty()) {
					result = (BSTNode<T>) node.getRight();
					result.setParent(node.getParent());
				} else if (node.getRight().isEmpty()) {
					result = (BSTNode<T>) node.getLeft();
					result.setParent(node.getParent());
				} else {
					BSTNode<T> succ = minimum((BSTNode<T>) node.getRight());
					node.setData(succ.getData());
					BSTNode<T> right = remove((BSTNode<T>) node.getRight(), succ.getData());
					node.setRight(right);
					if (!right.isEmpty()) { 
						right.setParent(node);
					}
					result = node;
				}
			}
		}

		return result; 
	}

	@Override
	public T[] preOrder() {
		T[] array = (T[]) new Comparable[this.size()];
		int[] pos = {0}; 
		preOrder(array, pos, root);
		return array;
	}

	private void preOrder(T[] array, int[] pos, BTNode<T> node){
		if (!node.isEmpty()){
			array[pos[0]++] = node.getData(); 
			preOrder(array, pos, node.getLeft());
			preOrder(array, pos, node.getRight());
		}
	}

	@Override
	public T[] order() {
		T[] array = (T[]) new Comparable[this.size()]; 
		int[] pos = {0};
		order(array, pos, root);
		return array;
	}

	private void order(T[] array, int[] pos, BTNode<T> node){
		if (!node.isEmpty()){
			order(array, pos, node.getLeft());
			array[pos[0]++] = node.getData();
			order(array, pos, node.getRight());
		}
	}


	@Override
	public T[] postOrder() {
		T[] array = (T[]) new Comparable[this.size()];
		int[] pos = {0};
		postOrder(array, pos, root);
		return array;
	}

	private void postOrder(T[] array, int[] pos, BTNode<T> node){
		if (!node.isEmpty()){
			postOrder(array, pos, node.getLeft());
			postOrder(array, pos, node.getRight());
			array[pos[0]++] = node.getData();
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
