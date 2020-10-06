package com.ihrm.domain.company.service;

import com.ihrm.common.service.BaseService;
import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.company.Department;
import com.ihrm.domain.company.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 16620
 */
@Service
public class DepartmentService extends BaseService {
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 1.保存部门
     */
    public void saveDepartment(Department department){
        //设置主键的值
        String id = idWorker.nextId()+"";
        department.setId(id);
        departmentDao.save(department);
    }
    /**
     * 更新部门
     */
    public void updateDepartment(Department department){
        //根据id查询部门
         Department depart = departmentDao.findById(department.getId()).get();
        //2.设置部门
        depart.setCode(department.getCode());
        depart.setIntroduce(department.getIntroduce());
        depart.setName(department.getName());
        //3.更新部门
        departmentDao.save(depart);
    }
    /**
     * 根据id查询部门
     */
    public Department findById(String id){
        return departmentDao.findById(id).get();
    }
    /**
     * 查询全部部门列表
     */
//    public List<Department> findAll(String companyId){
//        return departmentDao.findAll()
//    }
    /**
     * 4.查询某企业下全部部门列表
     */
    public List<Department> findCompanyId(String companyId){
//        Specification<Department> specification = new Specification<Department>() {
//            /**
//             *
//             * @param root :包含了所有对象数据
//             * @param criteriaQuery :一般不用
//             * @param criteriaBuilder :构造查询条件
//             * @return :company_id = "1"
//             */
//            @Override
//            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                //根据企业id查询
//                return criteriaBuilder.equal(root.get("companyId").as(String.class),companyId);
//            }
//        };

        return departmentDao.findAll(getSpec(companyId));
    }

}
