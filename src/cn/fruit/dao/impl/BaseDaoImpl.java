package cn.fruit.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import util.SqlMapClientUtil;
import cn.fruit.dao.BaseDao;

import com.ibatis.sqlmap.client.SqlMapSession;

public class BaseDaoImpl<T> implements BaseDao<T> {

	protected SqlMapSession session = SqlMapClientUtil.client.openSession();
//	private Class<T> clazz;
	
	
	@Override
	public void add(String sql, T t) throws SQLException {
		
		try {

			session.insert(sql, t);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	@Deprecated
	@Override
	public void deleteByOrder(String sql, int order) throws SQLException {
		
		try {

			session.delete(sql, order);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteById(String sql, String id) throws SQLException {
			
			try {

				session.delete(sql, id);

			} catch (Exception e) {

				e.printStackTrace();
			}
		
	}
	@Deprecated
	@Override
	public void updateByOrder(String sql, T t) throws SQLException {
		try {

			session.update(sql, t);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	
	@Override
	public void updateById(String sql, T t) throws SQLException {
		try {

			session.update(sql, t);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public T getById(String sql, String id) throws SQLException {
		T t = null;
		try {
			
			t = (T) session.queryForObject(sql, id);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return t;
	}
	@Deprecated
	@Override
	public T getByOrder(String sql, int order) throws SQLException {
		T t = null;
		try {
			
			t = (T) session.queryForObject(sql, order);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return t;
	}
	@Override
	public Number allCount(String sql, String attrUrl) throws SQLException {
		Number num = null;
		
		try {
			
			num = (Number) session.queryForObject(sql, attrUrl);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return num;
	}
	@Override
	public List<T> getCurrentPage(String sql, Map<String, Object> attrMap)
			throws SQLException {
		List<T> list = null;
		
		try {
			
			list = session.queryForList(sql, attrMap);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
	



}
