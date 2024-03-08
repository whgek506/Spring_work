package sample03;

import java.util.Scanner;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor : 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해줌
@RequiredArgsConstructor
public class SungJukImpl implements SungJuk{
	@NonNull
	private SungJukDTO sungJukDTO; //생성자 가져오기
	
	int tot;
	double avg;
	
	@Override
	public void calcTot() {
		sungJukDTO.setTot(sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath());
	}

	@Override
	public void calcAvg() {
		sungJukDTO.setAvg(sungJukDTO.getTot()/3.0);
	}

	@Override
	public void display() {
		System.out.println(" 이름" + "\t" + "국어"+ "\t" + "영어"+ "\t" + "수학"+ "\t" + "총점"+ "\t" + "평균");
		System.out.println(sungJukDTO);
	}

	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = scan.next();
		System.out.print("국어 성적을 입력하세요 : ");
		int kor = scan.nextInt();
		System.out.print("영어 성적을 입력하세요 : ");
		int eng = scan.nextInt();
		System.out.print("수학 성적을 입력하세요 : ");
		int math = scan.nextInt();
		
		sungJukDTO.setName(name);
		sungJukDTO.setKor(kor);
		sungJukDTO.setEng(eng);
		sungJukDTO.setMath(math);
	}

}
