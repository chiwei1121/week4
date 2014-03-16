import java.util.*;

class weekTest41{
	public static void main(String[] args){
		System.out.println("\n");
		System.out.println("Welcome to play Blackjack Game \n");
		System.out.println("1)Start 2)Quit: ");
		
		Scanner stdIn = new Scanner(System.in);
		int opt = stdIn.nextInt();
	
		while(true){
			if(opt == 2)
				break;
			cards tempC = new cards(1);
			players player = new players("Player");
			players dealer = new players("Dealer");

			for(int i=0;i<2;i++){ /*2 cards*/
				player.Hit(tempC.Playing());
				dealer.Hit(tempC.Playing());
			}
			
			System.out.println("\nYour Cards : ");
			player.Show();
			player.ShowPoint();

			while(true){
				System.out.println("1)Hit 2)Stay: ");
				int opt2 = stdIn.nextInt();

				if (opt2 == 1)
				{
					player.Hit(tempC.Playing());
					System.out.println("\nYour Cards : ");				
					player.Show();
					player.ShowPoint();

					if(player.Point() == 21){
						System.out.println("Blackjack!");
						break;
					}
					if(player.Point() >21){
						System.out.println("Busted!");
						break;
					}
				}
				else if(opt2 == 2)
					break;
				else
					continue;
			}

			System.out.println("\n");
			System.out.println("\nDealer Cards : ");
			dealer.Show();
			dealer.ShowPoint();
			
			while(true){
				if(dealer.Point() >= 17)
					break;
				else{
					dealer.Hit(tempC.Playing());
					System.out.println("\nDealer Cards : ");
					dealer.Show();
					dealer.ShowPoint();
				}	
			}

			System.out.println("\n");  /*return*/
			System.out.println( "玩家:" + player.Point());
			System.out.println("莊家:" + dealer.Point());
			if(player.Point() > 21)
				System.out.println("You lose!");
			else if (dealer.Point() >21){
				System.out.println("You win!");
			}
			else if(dealer.Point() == player.Point()){
				System.out.println("You lose!");
			}
			else if(dealer.Point() > player.Point()){
				System.out.println("You lose!");
			}
			else{
				System.out.println("You win!");
			}

			System.out.println("1)Continue 2)Quit : ");
			opt = stdIn.nextInt();
			player.moveCards();
			dealer.moveCards();
		}
	}
}
