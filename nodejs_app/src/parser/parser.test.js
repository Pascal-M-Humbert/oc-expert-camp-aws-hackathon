import assert from "assert";
import { parse } from "./parser";

describe("parser", () => {
  it("should parse data", () => {
    let path = "./resources/testData.csv";
    let expected = [
      { name: "Pizza", price: 5.9 },
      { name: "Burger", price: 6.99 },
      { name: "Fries", price: 3.5 }
    ];

    let actual = parse(path);

    assert.deepEqual(actual, expected);
  });
});
