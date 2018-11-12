package com.leon.web;

import java.net.InetAddress;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.leon.bean.Loginlog;
import com.leon.bean.SysUser;
import com.leon.service.LoginlogService;
import com.leon.service.SysUserService;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class SysUserController {
	
	@Autowired
	SysUserService ss;
	
	@Autowired
	LoginlogService ls;
	
	@RequestMapping("/login")
	public void login(SysUser u, Loginlog loginlog, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		
		String addr1 = InetAddress.getLocalHost().getHostAddress().toString();  // 获取ip
		String addr = request.getRemoteAddr();
		System.out.println("address:"+addr1);
		
		
		
		SysUser user = ss.selectOne(new EntityWrapper<SysUser>().eq("username", u.getUsername()).eq("password", u.getPassword()).eq("del", 0));
		user.setLastip(addr1);
		ss.update(user, new EntityWrapper<SysUser>().eq("id", user.getId())); // 更新上次登录ip
		
		loginlog.setIp(addr1);
		loginlog.setLocation("成都");
		loginlog.setNo(user.getUsername());
		loginlog.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString());
		ls.insert(loginlog); // 记录登录日志
		
		if(user!=null){
			session.setAttribute("lguser", user);
			response.getWriter().write("<script>location.href='"+request.getContextPath()+"/index.jsp';</script>");
		}else{
			response.getWriter().write("<script>alert('账号或密码错误!');location.href='"+request.getContextPath()+"/login.jsp';</script>");
		}
	}
	
	@RequestMapping("/chpwd")
	public void chpwd(HttpSession session, String prepwd, String newpwd, HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
		SysUser user = (SysUser) session.getAttribute("lguser");
		System.out.println("user="+user+"prepwd="+prepwd+",newpwd="+newpwd);
		
		if(user.getPassword().equals(prepwd)  && newpwd != null) {
			user.setPassword(newpwd);
			ss.update(user, new EntityWrapper<SysUser>().eq("id", user.getId()));
			
			response.getWriter().write("<script>alert('密码已更改!');parent.location.href='"+request.getContextPath()+"/index.jsp';</script>");
		}else {
			response.getWriter().write("<script>alert('原密码错误!');location.href='/password.jsp';</script>");
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		System.out.println("logout");
		session.invalidate();
		return "redirect:/login.jsp";
	}

}
