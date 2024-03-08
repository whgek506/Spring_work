package sample05;

import java.io.FileWriter;
import java.io.IOException;

//파일로 출력하는 클래스
public class FileOutputter implements Outputter{
	private String filePath; //파일 경로
	private String fileName; //파일 이름
	
	public FileOutputter() {
		System.out.println("FileOutputter 기본 생성자");
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		System.out.println("setFilePath(String filePath)");
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		System.out.println("setFileName(String fileName)");
	}


	@Override
	public void output(String message) {
		System.out.println("output(String message)");
		
		try {
			FileWriter fileWriter = new FileWriter(filePath + fileName); //파일 생성
			fileWriter.write(message); //메세지를 파일로 보내기
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
