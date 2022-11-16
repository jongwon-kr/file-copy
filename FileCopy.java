package Prc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void fCopy() throws IOException {
		File file = new File("D:/바탕화면/android.exe"); // 원본 파일
		File newFile = new File("D:/바탕화면/androidCopy.exe"); // 복사본 파일

		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(newFile);

		byte[] buf = new byte[131072]; // 버퍼

		int size; // 파일 사이즈
		long startTime = getTime(); // 시작 시간
		while ((size = fis.read(buf)) > 0) {
			fos.write(buf, 0, size);
		}
		long finishTime = getTime(); // 종료시간
		System.out.println(file.getName()+" 파일 데이터를 "+newFile.getName()+"로 복사하였습니다.");
		System.out.println("파일 크기 " + file.length()+"KB"); // 파일의 사이즈 출력
		System.out.println("파일 전송 버퍼 크기 : "+buf.length);
		System.out.println("걸린 시간 : " + (finishTime - startTime) / 1000.000 + "초"); // 걸린 시간 계산 및 출력
		fis.close(); // FileInputStream 닫기
		fos.close(); // FileOutputStream 닫기
	}

	// 현재 시간 반환
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