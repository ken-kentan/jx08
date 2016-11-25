
public class CalcController {
	private CalcModel calcModel;

	CalcController(){
		calcModel = new CalcModel();
	}
	
	int calc(String strVal1, String strVal2, String sign){
		int val1, val2;
		
		try {
			val1 = Integer.parseInt(strVal1);
			val2 = Integer.parseInt(strVal2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
		
		switch (sign) {
		case "+":
			return calcModel.plus(val1, val2);
		case "-":
			return calcModel.minus(val1, val2);
		case "*":
			return calcModel.multi(val1, val2);
		case "/":
			return calcModel.divide(val1, val2);
		default:
			System.out.println("Invalid input:" + sign);
			return 0;
		}
	}

}
