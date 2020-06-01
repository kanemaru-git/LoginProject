package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.util.DBUtil;

public class UserModel {

	public List<UserBean> getAllUsers() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		List<UserBean> usersList = new ArrayList<UserBean>();
		 
        try {
            // DBに接続するための手続
            DBUtil.makeConnection();
            DBUtil.makeStatement();
            
            //テーブル一行目をuserListに格納
            String SQL1 = "SELECT user_id,username,password,gender FROM `users` where user_id = 1";
            rs = DBUtil.execute(SQL1);
            UserBean userBean1 = new UserBean();
      	  userBean1.setUser_id(rs.getString("user_id"));
      	  userBean1.setUsername(rs.getString("username"));
      	  userBean1.setPassword(rs.getString("password"));
      	  userBean1.setGender(rs.getString("gender"));
      	  usersList.add(userBean1);
            
            
            // SQLを実行
            String SQL = "SELECT user_id,username,password,gender FROM `users`";
            rs = DBUtil.execute(SQL);
            
            //テーブル2行目から最後までuserListに格納
              while(rs.next()) {
            	  UserBean userBean = new UserBean();
            	  userBean.setUser_id(rs.getString("user_id"));
            	  userBean.setUsername(rs.getString("username"));
            	  userBean.setPassword(rs.getString("password"));
            	  userBean.setGender(rs.getString("gender"));
            	  usersList.add(userBean);
            	  System.out.println(usersList);
              }
//            while (rs.next()) {
//            	String user_id = rs.getString("user_id");
//                String username = rs.getString("username");
//                String password = rs.getString("password");
//                String gender = rs.getString("gender");
//                usersList.add(new UserBean(user_id,username,password,gender));
//            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
		return usersList;
	}

}
