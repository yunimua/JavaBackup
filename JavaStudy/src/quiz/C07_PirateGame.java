package quiz;

import java.util.Scanner;

import myobj.PiratePlay;
import myobj.pirate.Graphic;
import myobj.pirate.MrTong;
import myobj.pirate.Player;

public class C07_PirateGame {

	/*	
		1. 플레이어는 원하는 곳에 돌아가면서 칼을 찌른다
		
		2. 해적 아저씨가 날아가는 구멍이 랜덤으로 설정된다
		
		3. 플레이어는 여러명이 될 수 있다(최소 2인, 최대는 구멍 숫자만큼)
		
		4. 새 게임 생성시 구멍 개수를 설정할 수 있다
		
		5. 해적 아저씨를 날린 플레이어가 패배한다
	*/
	
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
//		int numOfplayer = -1;
//		while(numOfplayer < 2) { //+2명 이상 입력할때까지 실행
//			System.out.print("침여할 인원 수를 입력 > ");
//			numOfplayer = sc.nextInt();
//		}
//		
//		Player[] players = new Player[numOfplayer]; //+ import를 한다 : import myobj.pirate.Player;
//		
//		for (int i =0; i < numOfplayer; ++i) {
//			players[i] = new Player("플레이어" + (i+1));
//		}
//		System.out.println("[System] 플레이어 등록 완료");
//		
//		//나중에 통 크기 결정
//		int size = 30;
//		
//		while (true) {
//            MrTong tong = new MrTong(size); //+ MrTong에서 size를 체크
//            int turn = 0;
//            
//            boolean this_game = true;
//            while (this_game) {
//                System.out.println((turn + 1) + "턴 > \"" 
//                                + players[turn % numOfplayer].getName() + "\"님의 차례" );
//                Graphic.printTong(tong);
//                
//                System.out.println();
//                    
//                boolean this_turn = true;
//                while (this_turn) {
//                    int select = 0;
//                    while (select < 1 || select > size) {
//                            System.out.printf("찌를 곳의 번호를 선택하세요 (1 ~ %d) : ", size);
//                            select = sc.nextInt();
//                    }   
//                    if (tong.stab(select - 1)) { //+ MrTong에서 stab체크
//                            
//                            // 찌르기도 성공하고 발사도 시킨 경우
//                         if (tong.launched) {
//
//                                    // 지금 턴의 플레이어는 1패 추가
//                                    // 나머지 플레이어들은 1승 추가
//                                    // 다음 게임으로 넘어가야 함
//                                for (int i = 0; i < numOfplayer; ++i) {
//                                    if (i == turn % numOfplayer) {
//                                            players[i].lose();
//                                            System.out.println(players[i].getName() + "님의 패배!");
//                                    } else {
//                                            players[i].win();
//                                    }
//                                }     
//                                this_game = false;
//                                        
//                         } else { // 찔렀지만 발사는 안시킨 경우
//                                        
//                          // 다음 사람이 찌르러 가야 함 
//                          this_turn = false;
//                         }
//
//                        break;
//                    } else {
//                     System.out.println("이미 찔렀던 곳입니다.");
//                    }
//                 }	
//                
//            turn++;
//            }
//            
//	        System.out.println("새 게임이 시작됩니다!");
//	        System.out.println("#################################");
//	        System.out.println("");
//	        System.out.println("#################################");
//		}
//	}
//}


//			tong.stab(5); //+ 5번째가 O에서 X로 바뀜
//			
//			tong.stab(13);
//			
//			tong.stab(29); //+29번째는 X로 바뀜, 30번째는 에러남
			
			// 이번 게임의 tong 아저씨의 정보를 꺼내서 그래픽 함수에 넘김 
			//+ Graphic 안에 생성한 public static void "printTong"(MrTong tong) {에서 꺼내옴
			//Graphic.printTong(tong.getStabbed()); //+통아저씨를 가져와서 그래픽을 출력하는 방식(1안)
//			Graphic.printTong(tong);
			

		PiratePlay p = new PiratePlay(0, 0);
		
		p.new_Game();
	}
}	
		
//		Scanner sc = new Scanner(System.in);
//		
//		int hole = 10;
//		int player = 2;
//		int choice_hole;
//		int lose_hole;
//
//		//플레이어 수가 2보다 적거나, 구멍이 플레이어 수보다 적거나 같을 때는 다시 입력
//		while(player < 2) {
//			System.out.print("플레이 할 인원(2명†) 입력: ");
//			player = sc.nextInt();
//		}
//		while(hole < player || hole == player) {
//			System.out.print("총 구멍 수를 입력: ");
//			hole = sc.nextInt();
//		}
//		
//		lose_hole = (int)(Math.random()*hole+1);
//		System.out.println("함정 : " + lose_hole);
//		
//		int i = 0;
//		while(i < hole) {
//			System.out.printf("플레이어[%d] 찌르기 > ", i % player+1);
//			choice_hole = sc.nextInt();
//			int[] check = {choice_hole};
//			
//			if(choice_hole > hole || choice_hole < 1) {
//				continue;
//			}
//			if(choice_hole == lose_hole) {
//				System.out.println("패배...");
//				break;
//			}else {
//				System.out.print("공격 성공!! 다음 > \n");
//				++i;
//			}
//		}
//		System.out.println("칼을 모두 사용하였습니다.");
//	}
//}
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("1.세팅하기\n 2.안하기 > ");
//		System.out.print("> ");
//		int select = sc.nextInt();
//		
//		Settings mySetting = null;
//		if(select == 1) {
//			System.out.print("몇 명?");
//			int a = sc.nextInt();
//			System.out.print("통 몇 개?");
//			int b = sc.nextInt();
//			System.out.print("발사 버튼은 몇 개?");
//			int c = sc.nextInt();
//			
//			mySetting = new Settings(a, b, c);
//		} else {
//			mySetting = new Settings();
//		}
//	}
//}
