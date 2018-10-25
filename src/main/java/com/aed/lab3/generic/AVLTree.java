package com.aed.lab3.generic;

public class AVLTree<K extends Comparable <K>, V>{

	
	private Node<K, V> root;
	
	public AVLTree() {
		root = null;
	}
	
	
	public Node<K, V> getRoot(){
		return root;
	}

	
	public Node<K, V> search(K key){
		return searchAVL(key, root);
	}

	public Node<K, V> searchAVL(K key, Node<K, V> node){
		if(node!=null){
			if(node.getKey().compareTo(key)==0){
				return node;
			}else if(node.getKey().compareTo(key)<0){
				return searchAVL(key, node.getRight());
			}else{
				return searchAVL(key, node.getLeft());
			}
		}else{
			return null;
		}
	}
	
	private int getFe(Node<K, V> node){
		if(node==null){
			return -1;
		}else{
			return node.getFe();
		}
	}
	
	private Node<K, V> leftRotation(Node<K, V> node){
		Node<K, V> parent = node.getParent();
		Node<K, V> help = node.getLeft();
		node.setLeft(help.getRight());
		if(help.getRight()!=null){
			help.getRight().setParent(node);
		}
		help.setRight(node);
		node.setParent(help);
		help.setParent(parent);
		node.setFe(Math.max(getFe(node.getLeft()), getFe(node.getRight()))+1);
		help.setFe(Math.max(getFe(help.getLeft()), getFe(help.getRight()))+1);
		return help;
	}
	
	private Node<K, V> rightRotation(Node<K, V> node){
		Node<K, V> dad = node.getParent();
		Node<K, V> help = node.getRight();
		node.setRight(help.getLeft());
		if(help.getLeft()!=null){
			help.getLeft().setParent(node);
		}
		help.setLeft(node);
		node.setParent(help);
		help.setParent(dad);
		node.setFe(Math.max(getFe(node.getLeft()), getFe(node.getRight()))+1);
		help.setFe(Math.max(getFe(help.getLeft()), getFe(help.getRight()))+1);
		return help;
	}
	
	private Node<K, V> doubleLeftRotation(Node<K, V> node){
		node.setLeft(rightRotation(node.getLeft()));
		Node<K, V> help = leftRotation(node);
		return help;
	}
	
	private Node<K, V> doubleRightRotation(Node<K, V> node){
		node.setRight(leftRotation(node.getRight()));
		Node<K, V> help = rightRotation(node);
		return help;
	}
	
	private Node<K, V> insertAVL(Node<K, V> novo, Node<K, V> sub){
		Node<K, V> parent = sub;
		if(novo.getKey().compareTo(sub.getKey())<0){
			if(sub.getLeft()==null){
				sub.setLeft(novo);
				novo.setParent(sub);
			}else{
				sub.setLeft(insertAVL(novo, sub.getLeft()));
				sub.getLeft().setParent(parent);
				if(getFe(sub.getLeft())-getFe(sub.getRight())==2){
					if(novo.getKey().compareTo(sub.getLeft().getKey())<0){
						parent = leftRotation(sub);
					}else{
						parent = doubleLeftRotation(sub);
					}
				}
			}
			
		}
		else if(novo.getKey().compareTo(sub.getKey())>0){
			if(sub.getRight()==null){
				sub.setRight(novo);
				novo.setParent(sub);
			}else{
				sub.setRight(insertAVL(novo, sub.getRight()));
				sub.getRight().setParent(sub);
			}if(getFe(sub.getRight())-getFe(sub.getLeft())==2){
				if(novo.getKey().compareTo(sub.getRight().getKey())>0){
					parent = rightRotation(sub);
				}else{
					parent = doubleRightRotation(sub);
				}
			}
		}else{
			sub.getVal().add(novo.getVal().get(0));
		}
		if(sub.getLeft()==null&&sub.getRight()!=null){
			sub.setFe(sub.getRight().getFe()+1);
		}else if(sub.getLeft()!=null&&sub.getRight()==null){
			sub.setFe(sub.getLeft().getFe()+1);
		}else{
			sub.setFe(Math.max(getFe(sub.getLeft()), getFe(sub.getRight()))+1);
		}
		return parent;
	}
	
	public void insert(Node<K, V> novo){
		if(root==null){
			root = novo;
		}
		else{
			root = insertAVL(novo, root);
		}
	}

	
	public Node<K, V> min(Node<K, V> node) {
		if(node != null) {
			while(node.getLeft() != null) {
				node = node.getLeft();
			}
			return node;
		}
		return null;
	}

	public Node<K, V> max(Node<K, V> node) {
		if(node != null) {
			while(node.getRight() != null) {
				node = node.getRight();
			}
			return node;
		}
		return null;
	}
	
	public Node<K,V> successor(K key) {
		if(root != null) {
			return successor(search(key));
		}
		return null;
	}

	
	private Node<K,V> successor(Node<K,V> node) {
		if(node.getRight() != null) {
			return min(node.getRight());
		}
		Node<K,V> y = node.getParent();
		while(y != null && node == y.getRight()) {
			node = y;
			y = y.getParent();
		}
		return y;
	}

	public Node<K,V> predecessor(K key) {
		if(root != null) {
			return predecessor(search(key));
		}
		return null;
	}
	
	private Node<K,V> predecessor(Node<K,V> node) {
		if(node.getLeft() != null) {
			return max(node.getLeft());
		}
		Node<K,V> y = node.getParent();
		while(y != null && node == y.getLeft()) {
			node = y;
			y = y.getParent();
		}
		return y;
	}
}
