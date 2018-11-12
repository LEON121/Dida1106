package com.leon.web;


import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.leon.bean.Loginlog;
import com.leon.bean.Student;
import com.leon.service.GradeService;
import com.leon.service.LoginlogService;
import com.leon.service.StudentService;

import javax.servlet.http.HttpSession;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author leon
 * @since 2018-11-09
 */
@Controller
@Scope("prototype")
@RequestMapping("/loginlog")
public class LoginlogController {
	@Autowired
	LoginlogService ls;
	
	@Autowired
	StudentService ss;
	
	@Autowired
	GradeService gs;

	@RequestMapping("/list")
	public String getList(HttpSession session) {
		Page<Loginlog> page = new Page<Loginlog>(0, 5);
		Page<Loginlog> selectPage = ls.selectPage(page, new EntityWrapper<Loginlog>().orderBy("createtime",false));
		List<Loginlog> list = selectPage.getRecords();
		
		int stuCount = ss.selectCount(null);
		int gradeCount = gs.selectCount(null);
		
		
		session.setAttribute("stuCount", stuCount);
		session.setAttribute("gradeCount", gradeCount);
		session.setAttribute("lglog", list); // 我的足迹
		
		
		
		return "/main.jsp";
	}
}

