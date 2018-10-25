package com.aed.lab3.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.aed.lab3.generic.*;

@SuppressWarnings("unused")
class BSTTest {
	
	BinaryTree<Integer,String> bst;

	void setup() {
		bst = new BinaryTree<>();
	}
	@Test
	void insertBasicTest() {
		setup();
		bst.insert(5, "NonSense");
		assertTrue(bst.getRoot().compareTo(5)==0 && bst.getRoot().getValue().get(0).equals("NonSense"));
		
	}
	@Test
	void insertTest2() {
		setup();
		bst.insert(5, "NonSense");
		bst.insert(5, "Fredo0522");
		ArrayList<String> values = bst.getRoot().getValue();
		assertTrue(bst.getRoot().compareTo(5) == 0 && values.get(0).equals("NonSense") && values.get(1).equals("Fredo0522"));
	}
	
	@Test
	void insertRightChildTest() {
		setup();
		bst.insert(5, "NonSense");
		bst.insert(6, "Fredo0522");
		assertTrue(bst.getRoot().getRight().getKey().compareTo(6) == 0);
	}
	@Test
	void insertLeftChildTest(){
		setup();
		bst.insert(5, "NonSense");
		bst.insert(1, "Fredo0522");
		assertTrue(bst.getRoot().getLeft().getKey().compareTo(1) == 0);
	}
	
	@Test
	void insertTest3() {
		setup();
		bst.insert(5, "NonSense");
		bst.insert(1, "Fredo0522");
		bst.insert(2, "2");
		bst.insert(10, "10");
		bst.insert(9, "9");
		
		
	}

}
