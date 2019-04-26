package Setting;

import CustomerHandle.Teacher;
/**
 * 课程类
 * 存储一节课的基本信息
 *
 */
public class Class {
	private String subject;
	private int teaClass;// 当科目为必考课是为行政班号 选考时为教学班号
	private String where;
	private WeekDay weekDay;//在星期几上
	private String startTime;
	private String endTime;
	private int last;
	private int stuNum;
	private Teacher teacher;

	//将时间字符串转换为分钟
	public static int changeTimeStringToMinute(String s) {
		String[] re = s.split(":");
		if (re.length == 2) {
			return (Integer.parseInt(re[1]) + Integer.parseInt(re[0]) * 60);
		}
		return -1;
	}

	// 构造器 Class在表中（处理端）不需要用户输入，不制作InfoSet构造器
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
		System.out.println( teaClass + " 班的 " + subject + " 课程在 " + where + " 于 " + weekDay + "从 " + startTime +
			   " 到 " + endTime + "，学生有 " + stuNum + " 人");
		System.out.println("上课教师是：" + teacher.getName());
	}

	// 测试程序 输出一个课程的基本信息
	public static void ClassInTest1() throws Exception{
		Class cl = new Class("math", "2", "一教202", "Tues","8:15", "9:00", 60, new Teacher("Teacher05 math 2010291 1 female"));
		cl.showInfo();
	}
	//单元测试台
	public static void main(String args[]) throws Exception {
		ClassInTest1();
	}
}
