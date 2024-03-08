package sample04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
	
	//생성된 bean들 중에서 SungJukDTO2 타입을 찾아서 자동으로 매핑
	//생성자 or Setter 상관 없이 SungJukDTO2 타입을 찾아서 자동으로 매핑 해라
	@Autowired
	private SungJukDTO2 sungJukDTO2 = null;
	
	@Autowired
	@Qualifier("arrayList") //@Qualifier : SpringConfiguration의 id와 매핑(동일한 bean이 있을 수 있기 때문에 id로 구분하기 위해 사용)
	private ArrayList<SungJukDTO2> list; //interface으로 될 때는 매핑을 해줘야 함
	
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
