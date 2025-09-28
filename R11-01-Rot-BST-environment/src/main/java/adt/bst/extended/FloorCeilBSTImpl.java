package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		this.root = new BSTNode<>();

		for (Integer i : array) {
			this.insert(i);
		}
		return floor(numero, this.getRoot());
	}

	private Integer floor(double numero, BTNode<Integer> node){

		Integer result = null;

		if (!(node == null || node.isEmpty())){
			Integer data = node.getData();
			if (data == numero) {
				result = data;
			} else if (data > numero) {
				result = floor(numero, node.getLeft());
			} else {
				Integer rightFloor = floor(numero, node.getRight());
				if (rightFloor != null) {
					result = rightFloor;
				} else {
					result = data;
				}
			}
		}

		return result;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		this.root = new BSTNode<>();

		for (Integer i : array) {
			this.insert(i);
		}
		return ceil(numero, this.getRoot());

	}

	private Integer ceil(double numero, BTNode<Integer> node) {
		Integer result = null;

		if (!(node == null || node.isEmpty())){
			Integer data = node.getData();
			if (data == numero) {
				result = data;
			} else if (data < numero) {
				result = ceil(numero, node.getRight());
			} else {
				Integer leftCeil = ceil(numero, node.getLeft());
				if (leftCeil != null) {
					result = leftCeil;
				} else {
					result = data;
				}
			}
		}

		return result;
	}

}
