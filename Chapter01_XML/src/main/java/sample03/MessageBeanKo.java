package sample03;

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
