package SystemHandle;

import java.util.*;
import CustomerHandle.*;
/**
 * 管理员表类
 * 管理员将通过把Admin类对象传递给process方法来获取一个该类的实例
 *（或者这样说：process方法将根据Admin类对象属性的不同来决定生成的AdmiTable，同时更改Admin中的宏观信息（static是共用的））
 */
public class AdmiTable extends Table {

	public AdmiTable(String TABLEID) {
		super(TABLEID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Table process(Object s1) {
		return null;
	}
	
}
