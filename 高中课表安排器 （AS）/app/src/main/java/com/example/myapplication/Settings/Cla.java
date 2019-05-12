package com.example.myapplication.Settings;

import com.example.myapplication.CustomerHandle.*;
/**
 *
 *
 *
 */
public class Cla {
	private String subject;
	private int teaClass;
	private String where;
	private WeekDay weekDay;
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


	public Cla(String SUB, String TEACLASS, String WHERE, String WEEKDAY, String START, String END, int StuNum, Teacher TEACHER) {
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
		System.out.println( teaClass + " 班 " + subject + " 在 " + where + " 在 " + weekDay + "从 " + startTime +
			   " 到 " + endTime + "的课程学生人数是 " + stuNum + " 个");
		System.out.println("上课教师是" + teacher.getName());
	}


	public static void ClassInTest1() throws Exception{
		Cla cl = new Cla("math", "2", "???202", "Tues","8:15", "9:00", 60, new Teacher("Teacher05 math 2010291 1 female"));
		cl.showInfo();
	}

	public static void main(String args[]) throws Exception {
		ClassInTest1();
	}
}
