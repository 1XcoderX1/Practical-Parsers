package parttwo.jcup.ptokens;

public class FB extends F {

	public E c1;

	public FB(E e) {
		c1 = e;
	}

	@Override
	public void print(String pre, boolean isLeaf) {

		String type = "F ";
		System.out.println(pre + (isLeaf ? "\\-- " : "|-- ") + type);
		System.out.println(pre + "    " + (isLeaf ? "|-- " : "|-- ") + "(");
		c1.print(pre + (isLeaf ? "    " : "|   "), false);
		System.out.println(pre + "    " + (isLeaf ? "\\-- " : "|-- ") + ")");

	}

}
