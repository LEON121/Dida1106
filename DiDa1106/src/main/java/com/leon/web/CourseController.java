package com.leon.web;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.leon.bean.Course;
import com.leon.bean.Grade;
import com.leon.service.CourseService;
import com.leon.service.GradeService;
import com.leon.utils.PageHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;

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
 * @since 2018-11-07
 */
@Controller
@Scope("prototype")
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService cs;
	@Autowired
	GradeService gs;
	
	
	@RequestMapping(value="/list/{pageIndex}")
	public String getList(@PathVariable(name = "pageIndex") Integer pageIndex,@RequestParam(defaultValue="2") Integer pageSize, Model model) {
		Page<Course> page = new Page<Course>(pageIndex, pageSize); // 封装分页
		Page<Course> results = cs.selectPage(page, new EntityWrapper<Course>().eq("del", 0));
		List<Course> course = results.getRecords(); // 查询数据结果集
		
//		for (Course c : course) {
//			System.out.println(c);
//		}
		
		int pageTotal = ((Long)page.getTotal()).intValue();
		
		PageHelper<Course> ph = new PageHelper<Course>(pageIndex, pageSize, pageTotal, course, null);
		
		model.addAttribute("pageBean", ph);
		model.addAttribute("hasPrevious", page.hasPrevious());
		model.addAttribute("hasNext", page.hasNext());
		
		return "/courselist.jsp";
	}
	
	@RequestMapping("/addCourse")
	public void addGrade(Course course, HttpServletResponse response, HttpServletRequest request) throws Exception{
		System.err.println("addCourse:"+course);
		course.setDel(0);
		boolean b = cs.insert(course);
		if(true == b) {
			response.getWriter().write("<script>alert('添加成功!');location.href='"+request.getContextPath()+"/course/list/1';</script>");
		}else {
			response.getWriter().write("<script>alert('添加失败!');location.href='"+request.getContextPath()+"/course/list/1';</script>");
		}
	}
	
	
	@RequestMapping("/goUpdate/{id}")
	public String goUpdate(@PathVariable(name="id") Integer id, Model model) {
		Course course = cs.selectById(id);
		model.addAttribute("updatec", course);
		return "/courseupdate.jsp";
	}
	
	@RequestMapping("/update")
	public void update(Course course, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		System.out.println("updateCourse:"+course);
		
		boolean b = cs.update(course, new EntityWrapper<Course>().eq("id", course.getId()));
		if(true == b) {
			response.getWriter().write("<script>alert('更新成功!');location.href='"+request.getContextPath()+"/course/list/1';</script>");
		}else {
			response.getWriter().write("<script>alert('更新失败!');location.href='"+request.getContextPath()+"/course/list/1';</script>");
		}
	}
	
	@ResponseBody
	@RequestMapping("/del/{delId}")
	public void del(Course course, @PathVariable(name="delId") Integer delId,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("id="+delId);
		// 查询该课程下面是否有班级
		List<Grade> list = gs.selectList(new EntityWrapper<Grade>().eq("cid", delId));
		
		//System.out.println("list:"+list.size()); 
		if(0 != list.size()) {
			// 有班级，禁止删除
			response.getWriter().write("false");
		}else {
			 // 没有班级，删除
			course.setId(delId);
			course.setDel(1);
			cs.updateById(course);
			response.getWriter().write("true");
		}
	}

}

