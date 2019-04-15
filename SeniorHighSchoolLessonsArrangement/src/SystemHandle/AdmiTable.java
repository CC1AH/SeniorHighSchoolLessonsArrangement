package SystemHandle;
import java.util.*;
public class AdmiTable extends Table{
	public AdmiTable(String s1) {
		super(s1);
	}
	public AdmiTable(String s1, int mcn, int acn) {
		super(s1,acn,mcn);
	}
	private ArrayList<Integer> StuNumByClaAndChose[][];
	private ArrayList<Integer> StuNumInTeaCla[][];
	@Override
	public void process() {
		
	}
}
