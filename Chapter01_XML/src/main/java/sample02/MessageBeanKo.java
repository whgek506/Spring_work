package sample02;

public class MessageBeanKo implements MessageBean{

	public MessageBeanKo() {
		System.out.println("MessageBeanKo 기본 생성자"); //호출 시 출력
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요" + name);
		
	}

}
