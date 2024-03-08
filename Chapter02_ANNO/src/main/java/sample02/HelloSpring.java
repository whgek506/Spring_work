package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calcadd = (Calc) applicationContext.getBean("calcAdd");
		Calc calcmul = (Calc) applicationContext.getBean("calcMul");
		
		calcadd.calculate();
		calcmul.calculate();
	}

}