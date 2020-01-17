<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Live Data Search using Multiple Tag in PHP with Ajax</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput.css"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput-typeahead.css"/>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput.min.js"
            crossorigin="anonymous"></script>

    <style>
        .bootstrap-tagsinput {
            width: 100%;
        }
    </style>
</head>
<body>
<div class="container">
    <br/>
    <br/>
    <br/>
    <h2 align="center">Live Data Search using Multiple Tag in PHP with Ajax</h2><br/>
    <div class="form-group">
        <div class="row">
            <div class="col-md-10">
                <input type="text" id="tags" class="form-control" data-role="tagsinput"/>
            </div>
            <div class="col-md-2">
                <button type="button" name="search" class="btn btn-primary" id="search">Search</button>
            </div>
        </div>
    </div>
    <br/>
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
<br/>

<br/>
<br/>
<br/>
</body>
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
      success: function (data) {
        $('#total_records').text(data.length);
        var html = '';
        //if (data.length > 0) {
          //for (var count = 0; count < data.length; count++) {
            html += '<tr>';
            html += '<td>' + 'Hello' + '</td>';
            html += '<td>' + 'Hello' + '</td>';
            html += '<td>' + 'Hello' + '</td>';
            html += '<td>' + 'Hello' + '</td>';
            html += '<td>' + 'Hello' + '</td>';
            html += '<td>' + 'Hello' + '</td></tr>';
          //}
        //}
        //else {
          //html = '<tr><td colspan="5">No Data Found</td></tr>';
        //}
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
    var query = $('#tags').val();
    fire_ajax_submit();
  });
</script>
