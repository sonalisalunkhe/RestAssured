package Day1;

public class MissingNumber {
	
	public static void main() {
		
		
		int arr[]= {1,3,5,7,8};
		
		for(int i=1;i<=8;i++)
		{
			boolean found=false;
			for(int num:arr) {
				if(num==i) {
					found=true;
					break;
				}
				
				if(!found) {
					
				}
			}
		}
	}

}
