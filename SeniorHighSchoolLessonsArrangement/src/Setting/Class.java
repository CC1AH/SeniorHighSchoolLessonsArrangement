package Setting;
import CustomerHandle.Teacher;

public class Class {
	private String subject;
	private int teaClass;//����ĿΪ�ؿ�����Ϊ������� ѡ��ʱΪ��ѧ���
	private String where;
	private String startTime;
	private String endTime;
	private int stuNum;
	private Teacher teacher;
	
	public Class(String SUB,String TEACLASS, String WHERE,String START,String END,
			int StuNum,Teacher TEACHER) {
		subject = SUB;
	}
}
