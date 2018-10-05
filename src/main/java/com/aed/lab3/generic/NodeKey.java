package com.aed.lab3.generic;

public class NodeKey<K, T>  {
	
	private K key;
	private T value;
	private NodeKey<K,T> next;
	
	public NodeKey(K key, T value) {
		this.key = key;
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public NodeKey<K,T> getNext(){
		return next;
	}
	
	public void setNext(NodeKey<K,T> next) {
		this.next = next;
	}
	
	

}
