package com.system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 王宁
 * 2017/12/19
 * 计算工资表中各个项类
 */
public class GetWages {

    public double getBasicWages(String job){
        double basicWages=0.;
        if ("员工".equals(job)){
            basicWages=8000;
        }
        if ("财务部经理".equals(job)||"人事部经理".equals(job)||"行政部经理".equals(job)){
            basicWages=10000;
        }
        if ("超级管理员".equals(job)){
            basicWages=15000;
        }
       return basicWages;
    }

    public double getattendancereward(String rpreason){
        double attendancereward=0.;
        if ("迟到".equals(rpreason)||"未出勤".equals(rpreason)||"请假".equals(rpreason)){
            attendancereward=0;
        }else {
            attendancereward=500;
        }
        return attendancereward;
    }

    public double getyearwages(String entrytime){
        double yearwages=0.;
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date begin= null;
        try {
            begin = dfs.parse(entrytime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date end = null;
        try {
            end = dfs.parse(dfs.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
        long year=between/(12*30*24*3600);
        if (year!=0){
            yearwages=year*100;
        }else {
            yearwages=0.;
        }
        return yearwages;
    }

    public double getrpwages(String rpreason){
        double rpwages=0.;
        if ("迟到".equals(rpreason)||"请假".equals(rpreason)){
            rpwages=-50;
        }
        if ("未出勤".equals(rpreason)){
            rpwages=-100;
        }
        return rpwages;
    }

    public double getWages(int wages,int insurance){
        int taxIncome;
        taxIncome = wages - insurance - 3500;
        double tax = 0.;
        if (taxIncome <= 1500){
            tax = taxIncome * 0.03;
        }else if (taxIncome >1500 && taxIncome <= 4500){
            tax = taxIncome * 0.1 - 105;
        }else if (taxIncome >4500 && taxIncome <=9000){
            tax = taxIncome * 0.2 - 555;
        }else if (taxIncome >9000 && taxIncome <= 35000){
            tax = taxIncome * 0.25 - 1005;
        }else if (taxIncome >35000 && taxIncome <= 55000 ){
            tax = taxIncome * 0.3 - 2775;
        }else if (taxIncome >55000 && taxIncome <= 80000){
            tax = taxIncome * 0.35 - 5505;
        }else if (taxIncome > 80000 ){
            tax = taxIncome * 0.45 - 13505;
        }
        return tax;
    }

}
