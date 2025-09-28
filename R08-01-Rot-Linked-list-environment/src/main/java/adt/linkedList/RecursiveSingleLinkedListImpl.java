package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		int size = 0;

		if (!isEmpty()){
			size = 1 + this.next.size();
		}

		return size;
	
	}

	@Override
	public T search(T element) {
		T result = null;
		
		if (element != null && !isEmpty()){
			if (element.equals(this.data)){
				result = this.data;
			} else {
				result = this.next.search(element);
			}
		}

		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null){
			if (isEmpty()){
				this.data = element;
				next = new RecursiveSingleLinkedListImpl<>();
			} else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()){
			if (element.equals(this.data)){
				this.data = this.next.getData();
				this.next = this.next.getNext();
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size()];
		fill(array, 0);
		return array;
	}

	private void fill(T[] array, int position){
		if (!isEmpty()) {
			array[position] = this.data;
			this.next.fill(array, position + 1);
		}		

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
