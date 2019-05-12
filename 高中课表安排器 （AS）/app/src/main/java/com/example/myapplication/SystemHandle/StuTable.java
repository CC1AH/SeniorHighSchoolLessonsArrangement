package com.example.myapplication.SystemHandle;

import com.example.myapplication.SystemHandle.*;
import com.example.myapplication.Settings.*;

import java.util.*;
/**
 * 学生表类
 * 学生（其实是Admin最先上传其类对象（其中包含学生信息）来运用该方法）将通过把Stu类对象传递给process方法来获取一个该类的实例
 *（或者这样说：process方法将根据Stu类对象属性的不同来决定生成的StuTable，不必更改中的宏观信息（管理者输入的处理应该在学生独立申请获取表之前进行））
 */

public class StuTable extends Table{

	Cla[][] cla = new Cla[5][MCN+ACN];
	//课程二维数组，固定的大小
	public StuTable(String TABLEID) {
		super(TABLEID);  
	}

	@Override
	public Table process(Object s1) {
		/*
		 * 待填充的代码：根据传入的Object(学生)的信息填充课表二维数组
		 * 返回本对象的一个实例
		 */
		return this;
	}

}
