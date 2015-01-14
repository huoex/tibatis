package com.hex;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class IbatisSP{
  public static void main(String[] args)
   throws IOException,SQLException{
   Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
   SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

   int id = 128;
   System.out.println("Going to read employee name.....");
   Employee e = (Employee)smc.queryForObject
                ("Employee.getEmpInfo", id);

   System.out.println("First Name:  " + e.getFirst_name());

   System.out.println("Record name Successfully ");

  }
} 