package com.spring.jdbc;

import com.spring.jdbc.model.Company;
import com.spring.jdbc.model.Region;
import com.sun.deploy.security.ruleset.DRSResult;
import javafx.beans.binding.ListBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.validation.ObjectError;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Admin on 07.07.2016.
 */
public class TestSpringJDBC {
    private static final Logger logger= LoggerFactory.getLogger(TestSpringJDBC.class);
//    String sql="SELECT order_id,symbol,price FROM company.jc_company ";

    public static void separator(String title){
        logger.debug("\r\n\r\n\r\n");
        logger.debug("==============={}===============",title);
        logger.debug("");
    }

    public static void main(String[] args) throws SQLException {
        ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

       DataSource dataSource = context.getBean("dataSource", DataSource.class);
        logger.info("dataSource class : {} name : {}",dataSource.getClass().getCanonicalName());
        Connection connection = dataSource.getConnection();
        logger.info("connection : {}",connection.getClass().getCanonicalName());
        connection.close();
        Connection connection2 = dataSource.getConnection();
        logger.info("connection : {}",connection2.getClass().getCanonicalName());
        connection2.close();
        JdbcTemplate jdbc = context.getBean("jdbcTemplate", JdbcTemplate.class);
        //jdbc.queryForObject("SELECT order_id,symbol,price FROM company.jc_company",);
        separator("Select count");
        Integer count = jdbc.queryForObject("SELECT count(*)  FROM company.jc_company", Integer.class);
        logger.debug("count = {}",count);

        separator("slect symbol");
        final String companyName  = jdbc.queryForObject("SELECT symbol  FROM company.jc_company WHERE order_id=? AND symbol=?", new Object[]{1,"IBM"}, String.class);
        logger.debug("name = {}",companyName);
        separator("select count 2");
        Integer count2  = jdbc.queryForObject("SELECT count(*)  FROM company.jc_company WHERE order_id=? AND symbol=?", new Object[]{1,"IBM"}, Integer.class);
        logger.debug("count = {}",count2);

        separator("select company");
        Company company  = jdbc.queryForObject("SELECT order_id,symbol  FROM company.jc_company WHERE order_id=?", new Object[]{1}, new RowMapper<Company>() {
            public Company mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Company(resultSet.getInt("order_id"),resultSet.getString("symbol"));
            }
        });
        logger.debug("Company = {}",company);

         insertRegion(jdbc);
      //  queryListForComplexObject(jdbc);
     //   batchUpdates(jdbc);
        simpleInsertConstructor(jdbc);
    }

    public static void insertRegion(JdbcTemplate jdbc){
        separator("Insert region");
        PreparedStatementCreatorFactory creatorFactory=new PreparedStatementCreatorFactory(" insert into region.jc_region (regionName) VALUES (?)");
        creatorFactory.setGeneratedKeysColumnNames("regionid");
        creatorFactory.addParameter(new SqlParameter(Types.VARCHAR));
        PreparedStatementCreator preparedStatementCreator=creatorFactory.newPreparedStatementCreator(new String[]{"Mogilevskiy"});


        KeyHolder keyHolder=new GeneratedKeyHolder();
        int insertCount=jdbc.update(preparedStatementCreator,keyHolder);
        logger.debug("Insert int count: {}",insertCount);
        logger.debug("New Region is: {}", keyHolder.getKey());

    }
    public static void queryListForComplexObject(JdbcTemplate jdbc){
        List<Company> listCompany=jdbc.query("SELECT order_id,symbol  FROM company.jc_company", new RowMapper<Company>() {
            public Company mapRow(ResultSet resultSet, int i) throws SQLException {
                Company company=new Company(resultSet.getInt("order_id"),resultSet.getString("symbol"));

                return company;
            }
        });

        for (Company company:listCompany){
            logger.debug("Company list :{}",company);
        }
    }
    public static void batchUpdates (JdbcTemplate jdbc){
        separator("batch updates");
        final ArrayList<Region> regionList=new ArrayList<Region>() ;
        regionList.add(new Region("Region1"));
        regionList.add(new Region("Region2"));
        regionList.add(new Region("Region3"));
        regionList.add(new Region("Region4"));

        int[] ints=jdbc.batchUpdate("INSERT INTO region.jc_region (regionName) values(?)", new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1,regionList.get(i).getRegionName());
            }

            public int getBatchSize() {
                return regionList.size();
            }
        });
        for(Region region:regionList){
            logger.debug("Add {} ",region);
        }
    }

    public static void simpleInsertConstructor(JdbcTemplate jdbc){
        separator("SimpleJDBCInsertConstructor");
        SimpleJdbcInsert insertActor=new SimpleJdbcInsert(jdbc).withSchemaName("region").withTableName("jc_region").usingGeneratedKeyColumns("regionid");
        Map<String,Object> parameters=new HashMap<String, Object>();
        parameters.put("regionName","Region of constructor");
        Number number = insertActor.executeAndReturnKey(parameters);
        logger.debug("Add region {} ",number);

    }

}