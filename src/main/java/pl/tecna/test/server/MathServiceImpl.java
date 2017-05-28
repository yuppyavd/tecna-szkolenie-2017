package pl.tecna.test.server;

import groovy.lang.GroovyShell;

public class MathServiceImpl{
	private static String expression;
	
	public String evaluateExpression()
	{
		String script = "return" + expression;
		
		try{
			GroovyShell shell = new GroovyShell();
			return shell.evaluate(script).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
}
