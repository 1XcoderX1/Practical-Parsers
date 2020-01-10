package partone;

import java.util.ArrayList;

public class Node {

	private String type;
	public ArrayList<Node> children = new ArrayList<>();
	private int level = -1;

	public Node(int level, String type) {

		this.level = level;
		this.type = type;

	}

	public void print() {
		print("", true);
	}

	private void print(String pre, boolean isLeaf) {

		System.out.println(pre + (isLeaf ? "\\--" : "|--") + type);

		for (int i = 0; i < children.size() - 1; i++) {

			children.get(i).print(pre + (isLeaf ? "    " : "|    "), false);
		}

		if (children.size() > 0) {
			children.get(children.size() - 1).print(pre + (isLeaf ? "    " : "|   "), true);
		}
	}

	

	// Getter for the arraylist
	public ArrayList<Node> getChildren() {
		return children;
	}

}
