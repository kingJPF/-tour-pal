
package com.action;
import java.sql.*;
import com.action.User;
public class ConnectionSQL {
	public boolean Select(User user){  
        Connection conn=null;  
        PreparedStatement ps=null;  
        ResultSet rs=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection(  
                  //  "jdbc:mysql://localhost:3306/struts_tutorial","root","1234");  
            		"jdbc:mysql://localhost:3306/web_user","root","971213");
            String sql="Select userid,userpass from user";  
            ps=conn.prepareStatement(sql);  
            //ps.setString(1,user.getUname());  
            //ps.setString(2,user.getUpass());  
            rs=ps.executeQuery();  
            while(rs.next()){  
                if(user.getUsername().equals(rs.getString("userid"))&&user.getPassword().equals(rs.getString("userpass"))){  
                return true;  
                }  
            }  
            //return false;  
        }catch(Exception e){  
            e.printStackTrace();
        }finally{  
            try{  
                rs.close();  
                ps.close();  
                conn.close();  
            }catch(SQLException e){  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  
    public boolean Insert_choice(User user){  
    
        Connection conn=null;  
        PreparedStatement ps=null;  
          
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/web_user","root","971213");  
            String sql=  
                    "UPDATE user SET start=?,end=?,start_date=? WHERE userid = ?";  
            ps=conn.prepareStatement(sql);  
             
            ps.setString(1,user.getStart());
            ps.setString(2,user.getEnd());
            ps.setString(3,user.getDatemonth()+user.getDateday());
            ps.setString(4,user.getUsername());
            int mun=ps.executeUpdate();  
        }catch(Exception e){  
        e.printStackTrace(); 
        return false;
        }finally{  
            try{  
                  
                ps.close();  
                conn.close();  
            }catch(SQLException e){  
                e.printStackTrace();  
            }  
        }  
  
     return true;  
}  
    public boolean Insert(User user){
        Connection conn=null;  
        PreparedStatement ps=null;  
          
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/web_user","root","971213");  
            String sql=  
                    "insert into user(userid,userpass,usersex,userage,flag)values(?,?,?,?,?)";  
            ps=conn.prepareStatement(sql);  
            ps.setString(1,user.getUsername());  
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getUsersex());
            ps.setString(4,user.getUserage());
            ps.setInt(5, 0);
            int mun=ps.executeUpdate();  
        }catch(Exception e){  
        e.printStackTrace(); 
        return false;
        }finally{  
            try{  
                  
                ps.close();  
                conn.close();  
            }catch(SQLException e){  
                e.printStackTrace();  
            }  
        }  
        return true;
    }
}
