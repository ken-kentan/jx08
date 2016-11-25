
public class CalcModel {
	int plus(int val1, int val2){
		return val1 + val2;
	}
	
	int minus(int val1, int val2){
		return val1 - val2;
	}
	
	int multi(int val1, int val2){
		return val1 * val2;
	}
	
	int divide(int val1, int val2){
		if(val2 == 0){
			return 0;
		}
		
		return val1 / val2;
	}
}
