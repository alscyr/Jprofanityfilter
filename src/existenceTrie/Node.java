package existenceTrie;

public class Node {
	private char character;
	private Node left;
	private Node middle;
	private Node right;
	
	public Node(char character) {
		this.character = character;
		left = null;
		middle = null;
		right = null;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getMiddle() {
		return middle;
	}

	public void setMiddle(Node middle) {
		this.middle = middle;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	

}
