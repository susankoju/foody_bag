
            
<div id="fh5co-type" style="background-image: url(images/slide_3.jpg);" data-stellar-background-ratio="0.5">
	<div class="fh5co-overlay"></div>
	<div class="container">
		<div class="row">
                    
                    
        <c:forEach var="foodCategory" items="${foodCategories}">
              
                
			<div class="col-md-3 to-animate">
				<a href="" >
				<div class="fh5co-type" onMouseOver="this.style.border='1px solid grey';this.style.borderRadius='55px';" onMouseOut="this.style.border='none';">
                                    <a href="category?id=${foodCategory.id}"   >
					<h3 class="with-icon icon-${foodCategory.id}">${foodCategory.name}</h3>
                                    </a>
				</div>
				</a>
			</div>
                    
        </c:forEach>
                    
                    
		</div>
	</div>
</div>

