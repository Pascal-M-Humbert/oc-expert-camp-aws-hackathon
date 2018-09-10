var apiGatewayURL =
  "https://11jh9plcob.execute-api.eu-central-1.amazonaws.com/test/result";

$(document).ready(function() {
  // Using the core $.ajax() method
  $.ajax({
    type: "GET",
    // The URL for the request
    url: apiGatewayURL,

    // enable CORS calls
    crossDomain: true,
    // The data to send (will be converted to a query string)
    data: {
      value: "test"
    },
    contentType: "application/json",
    // The type of data we expect back
    dataType: "json"
  })
    // Code to run if the request succeeds (is done);
    // The response is passed to the function
    .done(function(json) {
      document.getElementById("status").style.visibility = "hidden";
      document.getElementById("loading").style.visibility = "hidden";
      document.getElementById("max").innerHTML = parseInt(json.result, 10) + 15;
      document.getElementById("min").innerHTML = parseInt(json.result, 10) - 15;
      document.getElementById("average").innerHTML = parseInt(json.result, 10);
    })
    // Code to run if the request fails; the raw request and
    // status codes are passed to the function
    .fail(function(xhr, status, errorThrown) {
      alert("Sorry, there was a problem!");
      console.log("Error: " + errorThrown);
      console.log("Status: " + status);
      console.dir(xhr);
    })
    // Code to run regardless of success or failure;
    .always(function(xhr, status) {
      // alert("The request is complete!");
    });
});
