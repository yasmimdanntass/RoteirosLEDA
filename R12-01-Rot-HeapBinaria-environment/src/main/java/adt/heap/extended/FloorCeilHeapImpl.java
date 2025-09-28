package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;

		if (array != null ){
			HeapImpl<Integer> newHeap = new HeapImpl<>(comparator);

			for (Integer i : array){
				newHeap.insert(i);
			}

			floor = null;
			Integer atual = newHeap.extractRootElement();

			while (atual != null) {
				if (atual <= numero) {
					if (floor == null || atual > floor) {
						floor = atual;
					}
				}
				atual = newHeap.extractRootElement();
			}
		}

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;

		if (array != null){
			HeapImpl<Integer> newHeap = new HeapImpl<>(comparator);

			for (Integer i : array){
				newHeap.insert(i);
			}

			ceil = null;
			Integer atual = newHeap.extractRootElement();

			while (atual != null) {
				if (atual >= numero) {
					if (ceil == null || atual < ceil) {
						ceil = atual;
					}
				}
				atual = newHeap.extractRootElement();
			}
		}

		return ceil;
	}

}
