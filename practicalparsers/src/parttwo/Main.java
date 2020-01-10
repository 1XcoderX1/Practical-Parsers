package parttwo;

import java.io.FileReader;

import parttwo.jcup.parser;
import parttwo.jcup.ptokens.E;
import parttwo.jflex.Lexer;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// Start parser

		String tFile = "src\\parttwo\\inputFile.txt";
		try {
			Lexer lexedInput = new Lexer(new FileReader(tFile));

			parser p = new parser(lexedInput);
			E result = (E) p.parse().value;
			System.out.println();
			System.out.println();
			result.print("", true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
