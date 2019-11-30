/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist.bit.foodybag.controllers;

import edu.kist.bit.foodybag.entity.Users;
import edu.kist.bit.foodybag.services.UsersJpaController;
import edu.kist.bit.foodybag.utils.FileUploadDTO;
import edu.kist.bit.foodybag.utils.FileUploadUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "SignupController", urlPatterns = {"/signup"})
@MultipartConfig
public class SignupController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("foodybagemf");
        UsersJpaController userJpaController = new UsersJpaController(emf);
        String first_Name,last_Name,address,contact,email,password;        

        
         FileUploadDTO fileUploadDTO = FileUploadUtil.fileUpload(request, response, "file");
        String photo = fileUploadDTO.getFileName();

        first_Name = request.getParameter("first_name");
        last_Name = request.getParameter("last_name");
        address = request.getParameter("address");
        contact = request.getParameter("contact");

        email = request.getParameter("email");
        password = request.getParameter("pass");
        address = request.getParameter("address");
        contact = request.getParameter("contact");                  
        
        
            Users user = new Users();
  
            
                user.setImg(photo);
            
  
            
            user.setFirstName(first_Name);
            user.setLastName(last_Name);
            user.setAddress(address);
            user.setContact(new Long(contact));


            
            user.setEmail(email);
            user.setPassword(password);
          //  user.setStatus(email);
            user.setStatus("active");
            user.setRole("customer");
            System.out.println(user);
            userJpaController.create(user);
            
          request.getRequestDispatcher("index.jsp").forward(request, response);  
//        Users user = new Users();
//        user.setFname(request.getParameter("fname"));
//        user.setLname(request.getParameter("lname"));
//        user.setAddress(request.getParameter("address"));
//        user.setUsername(request.getParameter("username"));
//        user.setPassword(request.getParameter("password"));
//        user.setGender(request.getParameter("gender"));
//        user.setCity(request.getParameter("city"));
//        user.setState(request.getParameter("state"));
//        user.setCountry(request.getParameter("country"));
//        user.setPhone(request.getParameter("phone"));
//        userJpaController.create(user);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
          String signUpURL = "./signup.jsp";      
        
        dispatchRequest(request, response, signUpURL);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void dispatchRequest(HttpServletRequest request, HttpServletResponse response, String signUpURL) throws ServletException, IOException 
    {
        request.getRequestDispatcher(signUpURL).forward(request, response);
    }

}
