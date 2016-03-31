package util;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientUtil {
	
	public static SqlMapClient client = null;
	
	static{
		
		try {
			Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			client = SqlMapClientBuilder.buildSqlMapClient(reader);
			
		} catch (IOException e) {
		}
	}
	
	public static SqlMapClient getSqlMapClient(){
		
		return client;
	}
	

}
