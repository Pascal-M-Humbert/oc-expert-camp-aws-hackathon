const aws = require("aws-sdk");
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
      console.log("data: " + data.Body.toString());
      let json = parse(data.Body.toString(), ",", "\n");
      console.log("json: " + JSON.stringify(json));
    }
  });
};

let parse = function(rawCsv, delimeter = ",", newLineCharacter = "\n") {
  let lines = rawCsv.split(newLineCharacter);
  let keys = lines.shift().split(delimeter);
  let output = [];
  for (let line of lines) {
    let object = {};
    let values = line.split(delimeter);
    for (let index in keys) {
      // TODO: trim values
      object[keys[index]] = values[index];
    }
    output.push(object);
  }
  return output;
};
