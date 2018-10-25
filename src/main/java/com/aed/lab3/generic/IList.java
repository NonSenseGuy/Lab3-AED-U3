package com.aed.lab3.generic;

public interface IList<T> {

	public void add(T o);
	
	public void remove(int i);
	
	public T get(int i);
	
	public int size();
}
