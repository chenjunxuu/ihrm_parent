package com.ihrm.domain.company;

import com.ihrm.domain.company.dao.CompanyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyTest {

    /**
     *
     */
       @Autowired
       private CompanyDao companyDao;

        @Test
        public void test(){
            Company company = companyDao.findById("1").get();
            System.out.println(company);
        }
    }
