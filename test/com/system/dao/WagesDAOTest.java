package com.system.dao;

import com.system.factory.WagesFactory;
import com.system.model.Wages;
import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import java.util.List;


/**
 * @author 王宁
 * 2017/12/20
 * 工资表测试类
 */
public class WagesDAOTest {
    WagesDAO wagesDAO;
    @Before
    public void setUp() throws Exception {
        wagesDAO= WagesFactory.getWagesDAOInstance();
    }

    @Test
    public void insertWages() throws Exception {
        Wages wages=new Wages();
        wages.setUserid("111");
        wages.setAttendancereward(0.);
        wages.setBasicwages(8000.);
        wages.setYearwages(100.);
        wages.setInsurance(100.);
        wages.setPublish(0.);
        wages.setTax(300.);
        wages.setWages(8100.);
        wages.setTruewages(8000.);
        wages.setDate(new Date(System.currentTimeMillis()));
        wagesDAO.insertWages(wages);
    }

    @Test
    public void updateWages() throws Exception {
        Wages wages=wagesDAO.search("101001");
        wages.setPublish(0.);
        wagesDAO.updateWages(wages);
        System.out.println(wages);
    }

    @Test
    public void search() throws Exception {
        Wages wages=wagesDAO.search("101001");
        System.out.println(wages);
    }

    @Test
    public void getAllWages() throws Exception {
        List<Wages>wagesList=wagesDAO.getAllWages();
        wagesList.forEach(wages -> System.out.println(wages));
    }

}