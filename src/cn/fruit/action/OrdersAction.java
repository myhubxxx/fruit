package cn.fruit.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import util.CommonUtils;
import util.PageBean;
import util.PropertiesUtils;
import cn.fruit.domain.Orders;
import cn.fruit.service.OrdersService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrdersAction extends ActionSupport implements ModelDriven<Orders> {
	
	private OrdersService service = (OrdersService) PropertiesUtils.getBean("ordersService");
	
	private Orders order = new Orders();
	@Override
	public Orders getModel() {
		return order;
	}
	
	public void order() throws IOException{
		
		try{	
			order.setOid(CommonUtils.uuid());
			order.setOdate(new Date());
			
			service.addOrder(order);
			
		}catch(Exception e){
			this.addFieldError("oid", "错误的订单信息");
			e.printStackTrace();
		}
		
		Map<String, Object> message = new HashMap<String, Object>();
			
		
		if( this.hasFieldErrors() ){
			message.put("code", "failure");
			message.put("case", "订单信息错误,请重下订单");
			
		}else{
			message.put("code", "success");
			
		}
		
		JSONObject jo = JSONObject.fromObject(message);
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf8");
		
		resp.getWriter().print(jo);
		resp.getWriter().close();
	}
	/**
	 * get the user's all orders
	 * @throws IOException
	 */
	public void getAllOrder() throws IOException{
		PageBean<Orders> pageBean = null;
		try{
			pageBean = new PageBean<Orders>();
			pageBean.setCurrentPage(0);
			pageBean.setPageSize(100);
			String attrUrl = "uid='" + order.getUser().getUid() + "'";
			pageBean.setAttrUrl(attrUrl);
			
			pageBean = service.getPage(pageBean);
			
		}catch(Exception e){
			this.addFieldError("oid", "订单请求错误");
			e.printStackTrace();
		}
		
		Map<String, Object> message = new HashMap<String, Object>();
		
		if(this.hasFieldErrors()){
			message.put("case", "订单查询出错");
			
		}else{
			message.put("Orders", pageBean.getPage());
		
		}
		
		JSONObject jo = JSONObject.fromObject(message);
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf8");
		resp.getWriter().print(jo);
		resp.getWriter().close();
		
	}
	
	

}
