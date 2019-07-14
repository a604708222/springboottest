package project.com.huawei.test.test;

import org.junit.Test;

public class Demo {

	@Test
	public void test(){
		
		String a = "ab";
		String b = "ab";
		String c = new String("ab");
		String d = new String("ab");
		System.out.println(d == c);
		System.out.println(d.equals(c));
		
	}
	
	@Test
	public void test1(){
		Thread t = new Thread(() -> System.out.println("aaa"));
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				
			}
			
		});
		
	}
	
	
}
