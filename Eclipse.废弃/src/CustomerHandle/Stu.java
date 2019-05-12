package CustomerHandle;

import java.util.*;
import Setting.*;
import SystemHandle.*;

/**
 * ���ļ���ѧ����
 * ������Ϣ ��ȡ�α�
 *
 */

public class Stu {
	private String name;
	private String id;
	private int admiClass;
	private Map<Integer, ArrayList<Choose>> teaClass;
	// ��ֵ��Integer��Ϊ��ѧ��ţ�3����һ�飩������ֵ(ArrayList<Choose>)Ϊѡ���Ŀ�����顣
	//���Ǵ˴�Mapֻ��һ����ֵ����ʵֻ�Ƿ���鿴���ѣ�ͬʱ�������ѧ����������Ϣ���Ժ��������Ҫ������ 
	private Sex sex;

	// ������1
	public Stu(String NAME, String SEX, String ID, int ADMICLASS, String CHOSENSUBS) throws Exception {// �������� �Ա� ID ������� ѡ���Ŀ��ʹ�ÿո�ָ���
		name = NAME;
		id = ID;
		admiClass = ADMICLASS;
		try {
			sex = Sex.valueOf(SEX);
			String[] temp = CHOSENSUBS.split(" ");
			if (temp.length != 3)
				throw new Exception("ChosenSubLengthWrong");// ÿ��ѧ��ֻ��ѡ�����ſ�
			ArrayList<Choose> chosenSub = new ArrayList<Choose>(3);
			teaClass = new TreeMap<Integer, ArrayList<Choose>>();
			for (String i : temp)
				chosenSub.add(Choose.valueOf(i));
			teaClass.put(admiClass % 3, chosenSub);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// ������2 �ù�����ֻ����һ���ַ�������Ҫ�����ļ�����
	public Stu(String InfoSet) throws Exception {
		String[] arr = InfoSet.split(" "); // ��\\w+
		try {
			if (arr.length != 7)
			throw new Exception("InfoSetLengthWrong");// ������Ϣ�ļ��ϱ�������Կո�ָ���߸����� ��Ӧ��ϵ����һ�����췽��
		name = arr[0];
		id = arr[2];
		admiClass = Integer.parseInt(arr[3]);
		
			sex = Sex.valueOf(arr[1]);
			ArrayList<Choose> chosenSub = new ArrayList<Choose>(3);
			teaClass = new TreeMap<Integer, ArrayList<Choose>>();
			for (int i = 4; i < 7; ++i)
				chosenSub.add(Choose.valueOf(arr[i]));
			// ������Ҫ��ӵĹ��ܣ����������Ŀ�Ƿ����ظ����������� ���� ��ʷ��
			teaClass.put(admiClass % 3, chosenSub);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void upload(String NAME, String SEX, String ID, int ADMICLASS, String CHOSENSUBS) throws Exception {
		Stu u1 = new Stu(NAME, SEX, ID, ADMICLASS, CHOSENSUBS);
		name = u1.name;
		id = u1.id;
		admiClass = u1.admiClass;
		teaClass = u1.teaClass;
		sex = u1.sex;
	}

	

	public String getName() {
		return name;
	}

	public String getID() {
		return id;
	}

	public Map<Integer, ArrayList<Choose>> getTeaClass() {
		return teaClass;
	}

	public Sex getSex() {
		return sex;
	}
	
	
	
	public void showInfo() {
		System.out.println(name + "�Ļ�����Ϣ��");
		System.out.println(id + " " + admiClass + " " + sex);
		System.out.println("ѡ�������");
		for (ArrayList<Choose> i : teaClass.values()) {
			System.out.println(i);
		}
		System.out.println("**********");
	}

	public StuTable get() {
		return (StuTable) new StuTable("myTable").process(this);
		//����˵�process��������½��Ŀα��ɸ���ָ���α������(myTable)
	}

	

	// �ڲ����Գ���1 ����ѧ���Ļ�����Ϣ����� ��ʵ������ѡ��
	public static void StuInTest1() throws Exception {
		FileDealing fl = new FileDealing(
				"D:\\RES\\MainLep\\SeniorHighSchoolLessonsArrangement\\SeniorHighSchoolLessonsArrangement\\src\\StuExample.txt");

		ArrayList<Stu> stus = new ArrayList<Stu>();
		for (int i = 0; i < 100; ++i)
			stus.add(new Stu(fl.get(i)));
		for (Stu f : stus) {
			f.showInfo();
		}
		System.out.println("����ѡ�������ѧ����");
		int counter = 1;
		for (Stu f : stus) {
			for (ArrayList<Choose> i : f.getTeaClass().values()) {
				if (i.contains(Choose.physics)) {
					System.out.print(f.name + " ");
					if (counter % 10 == 0) {
						System.out.println("");
					}
					counter++;
				}
			}
		}
	}
	
	//��Ԫ����̨
	public static void main(String args[]) throws Exception {
		StuInTest1();
	}
}
