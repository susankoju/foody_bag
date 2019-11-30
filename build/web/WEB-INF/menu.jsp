<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <c:forEach var="food" items="${menus}">
            <h2> Name: ${food.name}</h2>
            <p> Type: ${food.typeId.name} $ ${food.price} </p>
        </c:forEach>
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
								<li>
									<div class="fh5co-food-desc">
										<figure>
											<img src="images/res_img_5.jpg" class="img-responsive" alt="Free HTML5 Templates by FREEHTML5.co">
										</figure>
										<div>
											<h3>Pineapple Juice</h3>
											<p>Far far away, behind the word mountains.</p>
										</div>
									</div>
									<div class="fh5co-food-pricing">
										$17.50
									</div>
								</li>
								<li>
									<div class="fh5co-food-desc">
										<figure>
											<img src="images/res_img_6.jpg" class="img-responsive" alt="Free HTML5 Templates by FREEHTML5.co">
										</figure>
										<div>
											<h3>Green Juice</h3>
											<p>Far far away, behind the word mountains.</p>
										</div>
									</div>
									<div class="fh5co-food-pricing">
										$7.99
									</div>
								</li>
								<li>
									<div class="fh5co-food-desc">
										<figure>
											<img src="images/res_img_7.jpg" class="img-responsive" alt="Free HTML5 Templates by FREEHTML5.co">
										</figure>
										<div>
											<h3>Soft Drinks</h3>
											<p>Far far away, behind the word mountains.</p>
										</div>
									</div>
									<div class="fh5co-food-pricing">
										$12.99
									</div>
								</li>
								<li>
									<div class="fh5co-food-desc">
										<figure>
											<img src="images/res_img_5.jpg" class="img-responsive" alt="Free HTML5 Templates by FREEHTML5.co">
										</figure>
										<div>
											<h3>Carlo Rosee Drinks</h3>
											<p>Far far away, behind the word mountains.</p>
										</div>
									</div>
									<div class="fh5co-food-pricing">
										$12.99
									</div>
								</li>
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
