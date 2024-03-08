package sample04;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Scope("prototype")
@Setter
@Getter
public class SungJukDTO2 {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	@Override
	public String toString() {
		return 	name + "\t"
				+ kor + "\t"
				+ eng + "\t" 
				+ math + "\t"
				+ tot + "\t"
				+ String.format("%.2f", avg);
	}
}
