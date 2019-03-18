package com.yk.tree;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class TreeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost...");
		
		List<Dept> list=new ArrayList<Dept>();
		list.add(new Dept(1,"公司x",0));
		list.add(new Dept(2,"公司y",0));
		list.add(new Dept(3,"部门x1",1));
		list.add(new Dept(4,"部门x2",1));
		list.add(new Dept(5,"部门y1",2));
		list.add(new Dept(6,"部门y2",2));
		list.add(new Dept(7,"人员x1",3));
		list.add(new Dept(8,"人员y2",6));
		String str=JSON.toJSONString(getChilds(list,0));
		System.out.println(str);;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}
	
	public static  List<Dept> getChilds(List<Dept> list,int pid){
		//直属子类集合
		List<Dept> sonDept=new ArrayList<Dept>();
		//跨代子类集合
		List<Dept> grandSonDept=new ArrayList<Dept>();
		for(Dept dept:list){
			if(dept.getpId()==pid){
				sonDept.add(dept);
			}else{
				grandSonDept.add(dept);
			}
		}
		//从子类集合中查找下一级，自动过滤没有上一级的单位
		for(Dept dept:sonDept){
			//递归调用
			for(Dept childDept:getChilds(grandSonDept,dept.getId())){
				//设置子类集合
				dept.getChildren().add(childDept);
			};
			
		}
		return sonDept;
	}

}
