package com.aed.lab3.generic;

public interface BinaryTreeInterface<K> {
	
	public void insert(K key);
	public boolean search(K key);
	public K min();
	public K max();
	public K successor(K key);
	public K predecessor(K key);
	public void delete(K key);
	
	
}
