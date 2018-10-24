package com.aed.lab3.generic;

import javafx.util.Pair;

public class RBBinaryTree<K extends Comparable<K>, V> implements RBBinaryTreeInterface<K,V>{
	
	private RBTreeNode<K,V> root;
	private RBTreeNode<K,V> nil;
	private long size;
	
	public RBBinaryTree() {
		size = 0;
		root = nil;
		root.setParent(nil);
		nil = new RBTreeNode<K,V>(null,null,false);
	}
	
	public RBTreeNode<K,V> getRoot(){
		return root;
	}
	
	public void setRoot(RBTreeNode<K,V> root ) {
		this.root = root;
	}
	
	public long size() {
		return size;
	}
	
	
	public RBTreeNode<K, V> getNil() {
		return nil;
	}

	public void setNil(RBTreeNode<K, V> nil) {
		this.nil = nil;
	}
	
	@Override
	public void insert(K key, V value) {
		RBTreeNode<K,V> x;
		if((x = search(key)) != null) {
			x.getValue().add(value);
		}else {
			insert(new RBTreeNode<K,V>(key,value, RBTreeNode.RED));
		}
	}

	
	private void insert(RBTreeNode<K,V> z) {
		RBTreeNode<K,V> y = nil;
		RBTreeNode<K,V> x = root;
		while(x != nil) {
			y = x;
			if(z.compareTo(y.getKey()) < 0) {
				x = y.getLeft();
			}else {
				x = y.getRight();
			}
		}
		z.setParent(y);
		if(y == nil) {
			root = z;
		}else {
			if(z.compareTo(y.getKey()) < 0) {
				y.setLeft(z);
			}else {
				y.setRight(z);
			}
		}
		z.setLeft(nil);
		z.setRight(nil);
		insertFixUp(z);
		
	}
	
	private void insertFixUp(RBTreeNode<K,V> z) {
		RBTreeNode<K,V> y = null;
		while(z.getParent().isColor() == RBTreeNode.RED) {
			if(z.getParent() == z.getParent().getParent().getLeft()) {
				y = z.getParent().getParent().getRight();
				if(y.isColor() == RBTreeNode.RED) {
					z.getParent().setColor(RBTreeNode.BLACK);
					y.setColor(RBTreeNode.BLACK);
					z.getParent().getParent().setColor(RBTreeNode.RED);
					z = z.getParent().getParent();
				}else {
					if(z == z.getParent().getRight()) {
						z = z.getParent();
						leftRotate(z);
					}
					z.getParent().setColor(RBTreeNode.BLACK);
					z.getParent().getParent().setColor(RBTreeNode.RED);
					rightRotate(z.getParent().getParent());
				}
			}else {
				y = z.getParent().getParent().getLeft();
				if(y.isColor() == RBTreeNode.RED) {
					z.getParent().setColor(RBTreeNode.BLACK);
					y.setColor(RBTreeNode.BLACK);
					z.getParent().getParent().setColor(RBTreeNode.RED);
					z = z.getParent().getParent();
				}else {
					if(z == z.getParent().getLeft()) {
						z = z.getParent();
						rightRotate(z);
					}
					z.getParent().setColor(RBTreeNode.BLACK);
					z.getParent().getParent().setColor(RBTreeNode.RED);
					leftRotate(z.getParent().getParent());
				}
			}
		}
		root.setColor(RBTreeNode.BLACK);
	}
	
	
	public void leftRotate(RBTreeNode<K,V> x) {
		RBTreeNode<K,V> y = x.getRight();
		x.setRight(y.getLeft());
		y.getLeft().setParent(x);
		y.setParent(x.getParent());
		if(x.getParent() == nil) {
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
	
	public void rightRotate(RBTreeNode<K,V> x) {
		RBTreeNode<K,V> y = x.getLeft();
		x.setLeft(y.getRight());
		y.getRight().setParent(x);
		y.setParent(x.getParent());
		if(x.getParent() == nil) {
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

	@Override
	public RBTreeNode<K, V> search(K key) {
		return search(root, key);
	}
	
	private RBTreeNode<K,V> search(RBTreeNode<K,V> current, K key){
		if(current == nil || current.getKey().compareTo(key) == 0) {
			return current;
		}
		if(current.getKey().compareTo(key)<0) {
			return search(current.getLeft(), key);
		}else {
			return search(current.getRight(), key);
		}
	}

	@Override
	public RBTreeNode<K, V> min(RBTreeNode<K, V> node) {
		if(node != null) {
			while(node.getLeft() != null) {
				node = node.getLeft();
			}
			return node;
		}
		return null;
	}

	@Override
	public RBTreeNode<K, V> max(RBTreeNode<K, V> node) {
		if(node != null) {
			while(node.getRight() != null) {
				node = node.getRight();
			}
			return node;
		}
		return null;
	}

	@Override
	public RBTreeNode<K,V> successor(K key) {
		if(root != null) {
			return successor(search(key));
		}
		return null;
	}

	
	private RBTreeNode<K,V> successor(RBTreeNode<K,V> node) {
		if(node.getRight() != null) {
			return min(node.getRight());
		}
		RBTreeNode<K,V> y = node.getParent();
		while(y != null && node == y.getRight()) {
			node = y;
			y = y.getParent();
		}
		return y;
	}

	@Override
	public RBTreeNode<K,V> predecessor(K key) {
		if(root != null) {
			return predecessor(search(key));
		}
		return null;
	}
	
	private RBTreeNode<K,V> predecessor(RBTreeNode<K,V> node) {
		if(node.getLeft() != null) {
			return max(node.getLeft());
		}
		RBTreeNode<K,V> y = node.getParent();
		while(y != null && node == y.getLeft()) {
			node = y;
			y = y.getParent();
		}
		return y;
	}

	@Override
	public void delete(K key,V value) {
		RBTreeNode<K,V> z = search(key);
		if(z != nil) {
			for (int i = 0; i < z.getValue().size(); i++) {
				if(z.getValue().get(i).equals(value)) {
					z.getValue().remove(i);
					return;
				}
			}
			delete(z);
		}
	}
	
	private void delete(RBTreeNode<K,V> z) {
		RBTreeNode<K,V> y;
		RBTreeNode<K,V> x;
		if(z.getLeft() == nil || z.getRight() == nil) {
			y = z;
		}else {
			y = successor(z);
		}
		if(y.getLeft() != nil) {
			x = y.getLeft();
		}else {
			x = y.getRight();
		}
		x.setParent(y.getParent());
		if(y.getParent() == nil) {
			root = x;
		}else {
			if(y == y.getParent().getLeft()) {
				y.getParent().setLeft(x);
			}else {
				y.getParent().setRight(x);
			}
		}
		if(y != z) {
			z.setKey(y.getKey());
		}
		if(y.isColor() == RBTreeNode.BLACK) {
			deleteFixUp(x);
		}
	}
	
	private void deleteFixUp(RBTreeNode<K,V> x) {
		RBTreeNode<K,V> w;
		while(root != x && x.isColor() == RBTreeNode.BLACK) {
			if(x == x.getParent().getLeft()) {
				w = x.getParent().getRight();
				if(w.isColor() == RBTreeNode.RED) {
					w.setColor(RBTreeNode.BLACK);
					x.getParent().setColor(RBTreeNode.RED);
					leftRotate(x);
					w = x.getParent().getRight();
				}
				if(w.getLeft().isColor() == RBTreeNode.BLACK && w.getRight().isColor() == RBTreeNode.BLACK) {
					w.setColor(RBTreeNode.RED);
					x = x.getParent();
				}else {
					if(w.getRight().isColor() == RBTreeNode.BLACK) {
						w.getLeft().setColor(RBTreeNode.BLACK);
						w.setColor(RBTreeNode.RED);
						rightRotate(w);
						w = x.getParent();
					}
					w.setColor(x.getParent().isColor());
					x.getParent().setColor(RBTreeNode.BLACK);
					w.getRight().setColor(RBTreeNode.BLACK);
					leftRotate(x.getParent());
					x = root;
				}
			}else {
				w = x.getParent().getLeft();
				if(w.isColor() == RBTreeNode.RED) {
					w.setColor(RBTreeNode.BLACK);
					x.getParent().setColor(RBTreeNode.RED);
					rightRotate(x);
					w = x.getParent().getLeft();
				}
				if(w.getLeft().isColor() == RBTreeNode.BLACK && w.getRight().isColor() == RBTreeNode.BLACK) {
					w.setColor(RBTreeNode.RED);
					x = x.getParent();
				}else {
					if(w.getLeft().isColor() == RBTreeNode.BLACK) {
						w.getRight().setColor(RBTreeNode.BLACK);
						w.setColor(RBTreeNode.RED);
						leftRotate(w);
						w = x.getParent();
					}
					w.setColor(x.getParent().isColor());
					x.getParent().setColor(RBTreeNode.BLACK);
					w.getLeft().setColor(RBTreeNode.BLACK);
					rightRotate(x.getParent());
					x = root;
				}
			}
		}x.setColor(RBTreeNode.BLACK);
	}
	
	
}
