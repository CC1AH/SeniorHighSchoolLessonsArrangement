package com.example.myapplication.SystemHandle;

import android.util.Log;

import com.example.myapplication.CustomerHandle.Stu;
import com.example.myapplication.CustomerHandle.Teacher;
import com.example.myapplication.SystemHandle.*;
import com.example.myapplication.Settings.*;

import java.util.*;
/**
 * 学生表类
 * 学生（其实是Admin最先上传其类对象（其中包含学生信息）来运用该方法）将通过把Stu类对象传递给process方法来获取一个该类的实例
 *（或者这样说：process方法将根据Stu类对象属性的不同来决定生成的StuTable，不必更改中的宏观信息（管理者输入的处理应该在学生独立申请获取表之前进行））
 */

public class StuTable extends Table{

	public Cla[][] cla = new Cla[5][MCN+ACN];
	//课程二维数组，固定的大小
	public StuTable(String TABLEID) {
		super(TABLEID);  
	}

	//对主课和复课分别根据班级来进行排课 stuNum和TEACHER咱暂时不填
	public static Cla inflateClass(String SUB, String TEACLASS, String WHERE, String WEEKDAY, String START, String END){
		return new Cla(SUB, TEACLASS, WHERE, WEEKDAY, START, END, 50, new Teacher());
	}
	public static Cla[][] inflateMainClass(Cla[][] cl,Stu sample){
		// physics, biology, chemistry, history, politics, geography, math, chinese, english, PE, music, drawing，selfStudy,computer
		switch (sample.getAdmiClass()%3){
			case 1:
				//4 5 6
				cl[0][0] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A101","Monday","8:15","9:00");cl[0][1] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A103","Monday","9:10","9:55");cl[0][2] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A103","Monday","10:15","11:00");
				cl[0][3] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"ground","Monday","11:00","11:55");cl[0][7] = inflateClass("drawing",Integer.toString(sample.getAdmiClass()),"D103","Monday","16:45","17:30");cl[0][8] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A102","Monday","17:40","18:25");
				//2 7 8
				cl[1][0] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A102","Monday","8:15","9:00");cl[1][1] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A103","Monday","9:10","9:55");cl[1][3] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A101","Monday","11:00","11:55");
				cl[1][4] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A101","Monday","13:50","14:35");cl[1][5] = inflateClass("music",Integer.toString(sample.getAdmiClass()),"D101","Monday","14:45","15:30");cl[1][6] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"ground","Monday","15:40","16:25");
				//0 3 5
				cl[2][1] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A102","Wednesday","8:15","9:00");cl[2][2] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A102","Wednesday","9:10","9:55");cl[2][4] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A101","Wednesday","10:15","11:00");
				cl[2][6] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A103","Wednesday","11:00","11:55");cl[2][7] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A101","Wednesday","16:45","17:30");cl[2][8] = inflateClass("selfStudy",Integer.toString(sample.getAdmiClass()),"A101","Wednesday","17:40","18:25");
				//2 4 8
				cl[3][0] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A101","Thursday","8:15","9:00");cl[3][1] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A101","Thursday","9:10","9:55");cl[3][3] = inflateClass("computer",Integer.toString(sample.getAdmiClass()),"D105","Thursday","10:15","11:00");
				cl[3][5] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"ground","Thursday","11:00","11:55");cl[3][6] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A103","Thursday","16:45","17:30");cl[3][7] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A103","Thursday","17:40","18:25");
				//1 7 8
				cl[4][0] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A101","Friday","8:15","9:00");cl[4][2] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A103","Friday","9:10","9:55");cl[4][3] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A103","Friday","10:15","11:00");
				cl[4][4] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"ground","Friday","11:00","11:55");cl[4][5] = inflateClass("drawing",Integer.toString(sample.getAdmiClass()),"D103","Friday","16:45","17:30");cl[4][6] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A102","Friday","17:40","18:25");
				//2中空余的复课必须与1中相同
			case 2:
				cl[0][0] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A201","Monday","8:15","9:00");cl[0][1] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A203","Monday","9:10","9:55");cl[0][2] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A203","Monday","10:15","11:00");
				cl[0][3] = inflateClass("music",Integer.toString(sample.getAdmiClass()),"D203","Monday","11:00","11:55");cl[0][7] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"ground","Monday","16:45","17:30");cl[0][8] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A202","Monday","17:40","18:25");
				cl[1][0] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A202","Monday","8:15","9:00");cl[1][1] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A203","Monday","9:10","9:55");cl[1][3] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A201","Monday","11:00","11:55");
				cl[1][4] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A201","Monday","13:50","14:35");cl[1][5] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"D201","Monday","14:45","15:30");cl[1][6] = inflateClass("computer",Integer.toString(sample.getAdmiClass()),"ground","Monday","15:40","16:25");
				cl[2][1] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A202","Wednesday","8:15","9:00");cl[2][2] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A202","Wednesday","9:10","9:55");cl[2][4] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A201","Wednesday","10:15","11:00");
				cl[2][6] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A203","Wednesday","11:00","11:55");cl[2][7] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A201","Wednesday","16:45","17:30");cl[2][8] = inflateClass("selfStudy",Integer.toString(sample.getAdmiClass()),"A201","Wednesday","17:40","18:25");
				cl[3][0] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A201","Thursday","8:15","9:00");cl[3][1] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A201","Thursday","9:10","9:55");cl[3][3] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"ground","Thursday","10:15","11:00");
				cl[3][5] = inflateClass("drawing",Integer.toString(sample.getAdmiClass()),"D205","Thursday","11:00","11:55");cl[3][6] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A203","Thursday","16:45","17:30");cl[3][7] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A203","Thursday","17:40","18:25");
				cl[4][0] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A201","Friday","8:15","9:00");cl[4][2] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A203","Friday","9:10","9:55");cl[4][3] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A203","Friday","10:15","11:00");
				cl[4][4] = inflateClass("selfStudy",Integer.toString(sample.getAdmiClass()),"D203","Friday","11:00","11:55");cl[4][5] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"ground","Friday","16:45","17:30");cl[4][6] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A102","Friday","17:40","18:25");
				//3 中空余的复课必须与2相同
			case 3:
				cl[0][0] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A301","Monday","8:15","9:00");cl[0][1] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A303","Monday","9:10","9:55");cl[0][2] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A302","Monday","10:15","11:00");
				cl[0][3] = inflateClass("music",Integer.toString(sample.getAdmiClass()),"D301","Monday","11:00","11:55");cl[0][7] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"ground","Monday","16:45","17:30");cl[0][8] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A303","Monday","17:40","18:25");
				cl[1][0] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A302","Monday","8:15","9:00");cl[1][1] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A301","Monday","9:10","9:55");cl[1][3] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A303","Monday","11:00","11:55");
				cl[1][4] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A301","Monday","13:50","14:35");cl[1][5] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"ground","Monday","14:45","15:30");cl[1][6] = inflateClass("computer",Integer.toString(sample.getAdmiClass()),"D305","Monday","15:40","16:25");
				cl[2][1] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A102","Wednesday","8:15","9:00");cl[2][2] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A102","Wednesday","9:10","9:55");cl[2][4] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A301","Wednesday","10:15","11:00");
				cl[2][6] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A303","Wednesday","11:00","11:55");cl[2][7] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A301","Wednesday","16:45","17:30");cl[2][8] = inflateClass("selfStudy",Integer.toString(sample.getAdmiClass()),"A301","Wednesday","17:40","18:25");
				cl[3][0] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A301","Thursday","8:15","9:00");cl[3][1] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A303","Thursday","9:10","9:55");cl[3][3] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"ground","Thursday","10:15","11:00");
				cl[3][5] = inflateClass("drawing",Integer.toString(sample.getAdmiClass()),"D303","Thursday","11:00","11:55");cl[3][6] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A302","Thursday","16:45","17:30");cl[3][7] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A301","Thursday","17:40","18:25");
				cl[4][0] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A301","Friday","8:15","9:00");cl[4][2] = inflateClass("English",Integer.toString(sample.getAdmiClass()),"A301","Friday","9:10","9:55");cl[4][3] = inflateClass("math",Integer.toString(sample.getAdmiClass()),"A303","Friday","10:15","11:00");
				cl[4][4] = inflateClass("selfStudy",Integer.toString(sample.getAdmiClass()),"D303","Friday","11:00","11:55");cl[4][5] = inflateClass("PE",Integer.toString(sample.getAdmiClass()),"ground","Friday","16:45","17:30");cl[4][6] = inflateClass("Chinese",Integer.toString(sample.getAdmiClass()),"A302","Friday","17:40","18:25");
			default:
				break;
		}
		return cl;
	}
	public static Cla[][] inflateChosenClass(Cla[][] cl,Stu sample){
		
		return cl;
	}

	//整体方略：保证3个行政班具有完全相同的复课课表 主课只有顺序不同
	//三个班级中选择物理化学历史的只去上物理化学历史
	//其他的课程上自习或者公选课
	@Override
	public Table process(Object s1) {
		if(!(s1 instanceof Stu)){
			Log.d("process function error","the process method receives a method that is not an instance of Stu");
			return null;
		}
		cla = new Cla[5][MCN+ACN];
		inflateMainClass(cla,(Stu)s1);
		inflateChosenClass(cla,(Stu)s1);
		return this;
	}

}
