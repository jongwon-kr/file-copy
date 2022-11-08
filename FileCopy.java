import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void fread() throws IOException {
		File file = new File("D:/test/file.mp4");
		File newFile = new File("D:/test/test.mp4");

		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(newFile);

		byte[] buf = new byte[1024];

		int size;
		long startTime = getTime();
		while ((size = fis.read(buf)) > 0) {
			fos.write(buf, 0, size);
		}
		long finishTime = getTime();
		System.out.println("파일의 크기" + file.length());
		System.out.println("걸린 시간 : " + (finishTime - startTime) / 1000.000 + "초");
		fis.close();
		fos.close();
	}

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
