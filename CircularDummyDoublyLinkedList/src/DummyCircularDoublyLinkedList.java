
public class DummyCircularDoublyLinkedList<T> {
	Node<T> dummy;

	public DummyCircularDoublyLinkedList() {
		dummy = new Node(null);
		dummy.next = dummy;
		dummy.previous = dummy;

	}

	public void insertFirst(T data) {
		Node<T> nono = new Node(data);
		nono.next = dummy.next;
		nono.previous = dummy;
		dummy.next.previous = nono;
		dummy.next = nono;
	}

	public void insertLast(T data) {
		Node<T> nono = new Node(data);
		nono.previous = dummy.previous;
		nono.next = dummy;
		dummy.next.previous = nono;
		dummy.previous = nono;
	}

	public void insertMiddle(T node, T data) {
		Node<T> prev = findNode(node);
		if (prev == dummy) {
			System.out.println("Node not found.");
			return;
		}

		Node<T> nono = new Node<>(data);
		nono.next = prev.next;
		nono.previous = prev;
		prev.next = nono;

		if (nono.next != dummy) {
			nono.next.previous = nono;
		}
	}

	public int size() {
		Node<T> current = dummy.next;
		int count = 0;
		while (current != dummy) {
			count++;
		}
		return count;
	}

	public void display() {
		int count = 1;
		if (dummy == null || dummy.next == dummy) {
			System.out.println("List is Empty");
			return;
		}
		Node<T> current = dummy.next;

		while (current != dummy) {
			System.out.println(count + ". " + current.data);
			current = current.next;
			count++;
		}

	}

	public boolean deleteAll() {

		Node<T> current = dummy.next;
		while (current != dummy) {
			dummy.next = null;
			dummy.previous = null;
			current = current.next;
		}
		dummy.next = dummy;
		dummy.previous = dummy;
		return true;
	}

	public Node<T> findNode(T data) {
		Node<T> current = dummy.next;

		while (current != dummy) {
			if (current.data != null && current.data.equals(data)) {
				return current;
			}
			current = current.next;
		}

		return null;
	}

	public void delete(T data) {
		Node deletion = findNode(data);
		if (deletion == null) {
			System.out.println("Node not found");
			return;
		}
		deletion.previous.next = deletion.next;
		deletion.next.previous = deletion.previous;
		deletion.next = null;
		deletion.previous = null;
	}

	public void bubbleSort() {
		if (dummy.next == dummy || dummy.next.next == dummy) {
			return;
		}

		boolean swapped;
		do {
			swapped = false;
			Node<T> current = dummy.next;

			while (current.next != dummy) {
				if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
					T temp = current.data;
					current.data = current.next.data;
					current.next.data = temp;
					swapped = true;
				}
				current = current.next;
			}
		} while (swapped);
	}

	public void displaySorted() {
		bubbleSort();
		int count = 1;
		if (dummy == null || dummy.next == dummy) {
			System.out.println("List is Empty");
			return;
		}
		Node<T> current = dummy.next;

		while (current != dummy) {
			System.out.println(count + ". " + current.data);
			current = current.next;
			count++;
		}
	}
}
