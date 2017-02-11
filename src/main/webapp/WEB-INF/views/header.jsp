<header class="header">
        <div role="navigation" class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a href="${pageContext.request.contextPath}/" class="navbar-brand"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="logo" class="hidden-xs hidden-sm"><img src="${pageContext.request.contextPath}/resources/img/logo-small.png" alt="logo" class="visible-xs visible-sm"><span class="sr-only">Go to homepage</span></a>
                    <div class="navbar-buttons">
                        <button type="button" data-toggle="collapse" data-target=".navbar-collapse" class="navbar-toggle navbar-btn">Menu<i class="fa fa-align-justify"></i></button>
                    </div>
                </div>
                <div id="navigation" class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="search-location">
                            <div class="col-sm-2">
                                <i class="fa fa-map-marker" aria-hidden="true"></i>
                            </div>
                            <div class="col-sm-7">
                                <div class="form-group">
                                    <input type="text" id="location" name="location" placeholder="Any location?" class="form-control">
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <a href="#" class="btn navbar-btn btn-white"><i class="fa fa-search"></i></a>
                            </div>
                        </li>
                        <li class="active"><a href="${pageContext.request.contextPath}/category">Jobs</a></li>
                        <li>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
                    </ul>
                    <a href="#" data-toggle="modal" data-target="#login-modal" class="btn navbar-btn btn-white"><i class="fa fa-sign-in"></i>Manage Bookings</a>
                </div>
            </div>
        </div>
    </header>