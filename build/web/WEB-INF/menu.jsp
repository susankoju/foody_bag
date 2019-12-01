<%@page contentType="text/html" pageEncoding="UTF-8"%>
       
		</div>
		<div id="fh5co-menus" data-section="menu">
			<div class="container">
				<div class="row text-center fh5co-heading row-padded">
					<div class="col-md-8 col-md-offset-2">
						<h2 class="heading to-animate">Food Menu</h2>
						<p class="sub-heading to-animate">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
					</div>
				</div>
				<div class="row row-padded">
					<div class="col-md-12">
						<div class="fh5co-food-menu to-animate-2">
							<h2 class="fh5co-drinks">Tasty Foods!</h2>
							<ul>
                                                             <c:forEach var="food" items="${menus}">
								<li>
									<div class="fh5co-food-desc">
										<figure>
											<img src="./uploads/${food.img}" class="img-responsive" alt="Food Img">
										</figure>
										<div>
											<h3>${food.name}</h3>
											<p>${food.typeId.name}</p>
										</div>
									</div>
									<div class="fh5co-food-pricing">
										$ ${food.price}
									</div>
                                                                        
                                                                        
                                                                        <c:if test="${role=='admin'}">              
   <p><a href="updateFood?id=${food.id}" class="btn btn-primary btn-outline">Edit</a></p>        
   <p><a href="deleteFood?id=${food.id}" class="btn btn-danger btn-outline">Delete</a></p>

</c:if>                   
<c:if test="${role=='customer'}">              
   <p><a href="order?id=${food.id}" class="btn btn-primary btn-outline">Order</a></p>      

</c:if>
                                                                        
                                                                        
								</li>
                                                              </c:forEach>
							</ul>
						</div>
					</div>
					
				</div>
				<div class="row">
					<div class="col-md-4 col-md-offset-4 text-center to-animate-2">
						<p><a href="catMenu" class="btn btn-primary btn-outline">Category Menu</a></p>
					</div>
				</div>
			</div>
		</div>
