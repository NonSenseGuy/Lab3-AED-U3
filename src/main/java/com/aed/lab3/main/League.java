package com.aed.lab3.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.aed.lab3.generic.AVLTree;
import com.aed.lab3.generic.AVLTreeNode;
import com.aed.lab3.generic.BinaryTree;
import com.aed.lab3.generic.RBBinaryTree;
import com.aed.lab3.generic.RBTreeNode;
import com.aed.lab3.generic.TreeNode;

public class League {
	
	private RBBinaryTree<Double,String> pointsTree;
	private RBBinaryTree<Double,String> stealsTree;
	private AVLTree<Double,String> rbdTree;
	private AVLTree<Double,String> astTree;
	private BinaryTree<Double,String> bstPointsTree;
	private BinaryTree<Double,String> bstAstTree;
	private int maxValuePath;
	
	public League() {
		this.pointsTree = new RBBinaryTree<Double, String>();
		this.stealsTree = new RBBinaryTree<Double, String>();
		this.rbdTree = new AVLTree<Double, String>();
		this.astTree = new AVLTree<Double, String>();
		this.bstPointsTree = new BinaryTree<Double, String>();
		this.bstAstTree = new BinaryTree<Double, String>();
		this.maxValuePath = 0;
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
	
	public void addPlayer(String name, String team, int age, double points, double rebounds, double assists, 
			double steals, double blocks) throws IOException {
		
		Player temp = new Player(name, team, age, points, rebounds, assists, steals, blocks);

		plainText(maxValuePath, temp);
		String path = "./src/main/resources/last/" + maxValuePath + ".txt";
		
		pointsTree.insert(temp.getPoints(), path);
		stealsTree.insert(temp.getSteals(), path);
		rbdTree.insert(temp.getRebounds(), path);
		astTree.insert(temp.getAssists(), path);
		bstPointsTree.insert(temp.getPoints(), path);
		bstAstTree.insert(temp.getAssists(), path);
		
		this.maxValuePath += 1;
	}
	
	public void readCSV(String path) {
    	
    	String currentLine = "";
    	int counter = 0;
    	
    	try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			br.readLine();
			while((currentLine = br.readLine()) != null) {
				String[] information = currentLine.split(",");
				double rebounds = Double.valueOf(information[10]) + Double.valueOf(information[11]);
				
				Player temp = new Player(information[2], information[1], Integer.valueOf(information[3]),
						Double.valueOf(information[30]), rebounds, Double.valueOf(information[13]), 
						Double.valueOf(information[14]), Double.valueOf(information[15]));
				
				plainText(counter, temp);
				chargeCsv("./src/main/resources/last/" + counter + ".txt");
				counter++;
			}
		
			if(br != null) br.close();
			this.maxValuePath = counter;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void chargeCsv(String path) throws IOException {
		FileReader fl = new FileReader(path);
		BufferedReader br = new BufferedReader(fl);
		
		String[] information = br.readLine().split(",");
		
		Player temp = new Player(information[0], information[1], Integer.valueOf(information[2]),
				Double.valueOf(information[3]), Double.valueOf(information[4]), 
				Double.valueOf(information[5]), Double.valueOf(information[6]), 
				Double.valueOf(information[7]));
		
		if(br != null) br.close();
		if(fl != null) fl.close();
		
		pointsTree.insert(temp.getPoints(), path);
		stealsTree.insert(temp.getSteals(), path);
		rbdTree.insert(temp.getRebounds(), path);
		astTree.insert(temp.getAssists(), path);
		bstPointsTree.insert(temp.getPoints(), path);
		bstAstTree.insert(temp.getAssists(), path);
		
	}
    
    public void plainText(int counter, Player player) throws IOException {
    	File file = new File( "./src/main/resources/last/" + counter + ".txt");
    	
    	if(!file.exists()) file.createNewFile();
    	
    	FileWriter fw = new FileWriter(file);
    	BufferedWriter writer = new BufferedWriter(fw);
    	
    	writer.write(player.getName() + "," + player.getTeam() + "," + player.getAge() + "," +
    			player.getPoints() + "," + player.getRebounds() + "," + player.getAssists() + ","
    			+ player.getSteals() + "," + player.getBlocks());
    
    	if(writer != null) writer.close();
    	if(fw != null) fw.close();
    	
    }
    
    public ArrayList<Player> searchLessRB(double search, String typeData) throws IOException{
    	
    	ArrayList<Player> players = new ArrayList<>();
    	RBTreeNode<Double,String> aux = typeData.equals("Points% per Match") ?
    			pointsTree.min(pointsTree.getRoot()) : stealsTree.min(stealsTree.getRoot());
    	
    	while(aux.getKey().compareTo(search) == -1) {
    		
    		ArrayList<String> playerNode = aux.getValue();
    		
    		for(int i = 0; i < playerNode.size(); i++) {
    			players.add(chargePlainText(playerNode.get(i)));
    		}
    		aux = typeData.equals("Points% per Match") ? pointsTree.successor( aux.getKey()) : 
    			stealsTree.successor(aux.getKey());
    	}
    	return players;
    }
    
    public Player chargePlainText(String fileName) throws IOException {
    	
    	FileReader fl = new FileReader("./src/main/resources/last/" + fileName + ".txt");
		BufferedReader br = new BufferedReader(fl);
		
		String[] information = br.readLine().split(",");
		
		Player temp = new Player(information[0], information[1], Integer.valueOf(information[2]),
				Double.valueOf(information[3]), Double.valueOf(information[4]), 
				Double.valueOf(information[5]), Double.valueOf(information[6]), 
				Double.valueOf(information[7]));
		
		if(br != null) br.close();
		if(fl != null) fl.close();
		
		return temp;
    }

	public ArrayList<Player> searchLessBST(double data, String typeData) throws IOException {
		ArrayList<Player> players = new ArrayList<>();
		
    	TreeNode<Double, String> aux = typeData.equals("Points% per Match") ?  
    			bstPointsTree.min(bstPointsTree.getRoot()) : bstAstTree.min(bstAstTree.getRoot());
    	
    	while(aux.getKey().compareTo(data) == -1) {
    		
    		ArrayList<String> playerNode = aux.getValue();
    		
    		for(int i = 0; i < playerNode.size(); i++) {
    			players.add(chargePlainText(playerNode.get(i)));
    		}
    		aux = typeData.equals("Points% per Match") ? bstPointsTree.successor(aux.getKey()) : 
    			bstAstTree.successor( aux.getKey());
    	}
    	return players;
	}

	public ArrayList<Player> searchLessAVL(double data, String typeData) throws IOException {
		ArrayList<Player> players = new ArrayList<>();
		
    	AVLTreeNode<Double,String> aux = typeData.equals("Rebounds% per Match") ?
    			rbdTree.min(rbdTree.getRoot()) : astTree.min(astTree.getRoot());
    	
    	while(aux.getKey().compareTo(data) == -1) {
    		
    		ArrayList<String> playerNode = aux.getValue();
    		
    		for(int i = 0; i < playerNode.size(); i++) {
    			players.add(chargePlainText(playerNode.get(i)));
    		}
    		aux = typeData.equals("Rebounds% per Match") ? rbdTree.successor(aux.getKey()) : 
    			astTree.successor(aux.getKey());
    	}
    	return players;
	}

	public ArrayList<Player> searchGreaterAVL(double data, String typeData) {
		return null;
	}

	public ArrayList<Player> searchAVL(double data, String typeData) throws IOException{
		ArrayList<Player> players = new ArrayList<>();
		AVLTreeNode<Double,String> aux = typeData.equals("Rebounds% per Match") ? 
				rbdTree.search(data) : astTree.search(data);
		for(int i = 0; i < aux.getValue().size(); i++) {
			players.add(chargePlainText(aux.getValue().get(i)));
		}
		
		return players;
		
	}

	public ArrayList<Player> searchGreaterRB(double data, String typeData) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Player> searchRB(double data, String typeData) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Player> searchGreaterBST(double data, String typeData) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Player> searchBST(double data, String typeData) {
		// TODO Auto-generated method stub
		return null;
	}
}
