package com.ucar.training.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class SqlSessionFactoryUtils {
    private static Reader reader;
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try{
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (Exception e){
            System.out.println("error");
        }
    }

    public SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
