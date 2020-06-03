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
//親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class RegisterServlet extends HttpServlet {

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) 
       throws IOException, ServletException {

       // GETリクエストはあり得ないので、無条件でログイン画面に飛ばす
       RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/success_register.jsp");
       rDispatcher.forward(request, response);      
   }

   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) 
       throws IOException, ServletException {

       // 文字のエンコードを UTF-8 とする。これがないと文字化け。        
       request.setCharacterEncoding("UTF-8");
       
       // ユーザによって入力された情報を取り出す
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       String gender = request.getParameter("gender");
       
       // 取り出した情報を RegisterBean に格納する        
       RegisterBean register = new RegisterBean();
       register.setUsername(username);
       register.setPassword(password);
       register.setGender(gender);
       
       String forward_jsp = "/views/register.jsp";

       if((username != "") && (password != "")) {

       // モデルをインスタンス化する
       RegisterModel registerModel = new RegisterModel();
       
       //SQL実行
       registerModel.Register(username, password, gender);
       
       request.setAttribute("register", register);
       
       forward_jsp = "/views/success_register.jsp";
       }else {
    	   register.setEmsg("【必須】が入力されていません。");
           request.setAttribute("register", register);
       }
       // forwaed_jsp に設定されているJSPへディスパッチ
       RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
       rDispatcher.forward(request, response);      
       
   }
}