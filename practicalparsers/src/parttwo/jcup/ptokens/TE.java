package parttwo.jcup.ptokens;

public class TE extends E {

	public T v1;

	public TE(T v1) {
		this.v1 = v1;
	}

	@Override
	public void print(String pre, boolean isLeaf) {

		String type = "E";
		System.out.println(pre + (isLeaf ? "\\-- " : "|-- ") + type);
		v1.print(pre + (isLeaf ? "    " : "|   "), true);

	}

}
