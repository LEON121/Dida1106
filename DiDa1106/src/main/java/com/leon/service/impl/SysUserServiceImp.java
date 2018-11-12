package com.leon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.leon.bean.SysUser;
import com.leon.mapper.SysUserMapper;
import com.leon.service.SysUserService;

@Service
@Transactional
public class SysUserServiceImp extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
	

}
