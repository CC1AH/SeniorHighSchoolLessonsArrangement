package CustomerHandle;

import java.util.*;
import Setting.*;
import SystemHandle.*;

/**
 * 该文件是管理员类
 * 输入信息 取得总表
 * 
 */
public class Admin {
	private String id;
	private ArrayList<Stu> stus;
	private ArrayList<Teacher> teas;
	private static int admiClassNumber;
	private static int stuNum;
	private static int teaNum;
	
	//构造器
	public Admin(String Id,int admiClassNum,
			ArrayList<Stu> Stus,ArrayList<Teacher> Teachers) {
		id = Id;
		stus = new ArrayList<Stu>();
		stus.addAll(Stus);
		teas = new ArrayList<Teacher>();
		teas.addAll(Teachers);
		admiClassNumber = admiClassNum;
		stuNum = stus.size();
		teaNum = teas.size();
	}
	
	public void upload(ArrayList<Stu> Student,ArrayList<Teacher> Tea) {
		stus.addAll(Student);
		teas.addAll(Tea);
		stuNum += Student.size();
		teaNum += Tea.size();
	}
	
	
	public String getId() {
		return id;
	}
	
	public int getStuNum() {
		return stuNum;
	}
	
	public int getTeaNum() {
		return teaNum;
	}
	
	public ArrayList<Stu> getStus() {
		return stus;
	}
	
	public ArrayList<Teacher> getTeas() {
		return teas;
	}
	
	
	public void showInfo() {
		System.out.print("管理员" + id + "\n负责的师生个数分别是：");
		System.out.print(teaNum +","+stuNum+"。");
	}
	
	public AdmiTable get() {
		return (AdmiTable) new AdmiTable("myTable").process(this);
		//处理端的process方法填充新建的宏观表。由管理员指定总表的名称(myTable)
	}
	
	//内部测试程序1：输入，增加管理员的基本信息并打出
		public static void AdminInTest1() throws Exception{
			FileDealing f1 = new FileDealing(
					"D:\\RES\\MainLep\\SeniorHighSchoolLessonsArrangement\\SeniorHighSchoolLessonsArrangement\\src\\StuExample.txt");
			ArrayList<Stu> s1 = new ArrayList<Stu>();
			for (int i = 0; i < f1.size(); ++i)
				s1.add(new Stu(f1.get(i)));
			ArrayList<Teacher> s2 = new ArrayList<Teacher>();
			FileDealing f2 = new FileDealing(
					"D:\\RES\\MainLep\\SeniorHighSchoolLessonsArrangement\\SeniorHighSchoolLessonsArrangement\\src\\TeaExample.txt");
			for (int i = 0; i < f2.size(); ++i)
				s2.add(new Teacher(f2.get(i)));
			
			new Admin("01",4,s1,s2).showInfo();
			System.out.println("");
			Admin s3 = new Admin("02",4,s1,s2);
			s3.upload(s1, new ArrayList<Teacher>());
			s3.showInfo();
		}
		
	//单元测试台
		public static void main(String args[]) throws Exception {
			AdminInTest1();
	}
}
