package com.aed.lab3.generic;

public class TreeNode<E> {
	
	private E element;
	private TreeNode<E> parent;
	private TreeNode<E> left;
	private TreeNode<E> right;
	
	public TreeNode(E element) {
		this.element = element;
	}
	
	public TreeNode(E element, TreeNode<E> left, TreeNode<E> right, TreeNode<E> parent) {
		this. element = element;
		this.right = right;
		this.left = left;
		this.parent = parent;
	}
	
	public E getElement() {
		return element;
	}
	
	public void setElement(E element) {
		this.element = element;
	}
	
	public TreeNode<E> getParent() {
		return parent;
	}
	
	public void setParent(TreeNode<E> parent) {
		this.parent = parent;
	}
	
	public TreeNode<E> getLeft() {
		return left;
	}
	
	public void setLeft(TreeNode<E> left) {
		this.left = left;
	}
	
	public TreeNode<E> getRight() {
		return right;
	}
	
	public void setRight(TreeNode<E> right) {
		this.right = right;
	}
	
}
