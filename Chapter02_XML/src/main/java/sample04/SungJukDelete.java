package sample04;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;

public class SungJukDelete implements SungJuk {
	@Setter
	private List<SungJukDTO2> list;

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
	    String name = scan.next();
	    
	    int sw = 0; //수 일치 사용(이름의 존재 여부를 표시하기 위해)
	  //list 삭제 시 for문 사용X (list의 개수가 바뀌는데 for문은 개수만큼 돌기 때문에 마지막 데이터 제거 시 오류) => Iteratort 사용
	    Iterator<SungJukDTO2> it = list.iterator();
	    
	    while(it.hasNext()) { //항목이 있으면 true, 항목이 없으면 false
	    	
	    	//it가 가르키는 항목을 꺼내서 임시 메모리 공간에 저장 -> it 다음 항목으로 이동
	    	SungJukDTO2 sungJukDTO2 = it.next();
	    	
	    	if(sungJukDTO2.getName().equals(name)) {
	    		sw = 1; //sw 숫자의 변화 : 리스트와 일치하는 이름이 있음
	    	    
	    		System.out.println();
	    		System.out.println("정말 삭제 하시겠습니까?(Y/N)");
	    		System.out.println("입력 : ");
	    		String answer = scan.next();
	    		
	    		if(answer.equals("Y") || answer.equals("y")) {
	    			it.remove(); //임시 메모리 공간에 보관한 데이터 삭제
	    			System.out.println();
		    	    System.out.println(name + "님의 데이터를 삭제하였습니다");
		    	    
	    		}else System.out.println("삭제를 취소하였습니다.");
	    		
	    		break;
	    	    
	    	} //if
	    }//while
	    
	    if(sw==0) System.out.println("찾고자 하는 이름이 없습니다.");
	}

}
