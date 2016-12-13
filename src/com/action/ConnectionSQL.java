
package com.action;
import java.util.ArrayList;
import java.sql.*;
import java.util.ArrayList;

import com.action.User;
public class ConnectionSQL {
	
	private String a = "asd";
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	
	
	public boolean Select(User user){  
        Connection conn=null;  
        PreparedStatement ps=null;  
        ResultSet rs=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection(  
                  //  "jdbc:mysql://localhost:3306/struts_tutorial","root","1234");  
            		"jdbc:mysql://localhost:3306/struts_tutorial","root","1234");
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
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/struts_tutorial","root","1234");  
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
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/struts_tutorial","root","1234");  
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
    public boolean Match(User user,ArrayList<User_info> User_mate){
    	Connection conn=null;  
        PreparedStatement ps=null;  
       
        
        ArrayList<User_info> dellist = new ArrayList<User_info>();
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/struts_tutorial","root","1234");  
            String sql=  
                    "select * from user where start = ? and end = ? and start_date = ? and flag = 0";  
            ps=conn.prepareStatement(sql);  
            ps.setString(1,user.getStart());  
            ps.setString(2,user.getEnd());
            ps.setString(3,user.getDatemonth()+user.getDateday());
            ResultSet rsl = ps.executeQuery();
            String judge = "";
            while(rsl.next()){
            	judge = rsl.getString("userid");
            	System.out.println(judge);
            }
            
            if (judge.equals("")){
            	return false;
            }
            rsl.close();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
            	String username = rs.getString("userid");
            	String usersex = rs.getString("usersex");
            	String userage = rs.getString("userage");
            	//System.out.println(username);
            	//System.out.println(usersex);
            	
            	User_mate.add(new User_info(username,usersex,userage));
            	
            }
            for (User_info tmp : User_mate) {  
                //System.out.println(tmp);  
            	if (tmp.getUsername().equals(user.getUsername())){
            		dellist.add(tmp);
            	}
            }  
            User_mate.removeAll(dellist);
          
            if(User_mate.isEmpty()){
            	return false;
            }
           
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
    
    public boolean TeamInfo(User user,ArrayList<User_info> User_mate) {
    	Connection conn=null;  
        PreparedStatement ps=null;  
        Get_User_Info(user);

        ArrayList<User_info> dellist = new ArrayList<User_info>();
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/struts_tutorial","root","1234");  
            String sql=  
                    "select * from user where info = ?";  
            ps=conn.prepareStatement(sql);  
            ps.setString(1,user.getInfo());  
        
            ResultSet rsl = ps.executeQuery();
            String judge = "";
            while(rsl.next()){
            	judge = rsl.getString("userid");
            	System.out.println(judge);
            }
            
            if (judge.equals("")){
            	return false;
            }
            rsl.close();
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            	String username = rs.getString("userid");
            	String usersex = rs.getString("usersex");
            	String userage = rs.getString("userage");
            	//System.out.println(username);
            	//System.out.println(usersex);
            	user.setEnd(rs.getString("end"));
                user.setStart(rs.getString("Start"));
                user.setStart_date(rs.getString("start_date"));
            	User_mate.add(new User_info(username,usersex,userage));
            	
            }
            for (User_info tmp : User_mate) {  
                //System.out.println(tmp);  
            	if (tmp.getUsername().equals(user.getUsername())){
            		dellist.add(tmp);
            	}
            }  
            User_mate.removeAll(dellist);
          
            if(User_mate.isEmpty()){
            	return false;
            }
           
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
    
    public boolean Get_User_Info(User user) {
    	 Connection conn=null;  
         PreparedStatement ps=null;  
           
         try{  
        	 System.out.println("connecte Sql");
             Class.forName("com.mysql.jdbc.Driver");  
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/struts_tutorial","root","1234");  
             String sql=  
                     "select * from user where userid = ?";  
             ps=conn.prepareStatement(sql);  
              
             ps.setString(1,user.getUsername()); 
             ResultSet rsl = ps.executeQuery();
             while(rsl.next()) {
             user.setInfo(rsl.getString("info"));
             user.setStart_date(rsl.getString("start_date"));
             user.setStart(rsl.getString("start"));
             user.setEnd(rsl.getString("End"));
             }
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
    
    
    //将匹配的好友添加到同一队伍
    public boolean Team_match(User user ,String Leadname) {
    	
    	Connection conn=null;  
        PreparedStatement ps=null;
        
        String temp = "",name = "";
        try{  
       	 	System.out.println("connecte Sql");
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/struts_tutorial","root","1234");  
            String sql=  
                    "select * from user where userid = ?";  
            ps=conn.prepareStatement(sql);
            ps.setString(1,Leadname); 
            ResultSet rsl = ps.executeQuery();
            
            while(rsl.next()) {
            	temp = rsl.getString("info");
            	name = rsl.getString("userid");
            }
            
            
            if (temp == null){
            	PreparedStatement ps1=null;
            	sql = "UPDATE user SET info = ? WHERE userid = ?";
        		ps1=conn.prepareStatement(sql);
                ps1.setString(1,name);
                ps1.setString(2,user.getUsername());
                ps1.executeUpdate();
                
                
                PreparedStatement ps2=null;
                sql = "UPDATE user SET info = ? WHERE userid = ?";
        		ps2=conn.prepareStatement(sql);
                ps2.setString(1,name);
                ps2.setString(2,Leadname);
                ps2.executeUpdate();
                System.out.println(temp+"123");
        		
                user.setInfo(user.getUsername());
        		return true;
        	}else {
        		PreparedStatement ps3=null;
        		sql = "UPDATE user SET info = ? WHERE userid = ?";
        		ps3=conn.prepareStatement(sql);
                ps3.setString(1,name);
                ps3.setString(2,user.getUsername());
                ps3.executeUpdate();
                ps3.close();
                
        		user.setInfo(name);
        		return true;
        	}
            
        } catch(Exception e) {  
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
    	
    }
}
