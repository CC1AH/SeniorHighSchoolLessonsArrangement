package com.example.myapplication.SystemHandle;

import com.example.myapplication.SystemHandle.*;
import com.example.myapplication.Settings.*;
/**
 * ��ʦ����
 * ��ʦ����ʵ��Admin�����ϴ�����������а�����ʦ��Ϣ�������ø÷�������ͨ����Teacher����󴫵ݸ�process��������ȡһ�������ʵ��
 *����������˵��process����������Teacher��������ԵĲ�ͬ���������ɵ�TeaTable�����ظ����еĺ����Ϣ������������Ĵ���Ӧ������ʦ���������ȡ��֮ǰ���У���
 */
public class TeaTable extends Table {
	Class[][] cla = new Class[5][MCN+ACN];
	public TeaTable(String TABLEID) {
		super(TABLEID);
	}

	@Override
	public Table process(Object s1) {
		/*
		 * �����Ĵ��룺���ݴ����Object(��ʦ)����Ϣ���α��ά����
		 * ���ر������һ��ʵ��
		 */
		return this;
	}
}
