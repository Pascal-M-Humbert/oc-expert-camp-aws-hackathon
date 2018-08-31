const assert = require("assert");
const parser = require("./parser");

describe("parser", () => {
  it("should parse data", () => {
    let rawCsv =
      "stringKey,numberKey,booleanKey\n" +
      "string1,42,true\n" +
      "string2,43,false";
    let expected = [
      {
        stringKey: "string1",
        numberKey: "42",
        booleanKey: "true"
      },
      {
        stringKey: "string2",
        numberKey: "43",
        booleanKey: "false"
      }
    ];

    let actual = parser.parse(rawCsv);

    assert.deepEqual(actual, expected);
  });
});
