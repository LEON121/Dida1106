package com.leon.web;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.leon.bean.Course;
import com.leon.bean.Grade;
import com.leon.bean.Student;
import com.leon.service.GradeService;
import com.leon.service.StudentService;
import com.leon.utils.PageHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author leon
 * @since 2018-11-09
 */
@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService ss;
	
	@Autowired
	GradeService gs;
	
	@RequestMapping("/list/{pageIndex}")
	public String getList(String stuName, Integer gradeid, @PathVariable(name = "pageIndex") Integer pageIndex,@RequestParam(defaultValue="2") Integer pageSize, Model model) {
		Page<Student> page = new Page<Student>(pageIndex, pageSize);
		Page<Student> results = null;
		System.out.println("stuname="+stuName+",gid="+gradeid);
		if("".equals(gradeid) || null == gradeid) {
			results = ss.selectPage(page, new EntityWrapper<Student>().like("name", stuName).eq("del", 0));
		}else {
			results = ss.selectPage(page, new EntityWrapper<Student>().like("name", stuName).eq("gid", gradeid).eq("del", 0));
		}
			
		List<Student> stus = results.getRecords();
		
		for (Student s : stus) {
			Grade grade = gs.selectById(s.getGid());
			s.setGrade(grade);
		}
		//System.out.println("stus:"+stus);
		int pageTotal = ((Long)page.getTotal()).intValue();
		
		PageHelper<Student> ph = new PageHelper<Student>(pageIndex, pageSize, pageTotal, stus, null);
		
		model.addAttribute("pageBean", ph);
		model.addAttribute("hasPrevious", page.hasPrevious());
		model.addAttribute("hasNext", page.hasNext());
		
		return "/studentlist.jsp";
	}
	
	@RequestMapping("/details/{stuId}")
	public String getdetails(@PathVariable(name="stuId") Integer stuId, Model model) {
		Student student = ss.selectById(stuId);
		student.setGrade(gs.selectById(student.getGid()));
		
		System.out.println("stu:"+student);
		model.addAttribute("studetails", student);
		return "/studentdetails.jsp";
	}
	
	
	
	@RequestMapping("/addStu")
	public void addGrade(Student student, HttpServletResponse response, HttpServletRequest request) throws Exception{
		System.err.println("addStu:"+student);
		String no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // 自动生成学号
		
		student.setDel(0);
		student.setNo(no);
		
		boolean b = ss.insert(student);
		
		Grade grade = gs.selectById(student.getGid()); // 新增学生，班级学生数加1
		grade.setCount(grade.getCount()+1);
		
		if(true == b) {
			response.getWriter().write("<script>alert('添加成功!');location.href='"+request.getContextPath()+"/student/list/1';</script>");
		}else {
			response.getWriter().write("<script>alert('添加失败!');location.href='"+request.getContextPath()+"/student/list/1';</script>");
		}
	}

	@RequestMapping("/goUpdate/{id}")
	public String goUpdate(@PathVariable(name="id") Integer id, Model model) {
//		System.out.println("getUpdateId:"+id);
		Student student = ss.selectById(id);
		
		Integer gid = student.getGid();
		Grade grade = gs.selectById(gid);
		
//		System.out.println("updateGrade:"+grade);
		model.addAttribute("stu", student);
		model.addAttribute("grade", grade);
		
		return "/studentupdate.jsp";
	}
	
	@RequestMapping("/update")
	public void update(Student student, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		
		System.out.println("student:"+student);
		boolean b = ss.update(student, new EntityWrapper<Student>().eq("id", student.getId()));
		if(true == b) {
			response.getWriter().write("<script>alert('更新成功!');location.href='"+request.getContextPath()+"/student/list/1';</script>");
		}else {
			response.getWriter().write("<script>alert('添加失败!');location.href='"+request.getContextPath()+"/student/list/1';</script>");
		}
	}
	
	@RequestMapping("/del/{delId}")
	public String del(Student student, @PathVariable(name="delId") Integer delId,HttpServletRequest request, HttpServletResponse response) throws Exception {
		student.setId(delId);
		student.setDel(1);
		
		System.out.println(student);
		boolean b =ss.updateById(student);
		
		Grade grade = gs.selectById(student.getGid());  // 删除学生，该学生所在班级人数减1
		grade.setCount(grade.getCount()-1);
//		if( true == b) {
//			response.getWriter().write("<script>alert('删除成功!');location.href='"+request.getContextPath()+"/grade/list/1';</script>");
//		}
		
		
		return "/student/list/1";
	}
	
	
	@ResponseBody
	@RequestMapping("/gradelist")
	public List<Grade> getGrade(HttpServletResponse response) throws Exception{
		List<Grade> list = gs.selectList(new EntityWrapper<Grade>().eq("del", 0));
//		System.out.println(list);		
		
		return list;
	}
}

