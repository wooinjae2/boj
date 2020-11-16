package card;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int[] item = {95000, 19800, 188000, 67000, 82500, 42000, 10800, 16000, 29000, 30000, 52000, 123000, 109700, 78000, 29000, 43000, 47600};
	static int limit = 1000000;
	static int max = 0;
	List<Integer> result = new ArrayList<Integer>();
	static boolean[] check = new boolean[item.length];
	public static void main(String[] args) {
		
		
		for(int i = 0; i < item.length; i++) {
			check[i] = true;
			dfs(0, i);
			check[i] = false;
			
		}
		//교동면옥 95000 t
		//돈경돈까스 19800 t
		//더키친살바토레 188000 t
		//가족 67000 t
		//blank 82500 t
		//청림돼지국밥 42000 t
		//더벤티 10800
		//헤이안 16000  t
		//헤이안 29000  t
		//환여횟집 30000 t
		//우성삼계탕 52000 
		//예술포차 123000
		//피쉬&그릴 치르치르 109700 t
		//네포식당 78000 t
		//노랑통닭 29000
		//한신포차 43000 t
		//리춘시장 47600
		
		System.out.println(max);
	}
	
	
	static void dfs(int total, int idx) {
		if(total+ item[idx] > limit) {
//			System.out.println("여기");
			return;
		}else if(total+ item[idx] > max){
			max = total+ item[idx];
			for(int i = 0 ; i < check.length; i++) {
				if(check[i]) {
					System.out.print(item[i] + " ");
					
				}
			}
			System.out.println(max);
		}
		
		for(int i = idx+1; i < item.length; i++) {
			check[i] = true;
			dfs(item[idx] + total, i);
			check[i] = false;
		}
	}

}
