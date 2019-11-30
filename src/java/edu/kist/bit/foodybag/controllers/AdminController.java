/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist.bit.foodybag.controllers;


import edu.kist.bit.foodybag.entity.FoodTypes;
import edu.kist.bit.foodybag.entity.Foods;
import edu.kist.bit.foodybag.entity.Users;
import static edu.kist.bit.foodybag.entity.Users_.contact;
import static edu.kist.bit.foodybag.entity.Users_.email;
import edu.kist.bit.foodybag.services.FoodTypesJpaController;
import edu.kist.bit.foodybag.services.FoodsJpaController;
import edu.kist.bit.foodybag.services.UsersJpaController;
import edu.kist.bit.foodybag.services.exceptions.NonexistentEntityException;
import edu.kist.bit.foodybag.utils.FileUploadDTO;
import edu.kist.bit.foodybag.utils.FileUploadUtil;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "AdminController", urlPatterns = {"/addUser", "/addFood", "/addCategories", "/categories",
    "/adminDashboard", "/updateUser", "/manageUsers", "/deleteUsers", "/addFoodForm",
    "/updateFoood"})
@MultipartConfig
public class AdminController extends HttpServlet {

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

        UsersJpaController usersjpaController = new UsersJpaController(emf);
        List<Users> userList = usersjpaController.findUsersEntities();
        Users user = new Users();

        String redirectURL, ref;
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case "/signup":
                redirectURL = "signup.jsp";
                break;
            case "/register":
                Users createUser = getFormData(request);
                FileUploadDTO fileUploadDTO = FileUploadUtil.fileUpload(request, response, "file");
                String photo = fileUploadDTO.getFileLocation();

                createUser.setImg(photo);
                usersjpaController.create(createUser);
                redirectURL = "login.jsp";

                break;

            case "/addFood":
                        
            FoodsJpaController foodjpaController = new FoodsJpaController(emf);
            FoodTypesJpaController foodTypejpaController = new FoodTypesJpaController(emf);
            Foods food = new Foods();
        
             food.setName(request.getParameter("name"));
             food.setPrice(Long.valueOf(request.getParameter("price")));
             food.setSize(request.getParameter("size"));
             food.setTypeId(foodTypejpaController.findFoodTypes(Integer.parseInt(request.getParameter("category_id"))));
             food.setName(request.getParameter("name"));
       
        
                fileUploadDTO = FileUploadUtil.fileUpload(request, response, "file");
                photo = fileUploadDTO.getFileName();

                food.setImg(photo);
                foodjpaController.create(food);
                redirectURL = "/menu";

                break;

            case "/addFoodForm":
                redirectURL = "/WEB-INF/admin/addFoods.jsp";
                break;
                
            case "/adminsignup":
                redirectURL = "/WEB-INF/admin/adminsignup.jsp";
                break;
                
            case "/addCategories":
                        
                        FoodTypesJpaController categoriesjpaController = new FoodTypesJpaController(emf);
                        FoodTypes categories = new FoodTypes();
                        String category = request.getParameter("categoryName");
                        categories.setName(category);
                        categoriesjpaController.create(categories);
                redirectURL = "/WEB-INF/admin/addCategories.jsp";
                break;
            case "/categories":
                        redirectURL = "/WEB-INF/admin/addCategories.jsp";
                break;

            case "/manageuser":
                request.setAttribute("users", userList);
                redirectURL = "/WEB-INF/admin/manageuser.jsp";
                break;

            case "/updateuserform":
                ref = request.getParameter("ref");
                user = usersjpaController.findUsers(Integer.parseInt(ref));
                request.setAttribute("users", user);
                redirectURL = "/WEB-INF/admin/updateuser.jsp";
                break;

            case "/updateuser":
                Users updateUser = getFormData(request);
                Integer userId = Integer.parseInt(request.getParameter("id"));
                FileUploadDTO fileUpdateUploadDTO = FileUploadUtil.fileUpload(request, response, "file");
                String updatePhoto = fileUpdateUploadDTO.getFileLocation();
                updateUser.setImg(updatePhoto);
                updateUser.setId(userId);
                 {
                    try {
                        usersjpaController.edit(updateUser);
                    } catch (Exception ex) {
                        Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                redirectURL = "/WEB-INF/admin/manageuser.jsp";
                response.sendRedirect("manageuser");
                break;

            case "/deleteuser":
                ref = request.getParameter("ref");
                try {
                    usersjpaController.destroy(Integer.parseInt(ref));
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
                redirectURL = "/WEB-INF/admin/manageuser.jsp";
                break;

            default:
                redirectURL = "login.jsp";
                break;

        }
        if(servletPath.equals("/updateuser")){
            return;
        }
        dispatchRequest(request, response, redirectURL);

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

    private Users getFormData(HttpServletRequest request) {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String address = request.getParameter("address");
        String email = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String contact = request.getParameter("phone");
//                String photo = fileUploadDTO.getFileLocation();

        //if (fname.isEmpty() || lname.isEmpty() || address.isEmpty() || username.isEmpty() || password.isEmpty() || gender.isEmpty() || city.isEmpty() || state.isEmpty() || country.isEmpty() || phone.isEmpty()) {
        //    request.setAttribute("errorMsg", "Please Fill all fields!!!");
        //    return;
        //} else {
        Users user = new Users();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setAddress(address);
        
        
            
            user.setContact(new Long(contact));


            
            user.setEmail(email);
            user.setPassword(password);
          //  user.setStatus(email);
            user.setStatus("active");
            user.setRole("customer");

        return user;

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

    private void dispatchRequest(HttpServletRequest request, HttpServletResponse response, String redirectURL) throws ServletException, IOException {
        request.getRequestDispatcher(redirectURL).forward(request, response);
    }

}
