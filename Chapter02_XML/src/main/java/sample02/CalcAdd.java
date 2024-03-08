package sample02;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class CalcAdd implements Calc{
	@Setter
	private int x;
	@Setter
	private int y;
	
	@Override
	public void calculate() {
		System.out.println(x + " + " + y + "=" + (x+y));
		
	}

}