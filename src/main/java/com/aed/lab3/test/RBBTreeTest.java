package com.aed.lab3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.aed.lab3.generic.RBBinaryTree;
import com.aed.lab3.generic.RBTreeNode;

class RBBTreeTest {

	RBBinaryTree<Double,String> tree;
	
	void setup() {
		tree = new RBBinaryTree<>();
	}
	void setup2() {
		setup();
		tree.insert(5.0, "1");
	}
	
	@Test
	void insertTest1() {
		setup();
		tree.insert(5.0,"1");
		assertTrue(tree.getRoot().getKey() == 5.0);
		
	}
	
	@Test
	void insertTestLeft() {
		setup2();
		tree.insert(4.5, "2");
		assertTrue((tree.getRoot().getLeft().getKey() == 4.5) && tree.getRoot().getLeft().isColor() == RBTreeNode.RED);
	}
	
	@Test
	void insertTestRight() {
		setup2();
		tree.insert(9.2, "3");
		assertTrue(tree.getRoot().getRight().getKey() ==  9.2 && tree.getRoot().getRight().isColor() == RBTreeNode.RED);
	}
	
	void setup3() {
		setup2();
		tree.insert(9.2, "3");
		tree.insert(4.5, "2");
		
	}
	
	void setup4() {
		setup();
		for(double i = 0; i < 10; i++) {
			tree.insert(i, "" + i);
		}
	}
	
	@Test
	void searchRightTest() {
		setup3();
		RBTreeNode<Double,String> node = tree.search(9.2);
		assertTrue(node.getKey() == tree.getRoot().getRight().getKey());
	}
	
	@Test
	void searchLeftTree() {
		setup3();
		RBTreeNode<Double,String> node = tree.search(4.5);
		assertTrue(node.getKey() == tree.getRoot().getLeft().getKey());
		
	}
	
	@Test
	void maxminTest() {
		setup4();
		assertTrue(tree.min(tree.getRoot()).getKey() == 0 && tree.max(tree.getRoot()).getKey() == 9);
	}
	
	@Test
	void rootTest() {
		setup4();
		assertTrue(tree.getRoot().getKey() == 3.0);
	}
	

	
	

}
