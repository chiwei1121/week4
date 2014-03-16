import java.util.*;

class card{
	private String suitsName;
	private int pointNum;
	public card(String suitNum,int val){
		this.suitsName = suitNum;
		this.pointNum = val;
	}
	public String suitsName(){
		return this.suitsName;
	}
	public int pointNum(){
		return this.pointNum;
	}
	public void Show(){
		System.out.println(suitsName() + " " + pointNum());
	}
}