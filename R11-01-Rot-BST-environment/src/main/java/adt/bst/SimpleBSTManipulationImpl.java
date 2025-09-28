package adt.bst;

import adt.bt.BT;
import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return nodeEquals(tree1.getRoot(), tree2.getRoot());
	}

	private boolean nodeEquals(BTNode node1, BTNode node2){
		boolean result = true;

		if (node1.isEmpty() && node2.isEmpty()){
			result = true;

		} else if (node1.isEmpty() || node2.isEmpty()){
			result = false;

		} else if (node1.equals(node2)){
			result = nodeEquals(node1.getLeft(), node2.getLeft()) && nodeEquals(node1.getRight(), node2.getRight());

		} else {
			result = false;
		}

		return result;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return nodeIsSimilar(tree1.getRoot(), tree2.getRoot());
	}

	private boolean nodeIsSimilar(BTNode node1, BTNode node2) {
		boolean result = true;

		if (node1.isEmpty() && node2.isEmpty()){
			result = true;

		} else if (node1.isEmpty() || node2.isEmpty()){
			result = false;

		} else {
			result = nodeIsSimilar(node1.getLeft(), node2.getLeft()) && nodeEquals(node1.getRight(), node2.getRight());
		}

		return result;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		BSTNode min = tree.minimum();


	}


	private T orderSucc(BSTNode node, int k) {
		

}
