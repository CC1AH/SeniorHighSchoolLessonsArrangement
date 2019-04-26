package CustomerHandle;

import java.util.ArrayList;
import java.io.*;
import Setting.*;
import SystemHandle.*;

/**
 * ���ļ�����ʦ��
 * ������Ϣ ȡ�ÿα�
 *
 */

public class Teacher {
	private String name;
	private Choose subject;
	private String id;
	private int teaClass;
	private Sex sex;
	
	//������1 
	//�������� ��ѧ��Ŀ ID ��ѧ�༶��������ʦΪ������ţ�ѡ�޿���ʦΪ��ѧ��ţ����Ա�
	public Teacher(String Name,String Subject,String Id,int TeaClass,String SEX) {
		name = Name;
		id = Id;
		subject = Choose.valueOf(Subject);
		teaClass = TeaClass;
		sex = Sex.valueOf(SEX);
	}
	
	//������2
	//�����ַ��� ͳһ¼����ʦ��Ϣ �ָ�˳��ͬ ������1
	public Teacher(String infoSet) throws Exception{
		String[] info = infoSet.split("\\W+");
		try {
			if(info.length != 5) {
				throw new Exception("InfoSetLengthWrong");// ������Ϣ�ļ��ϱ�������Կո�ָ��5������ ��Ӧ��ϵ����һ�����췽��
			}
		name = info[0];
		subject = Choose.valueOf(info[1]);
		id = info[2];
		teaClass = Integer.parseInt(info[3]);
		sex = Sex.valueOf(info[4]);
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void upload(String Name,String Id,String Subject,int TeaClass,String SEX) {
		name = Name;
		id = Id;
		subject = Choose.valueOf(Subject);
		teaClass = TeaClass;
		sex = Sex.valueOf(SEX);
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public String getSex() {
		return sex.name();
	}
	
	public String getId() {
		return id;
	}
	
	public int getTeaClass() {
		return teaClass;
	}
	
	public Choose getSubject() {
		return subject;
	}
	
	public TeaTable get() {
		return (TeaTable)new TeaTable("myTable").process(this);
		//����˵�process��������½��Ŀα��ɸ���ʦָ���α������(myTable)
	}
	
	
	public void showInfo() {
		System.out.print("��ʦ " + name + " ��Id�� " + id + "\n����Ľ�ѧ��Ŀ�ǣ�");
		System.out.print(subject.name() + "\n����Ľ�ѧ�༶�ǣ�" + teaClass);
	}
	
	
	//�ڲ����Գ���1��������ʦ�Ļ�����Ϣ�����
	public static void TeaInTest1() throws Exception{
		FileDealing fl = new FileDealing(
				"D:\\RES\\MainLep\\SeniorHighSchoolLessonsArrangement\\SeniorHighSchoolLessonsArrangement\\src\\TeaExample.txt");

		ArrayList<Teacher> teas = new ArrayList<Teacher>();
		for (int i = 0; i < 45; ++i)
			teas.add(new Teacher(fl.get(i)));
		for (Teacher f : teas) {
			f.showInfo();
			System.out.println("\n*********");
		}
	}
	
	//��Ԫ����̨
	public static void main(String args[]) throws Exception {
		TeaInTest1();
	}
}
