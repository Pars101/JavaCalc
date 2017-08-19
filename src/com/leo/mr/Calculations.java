package com.leo.mr;

import java.util.Stack;

public class Calculations {
	private static int startPoint = 0;
	private static int endPoint = 0;
	
	public static String calculate(String s)
	{
		Stack<Double> calcStack = new Stack<Double>();
		Stack<Character> operatorStack = new Stack<Character>();
		
		calcStack.push(Double.parseDouble(getNumber(s)));
		operatorStack.push(getOperator(s));
		
		while(endPoint < s.length())
		{
			if(operatorStack.peek() == '*' || operatorStack.peek() ==  '/')
			{
				calcStack.push(Double.parseDouble(getNumber(s)));
				if(operatorStack.peek() == '*')
				{
					calcStack.push(calcStack.pop() * calcStack.pop());
				}
				else
				{
					calcStack.push(1/calcStack.pop() * calcStack.pop());
				}
				operatorStack.pop();
				if(endPoint < s.length())
				{
					operatorStack.push(getOperator(s));
				}
			}
			if(endPoint < s.length() && !operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'))
			{
				calcStack.push(Double.parseDouble(getNumber(s)));
				if(operatorStack.peek() == '-')
				{
					operatorStack.pop();
					operatorStack.push('+');
					calcStack.push(-calcStack.pop());
				}
				if(endPoint < s.length())
				{
					operatorStack.push(getOperator(s));
				}
			}
		}
		
		while(!operatorStack.isEmpty())
		{
			calcStack.push(calcStack.pop() + calcStack.pop());
			operatorStack.pop();
		}
		endPoint = 0;
		startPoint = 0;
		return calcStack.pop().toString();
	}
	public static String standardCalc(String s)
	{
		Stack<Double> calcStack = new Stack<Double>();
		Stack<Character> operatorStack = new Stack<Character>();
		
		calcStack.push(Double.parseDouble(getNumber(s)));
		operatorStack.push(getOperator(s));
		while(endPoint < s.length())
		{
			calcStack.push(Double.parseDouble(getNumber(s)));
			if(operatorStack.peek() == '+')
			{
				calcStack.push(calcStack.pop() + calcStack.pop());
			}
			else if(operatorStack.peek() == '-')
			{
				calcStack.push(-calcStack.pop() + calcStack.pop());
			}
			else if(operatorStack.peek() == '*')
			{
				calcStack.push(calcStack.pop() * calcStack.pop());
			}
			else if(operatorStack.peek() == '/')
			{
				calcStack.push(1/calcStack.pop() * calcStack.pop());
			}
			operatorStack.pop();
			if(endPoint < s.length())
			{
				operatorStack.push(getOperator(s));
			}
		}
		endPoint = 0;
		startPoint = 0;
		return calcStack.pop().toString();
	}
	
	private static String getNumber(String s)
	{
		String rval = "";
		endPoint++;
		while(endPoint < s.length() && s.charAt(endPoint) != '+'  && s.charAt(endPoint) != '-' && s.charAt(endPoint) != '*' && s.charAt(endPoint) != '/')
		{
			endPoint++;
		}
		rval = s.substring(startPoint, endPoint);
		startPoint = endPoint + 1;
		return rval;
	}

	private static Character getOperator(String s)
	{
		//Advised to be used right after getNumber()
		return s.charAt(endPoint);
	}
}
