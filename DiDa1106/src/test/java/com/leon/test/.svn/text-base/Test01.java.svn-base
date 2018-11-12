package com.leon.test;



import javax.sql.DataSource;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.leon.bean.SysUser;
import com.leon.mapper.SysUserMapper;
import com.leon.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test01 {

	@Autowired
	DataSource ds;

	@Autowired
	SysUserMapper um;

	@Autowired
	SysUserService ss;

	@Test
	public void test01() {
		System.out.println(ds);
	}


	@Test
	public void test02(){
		SysUser u= ss.selectOne(new EntityWrapper<SysUser>().eq("username", "admin").eq("password", "123").eq("del", 0));
	    System.out.println(u);
	}
}
