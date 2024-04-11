package org.jeecg.modules.demo.test.service.impl;

import org.jeecg.modules.demo.test.entity.TestV3Hello;
import org.jeecg.modules.demo.test.mapper.TestV3HelloMapper;
import org.jeecg.modules.demo.test.service.ITestV3HelloService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 第一个Vue3表单
 * @Author: jeecg-boot
 * @Date:   2024-04-04
 * @Version: V1.0
 */
@Service
public class TestV3HelloServiceImpl extends ServiceImpl<TestV3HelloMapper, TestV3Hello> implements ITestV3HelloService {

}
