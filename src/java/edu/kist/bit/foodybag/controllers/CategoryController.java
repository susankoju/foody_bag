/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist.bit.foodybag.controllers;

import edu.kist.bit.foodybag.entity.FoodTypes;
import edu.kist.bit.foodybag.entity.Foods;
import edu.kist.bit.foodybag.services.FoodTypesJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/category"})
public class CategoryController extends HttpServlet {

            /**
             * Processes requests for both HTTP <code>GET</code> and
             * <code>POST</code> methods.
             *
             * @param request servlet request
             * @param response servlet response
             * @throws ServletException if a servlet-specific error occurs
             * @throws IOException if an I/O error occurs
             */
            protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
                        response.setContentType("text/html;charset=UTF-8");
                        
                        String id = request.getParameter("id");
                        
                        EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("foodybagemf");       
        
                       
                        FoodTypesJpaController foodType = new FoodTypesJpaController(emf);
                        FoodTypes foodTypes = foodType.findFoodTypes(Integer.parseInt(id));
                        List<Foods> foods = foodTypes.getFoodsList();
                        
                        request.setAttribute("foodList", foods);
                        
                        request.getRequestDispatcher("/WEB-INF/foods.jsp").forward(request, response);
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
                        processRequest(request, response);
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

}
