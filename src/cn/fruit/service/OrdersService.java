package cn.fruit.service;

import util.PageBean;
import util.UserException;
import cn.fruit.domain.Orders;

public interface OrdersService {
	
	//	public void add
	public void addOrder(Orders form) throws UserException;
		
	public Orders getOrdersById(String oid);	
	
	public PageBean<Orders> getPage(PageBean<Orders> pageBean);
	

}
