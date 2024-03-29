package sample03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Annotation 사용 시 application 사용X
@Component("messageBean")
@Scope(value = "prototype")
public class MessageBeanKo implements MessageBean{
	
	private int num; //필드, 초기화

	public MessageBeanKo() {
		System.out.println("MessageBeanKo 기본 생성자"); //호출 시 출력
	}

	@Override
	public void sayHello(String name) {
		num++; //1
		System.out.println("num = " + num);
		System.out.println("안녕하세요" + name);
		
	}

}
