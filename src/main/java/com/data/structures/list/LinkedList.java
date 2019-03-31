package com.data.structures.list;

import java.util.HashSet;

public class LinkedList {
	public Node head;

	public void add(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	public void add(int data) {
		Node nodeToAdd = new Node(data);
		add(nodeToAdd);
	}

	public Node search(int data) {
		Node current = head;
		while (current != null) {
			if (current.data == data) {
				return current;
			}
			current = current.next;
		}
		// not found
		return null;
	}

	public int size() {
		Node current = head;
		int size = 0;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	public void removeDuplicates() {
		HashSet<Integer> duplicates = new HashSet<Integer>();
		Node current = head;
		while (current.next != null) {
			duplicates.add(current.data);
			// remove duplicates
			if (duplicates.contains(current.next.data)) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}

	public void removeDuplicates2() {
		HashSet<Integer> duplicates = new HashSet<Integer>();
		Node previous = null;
		Node current = head;
		while (current != null) {
			// remove duplicates
			if (duplicates.contains(current.data)) {
				previous.next = current.next;
			} else {
				duplicates.add(current.data);
				previous = current;
			}
			current = current.next;
		}
	}

	public void removeDuplicates3() {
		Node current = head;
		while (current != null) {
			Node previous = current;
			Node runner = current.next;
			while (runner != null) {
				if (runner.data == current.data) {
					previous.next = runner.next;
				} else {
					previous = runner;
				}
				runner = runner.next;
			}
			current = current.next;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Node current = head;
		while (current != null) {
			sb.append(current.data + " ");
			current = current.next;
		}
		sb.append("}");
		return sb.toString();
	}
}
