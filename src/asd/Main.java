package asd;

import java.util.Scanner;

public class Main {
	
	static boolean arr[][] = new boolean[10][10];
	static int type = 0;
	static int total = 0;
	public static void main(String[] args) {
		
		for(int i = 0 ; i < 10; i++) {
			for(int j = 0 ; j < 10; j ++) {
				arr[i][j] = false;
			}
		}

        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        
        for(int i = 0 ; i < count ; i++) {
        	String input = sc.nextLine();
        	String parseInput[] = input.split(" ");
        	type = Integer.parseInt(parseInput[0]);
//        	if(type==1) {
        		int x = Integer.parseInt(parseInput[2]);
        		int y = Integer.parseInt(parseInput[1]);
        		
        		
        		
        		moveGreen(x);
        		moveBlue(y);
        		
        		clearBlue();
        		clearGreen();
        		
        		
//        	}
        		
        	
        }
        int resultCount =0;
        for(int i = 0 ; i< 10; i++) {
        	for(int j =0 ;j< 10; j++) {
        		if(arr[i][j]) resultCount++;
        	}
        }
        
        System.out.println(total);
        System.out.println(resultCount);
	}
	
	static public void moveGreen(int x) {
//		System.out.println(type);
		if(type==3) {
			int i = 3;
			while(i <= 8 && !arr[i+1][x]) {
				i++;
			}
			arr[i][x] = true;
			arr[i-1][x] = true;
		}
		else if(type==2) {
			int i = 3;
			while(i <= 8 && (!arr[i+1][x] && !arr[i+1][x+1])) {
				i++;
			}
			
			arr[i][x] = true;
			arr[i][x+1] = true;
		}else {
			int i = 3;
			while(i <= 8 && !arr[i+1][x]) {
				i++;
			}
//			System.out.println(i);
			arr[i][x] = true;
		}
		
		calcGreen();
	}
	
	static public void moveBlue(int y) {
		if(type==3) {
			int i = 3;
			while(i <= 8 && (!arr[y][i+1] && !arr[y+1][i+1])) {
				i++;
			}

			arr[y][i] = true;
			arr[y+1][i] = true;
		}else if(type==2){
			int i = 4;
			while(i <= 8 && !arr[y][i+1]) {
				i++;
			}
			arr[y][i] = true;
			arr[y][i-1] = true;
		}else {
			int i = 4;
			while(i <= 8 && !arr[y][i+1]) {
				i++;
			}
			arr[y][i] = true;
		}
		
		calcBlue();
	}
	
	static public void calcBlue() {
		for(int j = 6 ; j< 10; j++) {
			int count = 0;
			for(int i = 0; i < 4; i ++) {
				if(arr[i][j]) {
					count++;
				}
			}
			if(count == 4) {
			   //결과 +1;
				total++;
				for(int i = j; i >= 4; i--) {
					for(int k = 0; k < 4; k++) {
						arr[k][i] = arr[k][i-1];
					}
				}
				
			}
		}
	}
	
	static public void calcGreen() {
		for(int i = 6 ; i< 10; i++) {
			int count = 0;
			for(int j = 0; j < 4; j ++) {
				if(arr[i][j]) {
					count++;
				}
			}
			if(count == 4) {
			   //결과 +1;
				total++;
				for(int j = i; j >= 4; j--) {
					for(int k = 0; k < 4; k++) {
						arr[j][k] = arr[j-1][k];
					}
				}
				
			}
		}
	}
	static public void clearGreen(){
	  int remove = 0;
	  for(int i = 4; i < 6; i++) {
		  int count = 0;
		  for(int j = 0; j < 4; j++) {
			  if(arr[i][j]) {
				  count++;
			  }
		  }
		  if(count>0) {
			  remove++;
		  }
			  
	  }
	  removeLastLine("g", remove);
	}
	
	static public void clearBlue() {
		int remove = 0;
		  for(int i = 4; i < 6; i++) {
			  int count = 0;
			  for(int j = 0; j < 4; j++) {
				  if(arr[j][i]) {
					  count++;
				  }
			  }
			  if(count>0) {
				  remove++;
			  }
				  
		  }
		  removeLastLine("b", remove);
	}
	static public void removeLastLine(String greenBlue, int line) {
		if(greenBlue=="g") {
			for(int i = 0; i < line ; i++) {
				for(int j = 9; j >= 4; j--) {
					for(int k = 0; k < 4; k++) {
						arr[j][k] = arr[j-1][k];
					}
				}
			}
		}else {
			for(int i = 0; i < line ; i++) {
				for(int j = 9; j >= 4; j--) {
					for(int k = 0; k < 4; k++) {
						arr[k][j] = arr[k][j-1];
					}
				}
			}
		}
	}

}


/*
5
1 1 1
2 3 0
3 2 2
3 2 3
3 1 3
 */
