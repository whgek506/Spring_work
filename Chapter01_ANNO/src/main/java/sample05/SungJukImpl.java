package sample05;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk{

	@Override
	public void name(String name) {
		System.out.println("이름 = " + name);
	}

	@Override
	public void tot(int kor, int eng, int math) {
		System.out.println("총 합 = " + (kor+eng+math));
	}

	@Override
	public void avg(int kor, int eng, int math) {
		int tot = kor+eng+math;
		double avg = tot/3; 
		System.out.println("평균 = " + Math.round(avg));
	}
	
//	<다른 방법^^>
//	private String name;
//	private int kor;
//	private int eng;
//	private int math;
//	private int tot;
//	private double avg;
//	
//	public SungJukImpl() {
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.print("이름을 입력하세요 : ");
//		name = scan.next();
//		System.out.print("국어 성적을 입력하세요 : ");
//		kor = scan.nextInt();
//		System.out.print("영어 성적을 입력하세요 : ");
//		eng = scan.nextInt();
//		System.out.print("수학 성적을 입력하세요 : ");
//		math = scan.nextInt();
//	}
//
//	@Override
//	public void calc() {
//		tot = (double) kor + math + eng;
//    	avg = tot / 3.0;
//	}
//
//	@Override
//	public void display() {
//		System.out.printf("이름 : %s, 국어 : %d, 수학 : %d, 영어 : %d, 총점 : %.0f, 평균 : %.2f %n", 
//							name, kor, math, eng, tot, avg);
//	}

}
