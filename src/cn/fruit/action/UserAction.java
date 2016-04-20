package cn.fruit.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import util.PropertiesUtils;
import util.UserException;
import cn.fruit.domain.User;
import cn.fruit.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private UserService service = (UserService) PropertiesUtils
			.getBean("userService");
	
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}

	

	
	public void login() throws IOException{
		
		User dbUser = null;
		try {
			dbUser = service.login(user);
			if(!dbUser.getUpass().equals(user.getUpass())){
				addFieldError("uname", "用户名或密码有错误");
			}
		} catch (Exception e) {
			addFieldError("uname", "用户名或密码有错误");	
			e.printStackTrace();
		}
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf8");
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		if(this.hasFieldErrors()){
			// login failure
			message.put("code", "failure");
			message.put("case", "账号或密码有错误");
			
		}else{ // login success
		
			HttpServletRequest req = ServletActionContext.getRequest();
			req.getSession().setAttribute("sessionUser", dbUser);
			dbUser.setUpass("");
			
			message.put("code", "success");
			message.put("user", dbUser);
		}
		
		JSONObject jo = JSONObject.fromObject(message);
		resp.getWriter().print(jo);
		resp.getWriter().close();
		
	}
	public String loginWeb(){
		User dbUser = null;
		boolean right = true;
		try{
			dbUser = service.login(user);
			if(!dbUser.getUpass().equals( user.getUpass())){
				right = false;
			}
			
		}catch( Exception e){
			e.printStackTrace();
			addFieldError("uname", "用户名或密码错误");
		}
		HttpServletRequest req = ServletActionContext.getRequest();
		
		if(this.hasFieldErrors() || false == right){
			req.getSession().setAttribute("msg", "用户名或密码错误");
			
			return "input";
		}else{
			dbUser.setUpass("");
			req.getSession().setAttribute("sessionUser", dbUser);
			
			return "success";
		}
	}
	public String regist(){
		System.out.println(user);
		
		
		
		
		
		return "success";
	}
	
	

}
