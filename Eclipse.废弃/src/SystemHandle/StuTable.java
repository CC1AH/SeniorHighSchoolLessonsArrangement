package SystemHandle;

import CustomerHandle.*;
import Setting.*;
import Setting.Class;

import java.util.*;
/**
 * ѧ������
 * ѧ������ʵ��Admin�����ϴ�����������а���ѧ����Ϣ�������ø÷�������ͨ����Stu����󴫵ݸ�process��������ȡһ�������ʵ��
 *����������˵��process����������Stu��������ԵĲ�ͬ���������ɵ�StuTable�����ظ����еĺ����Ϣ������������Ĵ���Ӧ����ѧ�����������ȡ��֮ǰ���У���
 */

public class StuTable extends Table{

	Class[][] cla = new Class[5][MCN+ACN];
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
