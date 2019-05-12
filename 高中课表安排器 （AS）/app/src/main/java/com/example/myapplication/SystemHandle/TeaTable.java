package com.example.myapplication.SystemHandle;

import com.example.myapplication.SystemHandle.*;
import com.example.myapplication.Settings.*;
/**
 * 老师表类
 * 老师（其实是Admin最先上传其类对象（其中包含老师信息）来运用该方法）将通过把Teacher类对象传递给process方法来获取一个该类的实例
 *（或者这样说：process方法将根据Teacher类对象属性的不同来决定生成的TeaTable，不必更改中的宏观信息（管理者输入的处理应该在老师独立申请获取表之前进行））
 */
public class TeaTable extends Table {
	Class[][] cla = new Class[5][MCN+ACN];
	public TeaTable(String TABLEID) {
		super(TABLEID);
	}

	@Override
	public Table process(Object s1) {
		/*
		 * 待填充的代码：根据传入的Object(教师)的信息填充课表二维数组
		 * 返回本对象的一个实例
		 */
		return this;
	}
}
