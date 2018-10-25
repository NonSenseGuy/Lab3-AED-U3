package com.aed.lab3.generic;

public class List<T> implements IList<T>  {

	private Object[] array;
	private int size;
	public List() {
		array = new Object[10];
		size = 0;
	}
	@Override
	public void add(T o)
	{
		if(size==array.length)
		{
			Object[] a = new Object[size+10];
			for (int i = 0; i < array.length; i++) {
				a[i] = array[i];
			}
			array = a;
		}
		array[size] = (Object)o;
		size++;
	}
	@Override
	public void remove(int i) throws IndexOutOfBoundsException
	{
		if(i<size)
		{
			for (int j = i; j < array.length-1; j++) {
				array[j] = array[j+1];
			}
			size--;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
		
	}
	@Override
	public T get(int i) throws IndexOutOfBoundsException
	{
		if(i<size)
		{
			return (T)array[i];
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	
	public void set(int i, T p) throws IndexOutOfBoundsException
	{
			array[i] = p;	
	}
	
	@Override
	public int size()
	{
		return size;
	}
	
	public void addList(List<T> l)
	{
		for (int i = 0; i < l.size; i++) {
			add(l.get(i));
		}
	}


}
