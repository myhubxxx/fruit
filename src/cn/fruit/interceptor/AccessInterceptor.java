package cn.fruit.interceptor;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.fruit.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AccessInterceptor extends AbstractInterceptor {

	/**
	 *  user to validate the user is login
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ac = invocation.getInvocationContext();
		HttpSession session =  ServletActionContext.getRequest().getSession();

		User user = (User) session.getAttribute("sessionUser");
		
		if(user != null){
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("text/html;charset=utf8");
			
			resp.getWriter().print("{\"code\":\"failure\",\"case\":\"you need login\"}");
		
			return "none";
		}
		else{
			
			return invocation.invoke();
		}
		
	}

}
