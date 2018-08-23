import csvToJson from "convert-csv-to-json";

export function parse(path, delimeter = ",") {
  return csvToJson.fieldDelimiter(delimeter).getJsonFromCsv(path);
}
