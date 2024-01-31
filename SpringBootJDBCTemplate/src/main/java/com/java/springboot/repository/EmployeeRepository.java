package com.java.springboot.repository;

import com.java.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void save(Employee emp){
        String insertSql = "insert into employee (id,name,tech) values(?,?,?)";
        int rowsAffected = jdbcTemplate.update(insertSql,emp.getId(),emp.getName(),emp.getTech());
        System.out.println("No of rows affected : " + rowsAffected);
    }
    public List<Employee> fetchAll(){
        String getSql = "select * from employee";
        RowMapper rm = (rs, rownum) -> {
            Employee emp = new Employee();
            emp.setId(rs.getInt(1));
            emp.setName(rs.getString(2));
            emp.setTech(rs.getString(3));
            return emp;
        };
        List<Employee> employess = jdbcTemplate.query(getSql, rm);
        return employess;
    }
    public Employee fecthId(int id){
        String fetchSql = "select * from employee where id="+id;
        Employee e = new Employee();
        jdbcTemplate.query(fetchSql, (rs,row) -> {
            e.setId(rs.getInt(1));
            e.setName(rs.getString(2));
            e.setTech(rs.getString(3));
            return e;
        }) ;
        return e;
    }
    public void delete(int id){
        int rows = jdbcTemplate.update("delete from employee where id="+id);
        System.out.println("Rows deleted : "+rows);
    }
}
