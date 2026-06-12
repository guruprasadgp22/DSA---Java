package Circular_Linked_List;

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class CircularLinkedList {
	Node head;
	Node tail;
	int size;
	
	{
		size = 0;
	}
	
	void addFirst(int val) {
		Node newNode = new Node(val);
		size++;
		if(head == null) {
			head = tail = newNode;
			tail.next = head;
			return;
		}
		newNode.next = head;
		head = newNode;
		tail.next = head;
	}
	
	void addLast(int val) {
		Node newNode = new Node(val);
		size++;
		if(head == null) {
			head = tail = newNode;
			tail.next = head;
			return;
		}
		
		tail.next = newNode;
		tail = newNode;
		tail.next = head;
	}
	
	void deleteFirst() {
		if(head == null) {
			return;
		}
		size--;
		head = head.next;
		tail.next = head;
	}
	
	void deleteLast() {
		if(head == null) {
			return;
		}
		size--;
		Node curr = head;
		
		while(curr.next != tail) {
			curr = curr.next;
		}
		
		tail = curr;
		tail.next = head;
	}
	
	void print() {
		if(head== null) {
			return;
		}
		
		Node curr = head;
		
		while(curr != tail) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}
	
	int getSize() {
		return size;
	}
}
public class Main {
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		
		int[] arr1 = {1,2,3,4};
		for(int val: arr1) {
			list.addLast(val);
		}
		System.out.println("After Insertion at end: ");
		list.print();
		System.out.println("Size: " + list.getSize());
		
		int[] arr2 = {5,6,7,8};
		for(int val: arr2) {
			list.addFirst(val);
		}
		System.out.println("After Insertion at start: ");
		list.print();
		System.out.println("Size: " + list.getSize());
		
		list.deleteFirst();
		System.out.println("After Deletion at start: ");
		list.print();
		System.out.println("Size: " + list.getSize());
		
		list.deleteLast();
		System.out.println("After Deletion at end: ");
		list.print();
		System.out.println("Size: " + list.getSize());

	}
}
