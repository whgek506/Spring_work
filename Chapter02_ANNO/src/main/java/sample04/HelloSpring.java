package sample04;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HelloSpring {
	
	public void menu(ApplicationContext applicationContext) { //main에 있는 ApplicationContext 받아오기
		System.out.println();
		Scanner scan = new Scanner(System.in);
		SungJuk sungJuk = null;
		int num;
		
		while(true) {
			System.out.println();
			System.out.println("******************");
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
		    System.out.println("4.삭제");
		    System.out.println("5.종료");
		    System.out.println("******************");
		    System.out.print("번호 : ");
		    num = scan.nextInt();
		    
		     if(num==1) {
		    	 sungJuk = applicationContext.getBean("sungJukInput", SungJuk.class);
		     }else if(num==2) { 
		    	 sungJuk = applicationContext.getBean("sungJukOutput", SungJuk.class);
		     }else if(num==3) { 
		    	 sungJuk = applicationContext.getBean("sungJukUpdate", SungJuk.class);
		     }else if(num==4) {
		    	 sungJuk = applicationContext.getBean("sungJukDelete", SungJuk.class);
		     } //if
		     if(num==5) break;
		     
		     sungJuk.execute();
		     
		}//while
	}

	public static void main(String[] args) {
		//HelloSpring helloSpring = new HelloSpring(); 변동X -> bean 사용 가능
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HelloSpring helloSpring = applicationContext.getBean("helloSpring", HelloSpring.class);
		helloSpring.menu(applicationContext); //menu() 함수에게 ApplicationContext 전달(menu도 사용해야 하는데 전달하면 따로 기재 할 필요X)
		
		System.out.println();
		System.out.println("프로그램을 종료합니다.");

	}

}
