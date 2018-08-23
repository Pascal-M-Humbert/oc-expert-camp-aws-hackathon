import assert from "assert";
import { parseDataFrom } from "./parser";

describe("parser", () => {
  beforeEach(() => {});

  it("should parse data", () => {
    let path = "../../resources/testData";
    let expected = [
      { name: "Pizza", price: 5.9 },
      { name: "Burger", price: 6.99 },
      { name: "Fries", price: 3.5 }
    ];

    let actual = parseDataFrom(path);

    assert.equal(actual, expected);
  });
});
