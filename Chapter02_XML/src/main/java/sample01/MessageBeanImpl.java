package sample01;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor //Lombok을 실행 해주는 어노테이션
public class MessageBeanImpl implements MessageBean {
	@NonNull //Null 값 허용X
	private String fruit;
	@Setter
	private int cost;
	@Setter
	private int qty;

//	<생성자 Injection(생성자를 통해 값을 전달 받음)>
//	public MessageBeanImpl(String fruit) {
//		this.fruit = fruit;
//	}
//
//	<Setter Injection(Setter를 통해 값을 전달 받음)>
//	public void setCost(int cost) {
//		this.cost = cost;
//	}
//
//	public void setQty(int qty) {
//		this.qty = qty;
//	}
	
	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

	@Override
	public void SayHello(String fruit, int cost) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

	@Override
	public void SayHello(String fruit, int cost, int qty) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
		
	}

}
