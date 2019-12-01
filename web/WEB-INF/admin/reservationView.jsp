
      
<c:if test="${role!='admin'}">
    <c:redirect url="index.jsp"/>
</c:if>
   
<c:if test="${role=='admin'}">              
    <jsp:include page="/WEB-INF/admin/sidebar.jsp"/>

</c:if>
      
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">            
              <!--overview start-->
			  <div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-laptop"></i> Reservation</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
						<li><i class="fa fa-laptop"></i>View Reservation</li>						  	
					</ol>
				</div>
			</div>
              
            <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                              Advanced Table
                          </header>
                          
                          <table class="table table-striped table-advance table-hover">
                           <tbody>
                              <tr>
                                  
                                 <th><i class="icon_pin_alt"></i> ID</th>
                                  <th><i class="icon_profile"></i> Customer Id</th>
                                  <!--
                                 <th><i class="icon_profile"></i> Full Name</th>
                                 <th><i class="icon_pin_alt"></i> Address</th>
                                    <th><i class="icon_mobile"></i> Contact</th>
                                
                                 <th><i class="icon_mail_alt"></i> Email</th>
                                  -->
                                 <th><i class="icon_mail_alt"></i> occasion</th>
                                   <th><i class="icon_mail_alt"></i> Date& Time</th>
                                 <th><i class="icon_mobile"></i> Message</th>
                                 <th><i class="icon_cogs"></i> Action</th>
                              </tr>
                              
                                <c:forEach var="reserve" items="${reserves}">
												
                              <tr>
                                <td>${reserve.id}</td>
                                
                                
                                 <td>${reserve.userId} </td>
                              
                                
                                 <td>${reserve.ocation}</td>
                                 <td>${reserve.time}</td>
                                 <td>${reserve.message}</td>
                                 <td>
                                  <div class="btn-group">
                                      <a class="btn btn-primary" href="#"><i class="icon_plus_alt2"></i></a>
                                      <a class="btn btn-success" href="#"><i class="icon_check_alt2"></i></a>
                                      <a class="btn btn-danger" href="#"><i class="icon_close_alt2"></i></a>
                                  </div>
                                  </td>
                              </tr>
                              
                                </c:forEach>
                              
                              
                              </tbody>
                        </table>
                      </section>
                  </div>
              </div>
              
          

                  </div>
                  <div class="widget-foot">
                    <!-- Footer goes here -->
                  </div>
                </div>
              </div>
              
            </div>
                        
          </div> 
              <!-- project team & activity end -->

          </section>
          <div class="text-right">
              
        </div>
      </section>
      <!--main content end-->