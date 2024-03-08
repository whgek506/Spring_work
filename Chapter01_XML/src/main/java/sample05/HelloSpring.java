package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SungJuk sungJuk;
		
		sungJuk = applicationContext.getBean("sungjuk", SungJuk.class);
		
		System.out.print("이름을 입력하세요 : ");
		String name = scan.next();
		System.out.print("국어 성적을 입력하세요 : ");
		int kor = scan.nextInt();
		System.out.print("영어 성적을 입력하세요 : ");
		int eng = scan.nextInt();
		System.out.print("수학 성적을 입력하세요 : ");
		int math = scan.nextInt();
		
		sungJuk.name(name);
		sungJuk.tot(kor, eng, math);
		sungJuk.avg(kor, eng, math);
		
//		<다른방법^^>
//		sungJuk.calc();
//		sungJuk.display();
	}

}
