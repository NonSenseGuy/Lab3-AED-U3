package com.aed.lab3.generic;

public class TreeNode<V> {
	
	private V value;
	private TreeNode<V> right;
	private TreeNode<V> left;
	
	public TreeNode(V value) {
		this.value = value;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}

	public TreeNode<V> getRight() {
		return right;
	}

	public void setRight(TreeNode<V> right) {
		this.right = right;
	}

	public TreeNode<V> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<V> left) {
		this.left = left;
	}
	
	
	
}
