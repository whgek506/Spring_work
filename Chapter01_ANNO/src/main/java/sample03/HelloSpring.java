package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//파일을 읽는 두 가지 방법
		//1. ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); -> 파일명
		//2. ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml"); -> 파일의 주소
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//스프링은 기본이 싱글톤 -> 생성자를 아무리 많이 만들어도 1개만 생성 -> 하나의 클래스를 잡고 각자의 객체가
		MessageBean messageBean = (MessageBean)applicationContext.getBean("messageBean"); //부모 = 자식
		messageBean.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean2 = (MessageBean)applicationContext.getBean("messageBean"); //부모 = 자식
		messageBean2.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean3 = (MessageBean)applicationContext.getBean("messageBean"); //부모 = 자식
		messageBean3.sayHello("Spring");
		System.out.println();
	}

}

//프로젝트를 실행하면 web.xml를 무조건 읽음