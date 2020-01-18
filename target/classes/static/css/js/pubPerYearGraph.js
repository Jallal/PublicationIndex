google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawStacked);

function drawStacked() {
  var data = new google.visualization.DataTable();
  data.addColumn('timeofday', 'Time of Day');
  data.addColumn('number', 'Motivation Level');
  data.addColumn('number', 'Energy Level');

  data.addRows([
    [{v: [8, 0, 0], f: '2000'}, 0, .25],
    [{v: [9, 0, 0], f: '2001'}, 0, .5],
    [{v: [10, 0, 0], f:'2002'}, 0, 1],
    [{v: [11, 0, 0], f: '2003'}, 0, 2.25],
    [{v: [12, 0, 0], f: '2004'}, 0, 2.25],
    [{v: [13, 0, 0], f: '2005'}, 0, 3],
    [{v: [14, 0, 0], f: '2006'}, 0, 4],
    [{v: [15, 0, 0], f: '2007'}, 0, 5.25],
    [{v: [16, 0, 0], f: '2008'}, 0, 7.5],
    [{v: [17, 0, 0], f: '2009'}, 0, 10],
  ]);

  var options = {
    title: 'Motivation and Energy Level Throughout the Day',
    isStacked: true,
    hAxis: {
      title: 'Time of Day',
      format: 'h:mm a',
      viewWindow: {
        min: [7, 30, 0],
        max: [17, 30, 0]
      }
    },
    vAxis: {
      title: 'Rating (scale of 1-10)'
    }
  };

  var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
  chart.draw(data, options);
}