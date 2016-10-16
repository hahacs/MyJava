package com.hahacs.dotest;

import java.io.InputStream;
import java.io.Reader;

import javax.annotation.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMybatis {
	public static void main(String[] args){
		//mybatis�������ļ�
        String resource = "conf.xml";
        //ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
        InputStream is = TestMybatis.class.getClassLoader().getResourceAsStream(resource);
//        Reader reader = null;
//        reader=Resources.getResourceAsReader(resource);
//        SqlSessionFactory sessionFactory1 = new SqlSessionFactoryBuilder().build(reader);
        
        
        //����sqlSession�Ĺ���
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
        //Reader reader = Resources.getResourceAsReader(resource); 
        //����sqlSession�Ĺ���
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //������ִ��ӳ���ļ���sql��sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "me.gacl.mapping.userMapper.getUser";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����һ��Ψһuser�����sql
        String k1 = session.selectOne("findWeekNewRegister");
        String k2 = session.selectOne("findWeekNewInvestor");
        String k3 = session.selectOne("findAllUserTotal");
        String k4 = session.selectOne("findAllInvestorTotal");
        String k5 = session.selectOne("findWeekRealName");
        String k6 = session.selectOne("findWeekBankCard");
        String k7 = session.selectOne("findWeekInvestor");
        String k8 = session.selectOne("findNewInvestAmount");
//        String k5 = session.selectOne("findWeekNewRegister");
        System.out.println("ȡ����������ע���û���:"+k1);
        System.out.println("ȡ����������Ͷ���û�����:"+k2);
        System.out.println("ȡ����ע���û���:"+k3);
        System.out.println("ȡ����Ͷ���û���:"+k4);
        System.out.println("ÿ��ע����:"+k1);
        System.out.println("ÿ��ʵ����:"+k5);
        System.out.println("ÿ�ܰ���:"+k6);
        System.out.println("ÿ��Ͷ����:"+k7);
        System.out.println("����Ͷ����Ͷ������:"+k7);
//        System.out.println(k5);
        session.close();
	}
}
