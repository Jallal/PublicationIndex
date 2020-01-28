<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <!-- needed for the collapsable table -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <!-- Ajax end -->

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/styleIndex.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
</head>

<body>
    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>Search Categories</h3>
            </div>

            <ul class="list-unstyled components">
                <!--p>Dummy Heading</p-->
                <li class="active">
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Refactoring</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li>
                            <a href="#">Category 1</a>
                        </li>
                        <li>
                            <a href="#">Category 2</a>
                        </li>
                        <li>
                            <a href="#">Category 3</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#pageSubmenu1" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Bugs</a>
                    <ul class="collapse list-unstyled" id="pageSubmenu1">
                        <li>
                            <a href="#">Page 1</a>
                        </li>
                        <li>
                            <a href="#">Page 2</a>
                        </li>
                        <li>
                            <a href="#">Page 3</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#pageSubmenu2" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Cats</a>
                    <ul class="collapse list-unstyled" id="pageSubmenu2">
                        <li>
                            <a href="#">Page 1</a>
                        </li>
                        <li>
                            <a href="#">Page 2</a>
                        </li>
                        <li>
                            <a href="#">Page 3</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#pageSubmenu3" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Dogs</a>
                    <ul class="collapse list-unstyled" id="pageSubmenu3">
                        <li>
                            <a  href="categoty 1" id="category1">Category1</a>
                        </li>
                        <li>
                            <a href="categoty 2" id="category2">Category2</a>
                        </li>
                        <li>
                            <a  href="categoty 3" id="category3">Category3</a>
                        </li>
                    </ul>
                </li>

            </ul>
        </nav>

        <!-- Page Content  -->
        <div id="content">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fas fa-align-left"></i>
                        <span>Categories filter</span>
                    </button>
                    <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>
                </div>
            </nav>

            <!-- Search section -->
            <section class="search-sec">
                <div class="container">
                    <form action="#" method="post" novalidate="novalidate">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="row">
                                    <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                        <select class="form-control search-slt" id="exampleFormControlSelect1">
                                            <option>Select search criteria</option>
                                            <option>Name</option>
                                            <option>Journal</option>
                                            <option>Category</option>
                                            <option>Any</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-6 col-md-3 col-sm-12 p-0">
                                        <input type="text" id="tags" class="form-control search-slt" data-role="tagsinput"/>
                                    </div>
                                    <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                        <button type="button" name="search" class="btn btn-warning search-slt2" id="search">Search</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <br/>
                </div>
            </section>
            <!--End of search section-->
            <div class="line"></div>
            <!-- Table start-->
            <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="show-entries">
                                    <span>Show</span>
                                    <select>
                                        <option>5</option>
                                        <option>10</option>
                                        <option>15</option>
                                        <option>20</option>
                                    </select>
                                    <span>entries</span>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <h2 class="text-center">Publication Details</h2>
                            </div>
                        </div>
                    </div>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Name <i class="fa fa-sort"></i></th>
                            <th>Address</th>
                            <th>City <i class="fa fa-sort"></i></th>
                            <th>Pin Code</th>
                            <th>Country <i class="fa fa-sort"></i></th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>Thomas Hardy</td>
                            <td>89 Chiaroscuro Rd.</td>
                            <td>Portland</td>
                            <td>97219</td>
                            <td>USA</td>
                            <td>
                                <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i
                                        class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Maria Anders</td>
                            <td>Obere Str. 57</td>
                            <td>Berlin</td>
                            <td>12209</td>
                            <td>Germany</td>
                            <td>
                                <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i
                                        class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>Fran Wilson</td>
                            <td>C/ Araquil, 67</td>
                            <td>Madrid</td>
                            <td>28023</td>
                            <td>Spain</td>
                            <td>
                                <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i
                                        class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>Dominique Perrier</td>
                            <td>25, rue Lauriston</td>
                            <td>Paris</td>
                            <td>75016</td>
                            <td>France</td>
                            <td>
                                <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i
                                        class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>Dominique Perrier</td>
                            <td>25, rue Lauriston</td>
                            <td>Paris</td>
                            <td>75016</td>
                            <td>France</td>
                            <td>
                                <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i
                                        class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>Dominique Perrier</td>
                            <td>25, rue Lauriston</td>
                            <td>Paris</td>
                            <td>75016</td>
                            <td>France</td>
                            <td>
                                <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i
                                        class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>Dominique Perrier</td>
                            <td>25, rue Lauriston</td>
                            <td>Paris</td>
                            <td>75016</td>
                            <td>France</td>
                            <td>
                                <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i
                                        class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>Dominique Perrier</td>
                            <td>25, rue Lauriston</td>
                            <td>Paris</td>
                            <td>75016</td>
                            <td>France</td>
                            <td>
                                <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i
                                        class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>
                        </tbody>
                        <br/>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text">Showing <b>7</b> out of <b>25</b> entries</div>
                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#">Previous</a></li>
                            <li class="page-item"><a href="#" class="page-link">1</a></li>
                            <li class="page-item"><a href="#" class="page-link">2</a></li>
                            <li class="page-item active"><a href="#" class="page-link">3</a></li>
                            <li class="page-item"><a href="#" class="page-link">4</a></li>
                            <li class="page-item"><a href="#" class="page-link">5</a></li>
                            <li class="page-item"><a href="#" class="page-link">Next</a></li>
                        </ul>
                    </div>
                </div>
            <!--TEST TABLE-->
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
            <!--script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script-->
            <!--link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script-->
            <!--table end-->
            <div class="line"></div>
            <!-- Table Graph and Pie --->
            <div class="row">
                    <!-- Starting the graph-->
                    <div class="col-sm-5 col-md-6">
                        <div class="table-wrapper">
                            <div class="card spur-card">
                                <div class="centerBlock">
                                    <!--graph for publications-->
                                    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                                    <!--div id="chart_div" style="width: 900px; height: 500px;"></div-->
                                    <div id="columnchart_material" style="width:600px; height: 500px;"></div>
                                    <script type="text/javascript" src="css/js/pubPerYearGraph.js"></script>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-5 offset-sm-2 col-md-6 offset-md-0">
                        <div class="table-wrapper">
                            <div class="card spur-card">
                                <div class="centerBlock">
                                    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                                    <div id="piechart" style="width: 600px; height: 500px;"></div>
                                    <script type="text/javascript" src="css/js/tagPie.js"></script>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <div class="line"></div>
        </div>
    </div>

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
</body>
<!--have Ajx work -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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

  function fire_ajax_submit(search) {

    $("#btn-search").prop("disabled", true);
    console.log("***********************************");
    console.log("Begore AJAX"+search);
    jQuery.ajax({
      type: "POST",
      contentType: "application/json",
      url: "/api/search",
      data: JSON.stringify(search),
      dataType: 'json',
      cache: false,
      timeout: 600000,
      success: function (data) {
        console.log("***********************************");
        console.log("I GOT A RESPONSE ");
        console.log(data);
        console.log("***********************************");
        $('#total_records').text(data.length);
        var html = '';
        if (data.length > 0) {
          for (var count = 0; count < data.length; count++) {
            html += '<tr>';
            html += '<td>' + data[count].customerName + '</td>';
            html += '<td>' + data[count].gender + '</td>';
            html += '<td>' + data[count].address + '</td>';
            html += '<td>' + data[count].city + '</td>';
            html += '<td>' + data[count].postalCode + '</td>';
            html += '<td>' + data[count].country + '</td></tr>';

            jQuery.getScript("css/js/tagPie.js").done(function () {
              console.log("yay, all good, do something *");
              drawPieChart(data[0].publicationsPerCategory);
            }).fail(function () {
              console.log("boo first chart failed , fall back to something else");
            });
          }


          jQuery.getScript("css/js/pubPerYearGraph.js").done(function () {
            console.log("yay, all good, do something *");
            drawChart(data[0].publicationsPerYear);
          }).fail(function () {
            console.log("boo first chart failed , fall back to something else");
          });
        }
        else {
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

  $('#search').click(function () {
    //var query = $('#tags').val();
    var search = {};
    search["search"] = $("#exampleFormControlSelect1").val();
    search["authorName"] = $('#tags').val();
    fire_ajax_submit(search);
  });

  $('#category1').click(function (event) {
    event.preventDefault();
    var search = {};
    search["category"] = "category1";
    fire_ajax_submit(search);
  });
  $('#category2').click(function (event) {
    event.preventDefault();
    var search = {};
    search["category"] = "category2";
    fire_ajax_submit(search);
  });
  $('#category3').click(function (event) {

    event.preventDefault();
    var search = {};
    search["category"] = "category3";
    fire_ajax_submit(search);
  });
</script>