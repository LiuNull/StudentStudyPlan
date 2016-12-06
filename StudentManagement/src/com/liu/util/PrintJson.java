package com.liu.util;

import org.apache.struts2.ServletActionContext;

public class PrintJson {
	public static void print(String json)throws Exception
	{
		ServletActionContext.getResponse().setContentType("text/html");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().printf(json);
		ServletActionContext.getResponse().getWriter().flush();
		ServletActionContext.getResponse().getWriter().close();
	}
}
