package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class SungJukUpdate implements SungJuk {
	@Autowired
	private List<SungJukDTO2> list;

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
	    String name = scan.next();
	    
	    int sw = 0; //수 일치 사용(이름의 존재 여부를 표시하기 위해)
	    for(SungJukDTO2 sungJukDTO2 : list) {
	    	if(sungJukDTO2.getName().equals(name)) {
	    		sw = 1; //sw 숫자의 변화 : 리스트와 일치하는 이름이 있음
	    	
	    		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
	    		System.out.println(sungJukDTO2);
	    		
	    		System.out.println();
	    		System.out.print("수정 할 국어 점수를 입력하세요 : ");
	    	    int kor = scan.nextInt();
	    	    System.out.print("수정 할 영어 점수를 입력하세요 : ");
	    	    int eng = scan.nextInt();
	    	    System.out.print("수정 할 수학 점수를 입력하세요 : ");
	    	    int math = scan.nextInt();
	    	    
	    	    int tot = kor + eng + math;
	    	    double avg = tot / 3.0;
	    	    
	    	    sungJukDTO2.setKor(kor);
	    	    sungJukDTO2.setEng(eng);
	    	    sungJukDTO2.setMath(math);
	    	    sungJukDTO2.setTot(tot);
	    	    sungJukDTO2.setAvg(avg);
	    	    
	    	    System.out.println();
	    	    System.out.println(name + "님의 데이터를 수정하였습니다");
	    	    
	    	    break; //수행을 다 끝낸 뒤 중복 되는 이름이 없기 때문에 for문 탈출
	    	    
	    	} //if
	    }//for
	    
	    if(sw==0) System.out.println("찾고자하는 이름이 없습니다.");

		
	}

}
