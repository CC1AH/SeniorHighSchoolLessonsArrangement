package com.example.myapplication.SystemHandle;

import com.example.myapplication.SystemHandle.*;
import com.example.myapplication.Settings.*;

import java.util.*;
/**
 * ѧ������
 * ѧ������ʵ��Admin�����ϴ�����������а���ѧ����Ϣ�������ø÷�������ͨ����Stu����󴫵ݸ�process��������ȡһ�������ʵ��
 *����������˵��process����������Stu��������ԵĲ�ͬ���������ɵ�StuTable�����ظ����еĺ����Ϣ������������Ĵ���Ӧ����ѧ�����������ȡ��֮ǰ���У���
 */

public class StuTable extends Table{

	Cla[][] cla = new Cla[5][MCN+ACN];
	//�γ̶�ά���飬�̶��Ĵ�С
	public StuTable(String TABLEID) {
		super(TABLEID);  
	}

	@Override
	public Table process(Object s1) {
		/*
		 * �����Ĵ��룺���ݴ����Object(ѧ��)����Ϣ���α��ά����
		 * ���ر������һ��ʵ��
		 */
		return this;
	}

}
