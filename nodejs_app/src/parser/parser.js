exports.parse = function(rawCsv, delimeter = ",", newLineCharacter = "\n") {
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
