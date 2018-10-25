package com.aed.lab3.generic;

import java.util.ArrayList;

public class AVLTreeNode<K extends Comparable<K>, V> implements Comparable<AVLTreeNode<K,V>> {
	private K key;
	private ArrayList<V> value;
	private AVLTreeNode<K,V> left;
	private AVLTreeNode<K,V> right;
	public int level;
	private int depth;

	public AVLTreeNode(K key, V value) {
		this.key = key;
		this.value = new ArrayList<>();
		this.value.add(value);
		depth = 1;
	}

	public AVLTreeNode(K key,ArrayList<V> value, AVLTreeNode<K,V> left, AVLTreeNode<K,V> right) {
		this.key = key;
		this.left = left;
		this.right = right;
		if (left == null && right == null)
			setDepth(1);
		else if (left == null)
			setDepth(right.getDepth() + 1);
		else if (right == null)
			setDepth(left.getDepth() + 1);
		else
			setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
	}
	


	public K getKey() {
		return key;
	}

	public void setKey(K data) {
		key = data;
	}

	public ArrayList<V> getValue() {
		return value;
	}

	public void setValue(ArrayList<V> value) {
		this.value = value;
	}

	public AVLTreeNode<K,V> getLeft() {
		return left;
	}

	public void setLeft(AVLTreeNode<K,V> left) {
		this.left = left;
	}

	public AVLTreeNode<K,V> getRight() {
		return right;
	}

	public void setRight(AVLTreeNode<K,V> right) {
		this.right = right;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public int compareTo(AVLTreeNode<K,V> o) {
		return this.key.compareTo(o.key);
	}

	public boolean isLeaf() {
		return right == null && left == null;
	}
	
	public boolean hasOneChild() {
		return (right == null && left != null)||(right != null && left == null); 
	}
	
	


}
