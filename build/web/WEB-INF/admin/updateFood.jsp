
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
						<li><i class="fa fa-laptop"></i>Edit Food</li>						  	
					</ol>
				</div>
			</div>
              
           
		<div class="panel-body">
                    <form class="form-horizontal " method="POST" action="updateFoodPost" enctype='multipart/form-data'>
                                  <div class="form-group" style="display: hidden;">
                                      <label class="col-sm-2 control-label">Food id</label>
                                      <div class="col-sm-10">
                                          <input name="id" type="number" value="${food.id}" class="form-control">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Food Name</label>
                                      <div class="col-sm-10">
                                          <input name="name" type="text" value="${food.name}" class="form-control">
                                      </div>
                                  </div>
                                   <div class="form-group">
                                      <label class="col-sm-2 control-label">Category Name</label>
                                      <div class="col-sm-10">
                                          
                                          <select name="category_id" class="form-control">
                                              <option value="${food.typeId.id}" selected>${food.typeId.name}</option>
                                                             <c:forEach var="type" items="${foodList}">
                                              <option value="${type.id}" >${type.name}</option>
                                                             </c:forEach>
                                          </select>
                                      </div>
                                  </div>
                         
                          <div class="form-group">
                                      <label class="col-sm-2 control-label">Size</label>
                                      <div class="col-sm-10">
                                          <input name="size" type="text" value="${food.size}"  class="form-control">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Price</label>
                                      <div class="col-sm-10">
                                          <input name="price" type="number" value="${food.price}"  class="form-control">
                                      </div>
                                  </div>
                         
                         <div class="form-group">
                                      <label class="col-sm-2 control-label">Image</label>
                                      <div class="col-sm-10">
                                          <input class="input100" value="${food.img}"  type="file" name="file" >
						<span class="focus-input100"></span>
                                      </div>
						
                                  </div>
                         
                         
                         
                         
                         
			
          

               <div class="panel-body">
                   <input type="submit" value="Update" class="btn btn-primary" >
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
 