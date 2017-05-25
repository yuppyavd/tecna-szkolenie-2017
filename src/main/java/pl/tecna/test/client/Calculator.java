package pl.tecna.test.client;

public class Calculator {
	double result;
	public Calculator()
	{
		result = 0;
	}
	
	public double evaluateExpression(String expres, double r)
	{
		char[] chars = expres.toCharArray();
		int i;
		
		for (i = 0; i < chars.length; i++) 
		{
			if(isOperator(chars[i]))	break;
		}
		
		double a = 0;
		double b = Double.parseDouble(expres.substring(i+1,expres.length()));
		//System.out.println(expres.substring(0,i));
		if(Double.parseDouble(expres.substring(0,i))==0) 
		{ 
			System.out.println("Pusty!!"); 
			return result = eval(r, b, chars[i]); 
		}
		else a = Double.parseDouble(expres.substring(0,i));
			return result = eval(a, b, chars[i]);
	}

	boolean isOperator(char operator)
	{
		switch (operator) {
		case '+':
		case '-':
		case '*':
		case '/':
			return true;
		default:
			return false;
		}
	}
double eval(double a, double b, char operator){
	switch (operator) {
	case '+':
		return a+b;
	case '*':
		return a*b;
	case '/':
		return a/b;
	case '-':
		return a-b;
	default:
		return 0;
	}
}
}