package com.example.myapplication.CustomerHandle;

import java.util.*;

import com.example.myapplication.Settings.*;
import com.example.myapplication.SystemHandle.*;

/**
 * 该文件是学生类
 * 输入信息 获取课表
 */

public class Stu {
    private String name;
    private String id;
    private int admiClass;
    private Map<Integer, ArrayList<Choose>> teaClass;
    // 键值（Integer）为教学班号（3个班一组），内容值(ArrayList<Choose>)为选择科目的数组。
    //但是此处Map只有一个键值（其实只是方便查看而已，同时便于添加学生的其他信息（以后可能有需要？））
    private Sex sex;
    private String choose;

    // 构造器1
    public Stu(String NAME, String SEX, String ID, int ADMICLASS, String CHOSENSUBS) throws Exception {// 输入姓名 性别 ID 行政班号 选择科目（使用空格分隔）
        name = NAME;
        id = ID;
        admiClass = ADMICLASS;
        choose =  CHOSENSUBS;
        try {
            sex = Sex.valueOf(SEX);
            String[] temp = CHOSENSUBS.split(" ");
            if (temp.length != 3)
                throw new Exception("ChosenSubLengthWrong");// 每个学生只能选择三门课
            ArrayList<Choose> chosenSub = new ArrayList<Choose>(3);
            teaClass = new TreeMap<Integer, ArrayList<Choose>>();
            for (String i : temp)
                chosenSub.add(Choose.valueOf(i));
            teaClass.put(admiClass % 3, chosenSub);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 构造器2 该构造器只接受一个字符串：主要便于文件操作
    public Stu(String InfoSet) throws Exception {
        String[] arr = InfoSet.split(" "); // 或\\w+
        try {
            if (arr.length != 7)
                throw new Exception("InfoSetLengthWrong");// 输入信息的集合必须包含以空格分割的七个单词 对应关系见上一个构造方法
            name = arr[0];
            id = arr[2];
            admiClass = Integer.parseInt(arr[3]);

            sex = Sex.valueOf(arr[1]);
            ArrayList<Choose> chosenSub = new ArrayList<Choose>(3);
            teaClass = new TreeMap<Integer, ArrayList<Choose>>();
            for (int i = 4; i < 7; ++i)
                chosenSub.add(Choose.valueOf(arr[i]));
            teaClass.put(admiClass % 3, chosenSub);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public Stu() {
        //一个空的默认构造器 用于在stu_table 中初始化（try块外部-可能没有初始化而无法使用）
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

    public String getChosen(){
        return choose;
    }

    public int getAdmiClass() {
        return admiClass;
    }

    public String showInfo() {
        String result = name + "的基本信息：" + id + " " + admiClass + " " + sex + "\n选课情况：";
        for (ArrayList<Choose> i : teaClass.values()) {
            result += i;
        }
        return result;
    }

    public StuTable get() {
        return (StuTable) new StuTable("myTable").process(this);
        //处理端的process方法填充新建的课表。由该生指定课表的名称(myTable)
    }


    // 内部测试程序1 输入学生的基本信息并打出 并实现特征选择
    public static void StuInTest1() throws Exception {
        FileDealing fl = new FileDealing(
                "D:\\RES\\MainLep\\SeniorHighSchoolLessonsArrangement\\SeniorHighSchoolLessonsArrangement\\src\\StuExample.txt");

        ArrayList<Stu> stus = new ArrayList<Stu>();
        for (int i = 0; i < 100; ++i)
            stus.add(new Stu(fl.get(i)));
        for (Stu f : stus) {
            System.out.println(f.showInfo());
        }
        System.out.println("其中选择物理的学生有");
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

    //单元测试台
    public static void main(String args[]) throws Exception {
        StuInTest1();
    }
}
