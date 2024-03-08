package sample04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lombok.Setter;

public class SungJukInput implements SungJuk {
	@Setter
	private SungJukDTO2 sungJukDTO2 = null;
	@Setter
	private List<SungJukDTO2> list;
	
//	public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) { => 대신 @Setter 사용
//		this.sungJukDTO2 = sungJukDTO2;
//	}
//	public void setList(List<SungJukDTO2> list) {
//		this.list = list;
//	}
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.print("이름을 입력하세요 : ");
	    String name = scan.next();
	    System.out.print("국어 점수를 입력하세요 : ");
	    int kor = scan.nextInt();
	    System.out.print("영어 점수를 입력하세요 : ");
	    int eng = scan.nextInt();
	    System.out.print("수학 점수를 입력하세요 : ");
	    int math = scan.nextInt();
	    
	    int tot = kor + eng + math;
	    double avg = tot / 3.0;
	    
	    //SungJukDTO2 sungJukDTO2 = new SungJukDTO2();
	    sungJukDTO2.setName(name);
	    sungJukDTO2.setKor(kor);
	    sungJukDTO2.setEng(eng);
	    sungJukDTO2.setMath(math);
	    sungJukDTO2.setTot(tot);
	    sungJukDTO2.setAvg(avg);
	    
	    //List<SungJukDTO2> list = new ArrayList<SungJukDTO2>(); 
	    list.add(sungJukDTO2);
	    
	    System.out.println();
	    System.out.println(name + "님의 데이터를 입력하였습니다");
	    
	    
	}

}
