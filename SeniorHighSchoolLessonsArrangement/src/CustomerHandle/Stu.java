package CustomerHandle;
import java.util.*;
import Setting.*;
import SystemHandle.*;
/**
 * 
 * @author 邢国浩
  * 该文件演示了学生类的初始化和基本信息存储和修改
 */

public class Stu {
	private String name;
	private String id;
	private int admiClass;
	private Map<Integer,ArrayList<Choose>> teaClass;//键值（Integer）为教学班号（3个班一组），内容值(ArrayList<Choose>)为选择科目的数组。
	//Map容器提供了根据内容（数 理 化）查找相关信息的功能，为以后对选择固定科目的学生的操作带来方便
	private Sex sex;
	
	//构造器1
	public Stu(String NAME,String SEX, String ID,
			int ADMICLASS,String CHOSENSUBS) throws Exception{//输入姓名 性别 ID 行政班号 选择科目（使用空格分隔）
		name = NAME;
		id = ID;
		admiClass = ADMICLASS;	
		try {
		sex = Sex.valueOf(SEX);
			String[] temp = CHOSENSUBS.split(" ");
			if(temp.length!=3)
				throw new Exception("ChosenSubLengthWrong");//每个学生只能选择三门课
		ArrayList<Choose> chosenSub = new ArrayList<Choose>(3);
		teaClass = new TreeMap<Integer,ArrayList<Choose>>();
		for(String i:temp)
		chosenSub.add(Choose.valueOf(i));
		teaClass.put(admiClass%3, chosenSub);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	//构造器2 该构造器只接受一个字符串：主要便于文件操作
	public Stu(String InfoSet) throws Exception{
		String[] arr = InfoSet.split(" ");
		if(arr.length!=7)
			throw new Exception("InfoSetLengthWrong");//输入信息的集合必须包含以空格分割的七个单词 对应关系见上一个构造方法
		name = arr[0];
		id = arr[2];
		admiClass = Integer.parseInt(arr[3]);	
		try {
		sex = Sex.valueOf(arr[1]);
		ArrayList<Choose> chosenSub = new ArrayList<Choose>(3);
		teaClass = new TreeMap<Integer,ArrayList<Choose>>();
		for(int i=4;i<7;++i)
		chosenSub.add(Choose.valueOf(arr[i]));
		//程序需要添加的功能：检查三个科目是否有重复（例：生物 生物 历史）
		teaClass.put(admiClass%3, chosenSub);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void upload(String NAME,String SEX, String ID,
			int ADMICLASS,String CHOSENSUBS) throws Exception {
		Stu u1 = new Stu(NAME,SEX,ID,ADMICLASS,CHOSENSUBS);
		name = u1.name; id = u1.id; admiClass = u1.admiClass; 
		teaClass = u1.teaClass;sex = u1.sex;
	}
	
	public StuTable get() {
		/*to be filled*/
		return new StuTable();
	}
	
	
	//测试程序 输入学生的基本信息并打出选择特定科目的学生姓名
	public static void main(String args[]) throws Exception {
		FileDealing fl = new FileDealing("D:\\RES\\MainLep\\SeniorHighSchoolLessonsArrangement\\SeniorHighSchoolLessonsArrangement\\src\\ex.txt");
		
		ArrayList<Stu> stus = new ArrayList<Stu>();
		for(int i=0;i<100;++i)
			stus.add(new Stu(fl.get(i)));
		for(Stu f:stus) {
			System.out.println(f.name + "的基本信息：");
			System.out.println(f.id + " " + f.admiClass + " " + f.sex);
			System.out.println("选课情况：");
			for(ArrayList<Choose> i: f.teaClass.values()) {
				System.out.println(i);
			}
			System.out.println("**********");
		}
		
		System.out.println("其中选择物理的学生有");
		for(Stu f:stus) {
			for(ArrayList<Choose> i: f.teaClass.values()) {
				if(i.contains(Choose.physics)){
					System.out.println(f.name);
				}
			}
		}
	}
}
