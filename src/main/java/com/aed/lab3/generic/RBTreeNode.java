package com.aed.lab3.generic;

import java.util.ArrayList;

public class RBTreeNode<K extends Comparable<K>,V> implements Comparable<K>{
	public final static boolean RED = true;
	public final static boolean BLACK = false;
	
	
	private K key;
	private ArrayList<V> value;
	private boolean color;
	private RBTreeNode<K,V> left;
	private RBTreeNode<K,V> right;
	private RBTreeNode<K,V> parent;
	
	
	public RBTreeNode(K key, V value, boolean color) {
		this.key = key;
		this.value = new ArrayList<>();
		this.value.add(value);
		this.color = color;
		
		
	}


	public K getKey() {
		return key;
	}


	public void setKey(K key) {
		this.key = key;
	}


	public ArrayList<V> getValue() {
		return value;
	}


	public void setValue(ArrayList<V> value) {
		this.value = value;
	}


	public boolean isColor() {
		return color;
	}


	public void setColor(boolean color) {
		this.color = color;
	}


	public RBTreeNode<K, V> getLeft() {
		return left;
	}


	public void setLeft(RBTreeNode<K, V> left) {
		this.left = left;
	}


	public RBTreeNode<K, V> getRight() {
		return right;
	}


	public void setRight(RBTreeNode<K, V> right) {
		this.right = right;
	}


	public RBTreeNode<K, V> getParent() {
		return parent;
	}


	public void setParent(RBTreeNode<K, V> parent) {
		this.parent = parent;
	}
	
	@Override
	public int compareTo(K o) {
		return key.compareTo(o);
	}
	
	public boolean isLeaf() {
		return right == null && left == null;
	}
	
	public boolean hasOneChild() {
		return (right == null && left != null)||(right != null && left == null); 
	}
	
	
	
	
}
