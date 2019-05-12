package SystemHandle;
/**
 * 虚类Table 不涉及具体实现
 * 无测试台
 *
 */
public abstract class Table {
	private String tableId;
	protected static int MCN = 4;
	protected static int ACN = 4;
	
	public Table(String TABLEID) {
		tableId = TABLEID;
	}

	public Table(String TABLEID, int MCN, int ACN) {
		tableId = TABLEID;
		this.MCN = MCN;
		this.ACN = ACN;
	}

	public abstract Table process(Object s1);
}