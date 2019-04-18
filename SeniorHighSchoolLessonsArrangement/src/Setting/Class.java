package Setting;

import CustomerHandle.Teacher;

public class Class {
	private String subject;
	private int teaClass;// 当科目为必考课是为行政班号 选考时为教学班号
	private String where;
	private String startTime;
	private String endTime;
	private int last;
	private int stuNum;
	private Teacher teacher;

	public static int changeTimeStringToMinute(String s) {
		String[] re = s.split(":");
		if (re.length == 2) {
			return (Integer.parseInt(re[1]) + Integer.parseInt(re[0]) * 60);
		}
		return -1;
	}

	// 构造器 Class在表中（处理端）不需要用户输入，不制作InfoSet构造器
	public Class(String SUB, String TEACLASS, String WHERE, String START, String END, int StuNum, Teacher TEACHER) {
		subject = SUB;
		where = WHERE;
		teaClass = Integer.parseInt(TEACLASS);
		startTime = START;
		endTime = END;
		last = changeTimeStringToMinute(END) - changeTimeStringToMinute(START);
		stuNum = StuNum;
		teacher = TEACHER;
	}

	public void setInfo(String SUB, String TEACLASS, String WHERE, String START, String END, int StuNum,
			Teacher TEACHER) {
		subject = SUB;
		where = WHERE;
		teaClass = Integer.parseInt(TEACLASS);
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
		System.out.println(subject + " of class " + teaClass + " in " + where + " lasts " + last
				+ " minutes,student number is " + stuNum);
		/* Information about Teacher needs to be filled */
	}

	// 测试程序 输出一个课程的基本信息
	public static void main(String args[]) {
		Class cl = new Class("maths", "2", "1stBuilding", "8:15", "9:00", 60, null);
		cl.showInfo();
	}
}
