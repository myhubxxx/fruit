package cn.fruit.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.CommonUtils;
import util.SqlMapClientUtil;
import cn.fruit.dao.FruitDao;
import cn.fruit.dao.impl.FruitDaoImpl;
import cn.fruit.domain.Fruit;
import cn.fruit.service.FruitService;

import com.ibatis.sqlmap.client.SqlMapSession;

public class FruitServiceImpl implements FruitService {

	private FruitDao dao = new FruitDaoImpl();
	private SqlMapSession session = SqlMapClientUtil.client.openSession();
	
	@Override
	public List<Fruit> getTopN(int num) {
		List<Fruit> list = null;
		int defaultNum = 4; 
		if(num > 0) defaultNum = num;
		// 构造查询条件
		Map<String, Object> attrMap = new HashMap<String, Object>();
		// the attrUrl is very important; it can't be null
		attrMap.put("attrUrl", "'a'='a'");
			attrMap.put("lose", 0);
			attrMap.put("pageSize", defaultNum);
			
		try {
			list = dao.getCurrentPage("Fruit.getCurrentPage", attrMap);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addFruit(Fruit form)  {
		
		form.setFid(CommonUtils.uuid());
		form.setFdate(new Date());
		
		try {
			session.startTransaction();
			
			dao.add("Fruit.insertFruit", form);
			
			session.commitTransaction();
		} catch (SQLException e) {
			try {
				session.endTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
