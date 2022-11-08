import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void fread() throws IOException {
		File file = new File("D:/test/file.mp4");	// 원본 파일
		File newFile = new File("D:/test/test.mp4");	// 복사본 파일

		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(newFile);

		byte[] buf = new byte[1024];	// 버퍼

		int size;	// 파일 사이즈
		long startTime = getTime();	// 시작 시간
		while ((size = fis.read(buf)) > 0) {
			fos.write(buf, 0, size);
		}
		long finishTime = getTime();	// 종료시간
		System.out.println("파일의 크기" + file.length());	// 파일의 사이즈 출력
		System.out.println("걸린 시간 : " + (finishTime - startTime) / 1000.000 + "초");	// 걸린 시간 계산 및 출력
		fis.close();	// FileInputStream 닫기
		fos.close();	// FileOutputStream 닫기
	}
		
	// 현재 시간 반환
	public static long getTime() {
		long reqTime = System.currentTimeMillis();
		return reqTime;
	}

	public static void main(String[] args) {
		try {
			fread();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
