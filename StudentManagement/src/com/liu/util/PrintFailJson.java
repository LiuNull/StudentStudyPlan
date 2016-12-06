package com.liu.util;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liu.model.BaseModel;

public class PrintFailJson {
	public static void print()throws Exception
	{
		BaseModel model=new BaseModel();
		model.setMsg("Ê§°Ü");
		model.setResult("fail");
		Gson gson = new Gson();
		String json=gson.toJson(model);
		ServletActionContext.getResponse().setContentType("text/html");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().printf(json);
		ServletActionContext.getResponse().getWriter().flush();
		ServletActionContext.getResponse().getWriter().close();
	}
}
