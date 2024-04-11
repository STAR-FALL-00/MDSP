package org.jeecg.modules.demo.test.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.test.entity.TestV3Hello;
import org.jeecg.modules.demo.test.service.ITestV3HelloService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 第一个Vue3表单
 * @Author: jeecg-boot
 * @Date:   2024-04-04
 * @Version: V1.0
 */
@Api(tags="第一个Vue3表单")
@RestController
@RequestMapping("/test/testV3Hello")
@Slf4j
public class TestV3HelloController extends JeecgController<TestV3Hello, ITestV3HelloService> {
	@Autowired
	private ITestV3HelloService testV3HelloService;
	
	/**
	 * 分页列表查询
	 *
	 * @param testV3Hello
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "第一个Vue3表单-分页列表查询")
	@ApiOperation(value="第一个Vue3表单-分页列表查询", notes="第一个Vue3表单-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<TestV3Hello>> queryPageList(TestV3Hello testV3Hello,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<TestV3Hello> queryWrapper = QueryGenerator.initQueryWrapper(testV3Hello, req.getParameterMap());
		Page<TestV3Hello> page = new Page<TestV3Hello>(pageNo, pageSize);
		IPage<TestV3Hello> pageList = testV3HelloService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param testV3Hello
	 * @return
	 */
	@AutoLog(value = "第一个Vue3表单-添加")
	@ApiOperation(value="第一个Vue3表单-添加", notes="第一个Vue3表单-添加")
	@RequiresPermissions("test:test_v3_hello:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody TestV3Hello testV3Hello) {
		testV3HelloService.save(testV3Hello);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param testV3Hello
	 * @return
	 */
	@AutoLog(value = "第一个Vue3表单-编辑")
	@ApiOperation(value="第一个Vue3表单-编辑", notes="第一个Vue3表单-编辑")
	@RequiresPermissions("test:test_v3_hello:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody TestV3Hello testV3Hello) {
		testV3HelloService.updateById(testV3Hello);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "第一个Vue3表单-通过id删除")
	@ApiOperation(value="第一个Vue3表单-通过id删除", notes="第一个Vue3表单-通过id删除")
	@RequiresPermissions("test:test_v3_hello:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		testV3HelloService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "第一个Vue3表单-批量删除")
	@ApiOperation(value="第一个Vue3表单-批量删除", notes="第一个Vue3表单-批量删除")
	@RequiresPermissions("test:test_v3_hello:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.testV3HelloService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "第一个Vue3表单-通过id查询")
	@ApiOperation(value="第一个Vue3表单-通过id查询", notes="第一个Vue3表单-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<TestV3Hello> queryById(@RequestParam(name="id",required=true) String id) {
		TestV3Hello testV3Hello = testV3HelloService.getById(id);
		if(testV3Hello==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(testV3Hello);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param testV3Hello
    */
    @RequiresPermissions("test:test_v3_hello:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TestV3Hello testV3Hello) {
        return super.exportXls(request, testV3Hello, TestV3Hello.class, "第一个Vue3表单");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("test:test_v3_hello:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, TestV3Hello.class);
    }

}
