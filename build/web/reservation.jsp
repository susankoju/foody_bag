<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ include file="./WEB-INF/jspf/header.jspf"%>


<div id="fh5co-contact" data-section="reservation">
			<div class="container">
				<div class="row text-center fh5co-heading row-padded">
					<div class="col-md-8 col-md-offset-2">
						<h2 class="heading to-animate">Reserve a Table</h2>
						<p class="sub-heading to-animate">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 to-animate-2">
						<h3>Contact Info</h3>
						<ul class="fh5co-contact-info">
							<li class="fh5co-contact-address ">
								<i class="icon-home"></i>
								Kamalpokhari,Kathmandu <br>Nepal
							</li>
							<li><i class="icon-phone"></i> (123) 465-6789</li>
							<li><i class="icon-envelope"></i>foodybag@gmail.com</li>
							<li><i class="icon-globe"></i> <a href="http://foodbag.com/" target="_blank">foodybag.com</a></li>
						</ul>
					</div>
                                    
                                    <form method="POST" action="./reservation">
					<div class="col-md-6 to-animate-2">
						<h3>Reservation Form</h3>
                                                <c:if test="${!empty sessionScope.loggedInUser}">
                                                    <div class="form-group " style="display:none;border:1px solid black;">
                                                            <label for="name" class="sr-only">Name</label>
                                                            <input id="number" name="user_id" class="form-control" value="${sessionScope.loggedInUser.id}" type="text">
                                                    </div>
                                                    <div class="form-group">
                                                            <label for="occation" class="sr-only">Occation</label>
                                                            <select required name="ocation" class="form-control" id="occation">
                                                                    <option>Select an Occation</option>
                                                              <option>Wedding Ceremony</option>
                                                              <option>Birthday</option>
                                                              <option>Others</option>
                                                            </select>
                                                    </div>
                                                    <div class="form-group ">
                                                            <label for="date" class="sr-only">Date</label>
                                                            <input required type="date" name="date" class="form-control" placeholder="Date &amp; Time" >
                                                    </div>



                                                    <div class="form-group ">
                                                            <label for="message" class="sr-only">Message</label>
                                                            <textarea name="message" id="message" cols="30" rows="5" class="form-control" placeholder="Message"></textarea>
                                                    </div>
                                                    <div class="form-group ">
                                                            <input type="submit" class="btn btn-primary" value="Send Message" type="submit">
                                                    </div>
                                                </c:if>
                                                
                                                <c:if test="${empty sessionScope.loggedInUser}">      
                                                    For reservation please, <a href="./login.jsp"> Log In </a>   
                                                </c:if>
					</div>
                                    </form>
				</div>
                            
                            
                            <c:if test="${!empty sessionScope.loggedInUser}">      
                                                          
				<div class="row text-center fh5co-heading row-padded">
					<div class="col-md-8 col-md-offset-2">
						<h2 class=" to-animate">Your Reservation </h2>
                                                
                                              
                                                
            <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          
                          <table class="table table-striped table-advance table-hover">
                           <tbody>
                              <tr>
                                  
                                
                                 <th><i class="icon_mail_alt"></i> occasion</th>
                                   <th><i class="icon_mail_alt"></i> Date& Time</th>
                                 <th><i class="icon_mobile"></i> Message</th>
                                 <th><i class="icon_cogs"></i> Action</th>
                              </tr>
                              <tr>
                                
                                  
                                 <td>Rosser</td>
                                 
                                  <td>Rosser</td>
                                 <td>gdfhjsnj</td>
                                 <td>
                                  <div class="btn-group">
                                      <a class="btn btn-primary" href="#"><i class="icon_plus_alt2"></i></a>
                                      <a class="btn btn-success" href="#"><i class="icon_check_alt2"></i></a>
                                      <a class="btn btn-danger" href="#"><i class="icon_close_alt2"></i></a>
                                  </div>
                                  </td>
                              </tr>
                              </tbody>
                        </table>
                      </section>
                  </div>
              </div>
					</div>
				</div>
                            </c:if>
			</div>
		</div>

		
	</div>
		



<%@ include file="./WEB-INF/jspf/footer.jspf"%>
