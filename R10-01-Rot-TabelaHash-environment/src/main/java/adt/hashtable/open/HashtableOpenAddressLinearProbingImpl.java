package adt.hashtable.open;

import java.util.LinkedList;

import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null){
			if (isFull()){
				throw new HashtableOverflowException();
			}
			int index = getHashIndex(element, 0);
			this.table[index] = element;
		}		
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()){
			

		}
	}

	@Override
	public T search(T element) {
		T r = null;
		int possibleIndex = getHashIndex(element, COLLISIONS) 
		if (possibleIndex != -1){
			r = (T) this.table[possibleIndex];
		}

		return r;
	}

	@Override
	public int indexOf(T element) {
		return getHashIndex(element, 0);
	}

	private int getHashIndex(T element, int probe){
		int index = -1;

		if (!isFull()){
			index = getHashIndex(element, probe + 1);
			if (this.table[index] != null){
				index = getHashIndex(element, probe + 1);
				this.COLLISIONS++;
			}
		}

		return index;
	}
}
