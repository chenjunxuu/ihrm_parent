package com.ihrm.domain.company.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import com.ihrm.domain.company.response.DeptListResult;
import com.ihrm.domain.company.service.CompanyService;
import com.ihrm.domain.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


/**
 * @author 16620
 */
//1.解决跨域
@CrossOrigin
@RestController
@RequestMapping(value = "company/department")
public class DepartmentController extends BaseController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;
    /**
     * 查询指定企业基本信息和旗下的所有部门信息
     */
    @GetMapping
    public Result findAllDepartment(){
        //1.指定企业id
        Company company = companyService.findById(companyId);
        List<Department> departmentList = departmentService.findCompanyId(companyId);
        DeptListResult deptListResult = new DeptListResult(company,departmentList);
        return new Result(ResultCode.SUCCESS,deptListResult);
    }
    /**
     * 根据ID查询department
     *
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable(value = "id") String id){
        Department department = departmentService.findById(id);
        return new Result(ResultCode.SUCCESS,department);
    }
    /**
     * 修改Department
     */
    @PostMapping(value = "/{id}")
    public Result updateDepartment(@PathVariable(value = "id") String id,@RequestBody Department department){
        //1.设置修改的部门id
        department.setId(id);
        //2.调用sevice更新
        departmentService.updateDepartment(department);
        return new Result(ResultCode.SUCCESS);
    }
    /**
     * 根据id删除
     */
    @DeleteMapping(value = "/{id}")
    public Result delecteDepartment(@PathVariable(value = "id") String id){
        return new Result(ResultCode.SUCCESS);
    }
    /**
     * 新增部门
     */
    @PostMapping
    public Result saveDepartment(@RequestBody Department department){
        //2.调用service保存企业
        department.setCompanyId(companyId);
        departmentService.saveDepartment(department);
        return new Result(ResultCode.SUCCESS);
    }
}
