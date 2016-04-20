package cn.fruit.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.CommonUtils;
import util.PageBean;
import util.SqlMapClientUtil;
import util.UserException;
import cn.fruit.dao.OrdersDao;
import cn.fruit.dao.impl.OrdersDaoImpl;
import cn.fruit.domain.Orders;
import cn.fruit.service.OrdersService;

import com.ibatis.sqlmap.client.SqlMapSession;

public class OrdersServiceImpl implements OrdersService {

	private OrdersDao dao = new OrdersDaoImpl();
	private SqlMapSession session = SqlMapClientUtil.client.openSession();

	@Override
	public void addOrder(Orders form) throws UserException {
		form.setOid(CommonUtils.uuid());
		form.setOdate(new Date());
		
		try {
			session.startTransaction();
			
			int flag = dao.add("Orders.insertOrders", form);
			if(flag != 1){ throw new UserException("订单信息有误"); }
			
			session.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
	}

	@Override
	public Orders getOrdersById(String oid) {
		Orders order = null;
		
		try {
			session.startTransaction();
			
			order = dao.getById("Orders.getById", oid);
			
			session.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.endTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return order;
	}

	@Override
	public PageBean<Orders> getPage(PageBean<Orders> pageBean) {
		List<Orders> list = null;
		try{
			session.startTransaction();
			
			Map<String, Object> attrMap = new HashMap<String, Object>();
			if (pageBean.getAttrUrl()==null || pageBean.getAttrUrl().trim().equals("")){
				attrMap.put("attrUrl", "'a'='a'");
			}else{
				attrMap.put("attrUrl", pageBean.getAttrUrl());
			}
			int lose = pageBean.getCurrentPage()>0 ?(pageBean.getCurrentPage()-1)*pageBean.getPageSize():0;
				attrMap.put("lose", lose);
				attrMap.put("pageSize", pageBean.getPageSize());
				
			list = dao.getCurrentPage("Orders.getCurrentPage", attrMap);
			pageBean.setPage(list);
			int recordNum = dao.allCount("Orders.getAllCount", (String)attrMap.get("attrUrl")).intValue();
			pageBean.setTotalRecord(recordNum);
			
			session.commitTransaction();
		}catch(SQLException e){
			e.printStackTrace();
			try {
				session.endTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return pageBean;
	}
	
	
	
}
