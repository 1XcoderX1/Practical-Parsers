package parttwo.jcup.ptokens;

public class ID extends F {

	public Integer num;

	
	public ID (Integer num) {
		
		this.num = num;
	}
	
	
	@Override
	public void print(String pre, boolean isLeaf) {
		
		String type = "F ";
		System.out.println(pre + (isLeaf ? "\\-- " : "|-- ") + type);
		System.out.println(pre + "    " + (isLeaf ? "\\-- " : "|-- ") + "ID");
				
	}

}
