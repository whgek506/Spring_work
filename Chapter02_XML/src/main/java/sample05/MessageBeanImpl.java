package sample05;

import lombok.Setter;

public class MessageBeanImpl implements MessageBean{
	
	private String name;
	private String phone;
	private Outputter outputter; //output()를 사용하기 위해

	public MessageBeanImpl(String name) {
		this.name = name;
		System.out.println("MessageBeanImpl(String name) 생성자");
	}

	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("setPhone(String phone)");
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("setOutputter(Outputter outputter)");
	}

	@Override
	public void helloCall() {
		outputter.output("나의 이름 " + name + "이고, 핸드폰은 " + phone + "이다.");
		System.out.println("helloCall()");
	}

}
