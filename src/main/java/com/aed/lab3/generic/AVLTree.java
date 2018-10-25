package com.aed.lab3.generic;


public class AVLTree<K extends Comparable<K>,V> {
	
	AVLTreeNode<K,V> root;

	public AVLTree() {
		root = null;
	}

	public AVLTreeNode<K, V> getRoot() {
		return root;
	}
	
	public void setRoot(AVLTreeNode<K, V> root) {
		this.root = root;
	}

	public AVLTreeNode<K,V> Maximum() {
		AVLTreeNode<K,V> local = root;
		if (local == null)
			return null;
		while (local.getRight() != null)
			local = local.getRight();
		return local;
	}

	public AVLTreeNode<K,V> Minimum() {
		AVLTreeNode<K,V> local = root;
		if (local == null)
			return null;
		while (local.getLeft() != null) {
			local = local.getLeft();
		}
		return local;
	}

	private int depth(AVLTreeNode<K,V> node) {
		if (node == null)
			return 0;
		return node.getDepth();
		
	}

	public void insert(K key, V value) {
		AVLTreeNode<K,V> newNode;
		if((newNode = search(key)) != null) {
			newNode.getValue().add(value);
		}
		newNode = new AVLTreeNode<K,V>(key,value);
		root = insert(root,newNode);
		switch (balanceNumber(root)) {
		case 1:
			root = rotateLeft(root);
			break;
		case -1:
			root = rotateRight(root);
			break;
		default:
			break;
		}
		return root;
	}

	private AVLTreeNode<K,V> insert(AVLTreeNode<K,V> node, AVLTreeNode<K,V> newNode) {
		if (node == null)
			return newNode;
		if (node.compareTo(newNode) > 0) {
			node = new AVLTreeNode<K,V>(node.getKey(), node.getValue(), insert(node.getLeft(), newNode),
					node.getRight());
		} else if (node.compareTo(newNode) < 0) {
			node = new AVLTreeNode<K,V>(node.getKey(),node.getValue(), node.getLeft(), insert(
					node.getRight(), newNode));
		}
	
		switch (balanceNumber(node)) {
		case 1:
			node = rotateLeft(node);
			break;
		case -1:
			node = rotateRight(node);
			break;
		default:
			return node;
		}
		return node;
	}
	
//	public void delete(K key, V value){
//		AVLTreeNode<K,V> node;
//		if((node = search(key)) != null) {
//			for(int i = 0; i < node.getValue().size(); i++) {
//				if(node.getValue().get(i).equals(value)) {
//					node.getValue().remove(i);
//					if(node.getValue().isEmpty()) {
//						delete(node);
//						return;
//					}
//				}
//			}
//			delete(node);
//		}
//	
//	}
//	
//	private void delete(AVLTreeNode<K,V> node) {
//		if(node.isLeaf()) {// If the node is a leaf
//			if(getParent(node) == null) {
//				root = null;
//				return;
//			}else if(getParent(node).compareTo(node) < 0) {// Get to the parent evaluate wich child is the one to be deleted
//				getParent(node).setRight(null);// Set left or right child null 
//			}else {
//				getParent(node).setLeft(null);
//			}
//		}else if(node.hasOneChild()) {// If the node has only one child
//			if(getParent(node).compareTo(node) < 0) {//Get to the parent of the deleted node and set the child of the deleted node 
//				if(node.getLeft() != null) {					//to be the child of the parent 
//					getParent(node).setRight(node.getLeft());
//				}else {
//					getParent(node).setRight(node.getRight());
//				}
//			}else {
//				if(node.getLeft() != null) {
//					getParent(node).setLeft(node.getLeft());
//				}else {
//					getParent(node).setLeft(node.getRight());
//				}
//				
//			}
//		}else {//If the node has 2 childs gets replaced with its successor and the succeessor its deleted
//			AVLTreeNode<K,V> successor = successor(node);
//			node.setKey(successor.getKey());
//			node.setValue(successor.getValue());
//			delete(successor);
//				
//		}
//		
//		switch (balanceNumber(getParent(node))) {
//		case 1:
//			node = rotateLeft(node);
//			break;
//		case -1:
//			node = rotateRight(node);
//			break;
//		
//		}
//		
//		
//	}
	
	
	public AVLTreeNode<K,V> successor(K key) {
		if(root != null) {
			return successor(search(key));
		}
		return null;
	}

	
	private AVLTreeNode<K,V> successor(AVLTreeNode<K,V> node) {
		if(node.getRight() != null) {
			return min(node.getRight());
		}
		AVLTreeNode<K,V> y = node.getParent();
		while(y != null && node == y.getRight()) {
			node = y;
			y = y.getParent();
		}
		return y;
	}

	
	public AVLTreeNode<K,V> predecessor(K key) {
		if(root != null) {
			return predecessor(search(key));
		}
		return null;
	}
	
	public AVLTreeNode<K,V> min(AVLTreeNode<K,V> node) {
		if(node != null) {
			while(node.getLeft() != null) {
				node = node.getLeft();
			}
			return node;
		}
		return null;
	}
	
	public AVLTreeNode<K,V> max(AVLTreeNode<K,V> node) {
		if(node != null) {
			while(node.getRight() != null) {
				node = node.getRight();
			}
			return node;
		}
		return null;
	}
	
	private AVLTreeNode<K,V> predecessor(AVLTreeNode<K,V> node) {
		if(node.getLeft() != null) {
			return max(node.getLeft());
		}
		AVLTreeNode<K,V> y = node.getParent();
		while(y != null && node == y.getLeft()) {
			node = y;
			y = y.getParent();
		}
		return y;
	}

	private int balanceNumber(AVLTreeNode<K,V> node) {
		int L = depth(node.getLeft());
		int R = depth(node.getRight());
		if (L - R >= 2)
			return -1;
		else if (L - R <= -2)
			return 1;
		return 0;
	}

	private void rotateLeft(AVLTreeNode<K,V> x) {
		if(x.getRight() != null) {
			AVLTreeNode<K,V> y = x.getRight();
			x.setRight(y.getLeft());
			y.getLeft().setParent(x);
			y.setParent(x.getParent());
			if(x.getParent() == null) {
				root = y;
			}else {
				if(x == x.getParent().getLeft()) {
					x.getParent().setLeft(y);
				}else {
					x.getParent().setRight(y);
				}
			}
			y.setLeft(x);
			x.setParent(y);	
		}
	}
	
	

	private void rotateRight(AVLTreeNode<K,V> x) {
		if(x.getLeft() != null) {
			AVLTreeNode<K,V> y = x.getLeft();
			x.setLeft(y.getRight());
			y.getRight().setParent(x);
			y.setParent(x.getParent());
			if(x.getParent() == null) {
				root = y;
			}else {
				if(x == x.getParent().getRight()) {
					x.getParent().setRight(y);
				}else {
					x.getParent().setLeft(y);
				}
			}
			y.setRight(x);
			x.setParent(y);
		}
	}

	public AVLTreeNode<K, V> search(K key){
		return search(root, key);
	}
	
	private AVLTreeNode<K,V> search(AVLTreeNode<K,V> current, K key){
		if(current == null || current.getKey().compareTo(key) == 0) {
			return current;
		}
		if(current.getKey().compareTo(key)>0) {
			return search(current.getLeft(), key);
		}else {
			return search(current.getRight(), key);
		}
	}
	
//	private AVLTreeNode<K,V> getParent(AVLTreeNode<K,V> node){
//		if(root == node)
//			return null;
//		return getParent(root, node);
//	}
	
//	private AVLTreeNode<K,V> getParent(AVLTreeNode<K,V> parent, AVLTreeNode<K,V> child){
//		if(parent == null || parent.getLeft().compareTo(child) == 0 || parent.getRight().compareTo(child) == 0) {
//			return parent;
//		}
//		if(parent.compareTo(child)<0) {
//			return getParent(parent.getLeft(),child);
//		}else {
//			return getParent(parent.getRight(), child);
//		}
//	}

}



