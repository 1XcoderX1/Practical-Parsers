package partone;

import java.util.ArrayList;
import java.util.Scanner;

public class Tokeniser {

	String input;
	ArrayList<String> output = new ArrayList<>();
	ArrayList<Token> tokens = new ArrayList<>();

	public Tokeniser(String str) {
		input = str;
	}

	public void start() {

		Scanner scanner = new Scanner(input);

		scanner.useDelimiter(" ");

		while (scanner.hasNext()) {

			String str = scanner.next();
			output.add(str);
			try {
				tokens.add(getToken(str));
			} catch (Exception e) {

				System.out.println("GG");
			}
		}
		scanner.close();

	}

	public Token getToken(String token) {

		if (token.equals("+")) {
			return Token.PLUS;
		} else if (token.equals("*")) {
			return Token.MULTIPLY;
		} else if (token.equals("(")) {
			return Token.L_BRACKET;
		} else if (token.equals(")")) {
			return Token.R_BRACKET;
		} else if (checkNum(token)) {
			return Token.INT;
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				
				System.out.println("Invalid input. Please enter a valid expression. ");
				System.exit(1);
				return null;
			}
		}

	}

	public static boolean checkNum(String str) {

		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException n) {

			return false;
		}
		return true;

	}

	// Getters and Setters

	public ArrayList<String> getOutput() {
		return output;
	}

	public ArrayList<Token> getTokens() {
		return tokens;
	}

}
