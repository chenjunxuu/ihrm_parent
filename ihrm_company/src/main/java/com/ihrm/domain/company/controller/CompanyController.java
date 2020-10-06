package com.ihrm.domain.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    //保存企业
    @PostMapping
    public Result saveCompany(@RequestBody Company company){
        companyService.add(company);
        return new Result(ResultCode.SUCCESS);
    }
    //根据id更新企业
    @PutMapping(value = "/{id}")
    public Result updateCompany(@PathVariable(value = "id") String id ,@RequestBody Company company){
        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }
    //根据id删除企业
    @DeleteMapping(value = "/{id}")
    public  Result deleteById(@PathVariable(value = "id") String id){
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }
    //根据id查询企业
    @GetMapping(value = "/{id}")
    public Result selectById(@PathVariable(value = "id") String id){
        Company company = companyService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(company);
        return result;
    }
    //根据查询全部企业列表
    @GetMapping(value = "")
    public Result findAll(){
        List<Company> companyList = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(companyList);
        return result;
    }
}
