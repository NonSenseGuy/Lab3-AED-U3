package com.aed.lab3.main;

import com.aed.lab3.generic.AVLTree;
import com.aed.lab3.generic.AVLTreeNode;
import com.aed.lab3.generic.BinaryTree;
import com.aed.lab3.generic.RBBinaryTree;
import com.aed.lab3.generic.RBTreeNode;

public class League {
	
	private RBBinaryTree<Double,String> pointsTree;
	private RBBinaryTree<Double,String> stealsTree;
	private AVLTree<Double,String> rbdTree;
	private AVLTree<Double,String> astTree;
	private BinaryTree<Double,String> bstPointsTree;
	private BinaryTree<Double,String> bstAstTree;
	
	public League(int i) {
		pointsTree = new RBBinaryTree<>();
		stealsTree = new RBBinaryTree<>();
		rbdTree = new AVLTree<>();
		astTree = new AVLTree<>();
		bstPointsTree = new BinaryTree<>();
		bstAstTree = new BinaryTree<>();
	}

	public RBBinaryTree<Double, String> getPointsTree() {
		return pointsTree;
	}

	public void setPointsTree(RBBinaryTree<Double, String> pointsTree) {
		this.pointsTree = pointsTree;
	}

	public RBBinaryTree<Double, String> getStealsTree() {
		return stealsTree;
	}

	public void setStealsTree(RBBinaryTree<Double, String> stealsTree) {
		this.stealsTree = stealsTree;
	}

	public AVLTree<Double, String> getRbdTree() {
		return rbdTree;
	}

	public void setRbdTree(AVLTree<Double, String> rbdTree) {
		this.rbdTree = rbdTree;
	}

	public AVLTree<Double, String> getAstTree() {
		return astTree;
	}

	public void setAstTree(AVLTree<Double, String> astTree) {
		this.astTree = astTree;
	}

	public BinaryTree<Double, String> getBstPointsTree() {
		return bstPointsTree;
	}

	public void setBstPointsTree(BinaryTree<Double, String> bstPointsTree) {
		this.bstPointsTree = bstPointsTree;
	}

	public BinaryTree<Double, String> getBstAstTree() {
		return bstAstTree;
	}

	public void setBstAstTree(BinaryTree<Double, String> bstAstTree) {
		this.bstAstTree = bstAstTree;
	}
	
	public static void createPointsTree(String path) {
		
	}
}
