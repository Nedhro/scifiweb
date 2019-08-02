/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserDao;

/**
 *
 * @author nidhro
 */
public class RegisterController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            //out.println("<h1>Hello Java</h1>");
            String name = req.getParameter("inputName");
            String email = req.getParameter("inputEmail");
            String password = req.getParameter("inputPassword");
            String mobile = req.getParameter("inputMobile");
            List errorList = new LinkedList();
            if (name.length() == 0) {
                errorList.add("Enter your valid Name");
            }
            if (email.length() == 0) {
                errorList.add("Enter your valid Email Address");
            }
            if (password.length() == 0) {
                errorList.add("Enter your password");
            }
            if (mobile.length() == 0) {
                errorList.add("Enter your National ID number");
            }
            req.setAttribute("Errors", errorList);
            if (!errorList.isEmpty()) {
                res.sendRedirect("registration.jsp");
            }

//            if (input > 0) {
//                res.sendRedirect("login.jsp");
//            } else {
//                res.sendRedirect("registration.jsp");
//            }
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || mobile.isEmpty()) {
                RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
                out.println("<font color=red>Please fill all the fields</font>");
                rd.include(req, res);
            } else {
                UserDao user = new UserDao(name, email, password, mobile);
                req.setAttribute("UserDao", user);
                user.insertUser();

                RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                rd.forward(req, res);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
