package com.onlyfun.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Springtest {	
	    private String messeage;

	    public String getMesseage() {
			return messeage;
		}
		public void setMesseage(String messeage) {
			this.messeage = messeage;
		}

		public void show(){
	        System.out.println("--message--"+ getMesseage());
	    }
		
	    public static void main(String[] args){
	        ApplicationContext ctx=new FileSystemXmlApplicationContext("src/com/onlyfun/springtest/application.xml");
	        Springtest fs=(Springtest) ctx.getBean("myBean");

	        fs.show();
	    }

}
