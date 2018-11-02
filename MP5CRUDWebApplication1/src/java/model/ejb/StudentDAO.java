/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.sql.DataSource;
import model.Student;

/** 
 *
 * @author ckumar
 */
@Stateless
@LocalBean
public class StudentDAO {
      
  @Resource(name="jdbc/studentDB")
  private DataSource ds;
  
  public void addStudent(Student student){
      String sql="INSERT INTO STUDENT VALUE('"+ student.getStudentID() +"', '"+ student.getName() +"', '"+ student.getAddress() +"')";
      executeModifyQuery(sql);
  }
  public void editStudent(Student student){
      String sql="UPDATE STUDENT SET NAME='"+ student.getName() +"', ADDRESS= '"+ student.getAddress() +"' WHERE STUDENTID='"+ student.getStudentID() +"'";
      executeModifyQuery(sql);
  }
  public void deleteStudent(Student student){
      String sql="DELETE FROM STUDENT WHERE STUDENTID='"+ student.getStudentID() +"'";
      executeModifyQuery(sql);
  }
  public Student getStudent(String id){
      Student student=new Student();
      String sql="SELECT * FROM STUDENT WHERE STUDENTID='"+id +"'";
      System.out.println(sql);
      ResultSet rs =executeFetchQuery(sql);
      try{
          if(rs.next()){
              student.setStudentID(rs.getString("STUDENTID"));
              student.setName(rs.getString("NAME"));
              student.setAddress(rs.getString("ADDRESS"));
          }
      }
          catch(Exception ex){
                  System.err.println("GS" + ex.getMessage());
                  }
          return student;
      }
      public ArrayList<Student>getAllStudent(){
          ArrayList<Student>list=new ArrayList<Student>();
          String sql="SELCET * FROM STUDENT";
          ResultSet rs= executeFetchQuery(sql);
          try{
              while(rs.next()){
                  Student student=new Student();
                  student.setStudentID(rs.getString("STUDENTID"));
                  student.setName(rs.getString("NAME"));
                  student.setAddress(rs.getString("ADDRESS"));
                  list.add(student);
              }
              }
              catch(SQLException ex){
                      System.err.println(ex.getMessage());
                      }
              return list;
          }
      

   public void executeModifyQuery(String sql){
     
       try{
           Connection conn=ds.getConnection();
           conn.createStatement().execute(sql);
         conn.close();       
     }
       catch(Exception e){
         System.err.println(e.getMessage());
       }
   } 
   public ResultSet executeFetchQuery(String sql){
       ResultSet rs=null;
       try{
           Connection conn=ds.getConnection();
           rs=conn.createStatement().executeQuery(sql);
         conn.close();       
     }
   
       catch(Exception e){  
         System.err.println(e.getMessage());
       }   
       return rs;
   } 
}

