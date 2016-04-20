package cn.fruit.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import util.PageBean;
import util.PropertiesUtils;
import cn.fruit.domain.Fruit;
import cn.fruit.service.FruitService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FruitAction extends ActionSupport implements ModelDriven<Fruit> {

	private Fruit fruit = new Fruit();

	@Override
	public Fruit getModel() {
		return fruit;
	}

	/**
	 * service
	 */
	private FruitService service = (FruitService) PropertiesUtils
			.getBean("fruitService");

	public String simpleShow() {

		String fruitListNum = PropertiesUtils.getValue("fruitListNum");
		int num = 0;
		try {
			num = Integer.parseInt(fruitListNum);
		} catch (Exception ignore) {
		}

		List<Fruit> list = service.getTopN(num);
		for (Fruit fruit : list) {
			System.out.println(fruit);
		}
		ActionContext.getContext().put("fruitList", list);

		return "success";
	}

	public String addFruit() {

		String imgPath = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("realName");
		fruit.setFpicture(imgPath);

		service.addFruit(fruit);

		return "index";
	}

	/**
	 * write the json to client
	 * 
	 * @throws IOException
	 */
	public void writerToJson() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf8");
		
		
		PrintWriter out = response.getWriter();
		
		PageBean<Fruit> pageBean = service.getPage(new PageBean<Fruit>());
		pageBean.setPageSize(20);
		List<Fruit> list = pageBean.getPage();
		
		JSONArray ja = JSONArray.fromObject(list);
		String json = ja.toString();
		/**
		 * out the json to the client
		 * put in response
		 */
		out.print(json);		
		out.flush();
		out.close();
	}

}
