package card;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int[] item = {95000, 19800, 188000, 67000, 82500};
	static int limit = 390000;
	static int max = 0;
	List<Integer> result = new ArrayList<Integer>();
	static boolean[] check = new boolean[item.length];
	public static void main(String[] args) {
		
		
		for(int i = 0; i < item.length; i++) {
			check[i] = true;
			dfs(0, i);
			check[i] = false;
			
		}
		//������� 95000
		//���海� 19800
		//��Űģ����䷹ 188000
		//���� 67000
		System.out.println(max);
	}
	
	
	static void dfs(int total, int idx) {
		if(total+ item[idx] > limit) {
//			System.out.println("����");
			return;
		}else if(total+ item[idx] > max){
			max = total+ item[idx];
			for(int i = 0 ; i < check.length; i++) {
				System.out.print(check[i] + " ");
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
