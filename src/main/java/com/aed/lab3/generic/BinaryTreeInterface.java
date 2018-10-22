package com.aed.lab3.generic;

public interface BinaryTreeInterface<K extends Comparable<K>, V> {
	
	public void insert(K key, V value);
	public TreeNode<K,V> search(K key);
	public TreeNode<K,V> min(TreeNode<K,V> node);
	public TreeNode<K,V> max(TreeNode<K,V> node);
	public TreeNode<K,V> successor(K key);
	public TreeNode<K,V> predecessor(K key);
	public void delete(K key);
	
	
}
