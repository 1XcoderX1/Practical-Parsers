package partone;

import java.util.ArrayList;

public class Parser {

	private Node rootNode = new Node(-1, " ");
	private ArrayList<Token> inputTokens;
	private int next = 0;

	public Parser(ArrayList<Token> tokens) {

		inputTokens = tokens;
	}

	public boolean parse() {

		rootNode = new Node(-1, "  ");
		next = 0;
		boolean result = F(0, rootNode);

		// Check if it checked the whole input or ended early.
		if (next != inputTokens.size()) {
			result = false;
		}

		// Print result
		System.out.println();

		if (result) {
			System.out.println("The input is valid. Parsing input now.............");
		} else {
			System.out.println("Invalid input. Please enter a valid expression. ");
		}
		System.out.println();

		return result;

	}

	public void printTree() {
		System.out.println("The following parse tree is generated for the input: ");
		System.out.println();

		rootNode.getChildren().get(0).print();
	}

	// To infer what enum has been read from the input tokens
	private boolean term(Token token, Integer integer, Node pred) {

		Node node;
		String tokName = token.toString();

		if (tokName == "L_BRACKET") {
			node = new Node(integer, "( ");
		}

		else if (tokName == "R_BRACKET") {
			node = new Node(integer, ") ");
		}

		else if (tokName == "PLUS") {
			node = new Node(integer, "+ ");
		}

		else if (tokName == "MULTIPLY") {
			node = new Node(integer, "* ");
		}

		else if (tokName == "INT") {
			node = new Node(integer, "int ");
		}

		else {
			node = null;
		}

		pred.getChildren().add(node);
		return inputTokens.get(next++) == token;

	}

	private boolean E(Integer l, Node parent) {
		Node node = new Node(l + 1, "E ");
		parent.getChildren().add(node);
		return T(l + 1, node) && E_prime(l + 1, node);
	}

	private boolean E_prime(Integer l, Node parent) {
		Node node = new Node(l + 1, "E'");
		parent.getChildren().add(node);

		int saveNext = next;
		// check if +TE'
		if (term(Token.PLUS, l, node) && T(l + 1, node) && E_prime(l + 1, node)) {
			return true;
		} else {
			node.children.clear();
			next = saveNext;
			Node node2 = new Node(l, "e ");
			node.children.add(node2);
			return true;
		}
	}

	private boolean T(Integer l, Node parent) {
		Node node = new Node(l + 1, "T ");
		parent.getChildren().add(node);

		return F(l + 1, node) && T_prime(l + 1, node);
	}

	private boolean T_prime(Integer l, Node parent) {
		Node node = new Node(l + 1, "T'");
		parent.getChildren().add(node);

		int saveNext = next;
		if (term(Token.MULTIPLY, l, node) && F(l + 1, node) && T_prime(l + 1, node)) {
			return true;
		} else {
			next = saveNext;
			node.children.clear();
			Node node2 = new Node(l, "e ");
			node.getChildren().add(node2);
			return true;
		}
	}

	private boolean F(Integer l, Node parent) {
		Node node = new Node(l + 1, "F ");
		parent.getChildren().add(node);
		int saveNext = next;

		if (term(Token.L_BRACKET, l, node) && E(l + 1, node) && term(Token.R_BRACKET, l, node)) {
			return true;
		} else {
			// Restore next pointer
			next = saveNext;
			node.children.clear();
			return term(Token.INT, l, node);
		}
	}

}
