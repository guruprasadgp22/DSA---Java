package Single_Linked_List;

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class SingleLinkedList {
	
	public Node head;
	int size;
	
	{
		size = 0;
	}
	
	void addFirst(int arr) {
		Node newNode = new Node(arr);
		size++;
		if(head == null) {
			head = newNode;
			return;
		}
		
		newNode.next = head;
		head = newNode;
	}
	
	void addLast(int arr) {
		Node newNode = new Node(arr);
		size++;
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node currentNode = head;
		
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		
		currentNode.next = newNode;
	}
	
	void deleteFirst() {
		if(head == null) {
			return;
		}
		size--;
		head = head.next;
	}
	
	void deleteLast() {
		if(head == null) {
			return;
		}
		
		size--;
		Node curr = head;
		Node temp = head.next;
		while(temp.next != null) {
			temp = temp.next;
			curr = curr.next;
		}
		
		curr.next = null;
	}
	
	void print() {
		Node currentNode = head;
		
		while(currentNode.next != null) {
			System.out.print(currentNode.data + " -> ");
			currentNode = currentNode.next;
		}
		System.out.println(currentNode.data);
	}
	
	int getSize() {
		return size;
	}
}

public class Main {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		SingleLinkedList list = new SingleLinkedList();
		
		for(int ele: arr) {
			list.addLast(ele);
		}
		
		System.out.print("After Insertion at end: ");
		list.print();
		System.out.println("Size: " + list.getSize());
		
		list.deleteFirst();
		System.out.print("After deletion at start: ");
		list.print();
		System.out.println("Size: " + list.getSize());

		list.deleteLast();
		System.out.print("After deletion at end: ");
		list.print();
		System.out.println("Size: " + list.getSize());

	}
}
