var aws = require("aws-sdk");

//construct getParam
var getParams = {
  Bucket: "oc-expert-camp-dump-file", //replace example bucket with your s3 bucket name
  Key: "SalesJan2009.csv" // replace file location with your s3 file location
};

exports.parserHandler = function(event, context, callback) {
  console.log("event: " + JSON.stringify(event));
  console.log("context: " + JSON.stringify(context));
  console.log("callback: " + JSON.stringify(callback));
};
