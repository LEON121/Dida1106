package com.leon.service.impl;

import com.leon.bean.Course;
import com.leon.mapper.CourseMapper;
import com.leon.service.CourseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leon
 * @since 2018-11-07
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
