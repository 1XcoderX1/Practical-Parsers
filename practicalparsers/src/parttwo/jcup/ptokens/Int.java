package parttwo.jcup.ptokens;

public class Int extends F {

	public Integer num;

	public Int(Integer num) {

		this.num = num;
	}

	@Override
	public void print(String pre, boolean isLeaf) {

		String type = "F ";
		System.out.println(pre + (isLeaf ? "\\-- " : "|-- ") + type);
		System.out.println(pre + "    " + (isLeaf ? "\\-- " : "|-- ") + "INT");

	}

}
