package SystemHandle;

public abstract class Table {
	private String tableId;
	private static int MCN = 4;
	private static int ACN = 4;

	public Table(String TABLEID) {
		tableId = TABLEID;
	}

	public Table(String TABLEID, int MCN, int ACN) {
		tableId = TABLEID;
		this.MCN = MCN;
		this.ACN = ACN;
	}

	public abstract void process();
}