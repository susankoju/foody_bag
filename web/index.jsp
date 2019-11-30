<%@page session="true" %>




	<div id="fh5co-container">



<div id="fh5co-home" class="js-fullheight animated " data-section="home" style="height: 486px;">
	
		<div class="flexslider">
				
				<div class="fh5co-overlay" style="opacity: 0.6992;"></div>
				<div class="fog-overlay"></div>
				<div class="fh5co-text" style="opacity: -0.328; margin-top: 186.4px; display: none;">
					<div class="container">
						<div class="row">
							<h1 class="to-animate fadeInUp animated" style="font-size:150px;margin-bottom:25px">foody bag</h1>
							<h2 class="to-animate fadeInUp animated" style=";margin-bottom:45px">The pleasure of variety at your place, <span id="txtLabel"></span><label id="cursor">|</label></h2>
							<h3 class="to-animate fadeInUp animated">
								<a href="./menu" class="special-button">See Menu</a>
							</h3>
						</div>
					</div>
				</div>
			  	<ul class="slides">
			   	<li style="background-image: url(&quot;images/slide_1.jpg&quot;); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 1; display: block; z-index: 2; height: 486px; background-position: 0px 199.2px;" data-stellar-background-ratio="0.5" class="flex-active-slide" data-thumb-alt=""></li>
			   	<li style="background-image: url(&quot;images/slide_2.jpg&quot;); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; height: 486px; background-position: 0px 199.2px;" data-stellar-background-ratio="0.5" data-thumb-alt="" class=""></li>
			   	<li style="background-image: url(&quot;images/slide_3.jpg&quot;); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; height: 486px; background-position: 0px 199.2px;" data-stellar-background-ratio="0.5" data-thumb-alt="" class=""></li>
			  	</ul>

			<ol class="flex-control-nav flex-control-paging"><li><a href="#" class="flex-active">1</a></li><li><a href="#" class="">2</a></li><li><a href="#" class="">3</a></li></ol><ul class="flex-direction-nav"><li class="flex-nav-prev"><a class="flex-prev" href="#">Previous</a></li><li class="flex-nav-next"><a class="flex-next" href="#">Next</a></li></ul></div>
			
		</div>
</div>

<!--
	<div class="js-sticky">
				<div class="fh5co-main-nav">
					<div class="container-fluid">
						<div class="fh5co-menu-1">
							<a href="./index.html" data-nav-section="home">Home</a>
							<a href="./about.html" data-nav-section="about">About</a>
							<a href="./features.html" data-nav-section="features">Features</a>
						</div>
						<div class="fh5co-logo">
							<a href="index.html" id="nav-logo">foody bag</a>
						</div>
						<div class="fh5co-menu-2">
							<a href="./menu.html" data-nav-section="menu">Menu</a>
							<a href="./events.html" data-nav-section="events">Events</a>
							<a href="./reservation.html" data-nav-section="reservation">Reservation</a>
                                                        <a href="./login.jsp"> Log In </a>
						</div>
					</div>
					
				</div>
			</div>


-->
<div id="fh5co-type" style="background-image: url(images/slide_3.jpg);" data-stellar-background-ratio="0.5">
	<div class="fh5co-overlay"></div>
	<div class="container">
		<div class="row">
			<div class="to-animate ">
				<div class="row text-center fh5co-heading row-padded" >
					<h2 class="heading to-animate fadeInUp animated" style="color:white;"> What Are You Craving for? </h2>
				</div>
			</div>
			<div class="col-md-3 to-animate">
				<a href="" >
				<div class="fh5co-type" onMouseOver="this.style.border='1px solid grey';this.style.borderRadius='55px';" onMouseOut="this.style.border='none';">
					<h3 class="with-icon icon-1">Fruits</h3>
				</div>
				</a>
			</div>
			<div class="col-md-3 to-animate">
				<a href="" class="hover-color">
				<div class="fh5co-type" onMouseOver="this.style.border='1px solid grey';this.style.borderRadius='55px';" onMouseOut="this.style.border='none';">
					<h3 class="with-icon icon-2">Sea food</h3>
				</div>
				</a>
			</div>
			<div class="col-md-3 to-animate">
				<a href="" class="hover-color">
				<div class="fh5co-type" onMouseOver="this.style.border='1px solid grey';this.style.borderRadius='55px';" onMouseOut="this.style.border='none';">
					<h3 class="with-icon icon-3">Vegetables</h3>
				</div>
				</a>
			</div>
			<div class="col-md-3 to-animate">
				<a href="" class="hover-color">
				<div class="fh5co-type" onMouseOver="this.style.border='1px solid grey';this.style.borderRadius='55px';" onMouseOut="this.style.border='none';">
					<h3 class="with-icon icon-4">Meat</h3>
				</div>
				</a>
			</div>
                    
		</div>
	</div>
</div>


	
<div id="fh5co-events"  style="background-image: url(images/slide_2.jpg);" data-stellar-background-ratio="0.5">
	<div class="fh5co-overlay"></div>
	<div class="container">
		<div class="row text-center fh5co-heading row-padded">
			<div class="col-md-8 col-md-offset-2 to-animate">
				<h2 class="heading">Can't Decide?</h2>
				<p class="sub-heading"> Let The Fortune Wheel Decide! </p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 to-animate-2">
				<canvas id="fortuneCanvas" style="width:70vw; height:70vh;">Opps! Your browser does't support Canvas.</canvas>
			</div>
			<div class="col-md-4" style="margin-top:5vh">
				<div class="fh5co-event to-animate-2" >
					<h3 id="fortuneFoodName"></h3>
					<span class="fh5co-event-meta">$ 100.00</span>
					<p id="fortuneFoodDescription"></p>
					<p><a href="menu.html" class="btn btn-primary btn-outline">Show Menu</a></p>
				</div>
			</div>
		</div>
		<div class="row text-center fh5co-heading row-padded">
			<div class="col-md-8 col-md-offset-2 to-animate">
				<button id="fortuneButton" onClick="spinStart();">Fortune Food</button>
			</div>
		</div>
	</div>
</div>

<section class="text-center join-us clearfix ipad-only">
            <div class="wrapper ">
                <h2>Join Us For Free</h2>
                <label>Subscribe to our free mailing list for freebies and more!</label>
                <form method="POST" action="#">
                    <input type="text" placeholder="Enter your email..." name="email">
                    <input type="submit" value="Sign Up">
                </form>
                <p>
                    We guarantee not to spam you or share your information.
                </p>
            </div>
        </section>

		
	