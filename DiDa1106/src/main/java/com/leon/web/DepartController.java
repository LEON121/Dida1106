package com.leon.web;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.leon.bean.Course;
import com.leon.bean.Depart;
import com.leon.bean.Emp;
import com.leon.bean.Grade;
import com.leon.service.DepartService;
import com.leon.service.EmpService;
import com.leon.utils.PageHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author leon
 * @since 2018-11-10
 */
@Controller
@Scope("prototype")
@RequestMapping("/depart")
public class DepartController {
	@Autowired
	DepartService ds;
	@Autowired
	EmpService es;
	
	/**
	 * 分页查询部门
	 * @param pageIndex
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping("/list/{pageIndex}")
	public String getList(@PathVariable(name = "pageIndex") Integer pageIndex,@RequestParam(defaultValue="2") Integer pageSize, Model model) {
		Page<Depart> page = new Page<Depart>(pageIndex, pageSize); // 封装分页
		Page<Depart> results =ds.selectPage(page, new EntityWrapper<Depart>().eq("del", 0));
		List<Depart> deps = results.getRecords(); // 查询数据结果集
		
		for (Depart depart : deps) {
			int count = es.selectCount(new EntityWrapper<Emp>().eq("did", depart.getId())); // 查询该部门下员工数
			depart.setCount(count);
		}
		
		int pageTotal = ((Long)page.getTotal()).intValue();
		
		PageHelper<Depart> ph = new PageHelper<Depart>(pageIndex, pageSize, pageTotal, deps, null);
		
		model.addAttribute("pageBean", ph);
		model.addAttribute("hasPrevious", page.hasPrevious());
		model.addAttribute("hasNext", page.hasNext());
		
		return "/departlist.jsp";
	}
	
	/**
	 * 添加部门
	 * @param depart
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/addDep")
	public void addGrade(Depart depart, HttpServletResponse response, HttpServletRequest request) throws Exception{
		System.err.println("adddepart:"+depart);
		depart.setDel(0);
		boolean b = ds.insert(depart);
		if(true == b) {
			response.getWriter().write("<script>alert('添加成功!');location.href='"+request.getContextPath()+"/depart/list/1';</script>");
		}else {
			response.getWriter().write("<script>alert('添加失败!');location.href='"+request.getContextPath()+"/depart/list/1';</script>");
		}
	}

	
	@RequestMapping("/goUpdate/{id}")
	public String goUpdate(@PathVariable(name="id") Integer id, Model model) {
//		System.out.println("getUpdateId:"+id);
		Depart depart = ds.selectById(id);
		
		model.addAttribute("depart", depart);
		
		return "/departupdate.jsp";
	}
	

	@RequestMapping("/update")
	public void update(Depart depart, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		
		System.out.println("depart:"+depart);
		boolean b = ds.update(depart, new EntityWrapper<Depart>().eq("id", depart.getId()));
		if(true == b) {
			response.getWriter().write("<script>alert('更新成功!');location.href='"+request.getContextPath()+"/depart/list/1';</script>");
		}else {
			response.getWriter().write("<script>alert('添加失败!');location.href='"+request.getContextPath()+"/depart/list/1';</script>");
		}
	}
	
	@ResponseBody
	@RequestMapping("/del/{delId}")
	public void del(Depart depart, @PathVariable(name="delId") Integer delId,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("id="+delId);
		// 查询该课程下面是否有班级
		List<Emp> list = es.selectList(new EntityWrapper<Emp>().eq("did", delId));
		
		//System.out.println("list:"+list.size()); 
		if(0 != list.size()) {
			// 有班级，禁止删除
			response.getWriter().write("false");
		}else {
			 // 没有班级，删除
			depart.setId(delId);
			depart.setDel(1);
			ds.updateById(depart);
			response.getWriter().write("true");
		}
	}
}

