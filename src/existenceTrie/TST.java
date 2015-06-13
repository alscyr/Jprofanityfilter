package existenceTrie;

public class TST {
	
	public final static char END ='$';
	private Node root;
	
	public TST() {
		root = null;
	}
	
	public void insert(String word) {
		root = insertTST(root, word, 0); 
	}
	
	public boolean exists(String word) {
		return existsTST(root, word, 0); 
	}
	
	private Node insertTST(Node tree, String key, int d) {
		char c = key.charAt(d);
		Node n = null;
		
		if (tree == null) {
			n = new Node(c);
		} else {
			n = tree;
		}
			char nc = n.getCharacter();
			
			if (c == END && nc == END) {
				return n;
			}
			if(c < nc) {
				n.setLeft(insertTST(n.getLeft(), key, d));
			} else if (c > nc) {
				n.setRight(insertTST(n.getRight(), key, d));
			} else if (c == nc) {
				n.setMiddle(insertTST(n.getMiddle(), key, d+1));
			}
		
		return n;
	}
	
	private boolean existsTST(Node tree, String key, int d) {
		if(tree == null) {
			return false;
		}
		
		char c = key.charAt(d);
		char nc = tree.getCharacter();
		
		if (c == END && nc == END) {
			return true;
		}
		
		if (c < nc) {
			return existsTST(tree.getLeft(), key, d);
		} else if (c > nc) {
			return existsTST(tree.getRight(), key, d);
		} else {
			return existsTST(tree.getMiddle(), key, d + 1);
		}
	}

}
