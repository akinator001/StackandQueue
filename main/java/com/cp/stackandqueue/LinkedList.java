package com.cp.stackandqueue;

public class LinkedList<K> {
	INode<K> head;
	INode<K> tail;

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void add(INode<K> node) {
		if (this.tail == null)
			this.tail = node;
		if (this.head == null) {
			this.head = node;
		} 
		else {
			INode<K> tempNode = this.head;
			this.head = node;
			this.head.setNext(tempNode);
		}
	}	
	
	public void append(INode<K> newNode) {
		if (this.tail == null) {
			this.tail = newNode;
		}
		if (this.head == null) {
			this.head = newNode;
		} 
		else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}
	
	public void print() {
		INode<K> tmp = head ; 
		while(tmp != null) {
			System.out.print(tmp.getKey()+"->");
			tmp=tmp.getNext();
		}
		System.out.println();
	}
	
	public void insert(INode<K> pNode, INode<K> node, INode<K> nNode) {
		pNode.setNext(node);
		node.setNext(nNode);
	}
	
	public INode<K> pop() {
		INode<K> tmp = head;
		head = head.getNext();
		return tmp;	
	}
	
	public INode<K> popLast() {
		INode<K> tmp = head;
		while( tmp.getNext() != tail) {
			tmp = tmp.getNext();
		}
		tail = tmp;
		tmp = tmp.getNext();
		tail.setNext(null);
		return tmp;
	}
	
	public boolean searchNode(K key){
		INode<K> tmp = head;
		while(tmp != null) {
			if(tmp.getKey() == key)
				return true;
			tmp = tmp.getNext();
		}
		return false;
	}
	
	public void insert(INode<K> pNode, INode<K> node) {
		if(pNode.getNext() == null) {
			pNode.setNext(node);
		}
		else {
			INode<K> tmp = pNode.getNext();
			pNode.setNext(node);
			node.setNext(tmp);
		}
	}

	public int size() {
		int size = 0;
		INode<K> tmp = head;
		while (tmp != null) {
			size++;
			tmp = tmp.getNext();
		}
		return size;
	}
	
	public void pop(INode<K> node) {
		INode<K> tmp = head;
		while (tmp.getNext() != node) {
			tmp = tmp.getNext();
		}
		tmp.setNext(node.getNext());
	}
		
}
