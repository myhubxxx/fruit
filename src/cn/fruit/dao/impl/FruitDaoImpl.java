package cn.fruit.dao.impl;

import java.sql.SQLException;

import util.SqlMapClientUtil;
import cn.fruit.dao.FruitDao;
import cn.fruit.domain.Fruit;

import com.ibatis.sqlmap.client.SqlMapSession;

public class FruitDaoImpl extends BaseDaoImpl<Fruit> implements FruitDao {

	protected SqlMapSession session = SqlMapClientUtil.client.openSession();
	
	@Override
	public int getNumbers(String sql) {
		Number number = null;
		
		try{
			
			number = (Number) session.queryForObject(sql);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return number.intValue();
	}



}
