package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//공통관심사항 코드 짜는 곳()
@Aspect
@Component
public class LoggingAdvice<MethodInvocationProceedJoinPoint> {
	
	@Before("execution(public void sample01.MessageBeanImpl.*Before())")
	public void beforeTrace() { //before
		System.out.println("before trace");
	}
	
	@After("execution(public * *.*.*After(..))")
	public void afterTrace() { //After
		System.out.println("after trace");
	}
	
	@Around("execution(public * *.MessageBeanImpl.*Print(..))")
	public void trace(ProceedingJoinPoint joinpoint)throws Throwable{ //Around
		//앞에 삽입 될 코드
		//ex)System.out.println("하늘");
		String methodName = joinpoint.getSignature().toShortString(); //핵심코드의 메소드
		System.out.println("메소드 = " + methodName);
		
		StopWatch stopWatch = new StopWatch(); //프로그램 실행 시간 계산
		stopWatch.start(); //프로그램 시작
		
		//핵심 코드 메소드 호출
		Object ob = joinpoint.proceed();
		System.out.println(ob);
		//뒤에 삽입 될 코드
		//System.out.println("땅");
		
		stopWatch.stop(); //프로그램 종료
		System.out.println("처리 시간 = " + stopWatch.getTotalTimeMillis()/1000 + "초");
	}
}
