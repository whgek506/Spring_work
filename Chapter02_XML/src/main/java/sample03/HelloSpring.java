package sample03;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SungJuk sungJuk = applicationContext.getBean("sungJukImpl", SungJuk.class);
		
		sungJuk.calcTot();
		sungJuk.calcAvg();
		sungJuk.display();
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("""
				1번 : 수정
				2번 : 종료
				""");
		System.out.print("선택 : ");
		int answer = scan.nextInt();
		
		if(answer==1) {
		sungJuk.modify();
		sungJuk.calcTot();
		sungJuk.calcAvg();
		sungJuk.display();
		System.out.println();
		} else System.out.println("종료합니다.");

	}

}
