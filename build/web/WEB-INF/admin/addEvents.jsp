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
					<h3 class="page-header"><i class="fa fa-laptop"></i> Event</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
						<li><i class="fa fa-laptop"></i>Add Event</li>						  	
					</ol>
				</div>
			</div>
              
           
		<div class="panel-body">
                    <form class="form-horizontal " method="post" action="addEvents">
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Event Name</label>
                                      <div class="col-sm-10">
                                          <input name="name" type="text" class="form-control">
                                      </div>
                                  </div>
                                   <div class="form-group">
                                      <label class="col-sm-2 control-label">Event Date & time</label>
                                      <div class="col-sm-10">
                                          <input type="date" name="time" class="form-control">
                                      </div>
                                  </div>
                         
                          <div class="form-group">
                                      <label class="col-sm-2 control-label">Event Description</label>
                                      <div class="col-sm-10">
                                          <input name="description" type="text" class="form-control">
                                      </div>
                                  </div>
                         
                         
                         
                         
			
          

               <div class="panel-body">
                   <input type="submit" value="Add" class="btn btn-primary" >
                   <input type="cancel" value="Cancel" class="btn btn-danger" >
                             
                            </div>
                    </form>
                        
                        


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
          <div class="credits">
                <!-- 
                    All the links in the footer should remain intact. 
                    You can delete the links only if you purchased the pro version.
                    Licensing information: https://bootstrapmade.com/license/
                    Purchase the pro version form: https://bootstrapmade.com/buy/?theme=NiceAdmin
                -->
             
            </div>
        </div>
      </section>
      