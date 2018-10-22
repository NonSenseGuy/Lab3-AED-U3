package com.aed.lab3.generic;

import java.util.ArrayList;

public class BinaryTree<K extends Comparable<K>, V> implements BinaryTreeInterface<K,V>{
	
	private TreeNode<K,V> root;
	private int size;
	
	public BinaryTree() {
		size = 0;
	}
	
	public TreeNode<K,V> getRoot(){
		return this.root;
	}
	
	public int size() {
		return size;
	}

	@Override
	public void insert(K key, V value) {
		TreeNode<K,V> node = new TreeNode<K,V>(key, value);
		TreeNode<K,V> aux;
		if(root == null) {
			this.root = node;
			size++;
		}else if((aux = search(key)) != null){
			aux.getValue().add(value);
		}else {
			insert(root, node);
		}
		
	}
	
	private void insert(TreeNode<K,V> current, TreeNode<K,V> newNode) {
		int compare = current.compareTo(newNode.getKey());
		//if the new node is greater than current 
		if(compare < 0) {
			//if the left child of current is null, the new node is inserted there
			if(current.getRight() == null) {
				current.setRight(newNode);
				newNode.setParent(current);
				size++;
				return;
			//else keep evaluating
			}else {
				insert(current.getRight(), newNode);
			}
		}else {
			if(current.getLeft() == null) {
				current.setLeft(newNode);
				newNode.setParent(current);
				size++;
				return;
			}else {
				insert(current.getLeft(), newNode);
			}
		}
	}

	@Override
	public TreeNode<K,V> search(K key) {
		if(root == null) {
			return null;
		}else {
			return search(root, key);
		}
	}
	
	private TreeNode<K,V> search(TreeNode<K,V> node, K key) {
		if(node == null || node.compareTo(key) == 0){
			return node;
		}else {
			if(node.compareTo(key) < 0) {
				return search(node.getRight(), key);
			}else {
				return search(node.getLeft(), key);
			}
		}
	}
	//Returns the minimum key in the tree
	@Override
	public TreeNode<K,V> min(TreeNode<K,V> node) {
		if(node != null) {
			while(node.getLeft() != null) {
				node = node.getLeft();
			}
			return node;
		}
		return null;
	}
	//Returns the maximum key in the tree
	@Override
	public TreeNode<K,V> max(TreeNode<K,V> node) {
		if(node != null) {
			while(node.getRight() != null) {
				node = node.getRight();
			}
			return node;
		}
		return null;
	}
	
	@Override
	public TreeNode<K,V> successor(K key) {
		if(root != null) {
			return successor(search(key));
		}
		return null;
	}

	
	private TreeNode<K,V> successor(TreeNode<K,V> node) {
		if(node.getRight() != null) {
			return min(node.getRight());
		}
		TreeNode<K,V> y = node.getParent();
		while(y != null && node == y.getRight()) {
			node = y;
			y = y.getParent();
		}
		return y;
	}

	@Override
	public TreeNode<K,V> predecessor(K key) {
		if(root != null) {
			return predecessor(search(key));
		}
		return null;
	}
	
	private TreeNode<K,V> predecessor(TreeNode<K,V> node) {
		if(node.getLeft() != null) {
			return max(node.getLeft());
		}
		TreeNode<K,V> y = node.getParent();
		while(y != null && node == y.getLeft()) {
			node = y;
			y = y.getParent();
		}
		return y;
	}
	

	@Override
	public void delete(K key) {
		if(root != null) {
			delete(search(key));
		}
		
	}
	
	public void deleteValue(K key, V value) {
		ArrayList<V> values = search(key).getValue();
		for(int i = 0; i < values.size(); i++) {
			if(values.get(i).equals(value)) {
				values.remove(i);
			}
		}
		if(values.size() == 0) {
			delete(key);
		}
	}
	
	private void delete(TreeNode<K,V> node) {
		
		
		
		if(node.isLeaf()) {// If the node is a leaf
			if(node.getParent().compareTo(node.getKey()) < 0) {// Get to the parent evaluate wich child is the one to be deleted
				node.getParent().setRight(null);// Set left or right child null 
				size--;
			}else {
				node.getParent().setLeft(null);
				size--;
			}
		}else if(node.hasOneChild()) {// If the node has only one child
			if(node.getParent().compareTo(node.getKey()) < 0) {//Get to the parent of the deleted node and set the child of the deleted node 
				if(node.getLeft() != null) {					//to be the child of the parent 
					node.getParent().setRight(node.getLeft());
				}else {
					node.getParent().setRight(node.getRight());
				}
				size--;
			}else {
				if(node.getLeft() != null) {
					node.getParent().setLeft(node.getLeft());
				}else {
					node.getParent().setLeft(node.getRight());
				}
				size--;
			}
		}else {//If the node has 2 childs gets replaced with its successor and the succeessor its deleted
			TreeNode<K,V> successor = successor(node);
			node.setKey(successor.getKey());
			node.setValue(successor.getValue());
			delete(successor);
				
		}
	}
	
//	public String inorder() {
//		if(root != null) {
//			return inorder("", root);
//		}else {
//			return "";
//		}
//	}
	
//	private String inorder(String msg,TreeNode<K,V> node) {
//		 if (node == null) 
//	            return msg;
//	  
//	        /* first recur on left child */
//	        return inorder(msg, node.getLeft() ); 
//	  
//	        /* then print the data of node */
//	        msg += (node.getKey() + " "); 
//	  
//	        /* now recur on right child */
//	        return inorder(msg ,node.getRight()); 
//	}


	
	
	
	
}
