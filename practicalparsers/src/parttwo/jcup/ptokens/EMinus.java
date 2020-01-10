package parttwo.jcup.ptokens;

public class EMinus extends E {

	public E vl;
	public T vr;

	public EMinus(E vl, T vr) {

		this.vl = vl;
		this.vr = vr;
	}

	@Override
	public void print(String pre, boolean isLeaf) {

		String type = "E";
		System.out.println(pre + (isLeaf ? "\\-- " : "|-- ") + type);
		vl.print(pre + (isLeaf ? "    " : "|   "), false);
		System.out.println(pre + (isLeaf ? "\\-- " : "|-- ") + "-");
		vr.print(pre + (isLeaf ? "    " : "|   "), false);
		vr.print(pre + (isLeaf ? "    " : "|   "), true);

	}

}
