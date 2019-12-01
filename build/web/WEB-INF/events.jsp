<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
	
<div id="fh5co-events" data-section="events" style="background-image: url(images/slide_2.jpg);" data-stellar-background-ratio="0.5">
                <div class="fh5co-overlay"></div>
			<div class="container">
				<div class="row text-center fh5co-heading row-padded">
					<div class="col-md-8 col-md-offset-2 to-animate">
						<h2 class="heading">Upcoming Events</h2>
						<p class="sub-heading">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
					</div>
				</div>
				<div class="row">
                                        <c:forEach var="event" items="${events}">
                                            <div class="col-md-4">

                                                    <div class="fh5co-event to-animate-2">
                                                            <h3>${event.title}</h3>
                                                            <span class="fh5co-event-meta">${event.time}</span>
                                                            <p>${event.description}</p>
                                                            
<c:if test="${role=='admin'}">              
   <p><a href="deleteEvent?id=${event.id}" class="btn btn-primary btn-outline">Delete</a></p>

</c:if>
   <c:if test="${role!='admin'}">              
  <p><a href="#" class="btn btn-primary btn-outline">Read More</a></p>

</c:if>
                                                    </div>
                                            </div>
                                        </c:forEach>>
				</div>
			</div>
		</div>

		

</div>

		
