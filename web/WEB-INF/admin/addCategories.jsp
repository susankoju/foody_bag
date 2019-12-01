
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
					<h3 class="page-header"><i class="fa fa-laptop"></i> Category</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="dashboard">Home</a></li>
						<li><i class="fa fa-laptop"></i>Add Category</li>						  	
					</ol>
				</div>
			</div>
              
           
		<div class="panel-body">
                    <form class="form-horizontal " method="POST" action="addCategories">
                                  <div class="form-group">
                                      <label class="col-sm-2 control-label">Category Name</label>
                                      <div class="col-sm-10">
                                          <input type="text" name="categoryName" class="form-control">
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
        </div>
      </section>