package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//핵심 코드 짜는 곳(Target)
@Component
public class MessageBeanImpl implements MessageBean{
	private String str;

	@Autowired
	public void setStr(@Value("Have a nice Day!!") String str) {
		this.str = str;
	}

	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore 메세지 = " + str); //핵심 코드
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000); //CPU 1/1000(1초) 휴식 후 핵심 코드 실행
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메세지 = " + str); //핵심 코드
		
	}

	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메세지 = " + str); //핵심 코드
	}

	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000); //CPU 1/1000(1초) 휴식 후 핵심 코드 실행
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintAfter 메세지 = " + str); //핵심 코드
	}

	@Override
	public String showPrint() {
		System.out.println("showPrint 메세지 = " + str); //핵심 코드
		return "스프링";
		
	}

	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrint 메세지 = " + str); //핵심 코드
		
	}
	
	@Override
	public void display() {
		System.out.println("display 메세지 = " + str); //핵심 코드
	}
}

/*
Target : 
JoinPoint : public void showPrintBefore()
			public void viewPrintBefore()
			public void display()

PointCut :  public void showPrintBefore()
			public void viewPrintBefore();

언제 : before 함수 수행 후 pointcut 함수에 끼어들어감
*/
