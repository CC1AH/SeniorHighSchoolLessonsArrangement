package com.example.myapplication.CustomerHandle;

import java.util.ArrayList;

import com.example.myapplication.Settings.*;
import com.example.myapplication.SystemHandle.*;

/**
 * 该文件是老师类
 * 输入信息 取得课表
 */
public class Teacher {
    private String name;
    private Choose subject;
    private String id;
    private int teaClass;
    private Sex sex;

    public Teacher(){

    }
    //构造器1
    //输入姓名 教学科目 ID 教学班级（主课老师为行政班号，选修课老师为教学班号），性别
    public Teacher(String Name, String Subject, String Id, int TeaClass, String SEX) {
        name = Name;
        id = Id;
        subject = Choose.valueOf(Subject);
        teaClass = TeaClass;
        sex = Sex.valueOf(SEX);
    }//两个构造器顺序不一样啊当时还出bug了：抽空改一下：规范是多么重要

    //构造器2
    //输入字符串 统一录入老师信息 分割顺序同 构造器1
    public Teacher(String infoSet) throws Exception {
        String[] info = infoSet.split("\\W+");
        try {
            if (info.length != 5) {
                throw new Exception("InfoSetLengthWrong");// 输入信息的集合必须包含以空格分割的5个单词 对应关系见上一个构造方法
            }
            name = info[0];
            subject = Choose.valueOf(info[1]);
            id = info[2];
            teaClass = Integer.parseInt(info[3]);
            sex = Sex.valueOf(info[4]);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void upload(String Name, String Id, String Subject, int TeaClass, String SEX) {
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
        return (TeaTable) new TeaTable("myTable").process(this);
        //处理端的process方法填充新建的课表。由该老师指定课表的名称(myTable)
    }


    public String showInfo() {
        String result = "老师 " + name + " 的Id是 " + id + "\n负责的教学科目是："+ subject.name() + "\n负责的教学班级是：" + teaClass;
        return result;
    }


    //内部测试程序1：输入老师的基本信息并打出
    public static void TeaInTest1() throws Exception {
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

    //单元测试台
    public static void main(String args[]) throws Exception {
        TeaInTest1();
    }
}
