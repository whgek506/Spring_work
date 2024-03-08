package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBeanKo messageBeanKo = new MessageBeanKo(); //자식 생성자 호출
		//MessageBeanEn messageBeanEn = new MessageBeanEn(); //결합도 100%, 1:1관계
		
		//부모 생성자 호출(인터페이스 사용 - new 뒤에 생성자명만 바꾸면 됨) => 결합도 낮추기, 다형성(부모 = 자식)
		MessageBean messageBean = new MessageBeanKo();
		messageBean.sayHello(" 한국인 입니다.");
		//MessageBean messageBean2 = new MessageBeanEn();
		//messageBean2.sayHello("I am korean");
		
	}

}
