 <!-- Modal -->
         <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true"  id="onload">

            <div class="modal-dialog">

              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">�</button>
                  <h4 class="modal-title">Need A service?</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="profession">Enter City</label>
                                            <input type="text" id="profession" name="profession" placeholder="Ex: Car wash" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="location">Location</label>
                                            <input type="text" id="location" name="location" placeholder="Any particular location?" class="form-control">
                                        </div>
                                    </div>
                                </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Submit</button>
                </div>
              </div>

            </div>
        </div>
    <!-- Modal -->
    
    <!-- *** LOGIN MODAL ***_________________________________________________________
    -->
    
    <!-- *** LOGIN MODAL END ***-->
    <section class="job-form-section job-form-section--image">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="job-form-box">
                        <h2 class="heading">Need <span class="accent">Best</span> <span class="accent">SERVICE</span>?</h2>
                        <form id="job-main-form" method="get" action="#" class="job-main-form">
                            <div class="controls">
                                <div class="row">
                                    <div class="col-sm-5">
                                        <div class="form-group">
                                            <label for="profession">Service Type</label>
                                            <input type="text" id="profession" name="profession" placeholder="Ex: Car wash" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-sm-5">
                                        <div class="form-group">
                                            <label for="location">Location</label>
                                            <input type="text" id="location" name="location" placeholder="Any particular location?" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-sm-2">
                                        <a href="${pageContext.request.contextPath}/search" class="btn btn-primary job-main-form__button">
                                            <i class="fa fa-search"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="row">
                                    <ul class="our-services">
                                        <li>Two Wheeler</li>
                                        <li>Car Service</li>
                                        <li>Car Wash</li>
                                        <li>Wheel Balancing</li>
                                        <li>Denting and Painting</li>
                                        <li>Part Repairing</li>
                                    </ul>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section style="our-services">
        <div class="container">
            <h3 class="heading">Featured Services</h3>
            <div class="row featured same-height-row">
                <div class="col-md-4">
                    <div class="box-image-text bg-visible same-height">
                        <div class="top">
                            <a href="${pageContext.request.contextPath}/servicecenterdetail">
                                <div class="image"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="" class="img-responsive"></div>
                            </a>
                        </div>
                        <div class="content">
                            <h5><a href="${pageContext.request.contextPath}/servicecenterdetail">Car Wash</a></h5>
                            <p class="featured__details"> <i class="fa fa-map-marker job__location"></i>JAIPUR<span class="label featured__label label-success">On Time</span></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="box-image-text bg-visible same-height">
                        <div class="top">
                            <a href="${pageContext.request.contextPath}/servicecenterdetail">
                                <div class="image"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="" class="img-responsive"></div>
                            </a>
                        </div>
                        <div class="content">
                            <h5><a href="${pageContext.request.contextPath}/servicecenterdetail">Denting and Painting</a></h5>
                            <p class="featured__details"> <i class="fa fa-map-marker job__location"></i>Jaipur<span class="label featured__label label-success">On Time</span></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="box-image-text bg-visible same-height">
                        <div class="top">
                            <a href="${pageContext.request.contextPath}/servicecenterdetail">
                                <div class="image"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="" class="img-responsive"></div>
                            </a>
                        </div>
                        <div class="content">
                            <h5><a href="${pageContext.request.contextPath}/servicecenterdetail">AC Repairing</a></h5>
                            <p class="featured__details"> <i class="fa fa-map-marker job__location"></i>Ajmer<span class="label featured__label label-default">According</span></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="box-image-text bg-visible same-height">
                        <div class="top">
                            <a href="${pageContext.request.contextPath}/servicecenterdetail">
                                <div class="image"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="" class="img-responsive"></div>
                            </a>
                        </div>
                        <div class="content">
                            <h5><a href="${pageContext.request.contextPath}/servicecenterdetail">Car Service</a></h5>
                            <p class="featured__details"> <i class="fa fa-map-marker job__location"></i>JAIPUR<span class="label featured__label label-success">On Time</span></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="box-image-text bg-visible same-height">
                        <div class="top">
                            <a href="${pageContext.request.contextPath}/servicecenterdetail">
                                <div class="image"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="" class="img-responsive"></div>
                            </a>
                        </div>
                        <div class="content">
                            <h5><a href="${pageContext.request.contextPath}/servicecenterdetail">Wheel Balancing</a></h5>
                            <p class="featured__details"> <i class="fa fa-map-marker job__location"></i>Jaipur<span class="label featured__label label-success">On Time</span></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="box-image-text bg-visible same-height">
                        <div class="top">
                            <a href="${pageContext.request.contextPath}/servicecenterdetail">
                                <div class="image"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="" class="img-responsive"></div>
                            </a>
                        </div>
                        <div class="content">
                            <h5><a href="${pageContext.request.contextPath}/servicecenterdetail">Two Wheeler</a></h5>
                            <p class="featured__details"> <i class="fa fa-map-marker job__location"></i>Ajmer<span class="label featured__label label-default">According</span></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="text-center margin-top"><a href="category.html" class="btn btn-ghost">See more Services</a></div>
        </div>
    </section>
    <section style="brands-name">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="heading">Choose From a Wide Range of Brands</h2>
                    <ul class="company-logo">
                        <li>
                            <a href="#"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="AirBnb " class="img-responsive"></a>
                        </li>
                        <li>
                            <a href="#"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="AirBnb " class="img-responsive"></a>
                        </li>
                        <li>
                            <a href="#"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="AirBnb " class="img-responsive"></a>
                        </li>
                        <li>
                            <a href="#"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="AirBnb " class="img-responsive"></a>
                        </li>
                        <li>
                            <a href="#"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="AirBnb " class="img-responsive"></a>
                        </li>
                        <li>
                            <a href="#"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="AirBnb " class="img-responsive"></a>
                        </li>
                        <li>
                            <a href="#"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="AirBnb " class="img-responsive"></a>
                        </li>
                        <li>
                            <a href="#"><img src="${pageContext.request.contextPath}/resources/img/airbnb.png" alt="AirBnb " class="img-responsive"></a>
                        </li>
                    </ul>
                    <hr>
                </div>
            </div>
        </div>
    </section>
    <section style="background: #fafafa;" class="section testimonails">
        <div class="container">
            <h2 class="heading">What our customers say</h2>
            <p class="lead text-center">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
            <div class="row">
                <div class="col-md-12">
                    <ul class="owl-carousel testimonials same-height-row">
                        <li class="item">
                            <div class="testimonial same-height-always">
                                <div class="text">
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                                </div>
                                <div class="bottom">
                                    <div class="icon"><i class="fa fa-quote-left"></i></div>
                                    <div class="name-picture"><img alt="" src="${pageContext.request.contextPath}/resources/img/person-1.jpg">
                                        <h5>CLient's Name</h5>
                                        <p>POST</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="item">
                            <div class="testimonial same-height-always">
                                <div class="text">
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                                </div>
                                <div class="bottom">
                                    <div class="icon"><i class="fa fa-quote-left"></i></div>
                                    <div class="name-picture"><img alt="" src="${pageContext.request.contextPath}/resources/img/person-2.jpg">
                                        <h5>Client's Name</h5>
                                        <p>POST</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="item">
                            <div class="testimonial same-height-always">
                                <div class="text">
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                                </div>
                                <div class="bottom">
                                    <div class="icon"><i class="fa fa-quote-left"></i></div>
                                    <div class="name-picture"><img alt="" src="${pageContext.request.contextPath}/resources/img/person-3.png">
                                        <h5>Client's Name</h5>
                                        <p>POST</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="item">
                            <div class="testimonial same-height-always">
                                <div class="text">
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                                </div>
                                <div class="bottom">
                                    <div class="icon"><i class="fa fa-quote-left"></i></div>
                                    <div class="name-picture"><img alt="" src="${pageContext.request.contextPath}/resources/img/person-4.jpg">
                                        <h5>Client's Name</h5>
                                        <p>POST</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="item">
                            <div class="testimonial same-height-always">
                                <div class="text">
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. </p>
                                </div>
                                <div class="bottom">
                                    <div class="icon"><i class="fa fa-quote-left"></i></div>
                                    <div class="name-picture"><img alt="" src="${pageContext.request.contextPath}/resources/img/person-4.jpg">
                                        <h5>CLient's Name</h5>
                                        <p>POST</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <section>
        <div class="container">
            <h3 class="heading">Our Packages</h3>
            <p class="lead text-center margin-bottom--big">
                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
            </p>
            <div class="row packages">
                <div class="col-md-3">
                    <div class="package ">
                        <div class="package-header">
                            <h5>Basic</h5>
                        </div>
                        <div class="price">
                            <div class="price-container">
                                <h4><span class="currency">$</span>7</h4><span class="period">/ month</span>
                            </div>
                        </div>
                        <ul>
                            <li><i class="fa fa-check"></i>Package Service</li>
                            <li><i class="fa fa-times"></i>Package Service</li>
                            <li><i class="fa fa-times"></i>Package Service</li>
                            <li><i class="fa fa-times"></i>Package Service</li>
                            <li><i class="fa fa-times"></i>Package Service</li>
                        </ul><a href="#" class="btn btn-primary">Sign Up</a>
                    </div>
                </div>
                <!-- end col-->
                <div class="col-md-3">
                    <div class="package ">
                        <div class="package-header">
                            <h5>Standard</h5>
                        </div>
                        <div class="price">
                            <div class="price-container">
                                <h4><span class="currency">$</span>21</h4><span class="period">/ month</span>
                            </div>
                        </div>
                        <ul>
                            <li><i class="fa fa-check"></i>Package Service</li>
                            <li><i class="fa fa-check"></i>Package Service</li>
                            <li><i class="fa fa-times"></i>Package Service</li>
                            <li><i class="fa fa-times"></i>Package Service</li>
                            <li><i class="fa fa-times"></i>Package Service</li>
                        </ul><a href="#" class="btn btn-primary">Sign Up</a>
                    </div>
                </div>
                <!-- end col-->
                <div class="col-md-3">
                    <div class="package best-value">
                        <div class="package-header">
                            <h5>Premium</h5>
                            <div class="meta-text">Best Value</div>
                        </div>
                        <div class="price">
                            <div class="price-container">
                                <h4><span class="currency">$</span>53</h4><span class="period">/ month</span>
                            </div>
                        </div>
                        <ul>
                            <li><i class="fa fa-check"></i>Package Service</li>
                            <li><i class="fa fa-check"></i>Package Service</li>
                            <li><i class="fa fa-check"></i>Package Service</li>
                            <li><i class="fa fa-times"></i>Auto Backup</li>
                            <li><i class="fa fa-times"></i>Package Service</li>
                        </ul><a href="#" class="btn btn-primary">Sign Up</a>
                    </div>
                </div>
                <!-- end col-->
                <div class="col-md-3">
                    <div class="package ">
                        <div class="package-header">
                            <h5>Standard</h5>
                        </div>
                        <div class="price">
                            <div class="price-container">
                                <h4><span class="currency">$</span>99</h4><span class="period">/ month</span>
                            </div>
                        </div>
                        <ul>
                            <li><i class="fa fa-check"></i>Package Service</li>
                            <li><i class="fa fa-check"></i>Package Service</li>
                            <li><i class="fa fa-check"></i>Package Service</li>
                            <li><i class="fa fa-check"></i>Package Service</li>
                            <li><i class="fa fa-check"></i>Package Service</li>
                        </ul><a href="#" class="btn btn-primary">Sign Up</a>
                    </div>
                </div>
                <!-- end col-->
            </div>
        </div>
    </section>
    <section style="background-image: url('${pageContext.request.contextPath}/resources/img/startup.jpg'); " class="section-divider">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Start searching for best Service Provider! <a href="" class="btn btn-white">See Service Provider</a></p>
                </div>
            </div>
        </div>
    </section>