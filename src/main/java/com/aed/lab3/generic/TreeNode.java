package com.aed.lab3.generic;

import java.util.ArrayList;

public class TreeNode<K extends Comparable<K>, V> implements Comparable<K>{
	
	private K key;
	private ArrayList<V> value;
	private TreeNode<K,V> right;
	private TreeNode<K,V> left;
	private TreeNode<K,V> parent;
	

	public TreeNode(K key, V value ) {
		this.key = key;
		this.value = new ArrayList<>();
		this.value.add(value);
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K value) {
		this.key = value;
	}

	public ArrayList<V> getValue() {
		return value;
	}

	public void setValue(ArrayList<V> value) {
		this.value = value;
	}

	public TreeNode<K,V> getRight() {
		return right;
	}

	public void setRight(TreeNode<K,V> right) {
		this.right = right;
	}

	public TreeNode<K,V> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<K,V> left) {
		this.left = left;
	}
	public TreeNode<K,V> getParent() {
		return parent;
	}

	public void setParent(TreeNode<K,V> parent) {
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
