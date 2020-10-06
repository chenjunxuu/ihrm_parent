package com.ihrm.domain.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.company.Company;

import com.ihrm.domain.company.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private IdWorker idWorker;
    /**
     * 保存企业
     * 1.配置idwork到工程
     * 2.在service中注入idworK
     * 3.通过idwork生成id
     * 4.保存企业
     */
    public void add(Company company){
        //基本属性的设置
        company.setId(idWorker.nextId() +"");
        company.setName(company.getName());
        company.setCreateTime(new Date());
        companyDao.save(company);
    }
    /**
     * 更新企业
     * 1.参数：Company
     * 2.根据id查询企业对象
     * 3.设置修改的熟悉
     * 4.调用dao完成更新
     */
    public void update(Company company){
        Company temp = companyDao.findById(company.getId()).get();
        temp.setName(company.getName());
        companyDao.save(company);
    }
    /**
     * 删除企业
     */
    public void deleteById(String id){
        companyDao.deleteById(id);
    }
    /**
    * 根据id查询企业
    */
    public Company findById(String id){
        return companyDao.findById(id).get();
    }
    /**
     * 查询企业列表
     */
    public List<Company> findAll(){
        return companyDao.findAll();
    }
}
