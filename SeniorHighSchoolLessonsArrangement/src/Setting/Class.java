package Setting;
import CustomerHandle.Teacher;

public class Class {
	private String subject;
	private int teaClass;//当科目为必考课是为行政班号 选考时为教学班号
	private String where;
	private String startTime;
	private String endTime;
	private int stuNum;
	private Teacher teacher;
	
	public Class(String SUB,String TEACLASS, String WHERE,String START,String END,
			int StuNum,Teacher TEACHER) {
		subject = SUB;
	}
}
