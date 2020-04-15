package org.cinglevue.tests;


import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {
	

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		  if ("executSession".equals(testMethod.getName())) {
			 
			     try {
					annotation.setInvocationCount(XLRead.getRowCount(System.getProperty("user.dir"), "userlist.xlsx", "sheet1"));
					 System.out.println("Invocation Count "+annotation.getInvocationCount());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     annotation.setThreadPoolSize(Integer.parseInt(new InputHandler().getProperty("ThreadPoolSize")));
			   }
		
	}

}