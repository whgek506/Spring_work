package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample03.MessageBean;

public class HelloSpring {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calc;
		
		calc = (Calc) applicationContext.getBean("calcAdd"); //부모 = 자식
		calc.calculate(25, 36);
		
		calc = applicationContext.getBean("calcMul", Calc.class); //캐스팅(부모 = 자식)하기 싫을 때 >>Calc.class<< 타입 표시
		calc.calculate(25, 36);

	}

}
