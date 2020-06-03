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

import jp.co.aforce.beans.RegisterBean;
import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.beans.UserBean;
import jp.co.aforce.models.LoginModel;
import jp.co.aforce.models.RegisterModel;
import jp.co.aforce.models.UserModel;

@WebServlet("/RegisterServlet")
//�e�N���X�� HttpServlet ���w�肷��
@SuppressWarnings("serial") // ���ꂪ�Ȃ��� waring ���ł�
public class RegisterServlet extends HttpServlet {

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) 
       throws IOException, ServletException {

       // GET���N�G�X�g�͂��蓾�Ȃ��̂ŁA�������Ń��O�C����ʂɔ�΂�
       RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/success_register.jsp");
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
       String gender = request.getParameter("gender");
       
       // ���o�������� RegisterBean �Ɋi�[����        
       RegisterBean register = new RegisterBean();
       register.setUsername(username);
       register.setPassword(password);
       register.setGender(gender);
       
       String forward_jsp = "/views/register.jsp";

       if((username != "") && (password != "")) {

       // ���f�����C���X�^���X������
       RegisterModel registerModel = new RegisterModel();
       
       //SQL���s
       registerModel.Register(username, password, gender);
       
       request.setAttribute("register", register);
       
       forward_jsp = "/views/success_register.jsp";
       }else {
    	   register.setEmsg("�y�K�{�z�����͂���Ă��܂���B");
           request.setAttribute("register", register);
       }
       // forwaed_jsp �ɐݒ肳��Ă���JSP�փf�B�X�p�b�`
       RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
       rDispatcher.forward(request, response);      
       
   }
}