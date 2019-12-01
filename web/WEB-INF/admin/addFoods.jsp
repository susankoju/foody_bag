
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
					<h3 class="page-header"><i class="fa fa-laptop"></i> Food</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="dashboard">Home</a></li>
						<li><i class="fa fa-laptop"></i>Add Food</li>						  	
					</ol>
				</div>
			</div>
              
           
		<div class="panel-body">
                    <form class="form-horizontal " method="POST" action="addFood" enctype='multipart/form-data'>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Food Name</label>
                                      <div class="col-sm-10">
                                          <input name="name" type="text" class="form-control">
                                      </div>
                                  </div>
                                   <div class="form-group">
                                      <label class="col-sm-2 control-label">Category Name</label>
                                      
                                      <!--
                                          <input name="category_id" type="number" class="form-control">
                                      -->
                                      
                                      <div class="col-sm-10">
                                      <select name="category_id" class="form-control">
                                                             <c:forEach var="type" items="${foodList}">
                                              <option value="${type.id}" >${type.name}</option>
                                                             </c:forEach>
                                          </select>
                                      </div>
                                                             
                                  </div>
                         
                          <div class="form-group">
                                      <label class="col-sm-2 control-label">Size</label>
                                      <div class="col-sm-10">
                                          <input name="size" type="text" class="form-control">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Price</label>
                                      <div class="col-sm-10">
                                          <input name="price" type="number" class="form-control">
                                      </div>
                                  </div>
                         
                         <div class="form-group">
                                      <label class="col-sm-2 control-label">Image</label>
                                      <div class="col-sm-10">
                                          <input class="input100" type="file" name="file" >
						<span class="focus-input100"></span>
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
      <!--main content end-->
 