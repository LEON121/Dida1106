package com.leon.service.impl;

import com.leon.bean.Emp;
import com.leon.mapper.EmpMapper;
import com.leon.service.EmpService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leon
 * @since 2018-11-10
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

}
