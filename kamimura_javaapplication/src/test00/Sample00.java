package test00;

public class Sample00 {
public static void main(String[] args) {
	int x = 100;
	String y = "abc";
	String sql = "intser into test values("+x+","+y+")";
	System.out.println(sql);
}
}
