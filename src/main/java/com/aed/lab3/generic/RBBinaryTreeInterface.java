package com.aed.lab3.generic;

public interface RBBinaryTreeInterface<K extends Comparable<K>,V> {
	
	public void insert(K key, V value);
	public RBTreeNode<K,V> search(K key);
	public RBTreeNode<K,V> min(RBTreeNode<K,V> node);
	public RBTreeNode<K,V> max(RBTreeNode<K,V> node);
	public RBTreeNode<K,V> successor(K key);
	public RBTreeNode<K,V> predecessor(K key);
	public RBTreeNode<K,V> delete(K key);
}
