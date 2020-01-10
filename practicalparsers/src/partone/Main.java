package partone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		getInput();

	}

	public static void getInput() throws Exception {

		String expression = null;

		System.out.println("Enter an expression to parse:  (Please use exactly one space between characters)");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Read the expression via a
																						// buffered reader

		try {
			expression = reader.readLine();
		} catch (IOException e) {
			System.out.println("Exception in IO expression. Try Again");
			System.exit(1);
		}

		Tokeniser tokeniser = new Tokeniser(expression);
		tokeniser.start();

		// The parser object
		Parser parser = new Parser(tokeniser.getTokens());
		boolean b = parser.parse();
		if (b) {
			parser.printTree();
		}

	}

}
