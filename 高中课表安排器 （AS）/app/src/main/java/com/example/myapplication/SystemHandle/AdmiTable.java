package com.example.myapplication.SystemHandle;

import java.util.*;
import com.example.myapplication.Settings.*;
/**
 * ����Ա����
 * ����Ա��ͨ����Admin����󴫵ݸ�process��������ȡһ�������ʵ��
 *����������˵��process����������Admin��������ԵĲ�ͬ���������ɵ�AdmiTable��ͬʱ����Admin�еĺ����Ϣ��static�ǹ��õģ���
 */
public class AdmiTable extends Table {

	int[][] StuNumByAdmClaAndChose;
	public AdmiTable(String TABLEID) {
		super(TABLEID);
	}

	@Override
	public Table process(Object s1) {
		/*
		 * �����Ĵ��룺���ݴ����Object(����Ա)����Ϣ������༶���ȵȣ����α�int��ά����
		 * ���ر������һ��ʵ��
		 */
		return this;
	}
	/* public void getDetails(int cla,Choose choose) {
		/*
		 * ��ѡ�ķ��� ��ù���Ա���еľ�����Ϣ 
		 */
	 /*}*/
}
