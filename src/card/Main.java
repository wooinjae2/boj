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
		//������� 95000 t
		//���海� 19800 t
		//��Űģ����䷹ 188000 t
		//���� 67000 t
		//blank 82500 t
		//û���������� 42000 t
		//����Ƽ 10800
		//���̾� 16000  t
		//���̾� 29000  t
		//ȯ��Ƚ�� 30000 t
		//�켺����� 52000 
		//�������� 123000
		//�ǽ�&�׸� ġ��ġ�� 109700 t
		//�����Ĵ� 78000 t
		//������ 29000
		//�ѽ����� 43000 t
		//������� 47600
		
		System.out.println(max);
	}
	
	
	static void dfs(int total, int idx) {
		if(total+ item[idx] > limit) {
//			System.out.println("����");
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
