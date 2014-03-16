import java.util.*;

class players{
	private ArrayList<card> gamePlayer;
	private String name;
	private int point;

	public players(String n){
		gamePlayer = new ArrayList<card>();
		this.name = n;
	}

	public void Hit(card t){
		gamePlayer.add(t);
	}

	public void Show(){ /*印出排組*/
		for(card i : gamePlayer){
			i.Show();
		}
	}

	public void ShowPoint(){
		Point();
		System.out.println("Point : " + point + "\n");
	}
	
	public void moveCards(){
		gamePlayer.clear();
	}
	
	public int Point(){
		int aceNum = 0, sum = 0,sum2=0;
		
		for(card i : gamePlayer){ /*sum add*/
			if(i.pointNum() == 1){
				aceNum ++; /* How much ace card ?*/
			}
			else if(i.pointNum() > 10){
				sum += 10;
			}
			else{
				sum += i.pointNum();
			}
		}
		sum2 = ComPoint(sum, aceNum);
		
		if(sum2 == -1){
			this.point = sum + aceNum*11;
			return (sum + aceNum*11);
		}
		else{
			this.point = sum2;
			return sum2;
		}
	}

	private int ComPoint(int value,int count){
		if((value==10 && count==1)|| value+count == 21){
			return 21;
		}
		else if(value+count > 21){
			return value+count;
		}
		else{
			if(value+(count*11) < 21 && count!=0)
				return -1;
			else
				return value+ count;
		}
	}
}