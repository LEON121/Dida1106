package com.leon.web;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.leon.bean.Course;
import com.leon.bean.Grade;
import com.leon.mapper.GradeMapper;
import com.leon.service.CourseService;
import com.leon.service.GradeService;
import com.leon.utils.PageHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author leon
 * @since 2018-11-07
 */
@Controller
@RequestMapping("/grade")
@Scope("prototype")
public class GradeController {
	
	@Autowired
	GradeService gs;
	@Autowired
	CourseService cs;

	@RequestMapping(value="/list/{pageIndex}")
	public String getList(@PathVariable(name = "pageIndex") Integer pageIndex,@RequestParam(defaultValue="2") Integer pageSize, Model model) {
		Page<Grade> page = new Page<Grade>(pageIndex, pageSize); // 封装分页
		Page<Grade> results = gs.selectPage(page, new EntityWrapper<Grade>().eq("del", 0));
		List<Grade> Grades = results.getRecords(); // 查询数据结果集
		
		for (Grade grade : Grades) {
			Course course = cs.selectById(grade.getCid());
			grade.setCourse(course);
		}
		
		int pageTotal = ((Long)page.getTotal()).intValue();
		
//		System.out.println("===============获取分页相关的一些信息======================");
//		System.out.println("总条数:" +page.getTotal());
//		System.out.println("当前页码: "+  page.getCurrent());
//		System.out.println("总页码:" + page.getPages());
//		System.out.println("每页显示的条数:" + page.getSize());
//		System.out.println("是否有上一页: " + page.hasPrevious());
//		System.out.println("是否有下一页: " + page.hasNext());
//
//		System.out.println("===============获取分页相关的一些信息======================");
//		System.out.println("总条数:" +results.getTotal());
//		System.out.println("当前页码: "+  results.getCurrent());
//		System.out.println("总页码:" + results.getPages());
//		System.out.println("每页显示的条数:" + results.getSize());
//		System.out.println("是否有上一页: " + results.hasPrevious());
//		System.out.println("是否有下一页: " + results.hasNext());
		
		
		PageHelper<Grade> ph = new PageHelper<Grade>(pageIndex, pageSize, pageTotal, Grades, null);
		
		model.addAttribute("pageBean", ph);
		model.addAttribute("hasPrevious", page.hasPrevious());
		model.addAttribute("hasNext", page.hasNext());
		
		return "/gradelist.jsp";
	}

	@RequestMapping("/addGrade")
	public void addGrade(Grade grade, HttpServletResponse response, HttpServletRequest request) throws Exception{
		System.err.println("addGrade:"+grade);
		grade.setDel(0);
		boolean b = gs.insert(grade);
		if(true == b) {
			response.getWriter().write("<script>alert('添加成功!');location.href='"+request.getContextPath()+"/grade/list/1';</script>");
		}else {
			response.getWriter().write("<script>alert('添加失败!');location.href='"+request.getContextPath()+"/grade/list/1';</script>");
		}
	}

	
	@RequestMapping("/goUpdate/{id}")
	public String goUpdate(@PathVariable(name="id") Integer id, Model model) {
//		System.out.println("getUpdateId:"+id);
		Grade grade = gs.selectById(id);
		Integer cid = grade.getCid();
		Course course = cs.selectById(cid);
		
//		System.out.println("updateGrade:"+grade);
		model.addAttribute("grade", grade);
		model.addAttribute("course", course);
		
		return "/gradeupdate.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/courselist")
	public List<Course> getCourse(HttpServletResponse response) throws Exception{
		List<Course> list = cs.selectList(new EntityWrapper<Course>().eq("del", 0));
		System.out.println(list);
		
//		response.getWriter().write("list");
		
		return list;
	}
	
	@RequestMapping("/update")
	public void update(Grade grade, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		
		System.out.println("grade:"+grade);
		boolean b = gs.update(grade, new EntityWrapper<Grade>().eq("id", grade.getId()));
		if(true == b) {
			response.getWriter().write("<script>alert('更新成功!');location.href='"+request.getContextPath()+"/grade/list/1';</script>");
		}else {
			response.getWriter().write("<script>alert('添加失败!');location.href='"+request.getContextPath()+"/grade/list/1';</script>");
		}
	}
	
	@RequestMapping("/del/{delId}")
	public String del(Grade grade, @PathVariable(name="delId") Integer delId,HttpServletRequest request, HttpServletResponse response) throws Exception {
		grade.setId(delId);
		grade.setDel(1);
		System.out.println(grade);
		boolean b = gs.updateById(grade);
//		if( true == b) {
//			response.getWriter().write("<script>alert('删除成功!');location.href='"+request.getContextPath()+"/grade/list/1';</script>");
//		}
		
		return "/grade/list/1";
	}
}

