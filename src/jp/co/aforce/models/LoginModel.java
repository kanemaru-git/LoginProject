package jp.co.aforce.models;

import java.sql.ResultSet;
 
import jp.co.aforce.util.DBUtil;
 
public class LoginModel {
 
    /**
     * ���͂��ꂽ�f�[�^��DB�ɏ�ɑ��݂��邩�ǂ����𒲂ׂ�B
     * 
     * @param username ���[�U��
     * @param password �p�X���[�h
     * @return ���O�C������=true, ���s=false
     */
    public boolean loginCheck(String username, String password) {
        // ���s���ʂ��i�[����ϐ�
        ResultSet rs = null;
 
        try {
            // DB�ɐڑ����邽�߂̎葱
            DBUtil.makeConnection();
            DBUtil.makeStatement();
            
            // SQL�����s
            String SQL = "SELECT * FROM `users` WHERE `username`='"+username+"' AND `password`='"+password+"'";
            rs = DBUtil.execute(SQL);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
        return rs != null;
    }
}