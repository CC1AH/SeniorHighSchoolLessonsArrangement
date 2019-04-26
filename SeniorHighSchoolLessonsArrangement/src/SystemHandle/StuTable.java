package SystemHandle;

import CustomerHandle.*;
/**
 * 学生表类
 * 学生（其实是Admin最先上传其类对象（其中包含学生信息）来运用该方法）将通过把Stu类对象传递给process方法来获取一个该类的实例
 *（或者这样说：process方法将根据Stu类对象属性的不同来决定生成的StuTable，不必更改中的宏观信息（管理者输入的处理应该在学生独立申请获取表之前进行））
 */

public class StuTable extends Table{

	public StuTable(String TABLEID) {
		super(TABLEID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Table process(Object s1) {
		// TODO Auto-generated method stub
		return null;
	}

}
