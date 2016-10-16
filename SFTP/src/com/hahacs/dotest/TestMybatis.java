package com.hahacs.dotest;

import java.io.InputStream;
import java.io.Reader;

import javax.annotation.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMybatis {
	public static void main(String[] args){
		//mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = TestMybatis.class.getClassLoader().getResourceAsStream(resource);
//        Reader reader = null;
//        reader=Resources.getResourceAsReader(resource);
//        SqlSessionFactory sessionFactory1 = new SqlSessionFactoryBuilder().build(reader);
        
        
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "me.gacl.mapping.userMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        String k1 = session.selectOne("findWeekNewRegister");
        String k2 = session.selectOne("findWeekNewInvestor");
        String k3 = session.selectOne("findAllUserTotal");
        String k4 = session.selectOne("findAllInvestorTotal");
        String k5 = session.selectOne("findWeekRealName");
        String k6 = session.selectOne("findWeekBankCard");
        String k7 = session.selectOne("findWeekInvestor");
        String k8 = session.selectOne("findNewInvestAmount");
//        String k5 = session.selectOne("findWeekNewRegister");
        System.out.println("取出本周新增注册用户数:"+k1);
        System.out.println("取出本周新增投资用户总数:"+k2);
        System.out.println("取出总注册用户数:"+k3);
        System.out.println("取出总投资用户数:"+k4);
        System.out.println("每周注册数:"+k1);
        System.out.println("每周实名数:"+k5);
        System.out.println("每周绑卡数:"+k6);
        System.out.println("每周投资数:"+k7);
        System.out.println("新增投资人投资总数:"+k7);
//        System.out.println(k5);
        session.close();
	}
}
