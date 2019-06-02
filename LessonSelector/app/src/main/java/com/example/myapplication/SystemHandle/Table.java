package com.example.myapplication.SystemHandle;

public abstract class Table {
	private String tableId;
	protected static int MCN = 4;
	protected static int ACN = 5;
	
	public Table(String TABLEID) {
		tableId = TABLEID;
	}

	public Table(String TABLEID, int MCN, int ACN) {
		tableId = TABLEID;
		this.MCN = MCN;
		this.ACN = ACN;
	}
	public static int getMCN(){
		return MCN;
	}
	public static int getACN(){
		return ACN;
	}
	public abstract Table process(Object s1);
}