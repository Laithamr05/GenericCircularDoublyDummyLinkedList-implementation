
public class Node<T> {
	Node<T> next;
	Node<T> previous;
	T data;

	public Node(T data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
}
