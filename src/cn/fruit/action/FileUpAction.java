package cn.fruit.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import util.CommonUtils;

import cn.fruit.domain.FileUp;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FileUpAction extends ActionSupport implements ModelDriven<FileUp>{
	
	private FileUp file = new FileUp();
	@Override
	public FileUp getModel() {
		return file;
	}
	
	
	public String saveFruitImg(){
		String path = ServletActionContext.getServletContext().getRealPath("/uploadImage");
		String realName = CommonUtils.uuid() + file.getFileFileName(); 
		try {
			file.saveTo(path + File.separator + realName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ServletActionContext.getRequest().getSession().setAttribute("realName", realName);
//		System.out.println(path + File.separator + realName );
//		new String().getClass(); Object
		
		return "toFruitAction";
	}

	  

}
