package com.aed.lab3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.aed.lab3.generic.AVLTree;
import com.aed.lab3.generic.Node;

class AVLTreeTest {
	
	AVLTree<Double, String> tree;

	void setup() {
		tree = new AVLTree<>();
		tree.insert(new Node<Double,String>(1.0, "1.0"));
	}
	
	@Test
	void insert1Test() {
		setup();
		
		assertTrue(tree.getRoot().getKey() == 1.0);
	}
	
	@Test
	void search1Test() {
		setup();
		assertTrue(tree.getRoot().getKey()  == tree.search(1.0).getKey());
	}

	
	void setup2() {
		setup();
		for (double i = 2; i < 10; i++) {
			tree.insert(new Node<Double,String>(i, "" + i));
		}
	}
	
	@Test
	void rootTest() {
		setup2();
		assertTrue(tree.getRoot().getKey() == 4);
	}
	
	@Test
	void search2Test() {
		setup2();
		assertTrue(tree.search(6.0) == tree.getRoot().getRight());
	}

}
