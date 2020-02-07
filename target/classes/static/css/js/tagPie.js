var values = [['Task', 'Hours per Day'], ['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]];
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawPieChart);

function drawPieChart(values) {
  if(values.length > 0){
    console.log("*****************************I'M THE PIE AND  I WAS CALLED*********************************");
    console.log(values);
    console.log("**************************************************************");

     for (var i = 1; i < values.length; i++) {
       values[i][1]= parseInt(values[i][1], 10);
     }

    console.log("**************************** AFTER CONVERSION*********************************");
    console.log(values);
    console.log("**************************************************************");
    var datem = google.visualization.arrayToDataTable(values);

    var options = {
      title: 'Publication per Categories',
      slices: {  4: {offset: 0.2},
        12: {offset: 0.3},
        14: {offset: 0.4},
        15: {offset: 0.5},
      }
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

    chart.draw(datem, options);
  }
}