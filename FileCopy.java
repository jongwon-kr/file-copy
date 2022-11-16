package Prc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void fCopy() throws IOException {
		File file = new File("D:/����ȭ��/android.exe"); // ���� ����
		File newFile = new File("D:/����ȭ��/androidCopy.exe"); // ���纻 ����

		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(newFile);

		byte[] buf = new byte[131072]; // ����

		int size; // ���� ������
		long startTime = getTime(); // ���� �ð�
		while ((size = fis.read(buf)) > 0) {
			fos.write(buf, 0, size);
		}
		long finishTime = getTime(); // ����ð�
		System.out.println(file.getName()+" ���� �����͸� "+newFile.getName()+"�� �����Ͽ����ϴ�.");
		System.out.println("���� ũ�� " + file.length()+"KB"); // ������ ������ ���
		System.out.println("���� ���� ���� ũ�� : "+buf.length);
		System.out.println("�ɸ� �ð� : " + (finishTime - startTime) / 1000.000 + "��"); // �ɸ� �ð� ��� �� ���
		fis.close(); // FileInputStream �ݱ�
		fos.close(); // FileOutputStream �ݱ�
	}

	// ���� �ð� ��ȯ
	public static long getTime() {
		long reqTime = System.currentTimeMillis();
		return reqTime;
	}

	public static void main(String[] args) {
		try { 
			fCopy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}