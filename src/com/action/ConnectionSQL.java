
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
	
	private String database ="struts_tutorial";
	private String user_name = "root";
	private String user_password = "1234";
	//登陆使用的数据库连接
	public boolean Select(User user){  
        Connection conn=null;  
        PreparedStatement ps=null;  
        ResultSet rs=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection(  
                  //  "jdbc:mysql://localhost:3306/struts_tutorial","root","1234");  
            		"jdbc:mysql://localhost:3306/" + database,user_name,user_password);
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
	
	//输入匹配信息
    public boolean Insert_choice(User user){  
        Connection conn=null;  
        PreparedStatement ps=null ,ps1=null,ps2;
        ResultSet rs;
        int i;
        String date="",start1="",end1="";
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database,user_name,user_password);
            
            String sql=  
                    "select start,end,start_date from user where userid = ?";  
            ps2=conn.prepareStatement(sql);  
             
            ps2.setString(1,user.getUsername()); 
            ResultSet rsl = ps2.executeQuery();
            while(rsl.next()) {     
            start1= rsl.getString("start");
            end1 = rsl.getString("end");
            date = rsl.getString("start");
            System.out.println(start1);
            }
            System.out.println(user.getStart());
            if( (start1.equals(user.getStart()) && end1.equals(user.getEnd())) && date.equals(user.getStart_date()) ) {
            	return true;
            } else {
	             sql=  
	                    "UPDATE user SET start=?,end=?,start_date=?,info=? WHERE userid = ?";  
	            ps=conn.prepareStatement(sql);  
	             
	            ps.setString(1,user.getStart());
	            ps.setString(2,user.getEnd());
	            ps.setString(3,user.getDatemonth()+user.getDateday());
	            ps.setString(5,user.getUsername());
	            
	            
	            sql = "Select userid from user where info = ?";
	            while (true){
		            final long l = System.currentTimeMillis();
		            i = (int)( l % 10000 );
		            ps1=conn.prepareStatement(sql);
		            ps1.setString(1, Integer.toString(i));
		            rs = ps1.executeQuery();
		            String judge = "";
		            while(rs.next()){
		                	judge = rs.getString("userid");
		            }
		            if (judge.equals("")){
		            	break;
		            }
	            }     
	            ps.setString(4,Integer.toString(i));
	            ps.executeUpdate();  
	            ps.close();
            }
        }catch(Exception e){  
        e.printStackTrace(); 
        return false;
        }finally{  
            try{  
                conn.close();  
            }catch(SQLException e){  
                e.printStackTrace();  
            }  
        }  
  
     return true;  
}  
    
    //注册用户
    public boolean Insert(User user){
        Connection conn = null;  
        PreparedStatement ps = null; 

        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database,user_name,user_password);  
            String sql=  
                    "insert into user(userid,userpass,usersex,userage,flag)values(?,?,?,?,?)";  
            ps=conn.prepareStatement(sql);  
            ps.setString(1,user.getUsername());  
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getUsersex());
            ps.setString(4,user.getUserage());
            ps.setInt(5, 0);
            ps.executeUpdate();  
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
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database,user_name,user_password);  
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
            
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database,user_name,user_password);  
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
             Class.forName("com.mysql.jdbc.Driver");  
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database,user_name,user_password);  
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
        ResultSet rs;
        int i;
        String temp = "",name = "",start="",end="",start_date="";
        try{  
       	 	System.out.println("connecte Sql");
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database,user_name,user_password);  
            String sql=  
                    "select * from user where userid = ?";  
            ps=conn.prepareStatement(sql);
            ps.setString(1,Leadname); 
            ResultSet rsl = ps.executeQuery();
            
            while(rsl.next()) {
            	temp = rsl.getString("info");
            	name = rsl.getString("userid");
            	start = rsl.getString("start");
            	end = rsl.getString("end");
            	start_date = rsl.getString("start_date");
            }
            
            user.setInfo(temp);
            if (temp == null){
            	PreparedStatement ps1=null;
            	System.out.println("1");
            	sql = "Select userid from user where info = ?";
                while (true){
    	            final long l = System.currentTimeMillis();
    	            i = (int)( l % 10000 );
    	            ps1=conn.prepareStatement(sql);
    	            ps1.setString(1, Integer.toString(i));
    	            rs = ps1.executeQuery();
    	            String judge = "";
    	            while(rs.next()){
    	                	judge = rs.getString("userid");
    	            }
    	            if (judge.equals("")){
    	            	break;
    	            }
                }
                System.out.println("2");
            	sql = "UPDATE user SET start = ?,end = ?, start_date = ? ,info = ? WHERE userid = ?";
        		ps1=conn.prepareStatement(sql);
        		ps1.setString(1,start);
        		ps1.setString(2,end);
        		ps1.setString(3,start_date);
        		
                ps1.setString(4,Integer.toString(i));
                ps1.setString(5,user.getUsername());
                ps1.executeUpdate();
                
                System.out.println("3");
                PreparedStatement ps2=null;
                sql = "UPDATE user SET info = ? WHERE userid = ?";
        		ps2=conn.prepareStatement(sql);
                ps2.setString(1,Integer.toString(i));
                ps2.setString(2,name);
                ps2.executeUpdate();
        		
                user.setInfo(user.getUsername());
        		return true;
        	}else {
        		PreparedStatement ps3=null;
        		sql = "UPDATE user SET info = ? WHERE userid = ?";
        		ps3=conn.prepareStatement(sql);
                ps3.setString(1,temp);
                ps3.setString(2,user.getUsername());
                ps3.executeUpdate();
                ps3.close();
                System.out.println("4");
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
    
    public boolean Match_Map(User user,ArrayList<User_info_more> User_mate){
    	Connection conn=null;  
        PreparedStatement ps=null;  
       
        
        ArrayList<User_info_more> dellist = new ArrayList<User_info_more>();
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database,user_name,user_password);  
            String sql=  "select * from user where start = ? and end = ?  and flag = 0";  
            ps=conn.prepareStatement(sql);  
            ps.setString(1,user.getStart());  
            ps.setString(2,user.getEnd());
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
            	String userdate = rs.getString("start_date");

            	//System.out.println(username);
            	//System.out.println(usersex);
            	
            	User_mate.add(new User_info_more(username,usersex,userage,userdate.substring(2, 4),userdate.substring(0, 2)));
            	
            }
            for (User_info_more tmp : User_mate) {  
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
}
