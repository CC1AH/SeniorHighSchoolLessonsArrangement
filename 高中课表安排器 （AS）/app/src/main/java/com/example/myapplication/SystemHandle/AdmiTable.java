package com.example.myapplication.SystemHandle;

import java.util.*;
import com.example.myapplication.Settings.*;
/**
 * 管理员表类
 * 管理员将通过把Admin类对象传递给process方法来获取一个该类的实例
 *（或者这样说：process方法将根据Admin类对象属性的不同来决定生成的AdmiTable，同时更改Admin中的宏观信息（static是共用的））
 */
public class AdmiTable extends Table {

	int[][] StuNumByAdmClaAndChose;
	public AdmiTable(String TABLEID) {
		super(TABLEID);
	}

	@Override
	public Table process(Object s1) {
		/*
		 * 待填充的代码：根据传入的Object(管理员)的信息填（包括班级数等等）填充课表int二维数组
		 * 返回本对象的一个实例
		 */
		return this;
	}
	/* public void getDetails(int cla,Choose choose) {
		/*
		 * 可选的方法 获得管理员表中的具体信息 
		 */
	 /*}*/
}
