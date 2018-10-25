package com.aed.lab3.generic;

import java.util.ArrayList;

public class Node<K extends Comparable <? super K>, V> {

	private K key;
	private ArrayList<V> vals;
	private int fe;
	private Node<K, V> left, right, parent;
	
	public Node(K k, V v) {
		vals = new ArrayList<>();
		key = k;
		vals.add(v);
		fe = 0;
		left = null;
		right = null;
		parent = null;
	}
	public K getKey() {
		return key;
	}
	public ArrayList<V> getVal() {
		return vals;
	}
	public Node<K, V> getLeft() {
		return left;
	}
	public void setLeft(Node<K, V> izq) {
		this.left = izq;
	}
	public Node<K, V> getRight() {
		return right;
	}
	public void setRight(Node<K, V> der) {
		this.right = der;
	}
	public int getFe() {
		return fe;
	}
	public void setFe(int fe) {
		this.fe = fe;
	}
	public Node<K, V> getParent() {
		return parent;
	}
	public void setParent(Node<K, V> dad) {
		this.parent = dad;
	}
	
}
