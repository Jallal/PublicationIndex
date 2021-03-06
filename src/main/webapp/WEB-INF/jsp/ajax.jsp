<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <title>Multi-Objectibe Next Release Problem</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>


    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">ISELab</a>
        </div>
    </div>
</nav>


<div class="container" style="min-height: 500px">
    <div class="starter-template">
        <h1>Release 13</h1>

        <!--div class="starter-template"-->
        <div class="starter-template">
            <div id="feedback"></div>


            <form class="form-horizontal" id="search-form">
                <div class="form-group form-group-lg">
                    <label class="col-sm-2 control-label">Username</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="bth-search"
                                class="btn btn-primary btn-lg">Search
                        </button>
                    </div>
                </div>
            </form>
            <div style="margin-top:5px">
                <div id="feedback_1">
                    <script src="js/drowChartWithInput_1.js"></script>
                </div>
            </div>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <div style="margin-top:5px">
                <div id="feedback_2">
                    <script src="js/drowChartWithInput_2.js"></script>

                </div>
            </div>
        </div>
        <div id="timeline_1" style="height: 600px; width:900px;"></div>
        <div id="timeline_2" style="height: 600px; width:900px;"></div>
    </div>
</div>







<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="js/main.js"></script>



<!--script  src="js/sprintChart.js"></script-->


<script type="text/javascript"
        src="webjars/jquery/2.2.4/jquery.min.js"></script>

<script type="text/javascript" src="js/main.js"></script>


<div class="container">
    <footer>
        <p>
            © <a href="http://www.umich.com">ISELab</a> 2019
        </p>
    </footer>
</div>
</body>
</html>