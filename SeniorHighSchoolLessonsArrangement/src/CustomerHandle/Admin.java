package CustomerHandle;

import java.util.*;
import Setting.*;
import SystemHandle.*;

/**
 * ���ļ��ǹ���Ա��
 * ������Ϣ ȡ���ܱ�
 * 
 */
public class Admin {
	private String id;
	private ArrayList<Stu> stus;
	private ArrayList<Teacher> teas;
	private static int admiClassNumber;
	private static int stuNum;
	private static int teaNum;
	
	//������
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
		System.out.print("����Ա" + id + "\n�����ʦ�������ֱ��ǣ�");
		System.out.print(teaNum +","+stuNum+"��");
	}
	
	public AdmiTable get() {
		return (AdmiTable) new AdmiTable("myTable").process(this);
		//����˵�process��������½��ĺ�۱��ɹ���Աָ���ܱ������(myTable)
	}
	
	//�ڲ����Գ���1�����룬���ӹ���Ա�Ļ�����Ϣ�����
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
		
	//��Ԫ����̨
		public static void main(String args[]) throws Exception {
			AdminInTest1();
	}
}
