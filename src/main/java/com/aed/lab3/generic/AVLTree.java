package com.aed.lab3.generic;


public class AVLTree<K extends Comparable<K>,V> {
	
	AVLTreeNode<K,V> root;

	public AVLTree() {
		root = null;
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

	public AVLTreeNode<K,V> insert(K key, V value) {
		AVLTreeNode<K,V> newNode;
		if((newNode = search(key)) != null) {
			newNode.getValue().add(value);
			return root;
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

	public AVLTreeNode<K,V> insert(AVLTreeNode<K,V> node, AVLTreeNode<K,V> newNode) {
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

	private int balanceNumber(AVLTreeNode<K,V> node) {
		int L = depth(node.getLeft());
		int R = depth(node.getRight());
		if (L - R >= 2)
			return -1;
		else if (L - R <= -2)
			return 1;
		return 0;
	}

	private AVLTreeNode<K,V> rotateLeft(AVLTreeNode<K,V> node) {
		AVLTreeNode<K,V> q = node;
		AVLTreeNode<K,V> p = q.getRight();
		AVLTreeNode<K,V> c = q.getLeft();
		AVLTreeNode<K,V> a = p.getLeft();
		AVLTreeNode<K,V> b = p.getRight();
		q = new AVLTreeNode<K,V>(q.getKey(),q.getValue(), c, a);
		p = new AVLTreeNode<K,V>(p.getKey(),q.getValue(), q, b);
		return p;
	}

	private AVLTreeNode<K,V> rotateRight(AVLTreeNode<K,V> node) {
		AVLTreeNode<K,V>q = node;
		AVLTreeNode<K,V> p = q.getLeft();
		AVLTreeNode<K,V> c = q.getRight();
		AVLTreeNode<K,V> a = p.getLeft();
		AVLTreeNode<K,V> b = p.getRight();
		q = new AVLTreeNode<K,V>(q.getKey(),q.getValue(), b, c);
		p = new AVLTreeNode<K,V>(p.getKey(),q.getValue(), a, q);
		return p;
	}

	public AVLTreeNode<K, V> search(K key){
		return search(root, key);
	}
	
	private AVLTreeNode<K,V> search(AVLTreeNode<K,V> current, K key){
		if(current == null || current.getKey().compareTo(key) == 0) {
			return current;
		}
		if(current.getKey().compareTo(key)<0) {
			return search(current.getLeft(), key);
		}else {
			return search(current.getRight(), key);
		}
	}

}



