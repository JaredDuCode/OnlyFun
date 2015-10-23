package com.onlyfun.springtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestThread {
	
	public static ExecutorService exec = Executors.newFixedThreadPool(1000);
	
	public static void test(){
		List<Future<String>> result = new ArrayList<Future<String>>();
		Future<String> future = exec.submit(new Callable<String>(){
			@Override
			public String call() throws Exception {
				TimeUnit.SECONDS.sleep(2);
				return "s";
			}
		});
		result.add(future);
		Future<String> future2 = exec.submit(new Callable<String>(){
			@Override
			public String call() throws Exception {
				TimeUnit.SECONDS.sleep(10);
				return "s";
			}
		});
		result.add(future2);
		
		Future<String> future3 = exec.submit(new Callable<String>(){
			@Override
			public String call() throws Exception {

				return "s";
			}
		});
		result.add(future3);
		
		for(Future<String> f : result){
			try {
				System.out.println(f.get(2,TimeUnit.SECONDS));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		test();
	}

}
