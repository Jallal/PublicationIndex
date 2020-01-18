<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Live Data Search using Multiple Tag in PHP with Ajax</title>

    <!--script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput.css" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput-typeahead.css" />
    <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput.min.js" crossorigin="anonymous"></script-->

    <!-- TESTS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/styles.css">
    <!-- needed for the collapsable table -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
<section class="search-sec">
    <div class="container">
        <form action="#" method="post" novalidate="novalidate">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <select class="form-control search-slt" id="exampleFormControlSelect1">
                                <option>Select Pickup City</option>
                                <option>Example one</option>
                                <option>Example one</option>
                                <option>Example one</option>
                                <option>Example one</option>
                                <option>Example one</option>
                                <option>Example one</option>
                            </select>
                        </div>
                        <div class="col-lg-6 col-md-3 col-sm-12 p-0">
                                <input type="text" id="tags" class="form-control search-slt" data-role="tagsinput" />
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <button type="button" name="search" class="btn btn-warning search-slt2" id="search">Search</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>

<br />

    <!-- TESTING STRAT-->
    <div class="container mt-3">
        <h4 class="mb-1">Accordion Example</h4>
        <div class="accordion" id="accordionExample">
            <div class="card">
                <div class="card-header" id="headingOne">
                    <h5 class="mb-0">
                        <button class="btn btn-link" type="button" data-toggle="collapse"
                                data-target="#collapseOne"
                                aria-expanded="true" aria-controls="collapseOne">
                            Limit categories
                        </button>
                    </h5>
                </div>
                <div id="collapseOne" class="collapse show"
                     aria-labelledby="headingOne" data-parent="#accordionExample">
                    <div class="card-body">
                        <div class="container">
                            <!-- Select categories -->
                            <div class="container">
                                <form action="#" method="post" novalidate="novalidate">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="row">
                                                <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                                    <select class="form-control search-slt2" id="exampleFormControlSelect1">
                                                        <option>Select Pickup City</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                    </select>
                                                </div>
                                                <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                                    <select class="form-control btn-primary   search-slt" id="exampleFormControlSelect1">
                                                        <option>Select Pickup City</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                    </select>
                                                </div>
                                                <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                                    <select class="form-control btn-warning search-slt" id="exampleFormControlSelect1">
                                                        <option>Select Pickup City</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                    </select>
                                                </div>
                                                <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                                    <select class="form-control btn-danger search-slt" id="exampleFormControlSelect1">
                                                        <option>Select Pickup City</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                        <option>Example one</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- end of categories -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--TESTING END -->

    <!-- Start of the table -->
    <div class="table-responsive">
        <div align="right">
            <p><b>Total Records - <span id="total_records"></span></b></p>
        </div>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Customer Name</th>
                <th>Gender</th>
                <th>Address</th>
                <th>City</th>
                <th>Postal Code</th>
                <th>Country</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<div style="clear:both"></div>
<br />

<br />
<br />
<br />

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <!--graph for publications-->
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            <div id="chart_div" style="width: 900px; height: 500px;"></div>
            <script  type="text/javascript" src="css/js/pubPerYearGraph.js"></script>
        </div>
        <div class="col-lg-6">
            <!--pie Chart -->
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            <div id="piechart" style="width: 900px; height: 500px;"></div>
            <script  type="text/javascript" src="css/js/tagPie.js"></script>
        </div>
    </div>
</div>
</body>
<!--script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</html>

<script>
$(document).ready(function () {
  console.log("********************************");

$("#search").submit(function (event) {

//stop submit the form, we will post it manually.
event.preventDefault();

fire_ajax_submit();

});

});

function fire_ajax_submit() {

var search = {};
$("#btn-search").prop("disabled", true);

$.ajax({
type: "POST",
contentType: "application/json",
url: "/api/search",
data: JSON.stringify(search),
dataType: 'json',
cache: false,
timeout: 600000,
  success:function(data)
  {

    console.log("***********************************");
    console.log("I GOT A RESPONSE ");
    console.log(data);
    console.log("***********************************");
    $('#total_records').text(data.length);
    var html = '';
    if(data.length > 0)
    {
      for(var count = 0; count < data.length; count++)
      {
        html += '<tr>';
        html += '<td>'+data[count].customerName +'</td>';
        html += '<td>'+data[count].gender+'</td>';
        html += '<td>'+data[count].address+'</td>';
        html += '<td>'+data[count].city+'</td>';
        html += '<td>'+data[count].postalCode+'</td>';
        html += '<td>'+data[count].country +'</td></tr>';
      }
    }
    else
    {
      html = '<tr><td colspan="5">No Data Found</td></tr>';
    }
    $('tbody').html(html);
  },
error: function (e) {

var json = "<h4>Ajax Response</h4><pre>"
+ e.responseText + "</pre>";
$('#feedback').html(json);

console.log("ERROR : ", e);
$("#btn-search").prop("disabled", false);

}
});

}

$('#search').click(function(){
  var query = $('#tags').val();
  fire_ajax_submit();
});
</script>
