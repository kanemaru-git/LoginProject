package jp.co.aforce.models;

import jp.co.aforce.util.DBUtil;

public class RegisterModel {
	
	public void Register(String username, String password,String gender) {
      
		try {
            // DBÇ…ê⁄ë±Ç∑ÇÈÇΩÇﬂÇÃéËë±
            DBUtil.makeConnection();
            DBUtil.makeStatement();
           
            
            // SQLÇé¿çs
            String SQL = "INSERT INTO `users` (username,password,gender) VALUES ('"+username+"','"+password+"','"+gender+"')";
            DBUtil.executeUpdate(SQL);
            
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
        
    }

}
