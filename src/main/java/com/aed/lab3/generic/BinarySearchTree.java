package com.aed.lab3.generic;

public class BinarySearchTree<E extends Comparable<E>> implements TreeInterface<E>{
	
	private TreeNode<E> root;
	private long size;
	
	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
	}
	
	@Override
	public void insert(E element) {
		TreeNode<E> node = new TreeNode<E>(element);
		if(this.root == null) {
			this.root = node;
			this.root.setParent(null);
			size++;
		}else {
			insert(this.root, node);
		}
	}
	
	private boolean insert(TreeNode<E> current, TreeNode<E> adding) {
		
		int compare = adding.getElement().compareTo(current.getElement());
		
		if(compare < 0) {
			if(current.getLeft() == null) {
				adding.setParent(current);
				current.setLeft(adding);
				size++;
				return true;
			}
			
			insert(current.getLeft(), adding);
			
		}else if (compare > 0){
			if(current.getRight() == null) {
				adding.setParent(current);
				current.setRight(adding);
				size++;
				return true;
			}
			
			insert(current.getRight(), adding);
			
		}else{
			if(current.getLeft() == null) {
				adding.setParent(current);
				current.setLeft(adding);
				size++;
			}else {
				current.getLeft().setParent(adding);
				adding.setLeft(current.getLeft());
				adding.setParent(current);
				current.setLeft(adding);
				size++;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(E element) {
		TreeNode<E> elementDelete = search(this.root,element);
		
		if(elementDelete == null) return false;
		
		int numLeaf = 0;
		numLeaf += elementDelete.getLeft() != null ? 1 : 0;
		numLeaf += elementDelete.getRight() != null ? 1 : 0;
		
		if(numLeaf == 0) {
			if(elementDelete.getParent().getLeft().getElement().compareTo(elementDelete.getElement()) == 0) {
				elementDelete.getParent().setLeft(null);
			}else {
				elementDelete.getParent().setRight(null);
			}
			elementDelete.setParent(null);
		}else if(numLeaf == 1) {
			TreeNode<E> child = elementDelete.getRight() != null ? elementDelete.getRight() :elementDelete.getLeft();
			
			if(elementDelete.getParent().getLeft().getElement().compareTo(elementDelete.getElement()) == 0) {
				elementDelete.getParent().setLeft(child);
				child.setParent(elementDelete.getParent());
			}else {
				elementDelete.getParent().setRight(child);
				child.setParent(elementDelete.getParent());
			}
			elementDelete.setParent(null);
		}else {
			TreeNode<E> rightMin = min(this.root.getRight());
			elementDelete.setElement(rightMin.getElement());
			rightMin.getParent().setLeft(null);
			rightMin.setParent(null);
		}
		
		
		this.size--;
		return true;
	}

	@Override
	public E search(E element) {
		if(isEmpty()) return null;
		return search(this.root, element) != null ? search(this.root, element).getElement() : null;
	}
	
	private TreeNode<E> search(TreeNode<E> current, E element) {
		if(current == null || current.getElement().compareTo(element) == 0) return current;
		
		if(element.compareTo(current.getElement()) < 0) return search(current.getLeft(), element);
		else return search(current.getRight(), element);
	}
	

	@Override
	public boolean isEmpty() {
		return (this.root == null && this.size == 0);
	}

	@Override
	public E root() {
		return this.root != null ? this.root.getElement(): null;
	}

	@Override
	public E max() {
		return max(this.root).getElement();
	}
	
	private TreeNode<E> max(TreeNode<E> current) {
		if(current.getRight() == null) return current;
		else return max(current.getRight());
	}

	@Override
	public E min() {
		return min(this.root).getElement();
	}
	
	private TreeNode<E> min(TreeNode<E> current) {
		if(current.getLeft() == null) return current;
		else return min(current.getLeft());
	}
	
	public long size() {
		return this.size;
	}
}
