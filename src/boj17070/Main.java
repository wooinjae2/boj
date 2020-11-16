package boj17070;

import java.util.Scanner;

public class Main {
	
	static int dirdir[][] = {{1, 0}, {0, 1}, {1,1}};
	static int total = 0;
    static int temp[][];
	
	public static void main(String[] args) {
	  //0, 앞 +1 
      //1, 뒤 + 1
	  //2, 앞 +1 뒤 +1
		
		Scanner sc = new Scanner(System.in);
	    
		int size = Integer.parseInt(sc.nextLine());
		int[][] map = new int[17][17];
		for(int i = 0 ; i < 17; i++) {
			for(int j = 0; j < 17; j++) {
				map[i][j]=1;
			}
		}
		
//		temp = new int[size][size];
		for(int i = 0 ; i < size; i++) {
			String input[] = sc.nextLine().split(" ");
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		
		dfs(map, 1, 0, 1, size);
		
		System.out.println(total);
		
		
	}
	
	
	static void dfs(int map[][], int dir, int x, int y, int size) {
		
		
		
		
//		temp[x + dirdir[dir][0]][y+dirdir[dir][1]] = 1;
//		for(int i = 0 ; i < size; i++) {
//			for(int j = 0 ; j < size; j++) {
//				System.out.print(temp[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("--------------------------------------------- ");
		
		
		
		
		for(int i = 0; i < 3; i++) {
			if(dir==0 && (i == 2 || i == 0)) { //아래
				if(check(map, x, y, i, size)) {
				dfs(map, i, x + dirdir[i][0], y + dirdir[i][1], size);
				}
			}
			if(dir==1 && (i == 2 || i == 1)) {// 오른쪽
				if(check(map, x, y, i, size)) {
				dfs(map, i, x + dirdir[i][0], y + dirdir[i][1], size);
				}
			}
			
			if(dir==2 &&(i == 0 || i == 1 || i == 2)){//대각선
				if(check(map, x, y, i, size)) {
					dfs(map, i, x + dirdir[i][0], y + dirdir[i][1], size);					
				}
			}
		}
	}
	
	static boolean check(int[][] map, int x, int y, int dir, int size) {
		if(x + dirdir[dir][0] == size-1 && y + dirdir[dir][1] == size - 1 && map[x + dirdir[dir][0]][y + dirdir[dir][1]]!=1) {
			total++;
			return false;
		}//초과 확인
		
		if(x + dirdir[dir][0] >= size || y + dirdir[dir][1]>= size) {
			return false;
		}
		
		if(map[x + dirdir[dir][0]][y+dirdir[dir][1]] == 1) {
			return false;
		}
		
		if(dir==2 && (map[x + 1][y+1]== 1 || map[x][y+1]== 1 ||map[x + 1][y]== 1)) {
			return false;
		}
		
		return true; 
	}
	/*
3
0 0 0
0 0 0
0 0 1
	*/
	
}
