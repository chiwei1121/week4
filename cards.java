import java.util.*;

class cards{
	private ArrayList<card> cards = new ArrayList<card>();
	int total,value;

	public cards(int num){
		String suit;
		String[] suitsCard = new String[] {"Club","Heart","Diamond","Spade"};
		this.total = num *52; 
		for(int i = 0; i < this.total; i++){
			suit = suitsCard[i / (13 * num)];
			value = 1 + i % 13;
			card newCard = new card(suit,value);
			cards.add(newCard);
		}
		Shuffle(this.total);
	}
	private void Shuffle(int v){ /*洗牌*/
		Random tempRandom = new Random();
		for(int i = 0; i < cards.size(); i++){
			int x = tempRandom.nextInt(v);
			Collections.swap(cards, i, x);
		}
	}

	public card Playing(){
		card tempCard = cards.get(0);
		cards.remove(0);
		this.total = this.total - 1;
		return tempCard;
	}

	public void Show(){
		for(card i: cards){
			i.Show();
		}
	}
}