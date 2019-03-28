package com.lnson.temp.app.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class MybatisConfig {

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(env.getProperty("jdbc.driverClass"));
        druidDataSource.setUrl(env.getProperty("jdbc.jdbcUrl"));
        druidDataSource.setUsername(env.getProperty("jdbc.user"));
        druidDataSource.setPassword(env.getProperty("jdbc.password"));
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis.xml"));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactoryBean sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory.getObject());
    }

    /**
     * 事务管理器
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
