package jp.co.aforce.models;

import jp.co.aforce.util.DBUtil;

public class RegisterModel {
	
	public void Register(String username, String password,String gender) {
      
		try {
            // DBに接続するための手続
            DBUtil.makeConnection();
            DBUtil.makeStatement();
           
            
            // SQLを実行
            String SQL = "INSERT INTO `users` (username,password,gender) VALUES ('"+username+"','"+password+"','"+gender+"')";
            DBUtil.executeUpdate(SQL);
            
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
        
    }

}
