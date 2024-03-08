package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;
import sample04.SungJukDTO2;

@Configuration //@Configuration : 환경설정 파일 지정 => 타입은 java이지만 xml로 취급
public class SpringConfiguration {
	
	//<project 안에 있는 모든 bean 생성하는 곳>
	//-------- sample01 ----------
//	@Bean
//	public MessageBeanImpl messageBeanImpl() {
//		return new MessageBeanImpl("사과");
//	}
	@Bean(name="messageBeanImpl") //setter, getter 사용 시 name 속성 이용
	public MessageBeanImpl getMessageBeanImpl() {
		return new MessageBeanImpl("사과"); //생성자에 값이 존재하지 않기 때문에 기본 값 넣어줌
	}
	
	//-------- sample02 ----------
	@Bean
	public CalcAdd calcAdd() {
		return new CalcAdd();
	}
	
	@Bean(name="calcMul")
	public CalcMul calcMul() {
		return new CalcMul();
	}
	
	//-------- sample04 ----------
	@Bean
	public List<SungJukDTO2> arrayList() { //타입은 부모로 잡아줌 / 메소드는 applicationContext.xml에 있는 id명과 동일하게 지정
		return new ArrayList<SungJukDTO2>();
	}

}

/*
@Bean
=> 메소드에서 return 되는 값을 스프링의 bean으로 생성
=> 메소드명을 설정할 때는 반드시 bean의 id명으로 설정
=> 메소드명을 설정할 때 자바처럼 getter를 사용하려면 @Bean(name="")을 사용
 */