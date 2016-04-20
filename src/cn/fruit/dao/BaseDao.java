package cn.fruit.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;



public interface BaseDao<T> {
	
	public int add(String sql, T t)throws SQLException;
	
	public void deleteByOrder(String sql, int order)throws SQLException;
	
	public void deleteById(String sql, String id)throws SQLException;
	
	public void updateByOrder(String sql, T t) throws SQLException;
	
	public void updateById(String sql, T t) throws SQLException;
	
	public T getById(String sql, String id)throws SQLException;
	
	public T getByOrder(String sql, int order)throws SQLException;
	
	/**
	 * use to describe the page
	 * get all record that much the info
	 */
	public Number allCount(String sql, String attrUrl)throws SQLException;
	
	/**
	 * get the some page info
	 * @param sql
	 * @param attrMap
	 * @return
	 * @throws SQLException
	 */
	public List<T> getCurrentPage(String sql, Map<String,Object> attrMap)throws SQLException;

}
