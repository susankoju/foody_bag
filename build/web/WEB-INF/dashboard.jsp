<%-- 
    Document   : dashboard
    Created on : Nov 19, 2019, 10:22:20 AM
    Author     : Dell
--%>

<div id="fh5co-type" style="background-image: url(images/slide_3.jpg);" data-stellar-background-ratio="0.5">
            <div class="fh5co-overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="to-animate ">
                        <div class="row text-center fh5co-heading row-padded" >
                            <h2 class="heading to-animate fadeInUp animated" style="color:white;"> What Are You Craving for? </h2>
                        </div>
                    </div>
                    <c:forEach var="foodCategory" items="${foodCategories}">
                        <div class="col-md-3 to-animate">
                            <a href="" >
                                <div class="fh5co-type" onMouseOver="this.style.border = '1px solid grey';this.style.borderRadius = '55px';" onMouseOut="this.style.border = 'none';">
                                    <h3 class="with-icon icon-${foodCategory.id}">${foodCategory.name}</h3>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                    
                </div>
            </div>
        </div>
        

