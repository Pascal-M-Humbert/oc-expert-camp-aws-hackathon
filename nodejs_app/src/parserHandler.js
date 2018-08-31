const aws = require("aws-sdk");
const parser = require("./parser/parser");
const s3 = new aws.S3();

exports.parserHandler = function(event, context, callback) {
  console.log("event: " + JSON.stringify(event));
  console.log("context: " + JSON.stringify(context));
  console.log("callback: " + JSON.stringify(callback));

  let getParams = {
    Bucket: event.Bucket,
    Key: event.Key
  };

  s3.getObject(getParams, function(err, data) {
    if (err) {
      console.log("err: " + err);
    } else {
      console.log("data: " + data.Body.toString()); //this will log data to console
      let json = parser.parse(data.Body.toString(), ",", "\r");
      console.log("json: " + JSON.stringify(json));
    }
  });
};
