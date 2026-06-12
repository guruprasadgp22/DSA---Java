package Double_Linked_List;

class Node {
	int data;
	Node prev;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

class DoubleLinkedList {
	Node head;
	int size;
	
	{
		size = 0;
	}
	
	void addFirst(int val) {
		Node newNode = new Node(val);
		size++;
		if(head == null) {
			head = newNode;
			return;
		}
		
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}
	
	void addLast(int val) {
		Node newNode = new Node(val);
		size++;
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node curr = head;
		
		while(curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = newNode;
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
		
		Node lastNode = head.next;
		Node secLastNode = head;
		
		while(lastNode.next != null) {
			secLastNode = secLastNode.next;
			lastNode = lastNode.next;
		}
		lastNode.prev = null;
		secLastNode.next = null;
	}
	
	void print() {
		Node curr = head;
		
		while(curr.next != null) {
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
		int[] arr1 = {1,2,3,4};
		DoubleLinkedList list = new DoubleLinkedList();
		for(int val: arr1) {
			list.addLast(val);
		}
		System.out.print("After Insertion at end: ");
		list.print();
		System.out.println("Size: " + list.getSize());
		
		int[] arr2 = {5,6,7,8};
		for(int val: arr2) {
			list.addFirst(val);
		}
		System.out.print("After Insertion at start: ");
		list.print();
		System.out.println("Size: " + list.getSize());
		
		list.deleteFirst();
		System.out.print("After Deletion at start: ");
		list.print();
		System.out.println("Size: " + list.getSize());
		
		list.deleteLast();
		System.out.print("After Deletion at end: ");
		list.print();
		System.out.println("Size: " + list.getSize());
	}
}