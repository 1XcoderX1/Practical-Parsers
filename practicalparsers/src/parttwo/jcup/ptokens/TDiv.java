package parttwo.jcup.ptokens;

public class TDiv extends T {

	public T vl;
	public F vr;

	public TDiv(T vl, F vr) {

		this.vl = vl;
		this.vr = vr;
	}

	@Override
	public void print(String pre, boolean isLeaf) {

		String type = "T";
		System.out.println(pre + (isLeaf ? "\\-- " : "|-- ") + type);
		vl.print(pre + (isLeaf ? "    " : "|   "), false);
		System.out.println(pre + "    " + (isLeaf ? "\\-- " : "|-- ") + "/");
		vr.print(pre + (isLeaf ? "    " : "|   "), true);

	}

}
