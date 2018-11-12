package com.leon.web;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.leon.bean.Course;
import com.leon.bean.Depart;
import com.leon.bean.Emp;
import com.leon.bean.Grade;
import com.leon.service.DepartService;
import com.leon.service.EmpService;
import com.leon.utils.PageHelper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
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
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	EmpService es;
	@Autowired
	DepartService ds;
	
	@RequestMapping("/list/{pageIndex}")
	public String getList(@PathVariable(name = "pageIndex") Integer pageIndex,@RequestParam(defaultValue="2") Integer pageSize, Model model) {
		Page<Emp> page = new Page<Emp>(pageIndex, pageSize); // 封装分页
		Page<Emp> results = es.selectPage(page, new EntityWrapper<Emp>().eq("del", 0));
		List<Emp> emp = results.getRecords(); // 查询数据结果集
		
		for (Emp e : emp) {
			Depart depart = ds.selectById(e.getDid());
			e.setDepart(depart);
		}
		
		int pageTotal = ((Long)page.getTotal()).intValue();
		
		PageHelper<Emp> ph = new PageHelper<Emp>(pageIndex, pageSize, pageTotal, emp, null);
		
		model.addAttribute("pageBean", ph);
		model.addAttribute("hasPrevious", page.hasPrevious());
		model.addAttribute("hasNext", page.hasNext());
		
		return "/emplist.jsp";
	}
	
	@RequestMapping("/addEmp")
	public void addGrade(Emp emp, HttpServletResponse response, HttpServletRequest request, MultipartFile pic) throws Exception{
		System.err.println("addEmp:"+emp);
		
		File path = createDir(request.getSession().getServletContext()); // 文件存储路径
		String fileName=createName(pic.getOriginalFilename()); // 重命名文件名
		File f=new File(path, fileName);
		
		if (!pic.isEmpty()) {
			pic.transferTo(f); // 将文件保存到服务器
		}
		emp.setPhoto(fileName);
		emp.setDel(0);
		System.out.println("insertEmp:"+emp);
		
		boolean b = es.insert(emp);
		if(true == b) {
			response.getWriter().write("<script>alert('添加成功!');location.href='"+request.getContextPath()+"/emp/list/1';</script>");
		}else {
			response.getWriter().write("<script>alert('添加失败!');location.href='"+request.getContextPath()+"/emp/list/1';</script>");
		}
		
	}

	// 创建目录
	private File createDir(ServletContext context) {
		String realPath = context.getRealPath("/static/upload");
		//String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdir();
		}
		return file;
	}
	// 创建文件名--区分同名文件,在文件名前加上当前的时间
	private String createName(String name) {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()) + "_" + name;
	}


	@RequestMapping("/goUpdate/{id}")
	public String goUpdate(@PathVariable(name="id") Integer id,HttpServletRequest request, Model model) {
//		System.out.println("getUpdateId:"+id);
		Emp emp = es.selectById(id);  // 查询要更新的员工
		
		Depart depart = ds.selectById(emp.getDid()); // 查询该员工所属部门
		
//		File path = createDir(request.getSession().getServletContext()); // 文件存储路径
//		System.out.println("empphoto:"+emp.getPhoto());
//		emp.setPhoto(path+"\\"+emp.getPhoto());
		
		System.out.println("updateEmp:"+emp);
		
		model.addAttribute("emp", emp);
		model.addAttribute("depart", depart);
		
		return "/empupdate.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/departlist")
	public List<Depart> getCourse(HttpServletResponse response) throws Exception{
		List<Depart> list = ds.selectList(new EntityWrapper<Depart>().eq("del", 0));
		System.out.println(list);
		
//		response.getWriter().write("list");
		
		return list;
	}
	
	@RequestMapping("/update")
	public void update(Emp emp, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		
		System.out.println("emp:"+emp);
		boolean b = es.update(emp, new EntityWrapper<Emp>().eq("no", emp.getNo()));
		if(true == b) {
			response.getWriter().write("<script>alert('更新成功!');location.href='"+request.getContextPath()+"/emp/list/1';</script>");
		}else {
			response.getWriter().write("<script>alert('更新失败!');location.href='"+request.getContextPath()+"/emp/list/1';</script>");
		}
	}
	
	@RequestMapping("/del/{delId}")
	public String del(Emp emp, @PathVariable(name="delId") Integer delId,HttpServletRequest request, HttpServletResponse response) throws Exception {
		emp.setNo(delId);
		emp.setDel(1);
		System.out.println(emp);
		boolean b = es.updateById(emp);
//		if( true == b) {
//			response.getWriter().write("<script>alert('删除成功!');location.href='"+request.getContextPath()+"/grade/list/1';</script>");
//		}
		
		return "/emp/list/1";
	}
	
	
}

