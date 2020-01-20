var value = [['Year', 'Publication'], ['2014', 1000], ['2015', 1170], ['2016', 660], ['2017', 1030]];
google.charts.load('current', {'packages':['bar']});
google.charts.setOnLoadCallback(drawChart);

function drawChart(value) {
  if(value.length > 0){
    // loop the outer array

    console.log("*****************************I'm the GRAPH and I WAS CALLED*********************************");
    console.log(value);
    console.log("**************************************************************");
    var data = google.visualization.arrayToDataTable(value);
    var options = {
      chart: {
        title: 'Publication per year',
        subtitle: 'Publications from 2010-2018',
      }
    };

    var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

    chart.draw(data, google.charts.Bar.convertOptions(options));
  }
}