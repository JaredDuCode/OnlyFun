package com.onlyfun.task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component("timeTask")
public class timeTask {
	  private int number;
      public void doJob(){
    	try {
    		number += 1;
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	System.out.println(number);
    	
    	System.out.println("======= time is " + new Date() +"  ==========");
      }
}
