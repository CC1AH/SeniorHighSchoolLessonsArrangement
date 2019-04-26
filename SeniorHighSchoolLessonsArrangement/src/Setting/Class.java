package Setting;

import CustomerHandle.Teacher;
/**
 * �γ���
 * �洢һ�ڿεĻ�����Ϣ
 *
 */
public class Class {
	private String subject;
	private int teaClass;// ����ĿΪ�ؿ�����Ϊ������� ѡ��ʱΪ��ѧ���
	private String where;
	private WeekDay weekDay;//�����ڼ���
	private String startTime;
	private String endTime;
	private int last;
	private int stuNum;
	private Teacher teacher;

	//��ʱ���ַ���ת��Ϊ����
	public static int changeTimeStringToMinute(String s) {
		String[] re = s.split(":");
		if (re.length == 2) {
			return (Integer.parseInt(re[1]) + Integer.parseInt(re[0]) * 60);
		}
		return -1;
	}

	// ������ Class�ڱ��У�����ˣ�����Ҫ�û����룬������InfoSet������
	public Class(String SUB, String TEACLASS, String WHERE, String WEEKDAY,String START, String END, int StuNum, Teacher TEACHER) {
		subject = SUB;
		where = WHERE;
		teaClass = Integer.parseInt(TEACLASS);
		weekDay = WeekDay.valueOf(WEEKDAY);
		startTime = START;
		endTime = END;
		last = changeTimeStringToMinute(END) - changeTimeStringToMinute(START);
		stuNum = StuNum;
		teacher = TEACHER;
	}

	public void setInfo(String SUB, String TEACLASS, String WHERE, String WEEKDAY,String START, String END, int StuNum,
			Teacher TEACHER) {
		subject = SUB;
		where = WHERE;
		teaClass = Integer.parseInt(TEACLASS);
		weekDay = WeekDay.valueOf(WEEKDAY);
		startTime = START;
		endTime = END;
		last = changeTimeStringToMinute(END) - changeTimeStringToMinute(START);
		stuNum = StuNum;
		teacher = TEACHER;
	}

	public String getSub() {
		return subject;
	}

	public int getTeaClass() {
		return teaClass;
	}

	public String getWhere() {
		return where;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public int getLast() {
		return last;
	}

	public int getStuNum() {
		return stuNum;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void showInfo() {
		System.out.println( teaClass + " ��� " + subject + " �γ��� " + where + " �� " + weekDay + "�� " + startTime +
			   " �� " + endTime + "��ѧ���� " + stuNum + " ��");
		System.out.println("�Ͽν�ʦ�ǣ�" + teacher.getName());
	}

	// ���Գ��� ���һ���γ̵Ļ�����Ϣ
	public static void ClassInTest1() throws Exception{
		Class cl = new Class("math", "2", "һ��202", "Tues","8:15", "9:00", 60, new Teacher("Teacher05 math 2010291 1 female"));
		cl.showInfo();
	}
	//��Ԫ����̨
	public static void main(String args[]) throws Exception {
		ClassInTest1();
	}
}
