package parttwo.jcup.ptokens;

public class FT extends T {

	public F v1;

	public FT(F v1) {
		this.v1 = v1;
	}

	@Override
	public void print(String pre, boolean isLeaf) {

		String type = "T";
		System.out.println(pre + (isLeaf ? "\\-- " : "|-- ") + type);
		v1.print(pre + (isLeaf ? "    " : "|   "), true);

	}

}
