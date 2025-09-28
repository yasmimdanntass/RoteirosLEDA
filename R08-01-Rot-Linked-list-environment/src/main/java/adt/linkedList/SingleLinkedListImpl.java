package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int result = 0;

		SingleLinkedListNode<T> auxHead = this.head;

		while (!auxHead.isNIL()){
			result++;
			auxHead = auxHead.getNext();
		}

		return result;
	}

	@Override
	public T search(T element) {
		T result = null;

		if (element != null){
			SingleLinkedListNode<T> auxHead = this.head;	

			while (!auxHead.isNIL()) {
				if (element.equals(auxHead.getData())){
					result = auxHead.getData();
				}

				auxHead = auxHead.getNext();
			}
		}
		return result;
		
	}
	

	@Override
	public void insert(T element) {
		if (element != null){

			SingleLinkedListNode<T> auxHead = this.head;

			if (auxHead.isNIL()){
				this.head.setData(element);
				this.head.setNext(new SingleLinkedListNode<>());
			} else {
				while (!auxHead.getNext().isNIL()){
					auxHead = auxHead.getNext();
				}
				auxHead.getNext().setData(element);
				auxHead.getNext().setNext(new SingleLinkedListNode<>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && element != null){

			if (this.head.getData().equals(element)){
				this.head = this.head.getNext();

			} else {
				SingleLinkedListNode<T> auxHead = this.head;

				while (!auxHead.getNext().isNIL() && !auxHead.getNext().getData().equals(element)) {
					auxHead = auxHead.getNext();
				}

				if (!auxHead.getNext().isNIL()) {
					auxHead.setNext(auxHead.getNext().getNext());
    		    }
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];

		SingleLinkedListNode<T> auxHead = this.head;

		int position = 0;

		while (!auxHead.isNIL()){
			array[position] = auxHead.getData();
			auxHead = auxHead.getNext();
			position++;
		}

		return array;

	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
