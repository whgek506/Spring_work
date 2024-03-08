package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk{
	
	//생성 된 bean들 중에서 SungJukDTO 찾아서 자동으로 Mapping 해줌(생성자든 Setter 상관 X)
	@Autowired
	private SungJukDTO sungJukDTO; //생성자 가져오기
	
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
