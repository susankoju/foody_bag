/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist.bit.foodybag.controllers;


import edu.kist.bit.foodybag.entity.Events;
import edu.kist.bit.foodybag.entity.FoodTypes;
import edu.kist.bit.foodybag.entity.Foods;
import edu.kist.bit.foodybag.entity.ItemsOrder;
import edu.kist.bit.foodybag.entity.Ratings;
import edu.kist.bit.foodybag.entity.Reservation;
import edu.kist.bit.foodybag.entity.Users;
import edu.kist.bit.foodybag.services.EventsJpaController;
import edu.kist.bit.foodybag.services.FoodTypesJpaController;
import edu.kist.bit.foodybag.services.FoodsJpaController;
import edu.kist.bit.foodybag.services.ItemsOrderJpaController;
import edu.kist.bit.foodybag.services.RatingsJpaController;
import edu.kist.bit.foodybag.services.ReservationJpaController;
import edu.kist.bit.foodybag.services.UsersJpaController;
import edu.kist.bit.foodybag.services.exceptions.IllegalOrphanException;
import edu.kist.bit.foodybag.services.exceptions.NonexistentEntityException;
import edu.kist.bit.foodybag.utils.FileUploadDTO;
import edu.kist.bit.foodybag.utils.FileUploadUtil;
import java.io.IOException;
import java.util.Date;
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



@WebServlet(name = "AdminController", urlPatterns = {"/addUser", "/addFood", "/addCategories", "/categories","/addEventsForm","/addEvents",
    "/adminDashboard", "/updateUser", "/manageUsers", "/deleteUsers","/deleteEvent","/deleteFood", "/addFoodForm","/reservationView", "/updateFood","/updateFoodPost",
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

        String redirectURL="login.jsp", ref;
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
                        
                        
                 FoodTypesJpaController foodType = new FoodTypesJpaController(emf);
                        List<FoodTypes> foods = foodType.findFoodTypesEntities();
                        
                        request.setAttribute("foodList", foods);
                
                        
                redirectURL = "/WEB-INF/admin/addFoods.jsp";
                
                
                        dispatchRequest(request, response, redirectURL);
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
            case "/addEvents":
                          
                        EventsJpaController eventjpaController = new EventsJpaController(emf);
                        Events event = new Events();
                        
                        event.setTitle(request.getParameter("name"));
                        event.setDescription(request.getParameter("description"));
                        //event.setTime(request.getParameter("time"));
                        event.setTime(new Date());
                        eventjpaController.create(event);
                redirectURL = "events";
                break;
            case "/categories":
                        
                redirectURL = "/WEB-INF/admin/addCategories.jsp";
                break;
            case "/addEventsForm":
                        redirectURL = "/WEB-INF/admin/addEvents.jsp";
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

            case "/reservationView":
                        ReservationJpaController reserveJpa = new ReservationJpaController(emf);
                        List<Reservation> reserves = reserveJpa.findReservationEntities();

                        request.setAttribute("reserves", reserves);
                        String URL = "/WEB-INF/admin/reservationView.jsp";
                        dispatchRequest(request, response, URL);
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

            case "/deleteEvent":
                ref = request.getParameter("id");
                try {
                    eventjpaController = new EventsJpaController(emf);
                    eventjpaController.destroy(Integer.parseInt(ref));
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
                redirectURL = "events";
                break;

            case "/deleteFood":
                ref = request.getParameter("id");
                
                try {                            
                    FoodsJpaController foodJpaController = new FoodsJpaController(emf);
                    try {
                                foodJpaController.destroy(Integer.parseInt(ref));
                    } catch (IllegalOrphanException ex) {
                                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
                redirectURL = "menu";
                break;
                
            case "/updateFood":
                ref = request.getParameter("id");
                 FoodsJpaController foodJpaController = new FoodsJpaController(emf);
                Foods fd =foodJpaController.findFoods(Integer.parseInt(ref));
               
                request.setAttribute("food", fd);
                
                
                  foodType = new FoodTypesJpaController(emf);
                     foods = foodType.findFoodTypesEntities();
                        
                        request.setAttribute("foodList", foods);             
            
                redirectURL = "/WEB-INF/admin/updateFood.jsp";
                break;

            case "/updateFoodPost":        
                                              
                        
                                 
            foodjpaController = new FoodsJpaController(emf);
            foodTypejpaController = new FoodTypesJpaController(emf);
            food = new Foods();
            String id = request.getParameter("id");
             food.setId(Integer.parseInt(id));
             food.setName(request.getParameter("name"));
             food.setPrice(Long.valueOf(request.getParameter("price")));
             food.setSize(request.getParameter("size"));
             food.setTypeId(foodTypejpaController.findFoodTypes(Integer.parseInt(request.getParameter("category_id"))));
                        ItemsOrderJpaController jpc =new ItemsOrderJpaController(emf);
                        RatingsJpaController rjpc = new RatingsJpaController(emf);
                        
             List<ItemsOrder> io = jpc.findItemsOrderEntities();
             List<Ratings> ra = rjpc.findRatingsEntities();
             
             food.setRatingsList(ra);
             food.setItemsOrderList(io);
        
                fileUploadDTO = FileUploadUtil.fileUpload(request, response, "file");
                photo = fileUploadDTO.getFileName();

                food.setImg(photo);
        
                    try {
                                foodjpaController.edit(food);
                    } catch (NonexistentEntityException ex) {
                                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
                redirectURL = "/menu";

                        
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
