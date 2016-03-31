package cn.fruit.action;

import cn.test.Person;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	
	public String justTest(){
		
		ActionContext.getContext().put("name", "you can ");
		
		ActionContext.getContext().getValueStack().set("name", "you can find me");
//		ActionContext.getContext().getValueStack().findValue("");
		Person p = new Person();
			p.setId(2);
			p.setName("1_p");
			p.setDesc("pp");
		ActionContext.getContext().getValueStack().push(p);	
//		ActionContext.getContext().ge
		
		return SUCCESS;
	}
	
}
