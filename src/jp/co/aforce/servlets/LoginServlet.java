package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.beans.UserBean;
import jp.co.aforce.models.LoginModel;
import jp.co.aforce.models.UserModel;

@WebServlet("/LoginServlet")
//�e�N���X�� HttpServlet ���w�肷��
@SuppressWarnings("serial") // ���ꂪ�Ȃ��� waring ���ł�
public class LoginServlet extends HttpServlet {

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) 
       throws IOException, ServletException {

       // GET���N�G�X�g�͂��蓾�Ȃ��̂ŁA�������Ń��O�C����ʂɔ�΂�
       RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
       rDispatcher.forward(request, response);      
   }

   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) 
       throws IOException, ServletException {

       // �����̃G���R�[�h�� UTF-8 �Ƃ���B���ꂪ�Ȃ��ƕ��������B        
       request.setCharacterEncoding("UTF-8");

       // ���[�U�ɂ���ē��͂��ꂽ�������o��
       String username = request.getParameter("username");
       String password = request.getParameter("password");

       // ���o�������� loginBean �Ɋi�[����        
       LoginBean loginBean = new LoginBean();
       loginBean.setUsername(username);
       loginBean.setPassword(password);

       // ���f�����C���X�^���X������
       LoginModel loginModel = new LoginModel();
       String forward_jsp = "/views/login.jsp";

       // ���͂��ꂽ���DB�ɑ��݂��邩���ׂ�
       if (loginModel.loginCheck(username, password)) {

           // TODO �����̓I���W�i���������l���� ����
           // ��j���O�C���������[�U�̏���\������
           //// DB��ɂ���S�Ẵ��[�U�����擾
           UserModel userModel = new UserModel();
            List<UserBean> users = userModel.getAllUsers();
           // TODO �����̓I���W�i���������l���� ����

           // ���N�G�X�g�I�u�W�F�N�g�ɐݒ�
           request.setAttribute("users", users);

    	   //���[�U����ݒ�
    	   request.setAttribute("username",loginBean);
           // ���O�C���ɐ���������� JSP ���w��            
           forward_jsp = "/views/success.jsp";

       // ���O�C�������s�����Ƃ��̏���
       } else {
           // �G���[���b�Z�[�W��ݒ�
           loginBean.setEmsg("���[�U���܂��̓p�X���[�h���Ⴂ�܂�");
           request.setAttribute("loginBean", loginBean);
       }
       // forwaed_jsp �ɐݒ肳��Ă���JSP�փf�B�X�p�b�`
       RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
       rDispatcher.forward(request, response);      
       
   }
}