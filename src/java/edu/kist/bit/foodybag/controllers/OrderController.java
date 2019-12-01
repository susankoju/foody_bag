/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist.bit.foodybag.controllers;

import edu.kist.bit.foodybag.entity.ItemsOrder;
import edu.kist.bit.foodybag.entity.Users;
import edu.kist.bit.foodybag.services.ItemsOrderJpaController;
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
@WebServlet(name = "OrderController", urlPatterns = {"/order"})
@MultipartConfig
public class OrderController extends HttpServlet {

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
        ItemsOrderJpaController itemsOrderController = new ItemsOrderJpaController(emf);
        String first_Name,last_Name,address,contact,email,password;        

        
         FileUploadDTO fileUploadDTO = FileUploadUtil.fileUpload(request, response, "file");
        String photo = fileUploadDTO.getFileName();

        first_Name = request.getParameter("first_name");
        
            ItemsOrder order = new ItemsOrder();
  
            itemsOrderController.create(order);
            
          request.getRequestDispatcher("menu.jsp").forward(request, response);  
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
          String signUpURL = "menu";      
        
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
