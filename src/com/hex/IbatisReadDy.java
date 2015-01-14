package com.hex;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class IbatisReadDy{
  @SuppressWarnings({ "unchecked", "unused" })
public static void main(String[] args)
   throws IOException,SQLException{
   Reader rd=Resources.getResourceAsReader("SqlMapConfig.xml");
   SqlMapClient smc=SqlMapClientBuilder.buildSqlMapClient(rd);

   /* This would read all records from the Employee table.*/
   System.out.println("Going to read records.....");
   Employee rec = new Employee();
   rec.setId(128);

   List <Employee> ems = (List<Employee>)smc.queryForList("Employee.findByID", rec);
   Employee em = null;
   for (Employee e : ems) {
      System.out.print("  " + e.getId());
      System.out.print("  " + e.getFirst_name());
      System.out.print("  " + e.getLast_name());
      System.out.print("  " + e.getSalary());
      em = e; 
      System.out.println("");
   }    

   System.out.println("Records Read Successfully ");

  }
} 