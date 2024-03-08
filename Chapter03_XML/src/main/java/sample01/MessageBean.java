package sample01;

public interface MessageBean {
	public void showPrintBefore(); //삽입O
	public void viewPrintBefore(); //삽입O
	
	public void showPrintAfter(); //삽입O
	public void viewPrintAfter(); //삽입O
	
	public String showPrint(); //삽입O
	public void viewPrint(); //삽입O
	
	public void display(); //삽입X
}
