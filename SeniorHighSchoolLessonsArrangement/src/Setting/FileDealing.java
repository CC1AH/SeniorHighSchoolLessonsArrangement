package Setting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * �ļ����� �ó��������ļ���ģ�黯���� ��� ����
 * 
 *
 */
public class FileDealing extends ArrayList<String> {
	private static final long serialVersionUID = 1L;

	// ��ȡ�ļ�
	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
		return sb.toString();
	}

	// ���ļ�д��
	public static void write(String fileName, String text) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	// ������1
	public FileDealing(String fileName, String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));
		if (get(0).equals("")) {
			remove(0);
		}
	}

	// ������2
	public FileDealing(String fileName) {
		this(fileName, "\n");// �Ի��к��з�
	}

	// ����д�뵽�ļ�
	public void write(String fileName) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {

				for (String item : this) {
					out.print(item);
				}
			} finally {
				out.close();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
