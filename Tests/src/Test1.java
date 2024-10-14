import java.util.Scanner;

public class Test1 {

	 public static void sortArray(int[] myArr){
	        int temp = myArr[0];
	        for (int i = 0; i < myArr.length; i++){
	            temp = myArr[0];
	            for (int j = 0; j < myArr.length - 1; j++){
	                if (myArr[j] < myArr[j + 1]){
	                    myArr[j] = myArr[j + 1];
	                    myArr[j + 1] = temp;
	                }
	            }
	        }
	   }

	   public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        
	        int len;

	        len = input.nextInt();

	        int[] list = new int[len];

	        for(int i = 0; i < list.length; i++) {
	            list[i] = input.nextInt();
	        }

	        sortArray(list);

	        for(int i = 0; i < list.length; i++) {
	            System.out.print(list[i] + ", ");
	            
	        }
	        System.out.println();
	   		}

		}
	

